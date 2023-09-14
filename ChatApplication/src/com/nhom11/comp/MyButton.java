/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.comp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author btdun
 */
public class MyButton extends JButton{

    /**
     * @return the NormalIcon
     */
    public Icon getNormalIcon() {
        return NormalIcon;
    }

    /**
     * @param NormalIcon the NormalIcon to set
     */
    public void setNormalIcon(ImageIcon NormalIcon) {
        this.NormalIcon = NormalIcon;
    }

    /**
     * @return the SelectedIcon
     */
    public Icon getSelectedIcon() {
        return SelectedIcon;
    }

    /**
     * @param SelectedIcon the SelectedIcon to set
     */
    public void setSelectedIcon(ImageIcon SelectedIcon) {
        this.SelectedIcon = SelectedIcon;
    }
    private boolean Selected = false;
    private ImageIcon NormalIcon;
    private ImageIcon SelectedIcon;
    public MyButton(){
        super();
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(0,0,0,0));
        setFocusable(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
//        setIcon(NormalIcon);
    }

    /**
     * @return the Selected
     */
    public boolean isSelected() {
        return Selected;
    }

    /**
     * @param Selected the Selected to set
     */
    public void setSelected(boolean Selected) {
        this.Selected = Selected;
        init();
    }
    public void init(){
        setBackground(new Color(150,202,255));
        if(!Selected){
            setIcon(NormalIcon);
        }
        else setIcon(SelectedIcon);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if(Selected){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRect(0, getHeight() - 3, getWidth(), 3);
        }
    }
    
    
}
