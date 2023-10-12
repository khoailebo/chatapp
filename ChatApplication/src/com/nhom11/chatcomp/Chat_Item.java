/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.chatcomp;

import com.nhom11.emoji.Emoji;
import com.nhom11.model.Model_Recieve_Message;
import com.nhom11.swing.JIMSendTextPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author btdun
 */
public class Chat_Item extends javax.swing.JPanel {

    /**
     * Creates new form Chat_Item
     */
    private JLabel label;

    public Chat_Item() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
    }

    public void setText(String text) {
        txt.setText(text);
    }

    public JIMSendTextPane getTxt() {
        return txt;
    }

    public void setImage(boolean right, Icon... images) {
        if (images.length > 0) {
            JLayeredPane layer = new JLayeredPane();
            layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
            layer.setBorder(new EmptyBorder(0, 5, 0, 0));
            Chat_Image chatImage = new Chat_Image(right);
            chatImage.setImage(images);
            layer.add(chatImage);
            add(layer);
        }

    }

    public void setImage(boolean right, String... images) {
        if (images.length > 0) {
            JLayeredPane layer = new JLayeredPane();
            layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
            layer.setBorder(new EmptyBorder(0, 5, 0, 0));
            Chat_Image chatImage = new Chat_Image(right);
            chatImage.setImage(images);
            layer.add(chatImage);
            add(layer);
        }
    }

    public void setEmoji(boolean right,  int EmojiID) {
//        setBackground(Color.black);
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new MigLayout("fillx","[fill]","[fill]"));
        layer.setBorder(new EmptyBorder(0, 0, 0, 0));
//        layer.setBackground(Color.blue);
//        Chat_Image chatImage = new Chat_Image(right);
//        chatImage.setImage(images);
        JLabel emoji = new JLabel(Emoji.getInstance().getEmoji(EmojiID).toSize(80, 80).getIcon());
        emoji.setBorder(new EmptyBorder(0,0,0,0));
        layer.add(emoji,"al center");
        add(layer);
    }

    public void setProFile(String User) {
        JLayeredPane layer = new JLayeredPane();
        layer.setBorder(new EmptyBorder(0, 5, 0, 10));
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton user = new JButton(User);
        user.setFocusable(false);
        user.setContentAreaFilled(false);
        user.setFont(new java.awt.Font("Segoe UI", 1, 13));
        user.setBorder(new EmptyBorder(0, 0, 0, 0));
        user.setCursor(new Cursor(Cursor.HAND_CURSOR));
        layer.add(user);
        add(layer, 0);
    }

    public void setTime(String time) {
        JLayeredPane Time_Panel = new JLayeredPane();
        Time_Panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        Time_Panel.setBorder(new EmptyBorder(5, 5, 10, 5));
        label = new JLabel(time);
//        label.setBorder(new EmptyBorder(0,0,0,0));
        label.setForeground(new Color(110, 110, 110));
        label.setHorizontalTextPosition(JLabel.LEFT);
        Time_Panel.add(label);
        add(Time_Panel);
    }

    public void setFile(boolean right, String fileName, String fileSize) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout());
        Chat_File file = new Chat_File();
        file.setRight(right);
        file.setFileName(fileName);
        file.setFIleSize(fileSize);
        layer.add(file);
        add(layer);
    }

    public void sendSuccessfull() {
        if (label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/com/nhom11/icon/tick.png")));
        }
    }

    public void seen() {
        if (label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/com/nhom11/icon/double_tick.png")));
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void hideText() {
        txt.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.nhom11.swing.JIMSendTextPane();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBackground(new java.awt.Color(44, 156, 230));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 0, 10));
        txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt.setOpaque(false);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom11.swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
