/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.chatcomp;

import com.nhom11.app.MessageType;
import com.nhom11.event.PublicEvent;
import com.nhom11.model.Model_Send_Message;
import com.nhom11.model.Model_User_Account;
import com.nhom11.service.Service;
import com.nhom11.swing.JIMSendTextPane;
import com.nhom11.swing.ModernScrollBar;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PTIT
 */
public class Chat_Bottom extends javax.swing.JPanel {

    Model_User_Account user;

    /**
     * Creates new form Chat_Body
     */
    public Chat_Bottom() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "0[fill]0[]2", "0[fill]2");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setOpaque(false);
        scroll.setBackground(new Color(51,51,51,0));
        txt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println(e.getKeyChar());
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 10 && e.isControlDown())sendMessage(txt);
                refresh();
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setHintText("Write Message Here ...");
        txt.setOpaque(false);
        txt.setBackground(new Color(80,80,80,0));
        scroll.setViewportView(txt);
        ModernScrollBar sb = new ModernScrollBar();
        sb.setBackground(new Color(229, 229, 229));
        sb.setPreferredSize(new Dimension(5, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll, "w 100%");
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 10));
        panel.setBackground(Color.WHITE);
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/nhom11/icon/send.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                sendMessage(txt);
            }
        });
        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/nhom11/icon/more.png")));
        cmdMore.addActionListener((ActionEvent ae) -> {
            if (panel_More.isVisible()) {
                panel_More.setVisible(false);
                mig.setComponentConstraints(panel_More, "dock south, height 0!");
                cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/nhom11/icon/more.png")));
            } else {
                panel_More.setVisible(true);
                mig.setComponentConstraints(panel_More, "dock south, height 170!");
                cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/nhom11/icon/more_disable.png")));
            }
        });
        panel.add(cmdMore);
        panel.add(cmd);
        panel.setOpaque(false);
        add(panel, "wrap");
        panel_More = new Panel_More();
        panel_More.setVisible(false);
        add(panel_More, "dock south");
        mig.setComponentConstraints(panel_More, "dock south, height 0!");
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        panel_More.setUser(user);
    }

    private void refresh() {
        repaint();
        revalidate();
    }

    public void sendMessage(JIMSendTextPane txt) {
        String text = txt.getText().trim();
        if (!text.equals("")) {
            PublicEvent.getInstance().getEventSendMessage().sendMessage(new Model_Send_Message(MessageType.TEXT,Service.getInstance().getCurrent_User_Account().getUserID(),
                    user.getUserID(), text));
            txt.setText("");
            txt.grabFocus();
            refresh();
        } else {
            txt.grabFocus();
        }
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

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    private Panel_More panel_More;
    private MigLayout mig;
}
