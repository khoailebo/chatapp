/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.*;
import com.nhom11.model.Model_Client;
import com.nhom11.model.Model_Login;
import com.nhom11.model.Model_Message;
import com.nhom11.model.Model_Recieve_Message;
import com.nhom11.model.Model_Register;
import com.nhom11.model.Model_Send_Message;
import com.nhom11.model.Model_User_Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author btdun
 */
public class Service {

    private static Service instance;
    private SocketIOServer server;
    public static final int PORT_NUMBER = 5000;
    private List<Model_Client> userStatus;
    private ServiceUser serviceUser;
    private static JTextArea txt;

    private Service(JTextArea txt) {
        this.txt = txt;
        serviceUser = new ServiceUser(txt);
        userStatus = new ArrayList<>();
    }

    public static Service getInstance(JTextArea txt) {
        if (instance == null) {
            instance = new Service(txt);
        }
        return instance;
    }
    public void startServer() {
        Configuration config = new Configuration();
        config.setPort(PORT_NUMBER);
        server = new SocketIOServer(config);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient sioc) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                txt.append("One client connected.\n");
            }

        });
        server.addEventListener("register", Model_Register.class, new DataListener<Model_Register>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Register t, AckRequest ar) throws Exception {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Model_Message m = serviceUser.register(t);
//                ar.sendAckData(m.isAction(), m.getMessage(),((Model_User_Account) m.getData()).getUserID());
                ar.sendAckData(m.isAction(), m.getMessage(), (m.getData()));
                if (m.isAction()) {
                    addClient(sioc, (Model_User_Account)m.getData());
                    txt.append("User register: " + t.getUsername() + " / " + t.getPassword() + "\n");
                    server.getBroadcastOperations().sendEvent("list_user", m.getData());
                }
            }
        });
        server.addEventListener("list_user", Integer.class, new DataListener<Integer>() {
            @Override
            public void onData(SocketIOClient sioc, Integer UserID, AckRequest ar) throws Exception {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                try{
                    List<Model_User_Account> users = serviceUser.getUserList(UserID);
                    sioc.sendEvent("list_user", users.toArray());
                }
                catch(SQLException e){
                    System.err.println(e);
                }
            }
        });
        server.addEventListener("login", Model_Login.class, new DataListener<Model_Login>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Login data, AckRequest ar) throws Exception {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Model_User_Account user = serviceUser.login(data);
//                txt.append("Login\n");
                if(user != null){
                    addClient(sioc, user);
                    ar.sendAckData(true,user);
//                    server.getBroadcastOperations().sendEvent("user_status", user.getUserID(),true);
                    userConnect(user.getUserID());
                }
                else ar.sendAckData(false);
            }
        });
        server.addEventListener("send", Model_Send_Message.class, new DataListener<Model_Send_Message>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Send_Message t, AckRequest ar) throws Exception {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                for(Model_Client client: userStatus){
                    if(client.getUser().getUserID() == t.getToUserID()){
                        client.getClient().sendEvent("recieve", new Model_Recieve_Message(t.getType(),t.getFromUserID(),t.getText()));
                        break;
                    }
                }
            }
        });
        server.addDisconnectListener(new DisconnectListener(){
            @Override
            public void onDisconnect(SocketIOClient sioc) {
                for(Model_Client client:userStatus){
                    if(client.getClient() == sioc){
                        userStatus.remove(client);
                        userDisconnect(client.getUser().getUserID());
                        break;
                    }
                }
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        server.start();
        txt.append("Server started at port: " + PORT_NUMBER + "\n");
    }
    
    
    public List<Model_Client> getUserStatus() {
        return userStatus;
    }
    public void userConnect(int UserID){
        server.getBroadcastOperations().sendEvent("user_status", UserID,true);
    }
   public void userDisconnect(int UserID){
       server.getBroadcastOperations().sendEvent("user_status", UserID,false);
   }
    public void setUserStatus(List<Model_Client> userStatus) {
        this.userStatus = userStatus;
    }
    
    public void addClient(SocketIOClient client,Model_User_Account user){
        userStatus.add(new Model_Client(client, user));
    }
}
