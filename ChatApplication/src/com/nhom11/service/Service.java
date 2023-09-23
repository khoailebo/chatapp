/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.service;

import com.nhom11.event.PublicEvent;
import com.nhom11.model.Model_Recieve_Message;
import com.nhom11.model.Model_User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author btdun
 */
public class Service {

    private static Service instance;
    private Socket client;
    public static final int PORT_NUMBER = 5000;
    private String host = "localhost";
    private static Model_User_Account Current_User_Account;

    private Service() {

    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public void connectToServer() {
        try {
            client = IO.socket("http://" + host + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
//                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    List<Model_User_Account> users = new ArrayList<>();
                    for (Object item : os){
                        users.add((new Model_User_Account((JSONObject)item)));
                }
                    PublicEvent.getInstance().getEventMenuLeft().addUsers(users);
                }
            });
            client.on("user_status",new Emitter.Listener(){
                @Override
                public void call(Object... os) {
//                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    boolean status = (boolean)os[1];
                    int User_ID = (int)os[0];
                    if(status){
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(User_ID);
                    }
                    else PublicEvent.getInstance().getEventMenuLeft().userDisconnect(User_ID);
                }
            });
            client.on("recieve", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
//                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    if(os.length > 0){
                        Model_Recieve_Message recieve = new Model_Recieve_Message(os[0]);
                        PublicEvent.getInstance().getEventSendMessage().receivedMessage(recieve);
                    }
                }
            });
            getClient().open();
        } catch (URISyntaxException e) {
            error();
        }
    }

    public void error() {
        System.out.println("Connected failed");
    }

    /**
     * @return the client
     */
    public Socket getClient() {
        return client;
    }

    /**
     * @return the Current_User_Account
     */
    public Model_User_Account getCurrent_User_Account() {
        return Current_User_Account;
    }

    /**
     * @param aCurrent_User_Account the Current_User_Account to set
     */
    public void setCurrent_User_Account(Model_User_Account aCurrent_User_Account) {
        Current_User_Account = aCurrent_User_Account;
    }
}
