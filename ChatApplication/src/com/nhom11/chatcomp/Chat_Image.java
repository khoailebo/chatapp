/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.chatcomp;

import com.nhom11.event.PublicEvent;
import com.nhom11.swing.Picture_Box;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author btdun
 */
public class Chat_Image extends javax.swing.JLayeredPane {

    /**
     * Creates new form Chat_Image
     */
    public Chat_Image(boolean right) {
        initComponents();
        setLayout(new MigLayout("","0["+(right?"right" : "left")+"]0",""));
        setBorder(new EmptyBorder(0,0,0,5));
    }
    public void setImage(Icon ... images){
        for(Icon image : images){
            Picture_Box pic = new Picture_Box();
            pic.setPreferredSize(getAutoDimension(image, 200, 200));
            pic.setImageIcon(image);
            addEvent(pic, image);
            add(pic,"wrap");
        }
    }
    public void setImage(String ... images){
        for(String image : images){
            Image_Item pic = new Image_Item();
            pic.setPreferredSize(new Dimension(200,200));
            pic.setImage(image);
//            addEvent(pic, image);
            add(pic,"wrap");
        }
    }
    public Dimension getAutoDimension(Icon image,int w,int h){
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        if(w > iw)w = iw;
        if(h > ih)h = h;
        double dw = 1.0 * w / iw;
        double dh = 1.0 * h / ih;
        double d = Math.min(dw, dh);
        iw *= d;
        ih *= d;
        return new Dimension(iw,ih);
    }
    public void addEvent(Component comp, Icon image){
        comp.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e))
                {
                    PublicEvent.getInstance().geteEventImageView().viewImage(image);
                }
            }
            
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
