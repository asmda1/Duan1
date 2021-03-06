/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.khachhang;

import com.nhom3.qlcf.dao.KhachHangDAO;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.model.KhachHang;
import static com.nhom3.qlcf.view.form.khachhang.FormKhachHang.jpnDangKyForm;
import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author baotri1998
 */
public class CapNhatHoiVien extends javax.swing.JPanel {

    KhachHangDAO khDao = new KhachHangDAO();

    /**
     * Creates new form FormDangKyHoiVien
     */
    public CapNhatHoiVien() {
        initComponents();
        txtsdt.setText("Nhập SĐT KH");
        txtsdt.setForeground(Color.gray);
        XuLy.placeHolder(txtsdt, "Nhập SĐT KH");
     

    }

    public CapNhatHoiVien(String danhsach) {
        initComponents();
        txtsdt.setText(danhsach);
        txtSodt.setName(danhsach);
        txtsdt.setEditable(false);
        if (checkTimSDT()) {
            TimSDT();
        }
         if(coxLoaiKhach.getSelectedIndex()==0){
            coxLoaiKhach.setEnabled(false);
        }else{
             coxLoaiKhach.setEnabled(true);
        }


    }

    public boolean checkTimSDT() {
        if (txtsdt.getText().trim().equals("Nhập SĐT KH") || txtsdt.getText().trim().equals("")) {
            lblThongBao.setText("nhập SĐT là bắt buột");
            lblThongBao.setForeground(Color.red);
            txttenkh.setText("");
            txtSodt.setText("");
            txtemail.setText("");
            txtdiem.setText("");
            lblThongBao.setForeground(Color.red);
            return false;
        } else if (txtsdt.getText().length() < 9 || txtsdt.getText().length() > 13) {
            lblThongBao.setText("SĐT chỉ nhập là [10-13] số");
            lblThongBao.setForeground(Color.red);
            txttenkh.setText("");
            txtSodt.setText("");
            txtemail.setText("");
            txtdiem.setText("");
            lblThongBao.setForeground(Color.red);
            return false;
        } else if (!txtsdt.getText().matches("[0-9]+")) {
            lblThongBao.setText("SĐT phải nhập là số");
            lblThongBao.setForeground(Color.red);
            txttenkh.setText("");
            txtSodt.setText("");
            txtemail.setText("");
            txtdiem.setText("");
            lblThongBao.setForeground(Color.red);
            return false;
        } else if (!khDao.checkSDT(txtsdt.getText())) {
            lblThongBao.setText("Chưa có KH hàng này! Thêm Ngay");
            lblThongBao.setCursor(new Cursor(Cursor.HAND_CURSOR));
            lblThongBao.setForeground(Color.red);
            txttenkh.setText("");
            txtSodt.setText("");
            txtemail.setText("");
            txtdiem.setText("");
            lblThongBao.setForeground(Color.red);
            return false;
        }
        return true;
    }

