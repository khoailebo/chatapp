/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom11.event;

import com.nhom11.model.Model_User_Account;

/**
 *
 * @author btdun
 */
public interface EventMain {
    public void showLoading(boolean show);
    public void initChat();
    public void setUser(Model_User_Account user);
    public void updateUser(Model_User_Account user);
}
