/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.login;

import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.helper.Timehelper;
import com.nhom3.qlcf.model.NguoiDung;
import static com.nhom3.qlcf.view.form.login.FormLogin.jfLogin;
import com.nhom3.qlcf.view.form.menu.FormMenu;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

/**
 *
 * @author baotri1998
 */
public class Login extends javax.swing.JPanel {

    public List<NguoiDung> list = null;
    public List<Integer> diem = null;
    public static NguoiDung user;
    Pattern pattern;
    /**
     * Creates new form login
     */
    public static Login lg;

    public Login() {
        initComponents();
        lg = this;
        jpnNenButton_login.setBackground(new Color(0, 0, 0, 64));

    }

    public boolean kiemTraDangNhap(String a) {
        try {
            list = new NguoiDungDAO().select("Select * from NguoiDung  where taiKhoan ='" + txtManhanVien.getText() + "' and matKhau ='" + txtPass.getText() + "'");
            for (NguoiDung u : list) {
                u.setTaiKhoan(txtManhanVien.getText());
                u.setMatKhau(txtPass.getText());
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    int s = 0;

    public boolean check() {

        String kytudatbiet = "{6,20}";

        pattern = Pattern.compile(kytudatbiet);

        if (txtManhanVien.getText().trim().equals("") && txtPass.getText().trim().equals("")) {
            lblThongBaoUser.setText("Không được bỏ trống tên đăng nhập");
            lblThongBaoPass.setText("Không được bỏ trống mật khẩu");
            lblLoiDangNhap.setText("");
            lblLoiDangNhap.hide();
            lblThongBaoUser.show();
            lblThongBaoPass.show();
            lbltime.hide();
            return false;
        } else if (pattern.matcher(txtManhanVien.getText()).matches() && txtPass.getText().trim().equals("")) {
            lblThongBaoUser.setText("User Không được thêm ký tự đặt biệt");
            lblLoiDangNhap.hide();
            lblThongBaoUser.show();
            lblThongBaoPass.hide();
            lbltime.hide();
            return false;
        } else if (pattern.matcher(txtPass.getText()).matches() && txtManhanVien.getText().trim().equals("")) {
            lblThongBaoPass.setText("Pass Không được thêm ký tự đặt biệt");
            lblLoiDangNhap.hide();
            lblThongBaoUser.hide();
            lblThongBaoPass.show();
            lbltime.hide();
            return false;
        } else if (txtManhanVien.getText().trim().equals("")) {
            lblThongBaoUser.setText("Không được bỏ trống tên đăng nhập");
            lblLoiDangNhap.hide();
            lblThongBaoUser.show();
            lblThongBaoPass.hide();
            lbltime.hide();
            return false;
        } else if (txtPass.getText().trim().equals("")) {
            lblThongBaoPass.setText("Không được bỏ trống mật khẩu");
            lblLoiDangNhap.hide();
            lblThongBaoUser.hide();
            lblThongBaoPass.show();
            lbltime.hide();
            return false;
        } else if (!kiemTraDangNhap(txtManhanVien.getText()) || !kiemTraDangNhap(txtPass.getText())) {
            lblLoiDangNhap.setForeground(Color.red);
            lblLoiDangNhap.setText("Tên Đăng Nhập Hoặc Mật Khẩu Không đúng");
            if (s < 4) {
                s++;
                lblLoiDangNhap.setToolTipText(String.valueOf(s));
            }
            if (lblLoiDangNhap.getToolTipText().equals("4")) {

                lblLoiDangNhap.setForeground(Color.red);
                lblLoiDangNhap.setText("Bạn đăng nhập sai quá 3 lần! ");
                lblLoiDangNhap.show();
                lblThongBaoUser.hide();
                lblThongBaoPass.hide();
                lblLoiDangNhap.show();
                lblThongBaoUser.hide();
                lblThongBaoPass.hide();
                lblLogin.setEnabled(false);
                lbltime.show();
                lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
                if (lbltime.getText().equals("15")) {
                    time15s();
                    lblLogin.setEnabled(false);
                    txtPass.setText("");
                    return false;

                } else if (lbltime.getText().equals("30")) {
                    diemNguoc30s();
                    lblLogin.setEnabled(false);
                    txtPass.setText("");
                    return false;

                }
                return false;

            }
            return false;
        }

        return true;
    }
    static int interval;
    static Timer timer;
    //diem ngc time 15s
    int interval1;
    java.util.Timer timer1;

    public void diemNguoc30s() {

        String secs = "30";
        int delay = 1000;
        int period = 1000;
        timer1 = new Timer();
        interval1 = Integer.parseInt(secs);
        System.out.println(secs);
        timer1.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                int so = setInterval1();
                lbltime.setText(String.valueOf(so));
                if (so <= 0) {
                    lblLoiDangNhap.hide();
                    lbltime.hide();
                    lbltime.setText("30");
                    lblLogin.setEnabled(true);
                    lblLoiDangNhap.setToolTipText("0");
                    s = 0;

                }
            }
        }, delay, period);

    }

    private final int setInterval1() {
        if (interval1 == 1) {
            timer1.cancel();
        }
        return --interval1;
    }

