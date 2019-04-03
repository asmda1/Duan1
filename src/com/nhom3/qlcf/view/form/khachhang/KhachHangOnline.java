/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.khachhang;

import com.nhom3.qlcf.helper.JDBCHelper;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class KhachHangOnline extends javax.swing.JPanel {

    DefaultTableModel model = null;

    /**
     * Creates new form FormKhachHangOnline
     */
    public KhachHangOnline() {
        initComponents();

        tblKhachHangOn.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblKhachHangOn.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tblKhachHangOn.getTableHeader().setOpaque(false);
        tblKhachHangOn.getTableHeader().setBackground(new Color(0, 0, 0));
        tblKhachHangOn.getTableHeader().setForeground(new Color(255, 255, 255));
        tblKhachHangOn.setRowHeight(25);
        showKHon();
    }

    public void showKHon() {
        ResultSet rs = JDBCHelper.executeQuery("SELECT * FROM dbo.KhachHang WHERE maKh NOT IN (SELECT makh FROM dbo.KhachHang WHERE maKh='KH000') AND trangThai =0");
        model = (DefaultTableModel) tblKhachHangOn.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
              Object[] row = new Object[]{
                  rs.getString("maKh"),rs.getString("tenkh"),rs.getString("diachi"),rs.getString("dienthoai")
                  
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

        jpnKHonline = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHangOn = new javax.swing.JTable();

        jpnKHonline.setLayout(new java.awt.CardLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblKhachHangOn.setForeground(new java.awt.Color(51, 51, 51));
        tblKhachHangOn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên", "Địa Chỉ Ship", "Điện Thoại"
            }
        ));
        tblKhachHangOn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblKhachHangOn.setFocusable(false);
        tblKhachHangOn.setGridColor(new java.awt.Color(0, 0, 0));
        tblKhachHangOn.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKhachHangOn.setRowHeight(25);
        tblKhachHangOn.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblKhachHangOn.setShowHorizontalLines(false);
        tblKhachHangOn.setShowVerticalLines(false);
        tblKhachHangOn.setSurrendersFocusOnKeystroke(true);
        tblKhachHangOn.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblKhachHangOn);

        jpnKHonline.add(jScrollPane2, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnKHonline, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpnKHonline, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnKHonline;
    private javax.swing.JTable tblKhachHangOn;
    // End of variables declaration//GEN-END:variables
}
