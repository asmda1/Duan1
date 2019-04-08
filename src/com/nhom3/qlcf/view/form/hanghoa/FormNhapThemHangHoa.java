/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.hanghoa;

import com.nhom3.qlcf.helper.Loginhelper;
import com.nhom3.qlcf.view.form.login.FormLogin;
;
import com.nhom3.qlcf.view.Run;
import com.nhom3.qlcf.view.form.login.Login;
import com.nhom3.qlcf.view.form.menu.FormMenu;
import static com.nhom3.qlcf.view.form.menu.FormMenu.jfMain;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author baotri1998
 */


public class FormNhapThemHangHoa extends javax.swing.JPanel {

    /**
     * Creates new form FormLogin
     */
    public static FormNhapThemHangHoa nhapThemHangHoa;

    public FormNhapThemHangHoa() {
        initComponents();
        // jpnLogin1.setBackground(new Color(0, 0, 0, 134));
        //jpnNenButton_login1.setBackground(new Color(0, 0, 0, 64));
        nhapThemHangHoa = this;

        jpnThemHoangHoa.add(new NhapHang());
        new Loginhelper().getLogin(lblTenDangNhapBangHang);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Card = new javax.swing.JPanel();
        jfNhapThemHang = new javax.swing.JPanel();
        jpnShowMenuOut = new javax.swing.JPanel();
        jpnQuayVe = new javax.swing.JPanel();
        lblQuayVeBangHang = new javax.swing.JLabel();
        jpnTenDangNhap = new javax.swing.JPanel();
        lblTenDangNhapBangHang = new javax.swing.JLabel();
        jpnDangXuat = new javax.swing.JPanel();
        lblDangXuatBangHang = new javax.swing.JLabel();
        jpnNen = new javax.swing.JPanel();
        jpldanhmuc = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNen = new javax.swing.JLabel();
        jpnThemHoangHoa = new javax.swing.JPanel();
        jpnToolbar19 = new javax.swing.JPanel();
        lblAn = new javax.swing.JLabel();
        lblOut = new javax.swing.JLabel();
        lblanhGiaoDien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        Card.setBackground(new java.awt.Color(255, 255, 255));
        Card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Card.setLayout(new java.awt.CardLayout());
        add(Card);

        jfNhapThemHang.setBackground(new java.awt.Color(255, 255, 255));
        jfNhapThemHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jfNhapThemHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnShowMenuOut.setBackground(new java.awt.Color(255, 255, 255));
        jpnShowMenuOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jpnShowMenuOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnShowMenuOutMouseExited(evt);
            }
        });
        jpnShowMenuOut.setLayout(null);

        jpnQuayVe.setBackground(new java.awt.Color(255, 255, 255));

        lblQuayVeBangHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblQuayVeBangHang.setForeground(new java.awt.Color(51, 102, 255));
        lblQuayVeBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuayVeBangHang.setText("Quay Về");
        lblQuayVeBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuayVeBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuayVeBangHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuayVeBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuayVeBangHangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnQuayVeLayout = new javax.swing.GroupLayout(jpnQuayVe);
        jpnQuayVe.setLayout(jpnQuayVeLayout);
        jpnQuayVeLayout.setHorizontalGroup(
            jpnQuayVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVeBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnQuayVeLayout.setVerticalGroup(
            jpnQuayVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVeBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnQuayVe);
        jpnQuayVe.setBounds(10, 90, 150, 40);

        jpnTenDangNhap.setBackground(new java.awt.Color(255, 255, 255));

        lblTenDangNhapBangHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTenDangNhapBangHang.setForeground(new java.awt.Color(51, 102, 255));
        lblTenDangNhapBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenDangNhapBangHang.setText("Tên NV");
        lblTenDangNhapBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTenDangNhapBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTenDangNhapBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTenDangNhapBangHangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnTenDangNhapLayout = new javax.swing.GroupLayout(jpnTenDangNhap);
        jpnTenDangNhap.setLayout(jpnTenDangNhapLayout);
        jpnTenDangNhapLayout.setHorizontalGroup(
            jpnTenDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenDangNhapBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnTenDangNhapLayout.setVerticalGroup(
            jpnTenDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenDangNhapBangHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnTenDangNhap);
        jpnTenDangNhap.setBounds(10, 9, 150, 40);

        jpnDangXuat.setBackground(new java.awt.Color(255, 255, 255));

        lblDangXuatBangHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDangXuatBangHang.setForeground(new java.awt.Color(51, 102, 255));
        lblDangXuatBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuatBangHang.setText("Đăng Xuất");
        lblDangXuatBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDangXuatBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatBangHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDangXuatBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDangXuatBangHangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnDangXuatLayout = new javax.swing.GroupLayout(jpnDangXuat);
        jpnDangXuat.setLayout(jpnDangXuatLayout);
        jpnDangXuatLayout.setHorizontalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuatBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnDangXuatLayout.setVerticalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuatBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnDangXuat);
        jpnDangXuat.setBounds(10, 50, 150, 40);

        jfNhapThemHang.add(jpnShowMenuOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 170, 140));
        jpnShowMenuOut.hide();

        jpnNen.setBackground(new java.awt.Color(255, 255, 255));

        jpldanhmuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpldanhmuc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NHẬP HÀNG");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jpldanhmuc.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 240, 180));

        lblNen.setBackground(new java.awt.Color(255, 255, 255));
        lblNen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/nenAdmin.png"))); // NOI18N
        lblNen.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        lblNen.setOpaque(true);
        jpldanhmuc.add(lblNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 620));

        jpnThemHoangHoa.setBackground(new Color(0,0,0,105)
        );
        jpnThemHoangHoa.setLayout(new javax.swing.BoxLayout(jpnThemHoangHoa, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jpnNenLayout = new javax.swing.GroupLayout(jpnNen);
        jpnNen.setLayout(jpnNenLayout);
        jpnNenLayout.setHorizontalGroup(
            jpnNenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNenLayout.createSequentialGroup()
                .addComponent(jpldanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jpnThemHoangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jpnNenLayout.setVerticalGroup(
            jpnNenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpldanhmuc, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnThemHoangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jfNhapThemHang.add(jpnNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1080, 630));

        jpnToolbar19.setBackground(new java.awt.Color(255, 255, 255));
        jpnToolbar19.setOpaque(false);

        lblAn.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAn.setForeground(new java.awt.Color(255, 255, 255));
        lblAn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAn.setText("-");
        lblAn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnMouseClicked(evt);
            }
        });

        lblOut.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout.png"))); // NOI18N
        lblOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblOutMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblOutMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jpnToolbar19Layout = new javax.swing.GroupLayout(jpnToolbar19);
        jpnToolbar19.setLayout(jpnToolbar19Layout);
        jpnToolbar19Layout.setHorizontalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnToolbar19Layout.createSequentialGroup()
                .addContainerGap(996, Short.MAX_VALUE)
                .addComponent(lblAn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOut)
                .addGap(17, 17, 17))
        );
        jpnToolbar19Layout.setVerticalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblOut, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jfNhapThemHang.add(jpnToolbar19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 50));

        lblanhGiaoDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/nenThuNgan.png"))); // NOI18N
        jfNhapThemHang.add(lblanhGiaoDien, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1120, 710));

        jLabel1.setText("jLabel1");
        jfNhapThemHang.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        add(jfNhapThemHang);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnMouseClicked
        // TODO add your handling code here:
        Run.main.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblAnMouseClicked

    private void lblOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseClicked
        // TODO add your handling code here:
        jpnShowMenuOut.show();
        lblOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout.png")));
    }//GEN-LAST:event_lblOutMouseClicked

    private void lblOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseEntered
        // TODO add your handling code here:
        lblOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout_hover.png")));
    }//GEN-LAST:event_lblOutMouseEntered

    private void lblOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseExited
        // TODO add your handling code here:
        lblOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout.png")));
    }//GEN-LAST:event_lblOutMouseExited

    private void lblOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutMousePressed

    private void lblOutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutMouseReleased

    private void lblQuayVeBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseClicked
        // TODO add your handling code here:

     new Loginhelper().QuayVe();
        /*jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));
        jpnBanHang_Button.setBackground(new Color(0, 0, 0));
        jpnBanHang_Button.setOpaque(false);
        lblBanHang_txt.setForeground(Color.WHITE);*/
        jpnQuayVe.setBackground(Color.white);
        lblQuayVeBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblQuayVeBangHangMouseClicked

    private void lblQuayVeBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseEntered
        // TODO add your handling code here:
        jpnQuayVe.setBackground(new Color(51, 102, 255));
        lblQuayVeBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblQuayVeBangHangMouseEntered

    private void lblQuayVeBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseExited
        // TODO add your handling code here:
        jpnQuayVe.setBackground(Color.white);
        lblQuayVeBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblQuayVeBangHangMouseExited

    private void lblTenDangNhapBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenDangNhapBangHangMouseEntered
        // TODO add your handling code here:
        jpnTenDangNhap.setBackground(new Color(51, 102, 255));
        lblTenDangNhapBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblTenDangNhapBangHangMouseEntered

    private void lblTenDangNhapBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenDangNhapBangHangMouseExited
        // TODO add your handling code here:

        jpnTenDangNhap.setBackground(Color.white);
        lblTenDangNhapBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblTenDangNhapBangHangMouseExited

    private void lblDangXuatBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseClicked
        // TODO add your handling code here:
        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(FormLogin.login.jfLogin);
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        jfMain.hide();
        jfNhapThemHang.hide();
        /* jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);
        jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));*/
         Login.txtPass.setText("");
        Login.lblLoiDangNhap.hide();
        jpnShowMenuOut.hide();
        jpnDangXuat.setBackground(Color.white);
        lblDangXuatBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblDangXuatBangHangMouseClicked

    private void lblDangXuatBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseEntered
        // TODO add your handling code here:

        jpnDangXuat.setBackground(new Color(51, 102, 255));
        lblDangXuatBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblDangXuatBangHangMouseEntered

    private void lblDangXuatBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseExited
        // TODO add your handling code here:

        jpnDangXuat.setBackground(Color.white);
        lblDangXuatBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblDangXuatBangHangMouseExited

    private void jpnShowMenuOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnShowMenuOutMouseExited
        // TODO add your handling code here:
        jpnShowMenuOut.hide();
    }//GEN-LAST:event_jpnShowMenuOutMouseExited

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel Card;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    protected static javax.swing.JPanel jfNhapThemHang;
    private javax.swing.JPanel jpldanhmuc;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnNen;
    private javax.swing.JPanel jpnQuayVe;
    private javax.swing.JPanel jpnShowMenuOut;
    private javax.swing.JPanel jpnTenDangNhap;
    protected static javax.swing.JPanel jpnThemHoangHoa;
    private javax.swing.JPanel jpnToolbar19;
    private javax.swing.JLabel lblAn;
    private javax.swing.JLabel lblDangXuatBangHang;
    private javax.swing.JLabel lblNen;
    private javax.swing.JLabel lblOut;
    private javax.swing.JLabel lblQuayVeBangHang;
    private javax.swing.JLabel lblTenDangNhapBangHang;
    private javax.swing.JLabel lblanhGiaoDien;
    // End of variables declaration//GEN-END:variables
}
