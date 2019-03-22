/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.sanpham;

import com.nhom3.qlcf.view.form.nhacungcap.*;
import com.nhom3.qlcf.view.form.hanghoa.*;

/**
 *
 * @author baotri1998
 */
public class SuaSP extends javax.swing.JPanel {

    /**
     * Creates new form SuaHangHoa
     */
    public SuaSP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplformNhap = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        lblvien = new javax.swing.JLabel();
        lblvien1 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        lblpass = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblpass3 = new javax.swing.JLabel();
        lblpass2 = new javax.swing.JLabel();
        cbxThayDoiTrangThai = new javax.swing.JComboBox<>();
        lblButonReset = new javax.swing.JLabel();
        lblButonCapNhat = new javax.swing.JLabel();
        lblChonAnh = new javax.swing.JLabel();
        jplformThongTin = new javax.swing.JPanel();
        jplTimkiem = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        lblButonTimKIem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblvien4 = new javax.swing.JLabel();
        lblvien5 = new javax.swing.JLabel();
        lblpass4 = new javax.swing.JLabel();
        lbluser1 = new javax.swing.JLabel();
        lblpass5 = new javax.swing.JLabel();
        lblvien6 = new javax.swing.JLabel();
        lblpass6 = new javax.swing.JLabel();
        lblpass7 = new javax.swing.JLabel();
        lblvien7 = new javax.swing.JLabel();
        lblvien8 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jplformNhap.setBackground(new java.awt.Color(255, 255, 255));
        jplformNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jplformNhap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CẦN NHẬP");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setMaximumSize(new java.awt.Dimension(122, 17));
        jLabel1.setMinimumSize(new java.awt.Dimension(122, 17));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(122, 17));
        jplformNhap.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 58));

        txtTenSP.setBorder(null);
        txtTenSP.setOpaque(false);
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });
        jplformNhap.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 102, 259, 40));

        lblvien.setText("___________________________________________");
        jplformNhap.add(lblvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 114, 260, 30));

        lblvien1.setText("___________________________________________");
        jplformNhap.add(lblvien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 260, 40));

        txtGia.setBackground(new java.awt.Color(255, 204, 0));
        txtGia.setBorder(null);
        txtGia.setOpaque(false);
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });
        jplformNhap.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 259, 40));

        lblpass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass.setText("Cập Nhật Giá:");
        jplformNhap.add(lblpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, 20));

        lbluser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbluser.setText("Cập Nhật Tên:");
        jplformNhap.add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 140, 20));

        lblpass3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass3.setText("Thay Đỗi Hình: ");
        jplformNhap.add(lblpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 100, 20));

        lblpass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass2.setText("Trạng Thái:");
        jplformNhap.add(lblpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, 20));

        cbxThayDoiTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn Bán", "Hết Hàng" }));
        jplformNhap.add(cbxThayDoiTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 210, -1));

        lblButonReset.setBackground(new java.awt.Color(255, 255, 255));
        lblButonReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblButonReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButonReset.setText("Reset");
        lblButonReset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblButonReset.setOpaque(true);
        jplformNhap.add(lblButonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 110, 40));

        lblButonCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        lblButonCapNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblButonCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButonCapNhat.setText("Cập Nhật");
        lblButonCapNhat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblButonCapNhat.setOpaque(true);
        jplformNhap.add(lblButonCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 110, 40));

        lblChonAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblChonAnh.setOpaque(true);
        jplformNhap.add(lblChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 110, 130));

        jplformThongTin.setBackground(new java.awt.Color(255, 255, 255));
        jplformThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jplformThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplTimkiem.setBackground(new java.awt.Color(0, 0, 0));

        lblButonTimKIem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblButonTimKIem.setForeground(new java.awt.Color(255, 255, 255));
        lblButonTimKIem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButonTimKIem.setText("Tìm Kiếm");

        javax.swing.GroupLayout jplTimkiemLayout = new javax.swing.GroupLayout(jplTimkiem);
        jplTimkiem.setLayout(jplTimkiemLayout);
        jplTimkiemLayout.setHorizontalGroup(
            jplTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTimkiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblButonTimKIem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jplTimkiemLayout.setVerticalGroup(
            jplTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblButonTimKIem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        jplformThongTin.add(jplTimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setMaximumSize(new java.awt.Dimension(122, 17));
        jLabel2.setMinimumSize(new java.awt.Dimension(122, 17));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(122, 17));
        jplformThongTin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 58));

        lblvien4.setText(".....................");
        jplformThongTin.add(lblvien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 114, 260, 30));

        lblvien5.setText("......................");
        jplformThongTin.add(lblvien5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 260, 40));

        lblpass4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass4.setText("Loại Hàng:");
        jplformThongTin.add(lblpass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, 20));

        lbluser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbluser1.setText("Tên Sản Phẩm:");
        jplformThongTin.add(lbluser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 140, 20));

        lblpass5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass5.setText("Nhà Cung Cấp:");
        jplformThongTin.add(lblpass5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 20));

        lblvien6.setText(".....................");
        jplformThongTin.add(lblvien6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 260, 30));

        lblpass6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass6.setText("Gía Bán Hiện Tại:");
        jplformThongTin.add(lblpass6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 120, 20));

        lblpass7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass7.setText("Trạng Thái:");
        jplformThongTin.add(lblpass7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, 20));

        lblvien7.setText(".....................");
        jplformThongTin.add(lblvien7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 260, 30));

        lblvien8.setText(".....................");
        jplformThongTin.add(lblvien8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 260, 30));

        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setOpaque(true);
        jplformThongTin.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 110, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jplformThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jplformNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jplformThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(jplformNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your hantxtdiachihere:
    }//GEN-LAST:event_txtGiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxThayDoiTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jplTimkiem;
    private javax.swing.JPanel jplformNhap;
    private javax.swing.JPanel jplformThongTin;
    private javax.swing.JLabel lblButonCapNhat;
    private javax.swing.JLabel lblButonReset;
    private javax.swing.JLabel lblButonTimKIem;
    private javax.swing.JLabel lblChonAnh;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lblpass2;
    private javax.swing.JLabel lblpass3;
    private javax.swing.JLabel lblpass4;
    private javax.swing.JLabel lblpass5;
    private javax.swing.JLabel lblpass6;
    private javax.swing.JLabel lblpass7;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel lbluser1;
    private javax.swing.JLabel lblvien;
    private javax.swing.JLabel lblvien1;
    private javax.swing.JLabel lblvien4;
    private javax.swing.JLabel lblvien5;
    private javax.swing.JLabel lblvien6;
    private javax.swing.JLabel lblvien7;
    private javax.swing.JLabel lblvien8;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
