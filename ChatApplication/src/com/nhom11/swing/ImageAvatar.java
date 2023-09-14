/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom11.swing;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author btdun
 */
public class ImageAvatar extends JComponent{
    
    private Icon image;

    /**
     * @return the image
     */
    public Icon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Icon image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(getImage() != null)
        {
            int width = getImage().getIconWidth();
            int height = getImage().getIconHeight();
            int dimension = Math.min(width, height);
            BufferedImage Circle_Filter = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D) Circle_Filter.createGraphics();
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.fillOval(0, 0, dimension - 1, dimension - 1);
            g2.dispose();
            BufferedImage Picture = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_ARGB);
            g2 = (Graphics2D) Picture.createGraphics();
            int x = (dimension - width) / 2;
            int y = (dimension - height) / 2;
//            System.out.println(x + " " + y);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(toImage(getImage()), x,y, null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2.drawImage(Circle_Filter, 0,0, null);
            g2.dispose();
            g2 = (Graphics2D) g;
            ImageIcon Final_Picture = new ImageIcon(Picture);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Rectangle Size = getAutoSize(Final_Picture);
//            System.out.println(Size);
            g2.drawImage(toImage(Final_Picture), Size.x, Size.y,Size.width,Size.height,null);
            
            
        }
        super.paintComponent(g);
    }
    public Rectangle getAutoSize(ImageIcon image){
        int dw = getWidth();
        int dh = getHeight();
        int ih = image.getIconHeight();
        int iw = image.getIconWidth();
        double Dw = 1.0 * dw / iw;
        double Dh = 1.0 * dh / ih;
        double d = Math.max(Dw, Dh);
        
        iw = (int)(iw * d);
        ih = (int)(ih * d);
//        System.out.println(dw + " "+dh + " " + iw + " " + ih + " " + d);
        int x = (dw - iw) / 2;
        int y = (dh - ih) / 2;
        return new Rectangle(x,y,iw,ih);
    }
    public Image toImage(Icon image){
        return ((ImageIcon)image).getImage();
    }
    
}
