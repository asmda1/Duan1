/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author baotri1998
 */
public class Timehelper implements TimerHelperInterFace {

    public javax.swing.Timer t;

    @Override
    public void TimerLoad(ActionListener action) {

        t = new javax.swing.Timer(1, action);
        t.start();

    }

    @Override
    public boolean datlich(JLabel lbl, JLabel lblsound, String sql) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 7); //0h:0m:10s
        Date dateSchedule = calendar.getTime();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                ResultSet rs = JDBCHelper.executeQuery(sql);
                try {
                    while (rs.next()) {
                        lbl.setText(rs.getString(1));
                        Soundhelper mp3;
                       
                        mp3 = new Soundhelper( getClass().getResource("/com/nhom3/qlcf/mp3/RengReng.mp3"));

                        if (lbl.getText().equals("0") || lblsound.getName().equals("mute")) {
                            lblsound.setName("sound");
                            lblsound.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/mute.png")));
                            mp3.stop();
                        } else {
                            mp3.play();
                            lblsound.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/sound.png")));
                        }
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };

        if (lblsound.getName().equals("sound")) {
            long period = 24 * 150;  //tinh theo giay 
            java.util.Timer timer = new java.util.Timer();
            timer.schedule(timerTask, dateSchedule, period);
            return false;
        }

        return true;
    }

    @Override
    public void DatLichTimer(JLabel lbl, JLabel lblsound, String sql) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 7); //0h:0m:10s
        Date dateSchedule = calendar.getTime();
        long period = 24 * 150;  //tinh theo giay 

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                ResultSet rs = JDBCHelper.executeQuery(sql);
                try {
                    while (rs.next()) {
                        lbl.setText(rs.getString(1));
                        Soundhelper mp3;
                       mp3 = new Soundhelper( getClass().getResource("/com/nhom3/qlcf/mp3/RengReng.mp3"));
                        if (lbl.getText().equals("0") || lblsound.getName().equals("mute")) {
                            mp3.stop();
                        } else {
                            mp3.play();

                        }
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        if (lblsound.getName().equals("sound")) {

            java.util.Timer timer = new java.util.Timer();
            timer.schedule(timerTask, dateSchedule, period);

        }

    }

    @Override
    public void LoadTime5s() {

    }

}
