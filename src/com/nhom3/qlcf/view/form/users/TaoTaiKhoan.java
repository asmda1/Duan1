/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.users;

import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.model.NguoiDung;
import java.util.stream.Stream;

/**
 *
 * @author baotri1998
 */
public class TaoTaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form Quanlyusers
     */
    public TaoTaiKhoan() {
        initComponents();
        AutogetMaND();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsers = new javax.swing.JTextField();
        lblvien = new javax.swing.JLabel();
        lblvien1 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        lblpass = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        lblpass1 = new javax.swing.JLabel();
        lblvien2 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblpass2 = new javax.swing.JLabel();
        lblvien3 = new javax.swing.JLabel();
        lblpass3 = new javax.swing.JLabel();
        cbxVaiTro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CẦN NHẬP");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setMaximumSize(new java.awt.Dimension(122, 17));
        jLabel1.setMinimumSize(new java.awt.Dimension(122, 17));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(122, 17));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 58));

        txtUsers.setBorder(null);
        txtUsers.setOpaque(false);
        txtUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsersActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 102, 259, 40));

        lblvien.setText("___________________________________________");
        jPanel1.add(lblvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 114, 260, 30));

        lblvien1.setText("___________________________________________");
        jPanel1.add(lblvien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 260, 30));

        txtMatKhau.setBorder(null);
        txtMatKhau.setOpaque(false);
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 259, 40));

        lblpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass.setText("Password*:");
        jPanel1.add(lblpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, 20));

        lbluser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbluser.setText("UserName*:");
        jPanel1.add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 80, 20));

        txtTen.setBorder(null);
        txtTen.setOpaque(false);
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 259, 40));

        lblpass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass1.setText("Họ Tên*:");
        jPanel1.add(lblpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, 20));

        lblvien2.setText("___________________________________________");
        jPanel1.add(lblvien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 260, 30));

        txtSDT.setBorder(null);
        txtSDT.setOpaque(false);
        jPanel1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 259, 40));

        lblpass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass2.setText("Vài Trò:");
        jPanel1.add(lblpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, 20));

        lblvien3.setText("___________________________________________");
        jPanel1.add(lblvien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 260, 30));

        lblpass3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass3.setText("Số ĐT *:");
        jPanel1.add(lblpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 20));

        cbxVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Admin" }));
        cbxVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVaiTroActionPerformed(evt);
            }
        });
        jPanel1.add(cbxVaiTro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 210, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reset");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 110, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TẠO");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsersActionPerformed

    private void cbxVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVaiTroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVaiTroActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        InsertUser();
    }//GEN-LAST:event_jLabel4MousePressed
    public void InsertUser() {
        NguoiDung nd = new NguoiDung();
        nd.setMaNguoidung(txtUsers.getName());
        nd.setTaiKhoan(txtUsers.getText());
        nd.setMatKhau(txtMatKhau.getText());
        nd.setDienThoai(txtSDT.getText());
        nd.setHoTen(txtTen.getText());
        nd.setVaiTro((String) cbxVaiTro.getSelectedItem());
        nd.setTrangThai(true);
        NguoiDungDAO ndDAO = new NguoiDungDAO();
        ndDAO.insert(nd);
    }

    public String AutogetMaND() {
        NguoiDungDAO ndDao = new NguoiDungDAO();
        int Index = ndDao.selectAll().size() - 1;
        String chuoi = ndDao.selectAll().get(Index).getMaNguoidung().substring(2);
        int so = Integer.parseInt(chuoi);
        txtUsers.setName("ND00" + String.valueOf(so + 1));
        return txtUsers.getName();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lblpass1;
    private javax.swing.JLabel lblpass2;
    private javax.swing.JLabel lblpass3;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel lblvien;
    private javax.swing.JLabel lblvien1;
    private javax.swing.JLabel lblvien2;
    private javax.swing.JLabel lblvien3;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtUsers;
    // End of variables declaration//GEN-END:variables
}
