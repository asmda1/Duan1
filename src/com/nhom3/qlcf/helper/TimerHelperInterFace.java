/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author baotri1998
 */
public interface TimerHelperInterFace {

    public void TimerLoad(ActionListener action);
    public void DatLichTimer(JLabel lbl,JLabel sound, String sql);
     public void LoadTime5s();
     public boolean datlich(JLabel lbl, JLabel sound, String sql);
}
