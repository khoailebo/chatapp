/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.service;

import com.nhom11.model.Model_User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;

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
    public static Model_User_Account getCurrent_User_Account() {
        return Current_User_Account;
    }

    /**
     * @param aCurrent_User_Account the Current_User_Account to set
     */
    public static void setCurrent_User_Account(Model_User_Account aCurrent_User_Account) {
        Current_User_Account = aCurrent_User_Account;
    }
}
