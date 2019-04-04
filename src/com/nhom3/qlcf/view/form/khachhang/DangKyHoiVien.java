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
public class DangKyHoiVien extends javax.swing.JPanel {
    
    KhachHangDAO khDao = new KhachHangDAO();

    /**
     * Creates new form FormDangKyHoiVien
     */
    public DangKyHoiVien() {
        initComponents();
        txtsdt.setText("Nhập SĐT KH");
        txtsdt.setForeground(Color.gray);
        XuLy.placeHolder(txtsdt, "Nhập SĐT KH");
        
    }
    
    public DangKyHoiVien(String danhsach) {
        initComponents();
        txtsdt.setText(danhsach);
        txtsdt.setEditable(false);
        if (checkTimSDT()) {
            TimSDT();
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
                    
                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (txtSodt.getText().trim().equals("")) {
                    lblThongBao.setText("SĐT là bắt buột");
                    lblThongBao.setForeground(Color.red);
                    
                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (txtSodt.getText().length() < 9 || txtSodt.getText().length() > 13) {
                    lblThongBao.setText("SĐT chỉ nhập là [10-13] số");
                    lblThongBao.setForeground(Color.red);
                    
                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (!txtSodt.getText().matches("[0-9]+")) {
                    lblThongBao.setText("SĐT phải nhập là số");
                    lblThongBao.setForeground(Color.red);
                    
                    lblThongBao.setForeground(Color.red);
                    return false;
                } else if (txtdiem.getText().trim().equals("")) {
                    lblThongBao.setText("Đăng ký hội viên phải có điểm hội viên");
                    lblThongBao.setForeground(Color.red);
                    lblThongBao.setForeground(Color.red);
                    return false;
                    
                } else {
                    int so = Integer.parseInt(txtdiem.getText());
                    if (so > 5000 || so < 200) {
                        lblThongBao.setText("Điểm thưởng phải nhập khoảng 200 - 5000");
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
        
    }
    
    public void Update() {
        KhachHangDAO khDao = new KhachHangDAO();
        KhachHang kh = new KhachHang();
        kh.setMakh(txttenkh.getName());
        kh.setTenKh(txttenkh.getText());
        kh.setDienThoai(txtSodt.getText());
        kh.setMatKhau(txtSodt.getName());
        kh.setEmail(txtemail.getText());
        kh.setDiemThuong(Integer.parseInt(txtdiem.getText()));
        khDao.update(kh);
        lblThongBao.setText("Thành công, KH " + txttenkh.getText() + " đã là hội viên!");
        lblThongBao.setForeground(Color.green);
        txtSodt.setText("");
        txtemail.setText("");
        txtdiem.setText("");
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

        jLabel1 = new javax.swing.JLabel();
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
        jLabel10 = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(450, 544));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cập Nhật Hội Viên");

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Đăng Ký");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        lblThongBao.setForeground(new java.awt.Color(255, 51, 51));
        lblThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBao.setText(".");
        lblThongBao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblThongBaoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttenkh, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSodt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(225, 225, 225)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblThongBaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongBaoMousePressed
        // TODO add your handling code here:

        if (lblThongBao.getText().trim().equals("Chưa có KH hàng này! Thêm Ngay")) {
            jpnDangKyForm.removeAll();
            jpnDangKyForm.add(new ThemKH(txtsdt.getText()));
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

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:

        if (checkUpdate()) {
            Update();
            
        }
    }//GEN-LAST:event_jLabel10MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JTextField txtSodt;
    private javax.swing.JTextField txtdiem;
    private javax.swing.JTextField txtemail;
    public static javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttenkh;
    // End of variables declaration//GEN-END:variables
}
