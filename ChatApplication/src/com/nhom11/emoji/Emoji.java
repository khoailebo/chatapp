/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.emoji;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author btdun
 */
public class Emoji {
    private static Emoji instance;
    public static Emoji getInstance(){
        if(instance ==  null){
            instance = new Emoji();
        }
        return instance;
    }
    private Emoji(){
        
    }
    public List<Model_Emoji> getStyle1(){
        List<Model_Emoji> l1 = new ArrayList<>();
        for(int i = 1;i <= 20;i++)
        {
            l1.add(new Model_Emoji(i,new ImageIcon(getClass().getResource("/com/nhom11/emoji/icon/" + i + ".png"))));
        }
        return l1;
    }
    public List<Model_Emoji> getStyle2(){
        List<Model_Emoji> l1 = new ArrayList<>();
        for(int i = 21;i <= 40;i++)
        {
            l1.add(new Model_Emoji(i,new ImageIcon(getClass().getResource("/com/nhom11/emoji/icon/" + i + ".png"))));
        }
        return l1;
    }
    
    public Model_Emoji getEmoji(int id){
        return new Model_Emoji(id,new ImageIcon(getClass().getResource("/com/nhom11/emoji/icon/" + id + ".png")));
    }
}