    public void time15s() {
        String secs = "15";
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                int so = setInterval();
                lbltime.setText(String.valueOf(so));
                if (so <= 0) {
                    lblLoiDangNhap.hide();
                    lbltime.hide();
                    lbltime.setText("30");
                    lblLogin.setEnabled(true);
                    lblLoiDangNhap.setToolTipText("0");
                    s = 0;
                }
            }
        }, delay, period);
    }

    private final int setInterval() {
        if (interval == 1) {
            timer.cancel();
        }
        return --interval;
    }

    public void loginnv() {//
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 3);
        Date date = calendar.getTime();
        TimerTask tim = new TimerTask() {
            @Override
            public void run() {
                list = new NguoiDungDAO().select("Select * from NguoiDung  where taiKhoan ='" + txtManhanVien.getText() + "' and matKhau ='" + txtPass.getText() + "'");
            }
        };
        Timer time = new Timer();
        long period = 24 * 150;
        time.schedule(tim, date, period);

        user = list.get(0);
        if (list.get(0).getVaiTro().equals("Administration")) {
            FormLogin.login.Card.removeAll();
            FormLogin.login.Card.add(new FormMenu());
            FormLogin.login.Card.repaint();
            FormLogin.login.Card.revalidate();
            FormLogin.login.Card.show();
            jpnNenButton_login.setBackground(new Color(0, 0, 0));
            jpnNenButton_login.setOpaque(false);
            lblLogin.setForeground(Color.white);
            lblLoiDangNhap.setText("Thành Công");
            lblLoiDangNhap.show();
            jfLogin.hide();
        } else {
            lblLoiDangNhap.setText("Thành Công");
            lblLoiDangNhap.show();
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
        lbluserIcon = new javax.swing.JLabel();
        lblPassicon = new javax.swing.JLabel();
        jpnNenButton_login = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txtPass = new javax.swing.JPasswordField();
        txtManhanVien = new javax.swing.JTextField();
        lbltime = new javax.swing.JLabel();
        lblThongBaoPass = new javax.swing.JLabel();
        lblLoiDangNhap = new javax.swing.JLabel();
        lblThongBaoUser = new javax.swing.JLabel();

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

        lbluserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/iconUser.png"))); // NOI18N
        jpnLogin.add(lbluserIcon);
        lbluserIcon.setBounds(340, 200, 50, 50);

        lblPassicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/lockicon.png"))); // NOI18N
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
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        jpnLogin.add(jLabel5);
        jLabel5.setBounds(310, 360, 120, 20);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText(" Ghi nhớ");
        jCheckBox1.setOpaque(false);
        jpnLogin.add(jCheckBox1);
        jCheckBox1.setBounds(60, 360, 190, 23);

        txtPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setText("123");
        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtPass.setOpaque(false);
        jpnLogin.add(txtPass);
        txtPass.setBounds(60, 290, 330, 50);

        txtManhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtManhanVien.setForeground(new java.awt.Color(255, 255, 255));
        txtManhanVien.setText("admin");
        txtManhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtManhanVien.setOpaque(false);
        jpnLogin.add(txtManhanVien);
        txtManhanVien.setBounds(60, 200, 330, 50);

        lbltime.setForeground(new java.awt.Color(255, 0, 0));
        lbltime.setText("15");
        lbltime.setName("15"); // NOI18N
        jpnLogin.add(lbltime);
        lbltime.setBounds(300, 120, 20, 30);
        lbltime.hide();

        lblThongBaoPass.setBackground(new java.awt.Color(255, 255, 255));
        lblThongBaoPass.setForeground(new java.awt.Color(255, 0, 0));
        lblThongBaoPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBaoPass.setOpaque(true);
        jpnLogin.add(lblThongBaoPass);
        lblThongBaoPass.setBounds(120, 270, 280, 30);
        lblThongBaoPass.hide();

        lblLoiDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        lblLoiDangNhap.setForeground(new java.awt.Color(255, 0, 0));
        lblLoiDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoiDangNhap.setToolTipText("0");
        lblLoiDangNhap.setOpaque(true);
        jpnLogin.add(lblLoiDangNhap);
        lblLoiDangNhap.setBounds(0, 120, 450, 30);
        lblLoiDangNhap.hide();

        lblThongBaoUser.setBackground(new java.awt.Color(255, 255, 255));
        lblThongBaoUser.setForeground(new java.awt.Color(255, 0, 0));
        lblThongBaoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBaoUser.setOpaque(true);
        jpnLogin.add(lblThongBaoUser);
        lblThongBaoUser.setBounds(120, 190, 280, 30);
        lblThongBaoUser.hide();

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

    }//GEN-LAST:event_jpnNenButton_loginMouseClicked

    private void lblLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMousePressed
        // TODO add your handling code here:

        /* FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(new FormMenu(null));
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);
        jfLogin.hide();*/
        if (!lblLoiDangNhap.getToolTipText().equals("4")) {
            if (lbltime.getText().equals("30") || lbltime.getText().equals("15")) {
                lbltime.hide();
                Timehelper timer = new Timehelper();
                lblLoiDangNhap.setForeground(Color.BLUE);
                lblThongBaoUser.setText("");
                lblThongBaoPass.setText("");
                lblLoiDangNhap.setText("Đang đăng nhập...");
                lblThongBaoPass.hide();
                lblThongBaoUser.hide();
                lblLoiDangNhap.show();
                timer.TimerLoad(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (lblLoiDangNhap.getToolTipText().equals("4")) {

                        } else {
                            if (check()) {
                                lbltime.setText("15");
                                loginnv();

                            }
                        }
                        timer.t.stop();
                    }
                }
                );

            }
        }

    }//GEN-LAST:event_lblLoginMousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:

        QuenMatKhau laymk = new QuenMatKhau(null, true);
        laymk.setVisible(true);
    }//GEN-LAST:event_jLabel5MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jpnBanner_login;
    private javax.swing.JPanel jpnLogin;
    public static javax.swing.JPanel jpnNenButton_login;
    public static javax.swing.JLabel lblLogin;
    public static javax.swing.JLabel lblLoiDangNhap;
    private javax.swing.JLabel lblPassicon;
    private javax.swing.JLabel lblThongBaoPass;
    private javax.swing.JLabel lblThongBaoUser;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lbluserIcon;
    private javax.swing.JTextField txtManhanVien;
    public static javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
