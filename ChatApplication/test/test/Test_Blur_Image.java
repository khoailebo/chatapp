/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package test;

import com.nhom11.swing.blurhash.BlurHash;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author btdun
 */
public class Test_Blur_Image {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\Downloads\\ảnh.jpg"));
            String encode = BlurHash.encode(image);
            System.out.println(encode);
        } catch (Exception e) {
        }
    }
}
