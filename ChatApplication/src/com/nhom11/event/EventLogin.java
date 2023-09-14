/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom11.event;

import com.nhom11.model.Model_Message;
import com.nhom11.model.Model_Register;

/**
 *
 * @author btdun
 */
public interface EventLogin {
    public void login();
    public void register(Model_Register data,EventMessage em);
    public void goLogin();
    public void goRegister();
//    public void setUserName(String name);
}
