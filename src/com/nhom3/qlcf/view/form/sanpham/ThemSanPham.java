/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.sanpham;

import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.dao.LoaiSanPhamDAO;
import com.nhom3.qlcf.dao.SanPhamDAO;
import com.nhom3.qlcf.helper.ReSizehelper;
import com.nhom3.qlcf.model.LoaiSanPham;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.view.Run;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author baotri1998
 */
public class ThemSanPham extends javax.swing.JPanel {

    BufferedImage image = null;
    File sourceFile, destFile;

    /**
     * Creates new form ThemSanPham
     */
    public ThemSanPham() {
        initComponents();

        txtTenSP.setText("Tên sản phẩm");
        txtTenSP.setForeground(Color.GRAY);
        XuLy.placeHolder(txtTenSP, "Tên sản phẩm");

        txtGiaBan.setText("Giá sản phẩm");
        txtGiaBan.setForeground(Color.GRAY);
        XuLy.placeHolder(txtGiaBan, "Giá sản phẩm");

        List<LoaiSanPham> list = new LoaiSanPhamDAO().selectAll();
        cboLoaiSP.addItem("Chọn loại sản phẩm");
        list.forEach((loaiSanPham) -> {
            cboLoaiSP.addItem(loaiSanPham.getMaLoai() + " - " + loaiSanPham.getTenLoai());
        });
        lblChonHinh.setName("Chọn hình");

    }

