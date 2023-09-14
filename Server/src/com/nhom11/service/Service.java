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
import com.nhom11.model.Model_Message;
import com.nhom11.model.Model_Register;
import com.nhom11.model.Model_User_Account;
import javax.swing.JTextArea;

/**
 *
 * @author btdun
 */
public class Service {

    private static Service instance;
    private SocketIOServer server;
    public static final int PORT_NUMBER = 5000;
    private static JTextArea txt;

    private Service(JTextArea txt) {
        this.txt = txt;
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
                Model_Message m = new ServiceUser(txt).register(t);
//                ar.sendAckData(m.isAction(), m.getMessage(),((Model_User_Account) m.getData()).getUserID());
                ar.sendAckData(m.isAction(), m.getMessage(), ((Model_User_Account)m.getData()).getUserID(),((Model_User_Account)m.getData()).getUser_Name());
                if (m.isAction()) {
                    txt.append("User register: " + t.getUsername() + " / " + t.getPassword() + "\n");
                    server.getBroadcastOperations().sendEvent("list_user", (Model_User_Account) m.getData());
                }
            }
        });
        server.start();
        txt.append("Server started at port: " + PORT_NUMBER + "\n");
    }
}
