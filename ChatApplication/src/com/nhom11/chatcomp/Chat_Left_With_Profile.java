/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.chatcomp;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.JLayeredPane;

/**
 *
 * @author btdun
 */
public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {

    /**
     * Creates new form Chat_Left
     */
    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(242, 242, 242));
    }
    public void setFile(String fileName,String fileSize){
        txt.setFile(false, fileName, fileSize);
    }
    public void setText(String text){
        if(text.equals(""))
        {
            txt.hideText();
        }
        else
        txt.setText(text);
        txt.sendSuccessfull();
//        txt.setTime("10:30 PM");
        
    }
    public void setImageProfile(Icon image){
        ImageAvatar.setImage(image);
    }
    public void setTime(String time){
        txt.setTime(time);
        txt.sendSuccessfull();
    }
    
    public void setImage(Icon ... images){
        txt.setImage(false, images);
    }
    public void setImage(String ... images){
        txt.setImage(false, images);
    }
    public void setProfile(String User){
        txt.setProFile(User);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        ImageAvatar = new com.nhom11.swing.ImageAvatar();
        txt = new com.nhom11.chatcomp.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        ImageAvatar.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/nhom11/icon/testing/dog.jpg"))); // NOI18N
        ImageAvatar.setMaximumSize(new java.awt.Dimension(31, 31));
        ImageAvatar.setMinimumSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(ImageAvatar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom11.swing.ImageAvatar ImageAvatar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.nhom11.chatcomp.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}