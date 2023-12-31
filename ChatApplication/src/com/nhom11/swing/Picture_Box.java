/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom11.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import sun.java2d.pipe.RenderingEngine;

/**
 *
 * @author btdun
 */
public class Picture_Box extends javax.swing.JLayeredPane {

    /**
     * @return the imageIcon
     */
    public Icon getImageIcon() {
        return imageIcon;
    }

    /**
     * @param imageIcon the imageIcon to set
     */
    public void setImageIcon(Icon imageIcon) {
        this.imageIcon = imageIcon;
    }

    /**
     * Creates new form Picture_Box
     */
    private Icon imageIcon;

    public Picture_Box() {
        initComponents();
        setBorder(new EmptyBorder(0,0,0,0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (imageIcon != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            Rectangle s = getAutoSize(imageIcon);
            g2.drawImage(toImage(imageIcon), s.x, s.y, s.width, s.height, null);
        }

        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Rectangle getAutoSize(Icon image) {
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        int w = getWidth();
        int h = getHeight();
        if(h > ih)h = ih;
        if(w > iw)w = iw;
        double dw = 1.0 * w / iw;
        double dh = 1.0 * h / ih;
        double d = Math.min(dw, dh);
        iw = (int) (iw * d);
        ih = (int) (ih * d);
        int x = (getWidth() - iw) / 2;
        int y = (getHeight() - ih) / 2;
        return new Rectangle(x, y, iw, ih);
    }

    public Image toImage(Icon image) {
        return ((ImageIcon) image).getImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
