/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.doanhthu;

import com.nhom3.qlcf.helper.JDBCHelper;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class SanPhamBanChay extends javax.swing.JPanel {

    /**
     * Creates new form LichSuMuaHang
     */
    public SanPhamBanChay() {
        initComponents();
        tblSanPhamBanChay.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblSanPhamBanChay.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tblSanPhamBanChay.getTableHeader().setOpaque(false);
        tblSanPhamBanChay.getTableHeader().setBackground(new Color(0, 0, 0));
        tblSanPhamBanChay.getTableHeader().setForeground(new Color(255, 255, 255));
        tblSanPhamBanChay.setRowHeight(22);
        fillToTable();
    }

    private void fillToTable() {
        ResultSet rs = JDBCHelper.executeQuery("EXEC dbo.SanPhamBanChay");
        DefaultTableModel model = (DefaultTableModel) tblSanPhamBanChay.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3)};
                model.addRow(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamBanChay = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblSanPhamBanChay.setForeground(new java.awt.Color(51, 51, 51));
        tblSanPhamBanChay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "maSP", "Tên SP", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamBanChay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSanPhamBanChay.setFocusable(false);
        tblSanPhamBanChay.setGridColor(new java.awt.Color(0, 0, 0));
        tblSanPhamBanChay.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblSanPhamBanChay.setRowHeight(25);
        tblSanPhamBanChay.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblSanPhamBanChay.setShowHorizontalLines(false);
        tblSanPhamBanChay.setShowVerticalLines(false);
        tblSanPhamBanChay.setSurrendersFocusOnKeystroke(true);
        tblSanPhamBanChay.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblSanPhamBanChay);
        if (tblSanPhamBanChay.getColumnModel().getColumnCount() > 0) {
            tblSanPhamBanChay.getColumnModel().getColumn(0).setResizable(false);
            tblSanPhamBanChay.getColumnModel().getColumn(1).setResizable(false);
            tblSanPhamBanChay.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SẢN PHẨM BÁN CHẠY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblSanPhamBanChay;
    // End of variables declaration//GEN-END:variables
}
