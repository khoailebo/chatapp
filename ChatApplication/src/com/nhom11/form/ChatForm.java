/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.form;

import java.awt.Color;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author btdun
 */
public class ChatForm extends JLayeredPane{
    public ChatForm(){
        setLayout(new MigLayout("fill","0[fill, 200!]5[fill, 100%]5[200!]0","0[fill]0"));
        add(new MenuLeft());
        add(new Chat());
        add(new MenuRight());
    }
}
