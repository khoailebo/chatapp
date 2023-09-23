/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nhom11.event;

import com.nhom11.model.Model_User_Account;
import java.util.List;

/**
 *
 * @author btdun
 */
public interface EventMenuLeft {
    public void addUsers(List<Model_User_Account>users);
    public void userConnect(int User_ID);
    public void userDisconnect(int User_ID);
}
