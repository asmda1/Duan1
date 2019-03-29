/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author baotri1998
 */
public class ReSizehelper {
        public BufferedImage buffImage(BufferedImage buffImage, int type,int chieurong,int chieucao ) {
   
        BufferedImage buff = new BufferedImage(chieurong, chieucao, type);
        //set đồ họa ảnh
        Graphics2D g = buff.createGraphics();
        g.drawImage(buffImage, 0, 0, chieurong, chieucao, null);
        g.dispose();
        return buff;
    }

}
