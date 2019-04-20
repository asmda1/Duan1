/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import com.nhom3.qlcf.view.form.login.FormLogin;
import static com.nhom3.qlcf.view.form.login.FormLogin.jfLogin;
import com.nhom3.qlcf.view.form.login.Login;
import static com.nhom3.qlcf.view.form.login.Login.jpnNenButton_login;
import static com.nhom3.qlcf.view.form.login.Login.lblLogin;
import com.nhom3.qlcf.view.form.menu.FormMenu;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author baotri1998
 */
public class Loginhelper {

    public void getLogin(JLabel user) {
         if (!Login.lg.list.isEmpty()) {
                    for (int i = 0; i < Login.lg.list.size(); i++) {
                        user.setText(Login.lg.list.get(i).getHoTen());
                        user.setName(Login.lg.list.get(i).getMaNguoidung());

                    }
                }
      

    }

    public void QuayVe() {
        if (Login.lg.list.get(0).getVaiTro().equals("Administration")) {
            FormLogin.login.Card.removeAll();
            FormLogin.login.Card.add(new FormMenu());
            FormLogin.login.Card.repaint();
            FormLogin.login.Card.revalidate();
            FormLogin.login.Card.show();
            jpnNenButton_login.setBackground(new Color(0, 0, 0));
            jpnNenButton_login.setOpaque(false);
            lblLogin.setForeground(Color.white);
            jfLogin.hide();
        } else {
            FormLogin.login.Card.removeAll();
            FormLogin.login.Card.add(new FormMenu(null));
            FormLogin.login.Card.repaint();
            FormLogin.login.Card.revalidate();
            FormLogin.login.Card.show();
            jpnNenButton_login.setBackground(new Color(0, 0, 0));
            jpnNenButton_login.setOpaque(false);
            lblLogin.setForeground(Color.white);
            jfLogin.hide();
        }
    }
}
