/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.form;

import com.nhom11.event.EventMessage;
import com.nhom11.event.PublicEvent;
import com.nhom11.model.Model_Message;
import com.nhom11.model.Model_Register;
import java.awt.Color;

/**
 *
 * @author btdun
 */
public class P_Register extends javax.swing.JPanel {

    /**
     * Creates new form P_Login
     */
    public P_Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        Register = new javax.swing.JButton();
        Back_To_Login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register");

        jLabel2.setText("User name");

        jLabel3.setText("Password");

        Register.setText("Register");
        Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterMouseClicked(evt);
            }
        });

        Back_To_Login.setForeground(new java.awt.Color(51, 153, 255));
        Back_To_Login.setText("Back to login");
        Back_To_Login.setBorder(null);
        Back_To_Login.setBorderPainted(false);
        Back_To_Login.setContentAreaFilled(false);
        Back_To_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back_To_Login.setFocusPainted(false);
        Back_To_Login.setFocusable(false);
        Back_To_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Back_To_LoginMouseClicked(evt);
            }
        });

        jLabel4.setText("Confirm password");

        txtConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPasswordActionPerformed(evt);
            }
        });

        txtMessage.setForeground(new java.awt.Color(51, 255, 51));
        txtMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Back_To_Login)
                    .addComponent(Register)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(txtConfirmPassword)
                    .addComponent(txtMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Register)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back_To_Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPasswordActionPerformed

    private void RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterMouseClicked
        // TODO add your handling code here:
        String user_name = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String cfpassword = String.valueOf(txtConfirmPassword.getPassword());
        if (user_name.equals("")) {
            txtUserName.grabFocus();
        } else if (password.equals("")) {
            txtPassword.grabFocus();
        } else if (!password.equals(cfpassword)) {
            txtPassword.grabFocus();
        } else {
            Model_Register data = new Model_Register(user_name, password);
            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
                @Override
                public void callMessage(Model_Message message) {
//                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    if (message.isAction()) {
                        txtMessage.setForeground(new Color(51, 255, 51));
                        PublicEvent.getInstance().getEventMain().initChat();
                    } else {
                        txtMessage.setForeground(Color.red);
                        txtMessage.setText(message.getMessage());
                    }
                }

            });
        }

    }//GEN-LAST:event_RegisterMouseClicked

    private void Back_To_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_To_LoginMouseClicked
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().goLogin();
    }//GEN-LAST:event_Back_To_LoginMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back_To_Login;
    private javax.swing.JButton Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JLabel txtMessage;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
