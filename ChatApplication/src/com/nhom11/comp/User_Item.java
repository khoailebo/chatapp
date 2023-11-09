/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.comp;

import com.nhom11.event.PublicEvent;
import com.nhom11.model.Model_User_Account;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author btdun
 */
public class User_Item extends javax.swing.JPanel {

    String Name, Status, Image_Path;
    boolean mouseOver = false;
    private Model_User_Account user;

    public User_Item(Model_User_Account user) {
        initComponents();
        this.user = user;
//        System.out.println(user.getUserName());
//        if(user  == null)System.out.println("null");
//        else
        init();
    }

    /**
     * Creates new form User_Item
     */
    public User_Item() {
        initComponents();
    }

    public void init() {
        if (user != null) {
            Label_Name.setText(user.getUserName());
            updateStatus();
//            Avatar.setImage(new ImageIcon(getClass().getResource(Image_Path)));
        }
    }

    public void updateStatus() {
        Label_Status.setText(user.isStatus() ? "online" : "offline");
        activeStatus.setActive(user.isStatus());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Name = new javax.swing.JLabel();
        Label_Status = new javax.swing.JLabel();
        Avatar = new com.nhom11.swing.ImageAvatar();
        activeStatus = new com.nhom11.swing.ActiveStatus();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        Label_Name.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        Label_Name.setText("Name");

        Label_Status.setText("online");

        Avatar.setBackground(new java.awt.Color(153, 153, 153));
        Avatar.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/nhom11/icon/user.png"))); // NOI18N

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Name)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Status)
                        .addGap(3, 3, 3)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Name)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Avatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(new Color(190, 190, 190));
        mouseOver = true;
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(Color.white);
        mouseOver = false;
    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if(mouseOver)
        PublicEvent.getInstance().getEventMain().setUser(user);
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom11.swing.ImageAvatar Avatar;
    private javax.swing.JLabel Label_Name;
    private javax.swing.JLabel Label_Status;
    private com.nhom11.swing.ActiveStatus activeStatus;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the user
     */
    public Model_User_Account getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Model_User_Account user) {
        this.user = user;
    }
}