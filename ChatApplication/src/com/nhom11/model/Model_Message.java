/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.model;

/**
 *
 * @author btdun
 */
public class Model_Message {

    /**
     * @return the action
     */
    public boolean isAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(boolean action) {
        this.action = action;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    public Model_Message(boolean action,String message){
        setMessage(message);
        setAction(action);
    }
    private boolean action;
    private String message;
}
