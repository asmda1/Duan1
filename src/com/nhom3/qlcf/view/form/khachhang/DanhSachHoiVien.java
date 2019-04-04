/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.khachhang;

import com.nhom3.qlcf.dao.KhachHangDAO;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.model.KhachHang;
import static com.nhom3.qlcf.view.form.khachhang.FormKhachHang.jpnBack_button;
import static com.nhom3.qlcf.view.form.khachhang.FormKhachHang.jpnDangKyForm;
import static com.nhom3.qlcf.view.form.khachhang.FormKhachHang.jpnGiaoDien;
import static com.nhom3.qlcf.view.form.khachhang.FormKhachHang.lblBack;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class DanhSachHoiVien extends javax.swing.JPanel {

    DefaultTableModel model = null;

    /**
     * Creates new form FormDanhSachHoiVien
     */
    public static DanhSachHoiVien dshv;
    public DanhSachHoiVien() {
        initComponents();
        tblKhHV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblKhHV.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tblKhHV.getTableHeader().setOpaque(false);
        tblKhHV.getTableHeader().setBackground(new Color(0, 0, 0));
        tblKhHV.getTableHeader().setForeground(new Color(255, 255, 255));
        tblKhHV.setRowHeight(25);
        dshv=this;
        showKHHV();
    }

    public void showKHHV() {
        ResultSet rs = JDBCHelper.executeQuery("SELECT * FROM dbo.KhachHang WHERE maKh NOT IN (SELECT makh FROM dbo.KhachHang WHERE maKh='KH000') AND trangThai =1");
        model = (DefaultTableModel) tblKhHV.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("maKh"), rs.getString("tenkh"), rs.getString("diachi"), rs.getString("dienthoai"), rs.getInt(8)

                };
                model.addRow(row);
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

        jpnDShoivien = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhHV = new javax.swing.JTable();

        jpnDShoivien.setLayout(new java.awt.CardLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblKhHV.setForeground(new java.awt.Color(51, 51, 51));
        tblKhHV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên", "Địa Chỉ", "Điện Thoại", "Điểm Thưởng"
            }
        ));
        tblKhHV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblKhHV.setFocusable(false);
        tblKhHV.setGridColor(new java.awt.Color(0, 0, 0));
        tblKhHV.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKhHV.setRowHeight(25);
        tblKhHV.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblKhHV.setShowHorizontalLines(false);
        tblKhHV.setShowVerticalLines(false);
        tblKhHV.setSurrendersFocusOnKeystroke(true);
        tblKhHV.getTableHeader().setReorderingAllowed(false);
        tblKhHV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhHVMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhHV);

        jpnDShoivien.add(jScrollPane3, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnDShoivien, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnDShoivien, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhHVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhHVMousePressed
        // TODO add your handling code here:
         int index = tblKhHV.getSelectedRow();
        List<KhachHang> listKH = new KhachHangDAO().selectAll();
        String sdt = listKH.get(index).getDienThoai();
        jpnDangKyForm.removeAll();
        jpnDangKyForm.add(new DangKyHoiVien(sdt));
        jpnDangKyForm.repaint();
        jpnDangKyForm.revalidate();
        jpnDangKyForm.show();
          jpnBack_button.show();
        jpnGiaoDien.hide();
    }//GEN-LAST:event_tblKhHVMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpnDShoivien;
    protected static javax.swing.JTable tblKhHV;
    // End of variables declaration//GEN-END:variables
}