    private void clearForm() {
        txtTenSP.setText("Tên sản phẩm");
        txtGiaBan.setText("Giá sản phẩm");
        cboLoaiSP.setSelectedIndex(0);
        lblHinh.setIcon(new ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/default.png")));
        sourceFile = null;
        destFile = null;
        lblDuongDan.setText(" ");
    }

    private static void copyFile(File sourceFile, File destFile)
            throws IOException {
        if (!sourceFile.exists()) {
            return;
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }

    }

    private void get_SetHinh() {

        int width = lblHinh.getWidth();
        int height = lblHinh.getHeight();
        JFileChooser jfc = new JFileChooser();

        FileFilter filter = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setFileFilter(filter);
        int result = jfc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                sourceFile = jfc.getSelectedFile();

                if (sourceFile.getName().length() > 50) {
                    lblDuongDan.setText("Tên ảnh không được quá 45 kí tự!!");
                    return;
                }

                String fileName = sourceFile.getName();

                destFile = new File(System.getProperty("user.dir") + "/src/com/nhom3/qlcf/img/" + fileName);

                copyFile(sourceFile, destFile);

                image = ImageIO.read(destFile);
                ImageIO.write(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height), "png", destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
        lblDuongDan.setText(sourceFile.getPath());
        lblHinh.setIcon(new ImageIcon(new ReSizehelper().buffImage(image, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType(), width, height)));
    }

    private void openImagesFolder() {
        try {
            Desktop.getDesktop().open(new File(Run.folderPAth));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String autoGetMaSP() {
        List<SanPham> listSP = new SanPhamDAO().selectAll();
        String maCuoi = listSP.get(listSP.size() - 1).getMaSanPham();
        return XuLy.tuDongTaoMa(listSP, maCuoi, "SP");
    }

    private boolean checkNull() {
        if (txtTenSP.getText().trim().isEmpty()) {
            lblTBTenSP.setText("Nhập tên sản phẩm!!");
            return false;
        }
        if (txtGiaBan.getText().trim().isEmpty()) {
            lblTBGiaSP.setText("Nhập giá sản phẩm!!");
            return false;
        }
        if (((String) cboLoaiSP.getSelectedItem()).equals("Chọn loại sản phẩm")) {
            lblTBLoaiSP.setText("Chọn loại sản phẩm!!");
            return false;
        }

        lblTBTenSP.setText(" ");
        lblTBGiaSP.setText(" ");
        lblTBLoaiSP.setText(" ");
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
        lblHinh = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lblTBGiaSP = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblReset = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblThem = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblTBLoaiSP = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTBTenSP = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblChonHinh = new javax.swing.JLabel();
        lblTBThemSP = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblMoThuMuc = new javax.swing.JLabel();
        lblDuongDan = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,130));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(161, 192));

        lblHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/default.png"))); // NOI18N
        lblHinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinh.setMaximumSize(new java.awt.Dimension(161, 192));
        lblHinh.setMinimumSize(new java.awt.Dimension(161, 192));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));
        add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 190, 33));
        add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 190, 32));

        jPanel6.setOpaque(false);

        lblTBGiaSP.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblTBGiaSP.setForeground(new java.awt.Color(204, 0, 0));
        lblTBGiaSP.setText(" ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTBGiaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTBGiaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 190, 20));

        jPanel9.setBackground(new java.awt.Color(0, 0, 255));

        lblReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblReset.setForeground(new java.awt.Color(255, 255, 255));
        lblReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReset.setText("Reset");
        lblReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblResetMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReset, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReset, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nhập Tên SP:*");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Nhập Giá Bán:*");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 90, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Loại Sản Phẩm:*");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        jPanel11.setBackground(new java.awt.Color(0, 0, 255));

        lblThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThem.setForeground(new java.awt.Color(255, 255, 255));
        lblThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem.setText("Thêm");
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblThemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 192, -1, 20));

        jPanel12.setOpaque(false);

        lblTBLoaiSP.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblTBLoaiSP.setForeground(new java.awt.Color(204, 0, 0));
        lblTBLoaiSP.setText(" ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTBLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTBLoaiSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 188, 20));

        jPanel4.setOpaque(false);

        lblTBTenSP.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblTBTenSP.setForeground(new java.awt.Color(204, 0, 0));
        lblTBTenSP.setText(" ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTBTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblTBTenSP)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 190, 20));

        add(cboLoaiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 190, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        lblChonHinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChonHinh.setForeground(new java.awt.Color(240, 240, 240));
        lblChonHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChonHinh.setText("Chọn hình");
        lblChonHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblChonHinhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblChonHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblChonHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 70, 30));

        lblTBThemSP.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblTBThemSP.setForeground(new java.awt.Color(204, 0, 0));
        lblTBThemSP.setText(" ");
        add(lblTBThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 330, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        lblMoThuMuc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMoThuMuc.setForeground(new java.awt.Color(240, 240, 240));
        lblMoThuMuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMoThuMuc.setText("Thư mục ảnh");
        lblMoThuMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMoThuMucMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMoThuMuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblMoThuMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 90, 30));

        lblDuongDan.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblDuongDan.setForeground(new java.awt.Color(255, 255, 255));
        lblDuongDan.setText(" ");
        add(lblDuongDan, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 320, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void lblThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMousePressed
        // TODO add your handling code here:
        if (checkNull()) {
            SanPham sp = new SanPham();

            sp.setMaSanPham(autoGetMaSP());
            System.out.println("maSP " + autoGetMaSP());

            String loaiSP = (String) cboLoaiSP.getSelectedItem();
            if (loaiSP.equals("Chọn loại sản phẩm")) {
                lblTBLoaiSP.setText("Chọn loại sản phẩm!!");
                return;
            }
            String maLoaiSP = loaiSP.substring(0, loaiSP.indexOf(" ")).trim();
            sp.setMaLoaiSanPham(new LoaiSanPhamDAO().selectID(maLoaiSP));
            System.out.println("maLoai " + maLoaiSP);

            sp.setTenSp(XuLy.xuLyTen(txtTenSP.getText()));
            System.out.println("ten " + XuLy.xuLyTen(txtTenSP.getText()));

            sp.setGiaBan(Double.parseDouble(txtGiaBan.getText().trim()));
            System.out.println("gia " + txtGiaBan.getText().trim());

            sp.setTrangThai(true);

            /*Notes:
            Hình thêm mới nằm bên ngoài PJ, show sản phẩm có thể lỗi (chưa test) 
            nếu f null => default.png, ngược lại tên hình
             */
            if (!destFile.exists() && destFile.length() == 0) {
                sp.setHinhAnh("default.png");
            } else {
                sp.setHinhAnh(destFile.getName());
                System.out.println("hinh " + destFile.getName());
            }
            boolean insertResult = new SanPhamDAO().insert(sp);
            if (insertResult) {
                lblTBThemSP.setText("Đã thêm sản phẩm mới!!");
                clearForm();
            } else {
                lblTBThemSP.setText("Thêm sản phẩm mới thất bại!!");
            }
        }
    }//GEN-LAST:event_lblThemMousePressed

    private void lblResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMousePressed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_lblResetMousePressed

    private void lblChonHinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChonHinhMousePressed
        // TODO add your handling code here:
        get_SetHinh();

    }//GEN-LAST:event_lblChonHinhMousePressed

    private void lblMoThuMucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoThuMucMousePressed
        // TODO add your handling code here:
        openImagesFolder();
    }//GEN-LAST:event_lblMoThuMucMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblChonHinh;
    private javax.swing.JLabel lblDuongDan;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblMoThuMuc;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel lblTBGiaSP;
    private javax.swing.JLabel lblTBLoaiSP;
    private javax.swing.JLabel lblTBTenSP;
    private javax.swing.JLabel lblTBThemSP;
    private javax.swing.JLabel lblThem;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
