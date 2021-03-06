/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.users;

import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.model.NguoiDung;
import static com.nhom3.qlcf.view.form.users.FormQuanLyTaiKhoan_admin.jpltable;
import java.awt.Color;

/**
 *
 * @author baotri1998
 */
public class DetailUser extends javax.swing.JDialog {

    /**
     * Creates new form DetailUser
     */
    public DetailUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

    }

    public boolean check() {
       String emails = "[\\w\\.]+@[\\w+]+\\.+[\\.\\w+]+";
        if (ttxhoten.getText().trim().equals("")) {
            lblthongbao.setText("Tên không được bỏ trống");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtSDT.getText().trim().equals("")) {
            lblthongbao.setText("SĐT không được bỏ trống");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (!txtSDT.getText().matches("[0-9]+")) {
            lblthongbao.setText("SĐT phải là số");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtSDT.getText().length() > 10 && txtSDT.getText().length() < 13) {
            lblthongbao.setText("SĐT phải từ [10-13] số");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (txtemail.getText().equals("")) {
            lblthongbao.setText("Email không được bỏ trống!");
            lblthongbao.setForeground(Color.red);
            return false;
        } else if (!txtemail.getText().matches(emails)) {
            lblthongbao.setText("Email phải đúng định dạng VD: abc@gmail.com!");
            lblthongbao.setForeground(Color.red);
            return false;

        }
        return true;
    }

    public DetailUser(java.awt.Frame parent, boolean modal, String user) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        NguoiDung nd = new NguoiDung();
        NguoiDungDAO dao = new NguoiDungDAO();
        nd = dao.selectID(user);
        txtUsers.setName(nd.getMaNguoidung());
        txtUsers.setText(nd.getTaiKhoan());
        ttxhoten.setText(nd.getHoTen());
        txtSDT.setText(nd.getDienThoai());
        txtemail.setText(nd.getEmail());
        cbxVaiTro.setSelectedItem(nd.getVaiTro());
        txtSDT.setName(nd.getMatKhau());

    }

    public void update() {

        try {
            NguoiDung nd = new NguoiDung();
            nd.setMaNguoidung(txtUsers.getName());
            nd.setHoTen(ttxhoten.getText());
            nd.setDienThoai(txtSDT.getText());
            nd.setVaiTro(cbxVaiTro.getSelectedItem().toString());
            nd.setMatKhau(txtSDT.getName());
            nd.setTaiKhoan(txtUsers.getText());
            nd.setEmail(txtemail.getText());
            nd.setTrangThai(true);
            NguoiDungDAO ndDAO = new NguoiDungDAO();
            ndDAO.update(nd);
            lblthongbao.setText("Cập Nhật Thành Công");

        } catch (Exception e) {
            System.out.println(e);

        }

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
        ttxhoten = new javax.swing.JTextField();
        lbluser = new javax.swing.JLabel();
        lblpass1 = new javax.swing.JLabel();
        lblvien2 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblpass2 = new javax.swing.JLabel();
        lblvien3 = new javax.swing.JLabel();
        lblpass3 = new javax.swing.JLabel();
        cbxVaiTro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblthongbao = new javax.swing.JLabel();
        lblpass4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblvien4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông Tin Nhân Viên");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setMaximumSize(new java.awt.Dimension(122, 17));
        jLabel1.setMinimumSize(new java.awt.Dimension(122, 17));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(122, 17));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 58));

        txtUsers.setEditable(false);
        txtUsers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsers.setBorder(null);
        txtUsers.setOpaque(false);
        txtUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsersActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 259, 30));

        lblvien.setText("___________________________________________");
        jPanel1.add(lblvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 114, 260, 30));

        ttxhoten.setBackground(new java.awt.Color(153, 255, 0));
        ttxhoten.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ttxhoten.setBorder(null);
        ttxhoten.setOpaque(false);
        jPanel1.add(ttxhoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 180, 260, 40));

        lbluser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbluser.setText("UserName*:");
        jPanel1.add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 80, 20));

        lblpass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass1.setText("Họ Tên*:");
        jPanel1.add(lblpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 80, 20));

        lblvien2.setText("___________________________________________");
        jPanel1.add(lblvien2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 260, 30));

        txtSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSDT.setBorder(null);
        txtSDT.setOpaque(false);
        jPanel1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 259, 40));

        lblpass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass2.setText("Email:");
        jPanel1.add(lblpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 70, 20));

        lblvien3.setText("___________________________________________");
        jPanel1.add(lblvien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 260, 30));

        lblpass3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass3.setText("Số ĐT *:");
        jPanel1.add(lblpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 80, 20));

        cbxVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Administration" }));
        cbxVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVaiTroActionPerformed(evt);
            }
        });
        jPanel1.add(cbxVaiTro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 210, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cập Nhật");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 130, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lấy Lại Mật Khẩu");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 130, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Close");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 440, 70, -1));

        lblthongbao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblthongbao.setForeground(new java.awt.Color(51, 204, 0));
        lblthongbao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblthongbao.setText("....");
        jPanel1.add(lblthongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 380, -1));

        lblpass4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass4.setText("Vài Trò:");
        jPanel1.add(lblpass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 80, 20));

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtemail.setBorder(null);
        txtemail.setOpaque(false);
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 260, 40));

        lblvien4.setText("___________________________________________");
        jPanel1.add(lblvien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsersActionPerformed

    private void cbxVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVaiTroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVaiTroActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        LayLaiMatKhau l = new LayLaiMatKhau(null, rootPaneCheckingEnabled, txtemail.getText());
        l.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:

        dispose();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        if (check()) {
            lblthongbao.setForeground(Color.GREEN);
            update();

            FormQuanLyTaiKhoan_admin.quanlynhanvien.jpltable.removeAll();
            jpltable.updateUI();
            jpltable.add(new Quanlyusers());
            jpltable.repaint();
            jpltable.updateUI();
        }

    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setBackground(Color.BLACK);
         jLabel4.setForeground(Color.white);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
         jLabel4.setBackground(Color.white);
         jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
         jLabel3.setBackground(Color.BLACK);
         jLabel3.setForeground(Color.white);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
          jLabel3.setBackground(Color.white);
         jLabel3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel3MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetailUser dialog = new DetailUser(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblpass1;
    private javax.swing.JLabel lblpass2;
    private javax.swing.JLabel lblpass3;
    private javax.swing.JLabel lblpass4;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel lblvien;
    private javax.swing.JLabel lblvien2;
    private javax.swing.JLabel lblvien3;
    private javax.swing.JLabel lblvien4;
    private javax.swing.JTextField ttxhoten;
    protected static javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtUsers;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
}
