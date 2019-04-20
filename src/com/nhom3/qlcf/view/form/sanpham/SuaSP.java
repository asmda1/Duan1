/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.sanpham;

import com.nhom3.qlcf.dao.LoaiSanPhamDAO;
import com.nhom3.qlcf.dao.SanPhamDAO;
import com.nhom3.qlcf.helper.ReSizehelper;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.model.LoaiSanPham;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.view.Run;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author baotri1998
 */
public class SuaSP extends javax.swing.JPanel {

    public static SanPham sanPham;

    File sourceFile, destFile;
//    File defaultImage = new File(getClass().getResource("/com/nhom3/qlcf/img/default.png").toString());

    /**
     * Creates new form SuaHangHoa
     */
    public SuaSP() {
        initComponents();
        txtTimKiem.setText("Tên sản phẩm");
        txtTimKiem.setForeground(Color.GRAY);
        XuLy.placeHolder(txtTimKiem, "Tên sản phẩm");
        lblChonAnh.setName("Enabled");
        if (sanPham != null) {
            fillForm(sanPham);
        } else {
            try {
                int width = 110;
                int height = 130;

                BufferedImage image = ImageIO.read(getClass().getResource("/com/nhom3/qlcf/img/default.png"));
                lblHinhSP.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height)));
                lblChonAnh.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillForm(SanPham sp) {
        lblTenSP.setText(sp.getTenSp());
        txtTenSP.setText(sp.getTenSp());

        LoaiSanPham lSP = new LoaiSanPhamDAO().selectID(sp.getMaLoaiSanPham().getMaLoai());
        lblLoaiSP.setText(lSP.getTenLoai());

        lblGiaSP.setText(new DecimalFormat("#,###,###").format(sp.getGiaBan()) + " VNĐ");
        txtGia.setText(String.valueOf(sp.getGiaBan()));

        lblTrangThaiSP.setText(sanPham.isTrangThai() ? "Còn bán" : "Ngừng bán");
        cboThayDoiTrangThai.setSelectedIndex(sanPham.isTrangThai() ? 0 : 1);

        //set hình
        int width = 110;
        int height = 130;
//        File defaultImage = new File(getClass().getResource("/com/nhom3/qlcf/img/default.png").getPath());
        BufferedImage image = null;
        File f;

        try {
            f = new File(Run.folderPAth + "Images\\" + sp.getHinhAnh());
            image = ImageIO.read(f);
        } catch (IOException e1) {

        }

        lblHinhSP.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height)));
        lblChonAnh.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height)));

    }

    private boolean checkNull() {
        if (txtTenSP.getText().trim().isEmpty()) {
            lblThongBao.setText("Tên sản phẩm không được trống!!");
            return false;
        }
        if (txtGia.getText().trim().isEmpty()) {
            lblThongBao.setText("Giá sẩn phẩm không được trống!!");
            return false;
        }

        return true;
    }

    private void clearForm() throws IOException {
        lblTenSP.setText(".....................");
        lblLoaiSP.setText(".....................");
        lblGiaSP.setText(".....................");
        lblTrangThaiSP.setText(".....................");

        BufferedImage image = ImageIO.read(getClass().getResource("/com/nhom3/qlcf/img/default.png"));
        lblHinhSP.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), 110, 130)));

        txtTenSP.setText("");
        txtGia.setText("");
        cboThayDoiTrangThai.setSelectedIndex(0);
        lblChonAnh.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), 110, 130)));

        sanPham = null;
    }

    private void chonAnh() {
        BufferedImage image = null;
        int width = 161;
        int height = 192;
        JFileChooser jfc = new JFileChooser();

        FileFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setFileFilter(filter);
        int result = jfc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                sourceFile = jfc.getSelectedFile();

                if (sourceFile.getName().length() > 50) {
                    lblThongBao.setText("Tên ảnh không được quá 45 kí tự!!");
                    return;
                }

                image = ImageIO.read(sourceFile);
                String fileName = null;
                if (sourceFile.getName() != null) {
                    fileName = sourceFile.getName();
                    lblChonAnh.setToolTipText("Đã chọn ảnh khác");
                } else {
                    lblChonAnh.setToolTipText("");
                }
                destFile = new File(Run.folderPAth + "Images\\" + fileName);

                XuLy.copyFile(sourceFile, destFile);

                image = ImageIO.read(destFile);
                ImageIO.write(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height), "png", destFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
        lblHinhSP.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), 110, 130)));
        lblChonAnh.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), 110, 130)));

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
        txtGia = new javax.swing.JTextField();
        lblvien1 = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblpass3 = new javax.swing.JLabel();
        lblpass2 = new javax.swing.JLabel();
        cboThayDoiTrangThai = new javax.swing.JComboBox<>();
        lblButonReset = new javax.swing.JLabel();
        lblButonCapNhat = new javax.swing.JLabel();
        lblChonAnh = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();
        jplformThongTin = new javax.swing.JPanel();
        jplTimkiem = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        lblButonTimKIem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        lblLoaiSP = new javax.swing.JLabel();
        lblpass4 = new javax.swing.JLabel();
        lbluser1 = new javax.swing.JLabel();
        lblpass6 = new javax.swing.JLabel();
        lblpass7 = new javax.swing.JLabel();
        lblTrangThaiSP = new javax.swing.JLabel();
        lblGiaSP = new javax.swing.JLabel();
        lblHinhSP = new javax.swing.JLabel();

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

        txtGia.setBackground(new java.awt.Color(255, 204, 0));
        txtGia.setBorder(null);
        txtGia.setOpaque(false);
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });
        jplformNhap.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 220, 40));

        lblvien1.setText("____________________________________   VNĐ");
        jplformNhap.add(lblvien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 260, 40));

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

        cboThayDoiTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn bán", "Ngừng bán" }));
        cboThayDoiTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThayDoiTrangThaiItemStateChanged(evt);
            }
        });
        jplformNhap.add(cboThayDoiTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 210, -1));

        lblButonReset.setBackground(new java.awt.Color(255, 255, 255));
        lblButonReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblButonReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButonReset.setText("Reset");
        lblButonReset.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblButonReset.setOpaque(true);
        lblButonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblButonResetMousePressed(evt);
            }
        });
        jplformNhap.add(lblButonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 110, 40));

        lblButonCapNhat.setBackground(new java.awt.Color(255, 255, 255));
        lblButonCapNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblButonCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButonCapNhat.setText("Cập Nhật");
        lblButonCapNhat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblButonCapNhat.setOpaque(true);
        lblButonCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblButonCapNhatMousePressed(evt);
            }
        });
        jplformNhap.add(lblButonCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 110, 40));

        lblChonAnh.setToolTipText("");
        lblChonAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblChonAnh.setOpaque(true);
        lblChonAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblChonAnhMousePressed(evt);
            }
        });
        jplformNhap.add(lblChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 110, 130));

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 0, 0));
        lblThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBao.setText(" ");
        jplformNhap.add(lblThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 280, -1));

        jplformThongTin.setBackground(new java.awt.Color(255, 255, 255));
        jplformThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jplformThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplTimkiem.setBackground(new java.awt.Color(0, 0, 0));

        lblButonTimKIem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblButonTimKIem.setForeground(new java.awt.Color(255, 255, 255));
        lblButonTimKIem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblButonTimKIem.setText("Tìm Kiếm");
        lblButonTimKIem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblButonTimKIemMousePressed(evt);
            }
        });

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

        lblTenSP.setText(".....................");
        jplformThongTin.add(lblTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 114, 260, 30));

        lblLoaiSP.setText("......................");
        jplformThongTin.add(lblLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 260, 40));

        lblpass4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass4.setText("Loại Sản Phẩm:");
        jplformThongTin.add(lblpass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, 20));

        lbluser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbluser1.setText("Tên Sản Phẩm:");
        jplformThongTin.add(lbluser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 84, 140, 20));

        lblpass6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass6.setText("Gía Bán Hiện Tại:");
        jplformThongTin.add(lblpass6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 120, 20));

        lblpass7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpass7.setText("Trạng Thái:");
        jplformThongTin.add(lblpass7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 80, 20));

        lblTrangThaiSP.setText(".....................");
        jplformThongTin.add(lblTrangThaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 260, 30));

        lblGiaSP.setText(".....................");
        jplformThongTin.add(lblGiaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 260, 30));

        lblHinhSP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinhSP.setMaximumSize(new java.awt.Dimension(110, 130));
        lblHinhSP.setMinimumSize(new java.awt.Dimension(110, 130));
        lblHinhSP.setOpaque(true);
        lblHinhSP.setPreferredSize(new java.awt.Dimension(110, 130));
        jplformThongTin.add(lblHinhSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, 130));

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

    private void lblButonTimKIemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButonTimKIemMousePressed
        // TODO add your handling code here:
        String tenSanPham = txtTimKiem.getText().trim();
        DanhSachSP ds = new DanhSachSP(null, true, tenSanPham);
        ds.setVisible(true);
    }//GEN-LAST:event_lblButonTimKIemMousePressed

    private void lblButonCapNhatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButonCapNhatMousePressed
        // TODO add your handling code here:
        if (checkNull()) {
            sanPham.setTenSp(XuLy.xuLyTen(txtTenSP.getText()));
            sanPham.setGiaBan(Double.parseDouble(txtGia.getText()));
            sanPham.setTrangThai(cboThayDoiTrangThai.getSelectedIndex() == 0);
            if (lblChonAnh.getToolTipText().equals("")) {
                sanPham.setHinhAnh(sanPham.getHinhAnh());
            } else {
                sanPham.setHinhAnh(destFile.getName());
            }

            boolean result = new SanPhamDAO().update(sanPham);
            if (result) {
                lblThongBao.setText("Cập nhật sản phẩm thành công!!");
            } else {
                lblThongBao.setText("Đã có lỗi xảy ra. Không thể cập nhật!!");
            }
        }
    }//GEN-LAST:event_lblButonCapNhatMousePressed

    private void lblChonAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChonAnhMousePressed
        // TODO add your handling code here:
        if (lblChonAnh.getName().equals("Enabled")) {
            chonAnh();
        } else {

        }
    }//GEN-LAST:event_lblChonAnhMousePressed

    private void cboThayDoiTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThayDoiTrangThaiItemStateChanged
        // TODO add your handling code here:
        int index = cboThayDoiTrangThai.getSelectedIndex();
        if (index == 0) {
            txtTenSP.setEditable(true);
            txtGia.setEditable(true);
            lblChonAnh.setName("Enabled");
        } else {
            fillForm(sanPham);
            txtTenSP.setEditable(false);
            txtGia.setEditable(false);
            lblChonAnh.setName("Disabled");
        }
    }//GEN-LAST:event_cboThayDoiTrangThaiItemStateChanged

    private void lblButonResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblButonResetMousePressed
        try {
            // TODO add your handling code here:
            clearForm();
        } catch (IOException ex) {
            Logger.getLogger(SuaSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblButonResetMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboThayDoiTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jplTimkiem;
    private javax.swing.JPanel jplformNhap;
    private javax.swing.JPanel jplformThongTin;
    private javax.swing.JLabel lblButonCapNhat;
    private javax.swing.JLabel lblButonReset;
    private javax.swing.JLabel lblButonTimKIem;
    private javax.swing.JLabel lblChonAnh;
    private javax.swing.JLabel lblGiaSP;
    private javax.swing.JLabel lblHinhSP;
    private javax.swing.JLabel lblLoaiSP;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTrangThaiSP;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lblpass2;
    private javax.swing.JLabel lblpass3;
    private javax.swing.JLabel lblpass4;
    private javax.swing.JLabel lblpass6;
    private javax.swing.JLabel lblpass7;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel lbluser1;
    private javax.swing.JLabel lblvien;
    private javax.swing.JLabel lblvien1;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
