/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author btdun
 */
public class Model_Recieve_Message {

    /**
     * @return the fromUserID
     */
    public int getFromUserID() {
        return fromUserID;
    }

    /**
     * @param fromUserID the fromUserID to set
     */
    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    public Model_Recieve_Message(Object json) {
        try {
            JSONObject js = (JSONObject) json;
            this.fromUserID = js.getInt("fromUserID");
            this.text = js.getString("text");
        }catch(JSONException e){
            System.err.println(e);
        }
    }

    public Model_Recieve_Message(int fromUserID, String text) {
        this.fromUserID = fromUserID;
        this.text = text;
    }

    private int fromUserID;
    private String text;
}
