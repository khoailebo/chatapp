/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.chatcomp;

import com.nhom11.swing.ModernScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PTIT
 */
public class Chat_Body extends javax.swing.JPanel {

    /**
     * Creates new form Chat_Body
     */
    public Chat_Body() {
        initComponents();
        init();
        addItemRight("Hi");
//        addItemLeft("", "Dung", "LTH2QIkXyEjF_Nads+WBE2jFMxoz");
//        addItemLeft("Hello", "Dung",new ImageIcon(getClass().getResource("/com/nhom11/icon/testing/dog.jpg")),
//                new ImageIcon(getClass().getResource("/com/nhom11/icon/testing/pic.jpg")));
//        addItemRight("",new ImageIcon(getClass().getResource("/com/nhom11/icon/testing/dog.jpg")),
//                new ImageIcon(getClass().getResource("/com/nhom11/icon/testing/pic.jpg")));
//        addDate("Today");
//        addItemRight("What xin chào bạn!What xin chào bạn!What xin chào bạn! fakslfjl flsjdflka sdflj lksdfjlskdf jklsdj fklajs ldkfjskld fklsdjflksdfkjls     What xin chào bạn!What xin chào bạn!What xin chào bạn!");
//        addItemRightFile("adobe illustrator.rar", "1 GB");
//        addItemLeftFile("Dung", "Hello world.java", "4KB");
    }
    public void init(){
        body.setLayout(new MigLayout(" fillx","","10[]10"));
        //remenber to wrap comp when you add, if not they will be add to the same line
        //we want each of them in a new line
        sb.setVerticalScrollBar(new ModernScrollBar());
        sb.getVerticalScrollBar().setBackground(Color.white);
    }
    public void addDate(String date){
        Chat_Date d = new Chat_Date();
        d.setDate(date);
        body.add(d,"wrap,al center");
        
    }
    public void addItemLeft(String text, String user,Icon ... images){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime("10:30 AM");
        item.setProfile(user);
//        System.out.println(item.getWidth());
        body.add(item,"wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemLeftFile(String user,String fileName,String fileSize){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setProfile(user);
        item.setText("");
        item.setFile(fileName, fileSize);
        item.setTime("10:45 PM");
        
        //use wrap to add new line after you add this comp
        body.add(item,"wrap, w 100::80%");
        refresh(body);
    }
    public void addItemLeft(String text, String user,String ... images){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime("10:30 AM");
        item.setProfile(user);
//        System.out.println(item.getWidth());
        body.add(item,"wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }
    public void addItemRight(String text,Icon ... images){
        Chat_Right item = new Chat_Right();
        item.setText(text);
//        if(images != null)
        item.setImage(images);
        item.setTime("10:30 PM");
        body.add(item,"wrap,al right, w 100::80%");
        scrollToBottom();
        body.repaint();
        body.revalidate();
    }
    
    public void addItemRight(String text, String user,String ... images){
        Chat_Right item = new Chat_Right();
        item.setText(text);
//        if(images.length >= 1)
        item.setImage(images);
        item.setTime("10:30 AM");
//        item.setProfile(user);
//        System.out.println(item.getWidth());
        body.add(item,"wrap,al right, w 100::80%");
        scrollToBottom();
        body.repaint();
        body.revalidate();
    }
    public void addItemRightFile(String fileNameString, String fileSize){
        Chat_Right item = new Chat_Right();
        item.setText("");
        item.setFile(fileNameString, fileSize);
        item.setTime("10:30 PM");
        body.add(item,"wrap,al right, w 100::80%");
        scrollToBottom();
        refresh(body);
    }
    public void addItemRight(String text){
        Chat_Right item = new Chat_Right();
        item.setText(text);
//        if(images != null)
//        item.setImage(images);
        item.setTime("10:30 PM");
        body.add(item,"wrap,al right, w 100::80%");
        scrollToBottom();
        body.repaint();
        body.revalidate();
    }
    public void refresh(Component comp){
        comp.repaint();
        comp.revalidate();
    }
     private void scrollToBottom() {
        JScrollBar verticalBar = sb.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sb = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        sb.setBorder(null);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        sb.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sb)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sb)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sb;
    // End of variables declaration//GEN-END:variables
}
