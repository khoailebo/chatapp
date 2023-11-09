/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.swing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author btdun
 */
public class Message_Text extends JTextField{
    public String hint_message = "Type messages here ...";
    public Message_Text(){
        setText("");
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
//        setEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if(getText().length() == 0)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            int h = getHeight();
            FontMetrics fm = getFontMetrics(g2.getFont());
            g2.setColor(new Color(0,0,0,100));
            g2.drawString(hint_message, ins.left, h / 2 + fm.getAscent() / 2);
        }
        
    }
    
}
