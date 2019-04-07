/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.users;

import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.helper.Hashing;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.Loginhelper;
import com.nhom3.qlcf.helper.SendMailHelper;
import com.nhom3.qlcf.helper.Timehelper;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.model.NguoiDung;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author baotri1998
 */
public class DoiMatKhau extends javax.swing.JPanel {

    /**
     * Creates new form Quanlyusers
     */
    NguoiDung ndung = null;

    public DoiMatKhau() {
        initComponents();
        code = Hashing.randomCode(4);
        lblmaXN.setText(code);
    }
    String code;

    public boolean check() {

        if (txtmkcu.getText().trim().equals("")) {
            lblthongbao.setText(" Không được bỏ trống mật khẩu");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (new NguoiDungDAO().checkMK(txtmkcu.getText()) == false) {
            lblthongbao.setText("Mật khẩu không đúng");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtmkmoi1.getText().trim().equals("")) {
            lblthongbao.setText("Mật khẩu mới không được bỏ trống");

            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtxnmkm.getText().length() < 3) {
            lblthongbao.setText("Mật khẩu phải ít nhất 3 kí tự");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtxnmkm.getText().trim().equals("")) {
            lblthongbao.setText("Chưa nhập xác nhận mật khậu");

            lblthongbao.setForeground(Color.red);
            return false;
        } else if (!txtxnmkm.getText().equals(txtmkmoi1.getText().trim())) {
            lblthongbao.setText("Mật khẩu xác nhận không đúng");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtcode.getText().trim().equals("")) {
            lblthongbao.setText("Code không được bỏ trống!");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (!txtcode.getText().equals(code)) {
            lblthongbao.setText("Code không đúng!");
            lblthongbao.setForeground(Color.red);
            code = Hashing.randomCode(4);
            lblmaXN.setText(code);
            return false;
        }
        return true;
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
        lblpass3 = new javax.swing.JLabel();
        lblvien2 = new javax.swing.JLabel();
        lblpass1 = new javax.swing.JLabel();
        lblvien3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblthongbao = new javax.swing.JLabel();
        lblpass2 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        lblvien4 = new javax.swing.JLabel();
        lblpass4 = new javax.swing.JLabel();
        lblvien5 = new javax.swing.JLabel();
        txtmkcu = new javax.swing.JPasswordField();
        txtmkmoi1 = new javax.swing.JPasswordField();
        txtxnmkm = new javax.swing.JPasswordField();
        lblmaXN = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblpass3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass3.setText("Xác Nhận Mật Khẩu:");
        jPanel1.add(lblpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, 20));

        lblvien2.setText("___________________________________________");
        jPanel1.add(lblvien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 260, 30));

        lblpass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass1.setText("Mật Khẩu Cũ:");
        jPanel1.add(lblpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

        lblvien3.setText("___________________________________________");
        jPanel1.add(lblvien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 260, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("HỦY");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 110, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CHẤP NHẬN");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 40));

        lblthongbao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblthongbao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblthongbao.setText(".");
        jPanel1.add(lblthongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 10, 360, 30));

        lblpass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass2.setText("Nhập Code:");
        jPanel1.add(lblpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 80, 20));

        txtcode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcode.setBorder(null);
        txtcode.setOpaque(false);
        jPanel1.add(txtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 170, 40));

        lblvien4.setText("____________________________");
        jPanel1.add(lblvien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 180, 30));

        lblpass4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass4.setText("Mật Khẩu Mới:");
        jPanel1.add(lblpass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 20));

        lblvien5.setText("___________________________________________");
        jPanel1.add(lblvien5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 260, 30));

        txtmkcu.setBorder(null);
        txtmkcu.setOpaque(false);
        jPanel1.add(txtmkcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 260, 40));

        txtmkmoi1.setBorder(null);
        txtmkmoi1.setOpaque(false);
        jPanel1.add(txtmkmoi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 260, 40));

        txtxnmkm.setBorder(null);
        txtxnmkm.setOpaque(false);
        jPanel1.add(txtxnmkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, 40));

        lblmaXN.setBackground(new java.awt.Color(0, 0, 0));
        lblmaXN.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        lblmaXN.setForeground(new java.awt.Color(255, 255, 255));
        lblmaXN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmaXN.setText("....");
        lblmaXN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmaXN.setOpaque(true);
        lblmaXN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblmaXNMousePressed(evt);
            }
        });
        jPanel1.add(lblmaXN, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 260, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        if (check()) {
            JDBCHelper.executeUpdate("Update dbo.NguoiDung set matKhau ='" + txtxnmkm.getText() + "' where maNguoiDung ='" + new ThongTinTK().lblMa.getText() + "'");
            lblthongbao.setText("Đổi mật khẩu thành công!");
            lblthongbao.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_jLabel7MousePressed

    private void lblmaXNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmaXNMousePressed
        // TODO add your handling code here:
        lblthongbao.setText("Đang Đỗi...");
        Timehelper timehelper = new Timehelper();
        timehelper.TimerLoad(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    code = Hashing.randomCode(4);
                    lblmaXN.setText(code);
                    lblthongbao.setText("");
                    lblthongbao.setForeground(Color.GREEN);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi");
                }

                timehelper.t.stop();
            }
        });
    }//GEN-LAST:event_lblmaXNMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblmaXN;
    private javax.swing.JLabel lblpass1;
    private javax.swing.JLabel lblpass2;
    private javax.swing.JLabel lblpass3;
    private javax.swing.JLabel lblpass4;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JLabel lblvien2;
    private javax.swing.JLabel lblvien3;
    private javax.swing.JLabel lblvien4;
    private javax.swing.JLabel lblvien5;
    private javax.swing.JTextField txtcode;
    private javax.swing.JPasswordField txtmkcu;
    private javax.swing.JPasswordField txtmkmoi1;
    private javax.swing.JPasswordField txtxnmkm;
    // End of variables declaration//GEN-END:variables
}
