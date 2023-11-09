/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.model;

import org.json.JSONObject;

/**
 *
 * @author btdun
 */
public class Model_Login {

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Model_Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public Model_Login(){
        
    }
    public JSONObject toJSONObject(){
        try{
            JSONObject json = new JSONObject();
            json.put("userName", userName);
            json.put("password", password);
            return json;
        }
        catch(Exception e){
            return null;
        }
    }
    private String userName;
    private String password;
    
}
