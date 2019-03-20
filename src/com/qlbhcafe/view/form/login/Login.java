/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbhcafe.view.form.login;

import static com.qlbhcafe.view.form.login.FormLogin.jfLogin;
import com.qlbhcafe.view.form.menu.FormMenu;
import java.awt.Color;

/**
 *
 * @author baotri1998
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form login
     */
    public static Login lg;

    public Login() {
        initComponents();
        lg = this;
        jpnNenButton_login.setBackground(new Color(0, 0, 0, 64));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpnBanner_login = new javax.swing.JLabel();
        txtU = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lbluserIcon = new javax.swing.JLabel();
        lblPassicon = new javax.swing.JLabel();
        jpnNenButton_login = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setOpaque(false);

        jpnLogin.setBackground(new java.awt.Color(0, 0, 65));
        jpnLogin.setOpaque(false);
        jpnLogin.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jpnBanner_login.setBackground(new java.awt.Color(102, 102, 255));
        jpnBanner_login.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jpnBanner_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpnBanner_login.setText("LOGIN HERE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnBanner_login, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnBanner_login, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jpnLogin.add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 110);

        txtU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtU.setForeground(new java.awt.Color(255, 255, 255));
        txtU.setText("nhanvien1");
        txtU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtU.setCaretColor(new java.awt.Color(255, 255, 255));
        txtU.setOpaque(false);
        txtU.setRequestFocusEnabled(false);
        txtU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUActionPerformed(evt);
            }
        });
        jpnLogin.add(txtU);
        txtU.setBounds(60, 200, 330, 50);

        txtPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setText("123455");
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtPass.setOpaque(false);
        jpnLogin.add(txtPass);
        txtPass.setBounds(60, 290, 330, 50);

        lbluserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/iconUser.png"))); // NOI18N
        jpnLogin.add(lbluserIcon);
        lbluserIcon.setBounds(340, 200, 50, 50);

        lblPassicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/lockicon.png"))); // NOI18N
        jpnLogin.add(lblPassicon);
        lblPassicon.setBounds(340, 290, 50, 50);

        jpnNenButton_login.setBackground(new java.awt.Color(204, 255, 255));
        jpnNenButton_login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jpnNenButton_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnNenButton_loginMouseClicked(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblLoginMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpnNenButton_loginLayout = new javax.swing.GroupLayout(jpnNenButton_login);
        jpnNenButton_login.setLayout(jpnNenButton_loginLayout);
        jpnNenButton_loginLayout.setHorizontalGroup(
            jpnNenButton_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        jpnNenButton_loginLayout.setVerticalGroup(
            jpnNenButton_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jpnLogin.add(jpnNenButton_login);
        jpnNenButton_login.setBounds(130, 400, 210, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quên Mật Khẩu?");
        jpnLogin.add(jLabel5);
        jLabel5.setBounds(310, 360, 120, 20);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText(" Ghi nhớ");
        jCheckBox1.setOpaque(false);
        jpnLogin.add(jCheckBox1);
        jCheckBox1.setBounds(60, 360, 190, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseEntered
        // TODO add your handling code here:
        jpnNenButton_login.setBackground(Color.WHITE);
        lblLogin.setForeground(Color.BLACK);
        jpnNenButton_login.setOpaque(true);
    }//GEN-LAST:event_lblLoginMouseEntered

    private void lblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseExited
        // TODO add your handling code here:
        jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);
    }//GEN-LAST:event_lblLoginMouseExited

    private void jpnNenButton_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNenButton_loginMouseClicked
        // TODO add your handling code here:
        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(new FormMenu());
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        jfLogin.hide();
    }//GEN-LAST:event_jpnNenButton_loginMouseClicked

    private void lblLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMousePressed
        // TODO add your handling code here:
        
        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(new FormMenu());
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);

        jfLogin.hide();
    }//GEN-LAST:event_lblLoginMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jpnBanner_login;
    private javax.swing.JPanel jpnLogin;
    public static javax.swing.JPanel jpnNenButton_login;
    public static javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassicon;
    private javax.swing.JLabel lbluserIcon;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtU;
    // End of variables declaration//GEN-END:variables
}
