/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.form;

import com.nhom11.model.Model_User_Account;
import java.awt.Color;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author btdun
 */
public class ChatForm extends JLayeredPane{
    Chat chat = new Chat();
    public ChatForm(){
        setLayout(new MigLayout("fill","0[fill, 200!]5[fill, 100%]5[200!]0","0[fill]0"));
        add(new MenuLeft());
        add(chat);
        add(new MenuRight());
        setOpaque(true);
        setBackground(new Color(51,51,51,200));
        chat.setVisible(false);
    }
    public void setUser(Model_User_Account user){
        chat.setUser(user);
        chat.setVisible(true);
    }
    public void updateUser(Model_User_Account user){
        chat.updateUser(user);
    }
}
