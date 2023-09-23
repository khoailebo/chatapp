/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.service;

import com.nhom11.connection.DatabaseConnection;
import com.nhom11.model.Model_Client;
import com.nhom11.model.Model_Login;
import com.nhom11.model.Model_Message;
import com.nhom11.model.Model_Register;
import com.nhom11.model.Model_User_Account;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author btdun
 */
public class ServiceUser {

    private static Connection con;
    String LOGIN = "select user.user_id, user_account.user_name,gender,imagestring from user inner join user_account on user.user_id = user_account.user_id "
            + "where user.user_name = ? and user.user_password = sha(?)";
    String GET_USER_LIST = "Select user_id,user_name,gender, imagestring from user_account where status = '1' and user_id != ?";
    String INSERT_SQL = "Insert into user (user_name,user_password) values(?, sha(?))";
    String Find_User_By_Name_SQL = "Select * from user where user_name = ? limit 1";
    String INSERT_SQL_USER_ACCOUNT = "Insert into user_account (user_id,user_name) values(?,?)";
    JTextArea txtArea;

    public ServiceUser(JTextArea txt) {
        this.txtArea = txt;
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    public Model_Message register(Model_Register data) {
        Model_Message message = new Model_Message();
        try {
            PreparedStatement p = con.prepareStatement(Find_User_By_Name_SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            p.setString(1, data.getUsername());
            ResultSet result = p.executeQuery();
//            System.out.println(result.first());
            if (result.first()) {
                message.setAction(false);
                message.setMessage("User name already exist");
                txtArea.append("User name already exist\n");
            } else {
                message.setAction(true);
                message.setMessage("Register successfully!");
            }
//            txtArea.append(result.getString(2));
            result.close();
            p.close();
            if (message.isAction()) {
                p = con.prepareStatement(INSERT_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getUsername());
                p.setString(2, data.getPassword());
                p.execute();
                result = p.getGeneratedKeys();
                result.first();
                int user_id = result.getInt(1);
//                System.out.println("Updated");
                p.close();
                result.close();
                p = con.prepareStatement(INSERT_SQL_USER_ACCOUNT);
                p.setInt(1, user_id);
                p.setString(2,data.getUsername());
                p.execute();
                p.close();
                if(con.getAutoCommit() == false)con.commit();
                con.setAutoCommit(true);
                message.setData(new Model_User_Account(user_id,data.getUsername(), "", "", true));
            }
        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Server error");
            try{
                if(con.getAutoCommit() == false)
                {
                    con.rollback();
                    con.setAutoCommit(true);
                }
            }
            catch(Exception ex){}
            txtArea.append("Server error:" + e + "\n");
        }
        return message;
    }
    public Model_User_Account login(Model_Login data){
        Model_User_Account user = null;
        try{
            PreparedStatement p = con.prepareStatement(LOGIN,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            p.setString(1, data.getUserName());
            p.setString(2, data.getPassword());
            ResultSet r = p.executeQuery();
//            txtArea.append("login" + ": " + data.getUserName() + "/" + data.getPassword() + "\n");
            if(r.first()){
                int User_ID = r.getInt(1);
                String User_Name = r.getString(2);
                String gender = r.getString(3);
                String image = r.getString(4);
                user = new Model_User_Account(User_ID,User_Name,gender,image,true);
            }
            r.close();
            p.close();
        }
        catch(SQLException e){
//            e.printStackTrace();
            System.err.println(e);
        }
        return user;
    }
    public List<Model_User_Account> getUserList(int UserID) throws SQLException{
        List <Model_User_Account> users = new ArrayList();
        PreparedStatement p = con.prepareStatement(GET_USER_LIST);
        p.setInt(1, UserID);
        ResultSet result = p.executeQuery();
        while(result.next()){
            int id = result.getInt(1);
            String User_Name = result.getString(2);
            String gender = result.getString(3);
            String image = result.getString(4);
            users.add(new Model_User_Account(id,User_Name,gender,image,checkUserStatus(id)));
        }
        result.close();
        p.close();
        return users;
    }
    private boolean checkUserStatus(int UserID){
        for (Model_Client item : Service.getInstance(null).getUserStatus()){
            if(item.getUser().getUserID() == UserID)return true;
        }
        return false;
    }
}
