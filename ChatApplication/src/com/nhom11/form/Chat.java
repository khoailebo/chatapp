/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.form;

import com.nhom11.chatcomp.Chat_Body;
import com.nhom11.chatcomp.Chat_Bottom;
import com.nhom11.chatcomp.Chat_Title;
import com.nhom11.event.EventSendMessage;
import com.nhom11.event.PublicEvent;
import com.nhom11.model.Model_Recieve_Message;
import com.nhom11.model.Model_Send_Message;
import com.nhom11.model.Model_User_Account;
import com.nhom11.service.Service;
import java.awt.Color;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author btdun
 */
public class Chat extends javax.swing.JPanel {

    Chat_Title chatTitle;
    Chat_Body chatBody;
    Chat_Bottom chatBottom;

    /**
     * Creates new form MenuLeft
     */
    public Chat() {
//        initComponents();
        init();
//        initEvent();
    }

    public void init() {
//        setBackground(Color.white);
        setLayout(new MigLayout("fillx", "0[fill]0", "0[40:40:]6[100%, bottom]6[shrink 0]6"));
        chatTitle = new Chat_Title();
        chatBody = new Chat_Body();
        chatBottom = new Chat_Bottom();
        setOpaque(true);
        setBackground(new Color(80,80,80));
        PublicEvent.getInstance().setEventSendMessage(new EventSendMessage() {
            @Override
            public void sendMessage(Model_Send_Message ms) {
                Service.getInstance().getClient().emit("send", ms.toJSONObject());
                chatBody.addItemRight(ms);
            }

            @Override
            public void receivedMessage(Model_Recieve_Message ms) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                chatBody.addItemLeft(ms);
            }

        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap, growy");
        add(chatBottom, "h ::50%");
    }

    public void initEvent() {
        PublicEvent.getInstance().setEventSendMessage(new EventSendMessage() {
            @Override
            public void sendMessage(Model_Send_Message ms) {
                Service.getInstance().getClient().emit("send", ms.toJSONObject());
                chatBody.addItemRight(ms);
            }

            @Override
            public void receivedMessage(Model_Recieve_Message ms) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                chatBody.addItemLeft(ms);
            }

        });
    }
    public void setUser(Model_User_Account user){
//        System.out.println("here");
        chatTitle.setName(user);
        chatBody.resetChat();
        chatBottom.setUser(user);
    }
    public void updateUser(Model_User_Account user){
        chatTitle.updateUser(user);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chat_Body = new com.nhom11.chatcomp.Chat_Body();
        chat_Title = new com.nhom11.chatcomp.Chat_Title();
        chat_Bottom2 = new com.nhom11.chatcomp.Chat_Bottom();

        setBackground(new java.awt.Color(51, 51, 51));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chat_Body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
            .addComponent(chat_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chat_Bottom2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chat_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chat_Body, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chat_Bottom2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom11.chatcomp.Chat_Body chat_Body;
    private com.nhom11.chatcomp.Chat_Bottom chat_Bottom2;
    private com.nhom11.chatcomp.Chat_Title chat_Title;
    // End of variables declaration//GEN-END:variables
}
