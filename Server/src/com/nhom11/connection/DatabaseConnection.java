/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author btdun
 */
public class DatabaseConnection {

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    private static DatabaseConnection instance;
    private Connection connection;
    private DatabaseConnection(){
        
    }
    public static DatabaseConnection getInstance(){
        if(instance == null)
        {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public void connectToDatabase() throws SQLException{
        String host = "localhost";
        String port = "3306";
        String database = "chat_application";
        String user_name = "Bui Dung";
        String password = "Khoai@211003";
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user_name, password);
    }
}
