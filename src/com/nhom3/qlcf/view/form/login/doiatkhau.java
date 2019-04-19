/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.login;

import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.helper.Hashing;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.ReSizehelper;
import static com.nhom3.qlcf.view.form.login.QuenMatKhau.txttofrom;
import com.nhom3.qlcf.view.form.users.ThongTinTK;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author baotri1998
 */
public class doiatkhau extends javax.swing.JDialog {

    /**
     * Creates new form doiatkhau
     */
    public doiatkhau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
           code = Hashing.randomCode(4);
        lblmaXN.setText(code);
        
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

      if (txtmkmoi1.getText().trim().equals("")) {
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
        lblmat2 = new javax.swing.JLabel();
        lblmat3 = new javax.swing.JLabel();
        lblpass3 = new javax.swing.JLabel();
        lblvien3 = new javax.swing.JLabel();
        lblhuy = new javax.swing.JLabel();
        lblchapnhan = new javax.swing.JLabel();
        lblthongbao = new javax.swing.JLabel();
        lblpass2 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        lblvien4 = new javax.swing.JLabel();
        lblpass4 = new javax.swing.JLabel();
        lblvien5 = new javax.swing.JLabel();
        txtmkmoi1 = new javax.swing.JPasswordField();
        txtxnmkm = new javax.swing.JPasswordField();
        jplimg = new javax.swing.JPanel();
        lblmaXN = new javax.swing.JLabel();
        lblimg = new javax.swing.JLabel();
        txtmkmshow = new javax.swing.JTextField();
        txtxnmkshow = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmat2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/eye.png"))); // NOI18N
        lblmat2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblmat2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblmat2MousePressed(evt);
            }
        });
        jPanel1.add(lblmat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 50, 30));

        lblmat3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/eye.png"))); // NOI18N
        lblmat3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblmat3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblmat3MousePressed(evt);
            }
        });
        jPanel1.add(lblmat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 50, 30));

        lblpass3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass3.setText("Xác Nhận Mật Khẩu:");
        jPanel1.add(lblpass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 118, 190, 20));

        lblvien3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvien3.setText("____________________________________________");
        jPanel1.add(lblvien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 148, 310, 30));

        lblhuy.setBackground(new java.awt.Color(255, 255, 255));
        lblhuy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblhuy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhuy.setText("HỦY");
        lblhuy.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblhuy.setOpaque(true);
        lblhuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblhuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblhuyMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblhuyMousePressed(evt);
            }
        });
        jPanel1.add(lblhuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 318, 110, 40));

        lblchapnhan.setBackground(new java.awt.Color(255, 255, 255));
        lblchapnhan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblchapnhan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblchapnhan.setText("CHẤP NHẬN");
        lblchapnhan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblchapnhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblchapnhan.setOpaque(true);
        lblchapnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblchapnhanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblchapnhanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblchapnhanMousePressed(evt);
            }
        });
        jPanel1.add(lblchapnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 318, 110, 40));

        lblthongbao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblthongbao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblthongbao.setText(".");
        jPanel1.add(lblthongbao, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 360, 30));

        lblpass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass2.setText("Nhập Code:");
        jPanel1.add(lblpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 258, 80, 20));

        txtcode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtcode.setBorder(null);
        txtcode.setOpaque(false);
        jPanel1.add(txtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 268, 170, 40));

        lblvien4.setText("____________________________");
        jPanel1.add(lblvien4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 278, 180, 30));

        lblpass4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass4.setText("Mật Khẩu Mới:");
        jPanel1.add(lblpass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 38, 100, 20));

        lblvien5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvien5.setText("___________________________________________");
        jPanel1.add(lblvien5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 68, 310, 30));

        txtmkmoi1.setBorder(null);
        txtmkmoi1.setOpaque(false);
        jPanel1.add(txtmkmoi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 58, 260, 40));

        txtxnmkm.setBorder(null);
        txtxnmkm.setOpaque(false);
        jPanel1.add(txtxnmkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 138, 260, 40));

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

        jPanel1.add(jplimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 188, -1, -1));

        txtmkmshow.setBorder(null);
        txtmkmshow.setOpaque(false);
        jPanel1.add(txtmkmshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 58, 280, 40));

        txtxnmkshow.setBorder(null);
        txtxnmkshow.setOpaque(false);
        jPanel1.add(txtxnmkshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 138, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblmat2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmat2MouseExited
        // TODO add your handling code here:
        txtmkmshow.hide();
        txtmkmoi1.show();
    }//GEN-LAST:event_lblmat2MouseExited

    private void lblmat2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmat2MousePressed
        // TODO add your handling code here:
        txtmkmshow.show();
        txtmkmshow.setText(txtmkmoi1.getText());
        txtmkmoi1.hide();
    }//GEN-LAST:event_lblmat2MousePressed

    private void lblmat3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmat3MouseExited
        // TODO add your handling code here:
        txtxnmkshow.hide();
        txtxnmkm.show();
    }//GEN-LAST:event_lblmat3MouseExited

    private void lblmat3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmat3MousePressed
        // TODO add your handling code here:
        txtxnmkshow.show();
        txtxnmkshow.setText(txtxnmkm.getText());
        txtxnmkm.hide();
    }//GEN-LAST:event_lblmat3MousePressed

    private void lblchapnhanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblchapnhanMousePressed
        // TODO add your handling code here:
        if (check()) {
            JDBCHelper.executeUpdate("Update dbo.NguoiDung set matKhau ='" + txtxnmkm.getText() + "' where dienThoai ='" + txttofrom.getName()+ "' or email ='" +txttofrom.getName()+"'");
            txtcode.setText("");
            txtxnmkm.setText("");
            txtmkmoi1.setText("");
            loadImg();
            lblthongbao.setText("Đổi mật khẩu thành công!");
            lblthongbao.setForeground(Color.GREEN);
        }
    }//GEN-LAST:event_lblchapnhanMousePressed

    private void lblmaXNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmaXNMousePressed
        // TODO add your handling code here:

        code = Hashing.randomCode(4);
        lblmaXN.setText(code);
        loadImg();

    }//GEN-LAST:event_lblmaXNMousePressed

    private void lblimgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblimgMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblimgMousePressed

    private void lblhuyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhuyMousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_lblhuyMousePressed

    private void lblchapnhanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblchapnhanMouseEntered
        // TODO add your handling code here:
        lblchapnhan.setBackground(Color.BLACK);
        lblchapnhan.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblchapnhanMouseEntered

    private void lblchapnhanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblchapnhanMouseExited
        // TODO add your handling code here:
          lblchapnhan.setBackground(Color.WHITE);
        lblchapnhan.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblchapnhanMouseExited

    private void lblhuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhuyMouseEntered
        // TODO add your handling code here:
           lblhuy.setBackground(Color.BLACK);
        lblhuy.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblhuyMouseEntered

    private void lblhuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhuyMouseExited
        // TODO add your handling code here:
          lblhuy.setBackground(Color.WHITE);
        lblhuy.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblhuyMouseExited

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
            java.util.logging.Logger.getLogger(doiatkhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doiatkhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doiatkhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doiatkhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                doiatkhau dialog = new doiatkhau(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jplimg;
    private javax.swing.JLabel lblchapnhan;
    private javax.swing.JLabel lblhuy;
    protected static javax.swing.JLabel lblimg;
    protected static javax.swing.JLabel lblmaXN;
    private javax.swing.JLabel lblmat2;
    private javax.swing.JLabel lblmat3;
    private javax.swing.JLabel lblpass2;
    private javax.swing.JLabel lblpass3;
    private javax.swing.JLabel lblpass4;
    private javax.swing.JLabel lblthongbao;
    private javax.swing.JLabel lblvien3;
    private javax.swing.JLabel lblvien4;
    private javax.swing.JLabel lblvien5;
    private javax.swing.JTextField txtcode;
    private javax.swing.JPasswordField txtmkmoi1;
    private javax.swing.JTextField txtmkmshow;
    private javax.swing.JPasswordField txtxnmkm;
    private javax.swing.JTextField txtxnmkshow;
    // End of variables declaration//GEN-END:variables
}
