/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.emoji;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author btdun
 */
public class Model_Emoji {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Model_Emoji(int id, Icon icon) {
        this.id = id;
        this.icon = icon;
    }

    public Model_Emoji() {
    }
    public Model_Emoji toSize(int x,int y){
        return new Model_Emoji(id,new ImageIcon(((ImageIcon)icon).getImage().getScaledInstance(x, x, Image.SCALE_SMOOTH)));
    }
    private int id;
    private Icon icon;
}
