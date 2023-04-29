package com.gyxs.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageToByteArrayUtil {
    /**
     * ͼƬתbyte[]
     *
     * @return
     */
    public static byte[] getByteArray(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int rgb = image.getRGB(x, y);
                    byte r = (byte) ((rgb >> 16) & 0xFF);
                    byte g = (byte) ((rgb >> 8) & 0xFF);
                    byte b = (byte) (rgb & 0xFF);
                    dos.write(r);
                    dos.write(g);
                    dos.write(b);
                }
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

