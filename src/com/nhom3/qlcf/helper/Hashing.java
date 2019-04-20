/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baotri1998
 */
public class Hashing {

    public static String hashedText(String password) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] pasToByte = password.getBytes();
            byte[] hashedByte = md.digest(pasToByte);
            BigInteger passToInt = new BigInteger(hashedByte);
            String result = passToInt.toString(16);
            return result;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hashing.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

    public static String randomCode(int lenght) {
        String sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            int index = (int) (random.nextFloat() * sample.length());
            sb.append(sample.charAt(index));
        }
        return sb.toString();
    }

    public static String ramdomso(int lenght) {
        String mahoa = "0123456789";
        Random random = new Random();
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            int index = (int) (random.nextFloat() * mahoa.length());
            sbr.append(mahoa.charAt(index));
        }
        return sbr.toString();
    }
}
