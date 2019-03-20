/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbhcafe.view.form.nhacungcap;

import com.qlbhcafe.view.form.sanpham.*;
import com.qlbhcafe.view.form.hanghoa.*;
import com.qlbhcafe.view.form.login.FormLogin;
import com.qlbhcafe.view.form.menu.FormMenu;
import com.qlbhcafe.view.Run;
import static com.qlbhcafe.view.form.menu.FormMenu.jfMain;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author baotri1998
 */
public class FormDanhSachNhaCC extends javax.swing.JPanel {

    /**
     * Creates new form FormLogin
     */
    public static FormDanhSachNhaCC login;

    public FormDanhSachNhaCC() {
        initComponents();
        // jpnLogin1.setBackground(new Color(0, 0, 0, 134));
        //jpnNenButton_login1.setBackground(new Color(0, 0, 0, 64));
        login = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfThemNhaCungCap = new javax.swing.JPanel();
        jpnShowMenuOut = new javax.swing.JPanel();
        jpnQuayVe = new javax.swing.JPanel();
        lblQuayVeBangHang = new javax.swing.JLabel();
        jpnTenDangNhap = new javax.swing.JPanel();
        lblTenDangNhapBangHang = new javax.swing.JLabel();
        jpnDangXuat = new javax.swing.JPanel();
        lblDangXuatBangHang = new javax.swing.JLabel();
        jpnToolbar19 = new javax.swing.JPanel();
        lblAn_BanHang = new javax.swing.JLabel();
        lblOutBangHang = new javax.swing.JLabel();
        jpnNen = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblanhGiaoDien = new javax.swing.JLabel();
        Card = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jfThemNhaCungCap.setBackground(new java.awt.Color(255, 255, 255));
        jfThemNhaCungCap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jfThemNhaCungCap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jfThemNhaCungCap.add(jpnShowMenuOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 170, 140));
        jpnShowMenuOut.hide();

        jpnToolbar19.setBackground(new java.awt.Color(255, 255, 255));
        jpnToolbar19.setOpaque(false);

        lblAn_BanHang.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAn_BanHang.setForeground(new java.awt.Color(255, 255, 255));
        lblAn_BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAn_BanHang.setText("-");
        lblAn_BanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAn_BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAn_BanHangMouseClicked(evt);
            }
        });

        lblOutBangHang.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblOutBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/logout.png"))); // NOI18N
        lblOutBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOutBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblOutBangHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jpnToolbar19Layout = new javax.swing.GroupLayout(jpnToolbar19);
        jpnToolbar19.setLayout(jpnToolbar19Layout);
        jpnToolbar19Layout.setHorizontalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnToolbar19Layout.createSequentialGroup()
                .addContainerGap(996, Short.MAX_VALUE)
                .addComponent(lblAn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOutBangHang)
                .addGap(17, 17, 17))
        );
        jpnToolbar19Layout.setVerticalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblOutBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jfThemNhaCungCap.add(jpnToolbar19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 50));

        jpnNen.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblKhachHang2.setForeground(new java.awt.Color(51, 51, 51));
        tblKhachHang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MNCC", "Tên", "Điện Thoại", "Chi Nhánh", "Loại Hàng SX"
            }
        ));
        tblKhachHang2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblKhachHang2.setFocusable(false);
        tblKhachHang2.setGridColor(new java.awt.Color(0, 0, 0));
        tblKhachHang2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKhachHang2.setRowHeight(25);
        tblKhachHang2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblKhachHang2.setShowHorizontalLines(false);
        tblKhachHang2.setShowVerticalLines(false);
        tblKhachHang2.setSurrendersFocusOnKeystroke(true);
        tblKhachHang2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblKhachHang2);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sắp Xếp Theo Loại Hàng");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jTextField1.setText("Tìm kiếm ten nha cc");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tìm Kiếm");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnNenLayout = new javax.swing.GroupLayout(jpnNen);
        jpnNen.setLayout(jpnNenLayout);
        jpnNenLayout.setHorizontalGroup(
            jpnNenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnNenLayout.setVerticalGroup(
            jpnNenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnNenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jfThemNhaCungCap.add(jpnNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1080, 630));

        lblanhGiaoDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/nenDao.png"))); // NOI18N
        jfThemNhaCungCap.add(lblanhGiaoDien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));

        add(jfThemNhaCungCap);

        Card.setBackground(new java.awt.Color(255, 255, 255));
        Card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Card.setLayout(new java.awt.CardLayout());
        add(Card);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAn_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAn_BanHangMouseClicked
        // TODO add your handling code here:
        Run.main.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblAn_BanHangMouseClicked

    private void lblOutBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseClicked
        // TODO add your handling code here:
        jpnShowMenuOut.show();
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/logout.png")));
    }//GEN-LAST:event_lblOutBangHangMouseClicked

    private void lblOutBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseEntered
        // TODO add your handling code here:
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/logout_hover.png")));
    }//GEN-LAST:event_lblOutBangHangMouseEntered

    private void lblOutBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseExited
        // TODO add your handling code here:
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlbhcafe/img/logout.png")));
    }//GEN-LAST:event_lblOutBangHangMouseExited

    private void lblOutBangHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutBangHangMousePressed

    private void lblOutBangHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutBangHangMouseReleased

    private void lblQuayVeBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseClicked
        // TODO add your handling code here:

        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(new FormMenu());
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
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
        jfThemNhaCungCap.hide();
        /* jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);
        jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));*/
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel Card;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    protected static javax.swing.JPanel jfThemNhaCungCap;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnNen;
    private javax.swing.JPanel jpnQuayVe;
    private javax.swing.JPanel jpnShowMenuOut;
    private javax.swing.JPanel jpnTenDangNhap;
    private javax.swing.JPanel jpnToolbar19;
    private javax.swing.JLabel lblAn_BanHang;
    private javax.swing.JLabel lblDangXuatBangHang;
    private javax.swing.JLabel lblOutBangHang;
    private javax.swing.JLabel lblQuayVeBangHang;
    private javax.swing.JLabel lblTenDangNhapBangHang;
    private javax.swing.JLabel lblanhGiaoDien;
    private javax.swing.JTable tblKhachHang2;
    // End of variables declaration//GEN-END:variables
}
