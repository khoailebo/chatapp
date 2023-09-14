/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.model;




/**
 *
 * @author btdun
 */
public class Model_User_Account {

    /**
     * @return the UserID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    /**
     * @return the User_Name
     */
    public String getUser_Name() {
        return User_Name;
    }

    /**
     * @param User_Name the User_Name to set
     */
    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Model_User_Account(int UserID, String User_Name, String image, String gender, boolean status) {
        this.UserID = UserID;
        this.User_Name = User_Name;
        this.image = image;
        this.gender = gender;
        this.status = status;
    }
    
    
    private int UserID;
    private String User_Name;
    private String image;
    private String gender;
    private boolean status;
    
}
