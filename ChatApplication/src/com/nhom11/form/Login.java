/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.form;

import com.nhom11.event.EventLogin;
import com.nhom11.event.EventMessage;
import com.nhom11.event.PublicEvent;
import com.nhom11.model.Model_Login;
import com.nhom11.model.Model_Message;
import com.nhom11.model.Model_Register;
import com.nhom11.model.Model_User_Account;
import com.nhom11.service.Service;
import io.socket.client.Ack;

/**
 *
 * @author btdun
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        init();
    }

    public void init() {
        slide.setAnimate(5);
        PublicEvent.getInstance().setEventLogin(new EventLogin() {
            @Override
            public void login(Model_Login data,EventMessage em) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        try {
//                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        Service.getInstance().getClient().emit("login", data.toJSONObject(), new Ack() {
                            @Override
                            public void call(Object... os) {
//                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                boolean login_Status = (boolean) os[0];
//                                System.out.println(login_Status);
                                if (login_Status) {
                                    Service.getInstance().setCurrent_User_Account(new Model_User_Account(os[1]));
                                        PublicEvent.getInstance().getEventMain().showLoading(true);
                                    try {
                                        Thread.sleep(3000);
                                    }
                                    catch(Exception e){
                                        e.printStackTrace();
                                    }
                                        PublicEvent.getInstance().getEventMain().initChat();
                                }
                        else{
                                    em.callMessage(new Model_Message(false,"Wrong password or user name"));
                                }
                            }

                        });
//                        if(Service.getInstance().getCurrent_User_Account() == null){
//                            em.callMessage(new Model_Message(false,"Fail to connect to server"));
//                        }

//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
                    }

                }).start();
            }

            @Override
            public void register(Model_Register data, EventMessage em) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Service.getInstance().getClient().emit("register", data.toJSONObject(), new Ack() {
                    @Override
                    public void call(Object... os) {
//                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        if (os.length > 0) {
                            Model_Message message = new Model_Message((boolean) os[0], String.valueOf(os[1]));
                            System.out.println(message.getMessage());
                            if (message.isAction()) {
                                Service.getInstance().setCurrent_User_Account(new Model_User_Account(os[2]));
                            }
                            em.callMessage(message);
                        }
                    }

                });
            }

            @Override
            public void goLogin() {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                slide.show(0);
            }

            @Override
            public void goRegister() {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                slide.show(1);
            }

        });
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        slide.init(login, register);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picture_Box1 = new com.nhom11.swing.Picture_Box();
        label = new javax.swing.JLabel();
        bottom_line = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        slide = new com.nhom11.swing.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        picture_Box1.setBackground(new java.awt.Color(255, 255, 255));
        picture_Box1.setImageIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom11/icon/login_image.png"))); // NOI18N
        picture_Box1.setOpaque(true);

        label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(102, 102, 102));
        label.setText("Bài Tập lớn nhóm 11");

        picture_Box1.setLayer(label, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout picture_Box1Layout = new javax.swing.GroupLayout(picture_Box1);
        picture_Box1.setLayout(picture_Box1Layout);
        picture_Box1Layout.setHorizontalGroup(
            picture_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picture_Box1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(label)
                .addContainerGap(599, Short.MAX_VALUE))
        );
        picture_Box1Layout.setVerticalGroup(
            picture_Box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picture_Box1Layout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addComponent(label)
                .addGap(39, 39, 39))
        );

        bottom_line.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout bottom_lineLayout = new javax.swing.GroupLayout(bottom_line);
        bottom_line.setLayout(bottom_lineLayout);
        bottom_lineLayout.setHorizontalGroup(
            bottom_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bottom_lineLayout.setVerticalGroup(
            bottom_lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom_line, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(picture_Box1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picture_Box1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(bottom_line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom_line;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label;
    private com.nhom11.swing.Picture_Box picture_Box1;
    private com.nhom11.swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
