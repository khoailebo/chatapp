/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author btdun
 */
public class ModernScrollBar  extends JScrollBar{
    public ModernScrollBar(){
        setUI(new MordernUI());
        setUnitIncrement(20);
        setPreferredSize(new Dimension(5,5));
        setBackground(Color.white);
    }

    
    
    
}
