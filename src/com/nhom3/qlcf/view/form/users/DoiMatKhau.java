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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
    List<String> img = null;

    public DoiMatKhau() {
        initComponents();
        loadImg();
        txtmkshow.hide();
        txtmkmshow.hide();
        txtxnmkshow.hide();

    }
    String code;

    public void loadImg() {
        if (lblmaXN.getName().equals("code")) {
            lblmaXN.setName("code1");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code1.png")));
        } else if (lblmaXN.getName().equals("code1")) {
            lblmaXN.setName("code2");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code2.png")));
        } else if (lblmaXN.getName().equals("code2")) {
            lblmaXN.setName("code3");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code3.png")));
        } else if (lblmaXN.getName().equals("code3")) {
            lblmaXN.setName("code4");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code4.png")));
        } else if (lblmaXN.getName().equals("code4")) {
            lblmaXN.setName("code5");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code5.png")));
        } else if (lblmaXN.getName().equals("code5")) {
            lblmaXN.setName("code6");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code6.png")));
        } else if (lblmaXN.getName().equals("code6")) {
            lblmaXN.setName("code7");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code7.png")));
        } else if (lblmaXN.getName().equals("code7")) {
            lblmaXN.setName("code8");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code8.png")));
        } else if (lblmaXN.getName().equals("code8")) {
            lblmaXN.setName("code9");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code9.png")));
        } else if (lblmaXN.getName().equals("code9")) {
            lblmaXN.setName("code10");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code10.png")));
        } else if (lblmaXN.getName().equals("code10")) {
            lblmaXN.setName("code11");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code11.png")));
        } else if (lblmaXN.getName().equals("code11")) {
            lblmaXN.setName("code12");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code12.png")));
        } else {
            lblmaXN.setName("code");
            lblimg.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code.png")));
        }
        code = Hashing.randomCode(4);
        lblmaXN.setText(code);

    }

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

            loadImg();
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
        lblmkcu = new javax.swing.JLabel();
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
        jplimg = new javax.swing.JPanel();
        lblmaXN = new javax.swing.JLabel();
        lblimg = new javax.swing.JLabel();
        txtmkshow = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtmkmshow = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtxnmkshow = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblpass3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass3.setText("Xác Nhận Mật Khẩu:");
        jPanel1.add(lblpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, 20));

        lblvien2.setText("___________________________________________");
        jPanel1.add(lblvien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 260, 30));

        lblmkcu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmkcu.setText("Mật Khẩu Cũ:");
        jPanel1.add(lblmkcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

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
        txtmkcu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmkcuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmkcuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmkcuKeyTyped(evt);
            }
        });
        jPanel1.add(txtmkcu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 260, 40));

        txtmkmoi1.setBorder(null);
        txtmkmoi1.setOpaque(false);
        jPanel1.add(txtmkmoi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 260, 40));

        txtxnmkm.setBorder(null);
        txtxnmkm.setOpaque(false);
        jPanel1.add(txtxnmkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, 40));

        jplimg.setBackground(new java.awt.Color(255, 255, 255));
        jplimg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmaXN.setBackground(new java.awt.Color(0, 0, 0));
        lblmaXN.setFont(new java.awt.Font("Viner Hand ITC", 2, 48)); // NOI18N
        lblmaXN.setForeground(new java.awt.Color(153, 153, 255));
        lblmaXN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmaXN.setText("....");
        lblmaXN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmaXN.setName("code"); // NOI18N
        lblmaXN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblmaXNMousePressed(evt);
            }
        });
        jplimg.add(lblmaXN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 60));

        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/code.png"))); // NOI18N
        lblimg.setName("1"); // NOI18N
        lblimg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblimgMousePressed(evt);
            }
        });
        jplimg.add(lblimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 60));

        jPanel1.add(jplimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 220, 60));

        txtmkshow.setBorder(null);
        txtmkshow.setOpaque(false);
        jPanel1.add(txtmkshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 260, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/eye.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 40, 40));

        txtmkmshow.setBorder(null);
        txtmkmshow.setOpaque(false);
        jPanel1.add(txtmkmshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 270, 50));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/eye.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 50, 40));

        txtxnmkshow.setBorder(null);
        txtxnmkshow.setOpaque(false);
        jPanel1.add(txtxnmkshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 270, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/eye.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 50, 50));

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
            txtcode.setText("");
            txtmkcu.setText("");
            txtxnmkm.setText("");
            txtmkmoi1.setText("");
            loadImg();
            lblthongbao.setText("Đổi mật khẩu thành công!");
            lblthongbao.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_jLabel7MousePressed

    private void lblmaXNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmaXNMousePressed
        // TODO add your handling code here:

        code = Hashing.randomCode(4);
        lblmaXN.setText(code);
        loadImg();


    }//GEN-LAST:event_lblmaXNMousePressed

    private void lblimgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblimgMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblimgMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        txtmkshow.show();
        txtmkshow.setText(txtmkcu.getText());
        txtmkcu.hide();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:

        txtmkshow.hide();
        txtmkcu.show();
    }//GEN-LAST:event_jLabel1MouseExited

    private void txtmkcuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmkcuKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtmkcuKeyTyped

    private void txtmkcuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmkcuKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtmkcuKeyPressed

    private void txtmkcuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmkcuKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtmkcuKeyReleased

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        txtmkmshow.hide();
        txtmkmoi1.show();

    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        txtmkmshow.show();
        txtmkmshow.setText(txtmkmoi1.getText());
        txtmkmoi1.hide();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        txtxnmkshow.show();
        txtxnmkshow.setText(txtxnmkm.getText());
        txtxnmkm.hide();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        txtxnmkshow.hide();
        txtxnmkm.show();
    }//GEN-LAST:event_jLabel3MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jplimg;
    protected static javax.swing.JLabel lblimg;
    protected static javax.swing.JLabel lblmaXN;
    private javax.swing.JLabel lblmkcu;
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
    private javax.swing.JTextField txtmkmshow;
    private javax.swing.JTextField txtmkshow;
    private javax.swing.JPasswordField txtxnmkm;
    private javax.swing.JTextField txtxnmkshow;
    // End of variables declaration//GEN-END:variables
}
