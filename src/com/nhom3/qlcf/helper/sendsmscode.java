/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.io.IOException;

/**
 *
 * @author baotri1998
 */
public class sendsmscode {

    public void sendSMScode(String sdt,String code) {
     
        SpeedSMSAPI api = new SpeedSMSAPI("QSX6vmppNEZEA6d67QpmB0C3gVtefZZM");
        try {
            String result = api.sendSMS(sdt, "Ma xac nhan cua khach hang la: " + code, 4, "");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void sendSMSxacnhan(String sdt, String tentk) {
        String mess = " Xin chuc mung, " + tentk + " ban da tro thanh hoi vien cua chung toi va se duoc tan huong nhung uu dai dac biet tu TNP Coffe!"
                + "Xin cam on!";
        SpeedSMSAPI api = new SpeedSMSAPI("QSX6vmppNEZEA6d67QpmB0C3gVtefZZM");
        try {
            String re = api.sendSMS(sdt, mess, 2, "");
            System.out.println(re);
        } catch (Exception e) {
        }
    }
      

    public static void main(String[] args) {
      
    }
}
