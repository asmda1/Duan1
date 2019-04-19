/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.banhang;

import com.nhom3.qlcf.dao.KhachHangDAO;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.ReSizehelper;
import com.nhom3.qlcf.helper.Soundhelper;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.model.CTHoaDon;
import com.nhom3.qlcf.model.HoaDon;
import com.nhom3.qlcf.model.KhachHang;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.model.SizeSP;
import com.nhom3.qlcf.view.form.khachhang.jdialogThemKH;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class KhachDatOnline extends javax.swing.JDialog {

    /**
     * Creates new form CapNhatHoaDon
     */
    List<HoaDon> listHD = null;
    List<CTHoaDon> listCTHD = null;
    DefaultTableModel model;
    int index = 0;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    JLabel tenSP, giaBan, maSize, soLuong, HinhAnh;
    
    public KhachDatOnline(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        tblkhachdatonline.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblkhachdatonline.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tblkhachdatonline.getTableHeader().setOpaque(false);
        tblkhachdatonline.getTableHeader().setBackground(new Color(0, 0, 0));
        tblkhachdatonline.getTableHeader().setForeground(new Color(255, 255, 255));
        tblkhachdatonline.setRowHeight(25);
        filltoTable();
    }
    
    public void filltoTable() {
        
        ResultSet rs = JDBCHelper.executeQuery("EXEC dbo. KhachDatOnline");
        model = (DefaultTableModel) tblkhachdatonline.getModel();
        listHD = new ArrayList<HoaDon>();
        listHD.clear();
        try {
            model.setRowCount(0);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                kh.setTenKh(rs.getString(2));
                kh.setDienThoai(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaKhachHang(kh);
                hd.setTongTien(rs.getDouble(6));
                hd.setTrangThai(rs.getBoolean(7));
                Object[] row = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getDouble(6), rs.getBoolean(7) == false ? "Chưa Thanh toán" : "Thanh Toán"};
                model.addRow(row);
                listHD.add(hd);
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //
    public void update() {
        JDBCHelper.executeUpdate("UPDATE dbo.HoaDon SET trangThai = 1, tongtien=" + Double.parseDouble(lbltongtien.getName()) + " WHERE maHD ='" + lblmaHD.getName() + "'");
        
        if (listHD.isEmpty()) {
            lblThongBao.setText("Không Có Hóa Đơn Nào!");
            lblThongBao.setForeground(Color.red);
        } else if (lblmaHD.getText().equals("Mã HĐ: ")) {
            lblThongBao.setText("Chọn Hóa Đơn Để Thanh Toán!");
            lblThongBao.setForeground(Color.red);
        } else {
            lblThongBao.setText("Thanh Toán Thành Công !");
            lblThongBao.setForeground(Color.green);
            filltoTable();
            jplchiTietSP.removeAll();
            jplchiTietSP.updateUI();
            lblmaHD.setText("Mã HĐ: ");
            lblKH.setText("");
            lblsdt.setText("");
            lbltongtien.setText("");
        }
        
    }
    
    public void fillChiTietSP() {
        ResultSet rs = JDBCHelper.executeQuery("EXEC dbo.ChitietKHdatSP @maHD ='" + lblmaHD.getName() + "'");
        listCTHD = new ArrayList<>();
        try {
            while (rs.next()) {
                SanPham sp = new SanPham();
                SizeSP sz = new SizeSP();
                CTHoaDon cthd = new CTHoaDon();
                sp.setTenSp(rs.getString(1));
                sp.setGiaBan(rs.getDouble(2));
                sz.setMaSize(rs.getString(3));
                cthd.setSoLuong(rs.getInt(4));
                sp.setHinhAnh(rs.getString(5));
                cthd.setSizeSP(sz);
                cthd.setMaSanPham(sp);
                listCTHD.add(cthd);
                jplChiTietSP();
            }
            
        } catch (Exception e) {
        }
    }
    
    public void jplChiTietSP() {
        
        jplchiTietSP.removeAll();
        jplchiTietSP.updateUI();
        jplchiTietSP.setVisible(true);
        jplchiTietSP.setLayout(new BoxLayout(jplchiTietSP, BoxLayout.PAGE_AXIS));
        JPanel[] pnl = new JPanel[listCTHD.size()];
        try {
            for (int i = 0; i < listCTHD.size(); i++) {
                pnl[i] = new JPanel();
                // pnl[i].setBorder(BorderFactory.createLineBorder(new Color(204, 7, 140), 1));
                pnl[i].setBackground(Color.WHITE);
                pnl[i].setLayout(new GridLayout(1, 2, 5, 15));
                pnl[i].setPreferredSize(new Dimension(600, 70));
                pnl[i].setMaximumSize(new Dimension(600, 70));
                pnl[i].setMinimumSize(new Dimension(600, 70));
                tenSP = new JLabel(listCTHD.get(i).getMaSanPham().getTenSp());
                tenSP.setFont(new Font("Tahoma", 1, 11));
                tenSP.setPreferredSize(new Dimension(50, 20));
                giaBan = new JLabel(String.valueOf(chuyentien.format(listCTHD.get(i).getMaSanPham().getGiaBan())) + " VNĐ/ " + listCTHD.get(i).getSoLuong());
                maSize = new JLabel(listCTHD.get(i).getSizeSP().getMaSize());
                soLuong = new JLabel(String.valueOf(listCTHD.get(i).getSoLuong()));
                HinhAnh = new JLabel();
                
                BufferedImage image = ImageIO.read(getClass().getResource("/com/nhom3/qlcf/img/" + listCTHD.get(i).getMaSanPham().getHinhAnh()));
                
                
                int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
                BufferedImage hinhAnh = new ReSizehelper().buffImage(image, type, 70, 70);
                ImageIcon icon = new ImageIcon(hinhAnh);
                HinhAnh.setIcon(icon);
                pnl[i].add(tenSP);
                pnl[i].add(HinhAnh);
                pnl[i].add(giaBan);
                pnl[i].add(maSize);
                jplchiTietSP.add(pnl[i]);
                jplchiTietSP.updateUI();
                
            }
            
        } catch (Exception e) {
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tblkhachdatonline = new javax.swing.JTable();
        lblthanhToan = new javax.swing.JLabel();
        lblmaHD = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        lblsdt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbltongtien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jplchiTietSP = new javax.swing.JPanel();
        txttimsdt = new javax.swing.JTextField();
        lblbuttontim = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblkhachdatonline.setForeground(new java.awt.Color(51, 51, 51));
        tblkhachdatonline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Tên KH", "SĐT", "Địa Chỉ"
            }
        ));
        tblkhachdatonline.setToolTipText("");
        tblkhachdatonline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblkhachdatonline.setFocusable(false);
        tblkhachdatonline.setGridColor(new java.awt.Color(0, 0, 0));
        tblkhachdatonline.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblkhachdatonline.setRowHeight(25);
        tblkhachdatonline.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblkhachdatonline.setShowHorizontalLines(false);
        tblkhachdatonline.setShowVerticalLines(false);
        tblkhachdatonline.setSurrendersFocusOnKeystroke(true);
        tblkhachdatonline.getTableHeader().setReorderingAllowed(false);
        tblkhachdatonline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblkhachdatonlineMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblkhachdatonline);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 51, 420, 320));

        lblthanhToan.setBackground(new java.awt.Color(0, 102, 255));
        lblthanhToan.setForeground(new java.awt.Color(255, 255, 255));
        lblthanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblthanhToan.setText("Chọn Hóa Đơn Thanh Toán");
        lblthanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblthanhToan.setOpaque(true);
        lblthanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblthanhToanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblthanhToanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblthanhToanMousePressed(evt);
            }
        });
        jPanel1.add(lblthanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 383, 139, 30));

        lblmaHD.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblmaHD.setForeground(new java.awt.Color(0, 51, 255));
        lblmaHD.setText("Mã HĐ: ");
        jPanel1.add(lblmaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 383, 80, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Close");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 388, 84, 35));

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(0, 255, 0));
        jPanel1.add(lblThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 1, 300, 36));

        lblKH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblKH.setForeground(new java.awt.Color(0, 204, 0));
        jPanel1.add(lblKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 383, 177, 35));

        lblsdt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblsdt.setForeground(new java.awt.Color(0, 51, 255));
        jPanel1.add(lblsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 383, 167, 35));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Khách Đặt Online");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 1, 370, 36));

        lbltongtien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltongtien.setText("...");
        jPanel1.add(lbltongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 388, 180, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Chi Tiết Sản Phẩm");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 490, 30));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jplchiTietSP.setBackground(new java.awt.Color(255, 255, 255));
        jplchiTietSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jplchiTietSPLayout = new javax.swing.GroupLayout(jplchiTietSP);
        jplchiTietSP.setLayout(jplchiTietSPLayout);
        jplchiTietSPLayout.setHorizontalGroup(
            jplchiTietSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        jplchiTietSPLayout.setVerticalGroup(
            jplchiTietSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jplchiTietSP);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 490, 290));

        txttimsdt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(txttimsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, 30));
        txttimsdt.setText("Tìm SĐT");
        txttimsdt.setForeground(Color.gray);
        XuLy.placeHolder(txttimsdt, "Tìm SĐT");

        lblbuttontim.setBackground(new java.awt.Color(0, 102, 204));
        lblbuttontim.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblbuttontim.setForeground(new java.awt.Color(255, 255, 255));
        lblbuttontim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbuttontim.setText("Tìm SDT");
        lblbuttontim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblbuttontim.setOpaque(true);
        lblbuttontim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblbuttontimMousePressed(evt);
            }
        });
        jPanel1.add(lblbuttontim, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblkhachdatonlineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachdatonlineMousePressed
        // TODO add your handling code here:
        index = tblkhachdatonline.getSelectedRow();
        HoaDon hd = listHD.get(index);
        tblkhachdatonline.setToolTipText("Anh/Chị: " + hd.getMaKhachHang().getTenKh() + ", Địa Chỉ Giao Hàng: "
                + hd.getMaKhachHang().getDiaChi());
        
        lblmaHD.setText("Mã HĐ:" + hd.getMaHoaDon());
        lblmaHD.setName(hd.getMaHoaDon());
        lblKH.setText("Anh/Chị: " + hd.getMaKhachHang().getTenKh());
        lblKH.setName(hd.getMaKhachHang().getTenKh());
        lblsdt.setText("SĐT: " + hd.getMaKhachHang().getDienThoai());
        lblsdt.setName(hd.getMaKhachHang().getDienThoai());
        fillChiTietSP();
        int tongtien = 0;
        for (int i = 0; i < listCTHD.size(); i++) {
            tongtien += listCTHD.get(i).getSoLuong() * listCTHD.get(i).getMaSanPham().getGiaBan();
        }
        lbltongtien.setText("Tổng Tiền : " + chuyentien.format(tongtien) + " VNĐ");
        lbltongtien.setName(String.valueOf(tongtien));
        lblmaHD.setName(hd.getMaHoaDon());
        lblthanhToan.setText("Thanh Toán Ngay");

        //cbxTrangThai.setSelectedItem(hd.isTrangThai());
    }//GEN-LAST:event_tblkhachdatonlineMousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel2MousePressed

    private void lblthanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthanhToanMousePressed
        // TODO add your handling code here:
        update();
        String tienkhach ="0";
        String tienthoi ="0";
        InHoaDon in = new InHoaDon(null, rootPaneCheckingEnabled, lblmaHD.getName(), lbltongtien.getName(), lblKH.getName(), lblsdt.getName());
        in.setVisible(true);
    }//GEN-LAST:event_lblthanhToanMousePressed

    private void lblbuttontimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuttontimMousePressed
        // TODO add your handling code here:
        KhachHangDAO khDao = new KhachHangDAO();
        if (txttimsdt.getText().trim().equals("") || txttimsdt.getText().trim().equals("Tìm SĐT KH")) {
            lblThongBao.setText("Nhập số điện thoại khách hàng!");
            lblThongBao.setForeground(Color.red);
            lblThongBao.setCursor(null);
            lblThongBao.setName("KH000");
        } else if (!txttimsdt.getText().matches("[0-9]+")) {
            lblThongBao.setText("Lỗi! phải nhập bằng số!");
            lblThongBao.setForeground(Color.red);
            lblThongBao.setCursor(null);
            lblThongBao.setName("KH000");
            
        } else if (txttimsdt.getText().length() < 9 || txttimsdt.getText().length() > 13) {
            lblThongBao.setText("SĐT phải là [9-13] số!");
            lblThongBao.setForeground(Color.red);
            lblThongBao.setCursor(null);
            
        } else if (khDao.checkSDT(txttimsdt.getText()) == false) {
            lblThongBao.setText("SĐT này không có trong danh sách");
            lblThongBao.setForeground(Color.red);
            lblThongBao.setCursor(null);
            
        } else {
              lblThongBao.setText("Tìm Thành công");
            lblThongBao.setForeground(Color.GREEN);
            ResultSet rs = JDBCHelper.executeQuery("Exec TimKhachHang @SDT ='" + txttimsdt.getText() + "'");
            model = (DefaultTableModel) tblkhachdatonline.getModel();
            listHD = new ArrayList<HoaDon>();
            listHD.clear();
            try {
                model.setRowCount(0);
                while (rs.next()) {
                    HoaDon hd = new HoaDon();
                    KhachHang kh = new KhachHang();
                    kh.setTenKh(rs.getString(2));
                    kh.setDienThoai(rs.getString(3));
                    kh.setDiaChi(rs.getString(4));
                    hd.setMaHoaDon(rs.getString(1));
                    hd.setMaKhachHang(kh);
                    hd.setTongTien(rs.getDouble(6));
                    hd.setTrangThai(rs.getBoolean(7));
                    Object[] row = new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDouble(6), rs.getBoolean(7) == false ? "Chưa Thanh toán" : "Thanh Toán"};
                    model.addRow(row);
                    listHD.add(hd);
                    
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_lblbuttontimMousePressed

    private void lblthanhToanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthanhToanMouseEntered
        // TODO add your handling code here:
        lblthanhToan.setBackground(Color.red);
    }//GEN-LAST:event_lblthanhToanMouseEntered

    private void lblthanhToanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthanhToanMouseExited
        // TODO add your handling code here:
        lblthanhToan.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_lblthanhToanMouseExited

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachDatOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachDatOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachDatOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachDatOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhachDatOnline dialog = new KhachDatOnline(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jplchiTietSP;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblbuttontim;
    private javax.swing.JLabel lblmaHD;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JLabel lblthanhToan;
    private javax.swing.JLabel lbltongtien;
    private javax.swing.JTable tblkhachdatonline;
    private javax.swing.JTextField txttimsdt;
    // End of variables declaration//GEN-END:variables
}