    public boolean checkUpdate() {
        KhachHangDAO khDao = new KhachHangDAO();
        String emails = "[\\w\\.]+@[\\w+]+\\.+[\\.\\w+]+";
        if (txtsdt.getText().trim().equals("Nhập SĐT KH") || txtsdt.getText().trim().equals("")) {
            lblThongBao.setText("Không có thông khách hàng để nhập, tìm SĐT KH!");
            lblThongBao.setForeground(Color.red);
            txttenkh.setText("");
            txtSodt.setText("");
            txtemail.setText("");
            txtdiem.setText("");
            lblThongBao.setForeground(Color.red);
            return false;
        } else if (txttenkh.getText().trim().equals("")) {
            lblThongBao.setText("Tên KH là bắt buột");
            lblThongBao.setForeground(Color.red);
            txtSodt.setText("");
            txtemail.setText("");
            txtdiem.setText("");
            lblThongBao.setForeground(Color.red);
            return false;
        } else {
            if (txtemail.getText().trim().equals("")) {
                lblThongBao.setText("Email KH là bắt buột");
                lblThongBao.setForeground(Color.red);

                lblThongBao.setForeground(Color.red);
                return false;
            } else {
                if (!txtemail.getText().matches(emails)) {
                    lblThongBao.setText("Email sai định dạng phải có dấu '@/.com' phía sau " + txtemail.getText());
                    lblThongBao.setForeground(Color.red);

                    return false;
                }else if (coxLoaiKhach.getSelectedIndex()==1) {
                    lblThongBao.setText("Chọn mục hội viên để hoàn thành đăng ký!");
                    lblThongBao.setForeground(Color.red);
                    return false;

                }  else if (txtSodt.getText().trim().equals("")) {

                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (txtSodt.getText().length() < 9 || txtSodt.getText().length() > 13) {
                    lblThongBao.setText("SĐT chỉ nhập là [10-13] số");
                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (!txtSodt.getText().matches("[0-9]+")) {
                    lblThongBao.setText("SĐT phải nhập là số");
                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (txtdiem.getText().trim().equals("")) {
                    lblThongBao.setText("Đăng ký hội viên phải có điểm hội viên");
                    lblThongBao.setForeground(Color.red);

                    return false;

                } else {
                    int so = Integer.parseInt(txtdiem.getText());
                    if (so > 5000 || so < 0) {
                        lblThongBao.setText("Điểm thưởng phải nhập khoảng 0 - 5000");
                        lblThongBao.setForeground(Color.red);
                        return false;
                    }

                }
            }
            return true;
        }
    }

    public void TimSDT() {

        KhachHang kh = new KhachHang();
        kh = khDao.selectID(txtsdt.getText());
        txttenkh.setText(kh.getTenKh());
        txtSodt.setText(kh.getDienThoai());
        txtSodt.setName(kh.getMatKhau());
        txtemail.setText(kh.getEmail());
        txtdiem.setText(String.valueOf(kh.getDiemThuong()));
        txttenkh.setName(kh.getMakh());
        txtdiachi.setText(kh.getDiaChi());
        if (kh.isTrangThai()) {
            coxLoaiKhach.setSelectedIndex(0);
     
        } else {
            coxLoaiKhach.setSelectedIndex(1);
        
        }

    }

    public void Update() {

        KhachHang kh = new KhachHang();
        kh.setMakh(txttenkh.getName());
        kh.setTenKh(txttenkh.getText());
        kh.setDienThoai(txtSodt.getText());
        kh.setMatKhau(txtSodt.getName());
        kh.setEmail(txtemail.getText());
        if (coxLoaiKhach.getSelectedIndex() == 0) {
            kh.setTrangThai(true);
        } else {
            kh.setTrangThai(false);
        }

        kh.setDiaChi(txtdiachi.getText());
        kh.setDiemThuong(Integer.parseInt(txtdiem.getText()));
        khDao.update(kh);
        lblThongBao.setText("Thành công, KH " + txttenkh.getText() + " đã là hội viên!");
        lblThongBao.setForeground(Color.green);
        txtSodt.setText("");
        txtemail.setText("");
        txtdiem.setText("");
        txtdiachi.setText("");
        txttenkh.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtsdt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttenkh = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtSodt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtdiem = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblbuton_dky = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        coxLoaiKhach = new javax.swing.JComboBox<>();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(450, 544));

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitle.setText("Cập Nhật Hội Viên");

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tìm Khách Hàng");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên Khách:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Điện Thoại:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Điểm Thưởng:");

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Hủy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        txtdiem.setText("0");

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        lblbuton_dky.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblbuton_dky.setForeground(new java.awt.Color(255, 255, 255));
        lblbuton_dky.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbuton_dky.setText("Đăng Ký");
        lblbuton_dky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblbuton_dkyMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbuton_dky, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbuton_dky, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        lblThongBao.setForeground(new java.awt.Color(255, 51, 51));
        lblThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBao.setText(".");
        lblThongBao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblThongBaoMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Địa chỉ:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Loại Khách:");

        coxLoaiKhach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hội Viên", "Khách Online" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(coxLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttenkh, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSodt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 69, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblThongBao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSodt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtdiem, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(coxLoaiKhach))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblThongBaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongBaoMousePressed
        // TODO add your handling code here:

        if (lblThongBao.getText().trim().equals("Chưa có KH hàng này! Thêm Ngay")) {
            jpnDangKyForm.removeAll();
            jpnDangKyForm.add(new DangKyHoiVien(txtsdt.getText()));
            jpnDangKyForm.repaint();
            jpnDangKyForm.revalidate();
            jpnDangKyForm.show();
            hide();

        }

    }//GEN-LAST:event_lblThongBaoMousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:

        if (checkTimSDT()) {
            TimSDT();
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void lblbuton_dkyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuton_dkyMousePressed
        // TODO add your handling code here:

        if (checkUpdate()) {
            Update();

        }
    }//GEN-LAST:event_lblbuton_dkyMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> coxLoaiKhach;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblThongBao;
    protected static javax.swing.JLabel lblbuton_dky;
    protected static javax.swing.JLabel lbltitle;
    private javax.swing.JTextField txtSodt;
    private javax.swing.JTextField txtdiachi;
    public static javax.swing.JTextField txtdiem;
    private javax.swing.JTextField txtemail;
    public static javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttenkh;
    // End of variables declaration//GEN-END:variables
}
