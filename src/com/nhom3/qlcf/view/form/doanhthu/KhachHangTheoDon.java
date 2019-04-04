/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.doanhthu;


import com.nhom3.qlcf.dao.KhachHangDAO;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.model.KhachHang;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class KhachHangTheoDon extends javax.swing.JPanel {

    /**
     * Creates new form LichSuMuaHang
     */
    public KhachHangTheoDon() {
        initComponents();
        txtSearch.setText("Tìm kiếm khách hàng");
        txtSearch.setForeground(Color.gray);
        XuLy.placeHolder(txtSearch, "Tìm kiếm khách hàng");
        fillToTable("");
    }

    private void fillToTable(String tenKH) {
        List<KhachHang> listKH;
        if (tenKH.isEmpty()) {
            listKH = new KhachHangDAO().select("Select DISTINCT dbo.KhachHang.* FROM dbo.KhachHang JOIN dbo.HoaDon ON HoaDon.maKH = KhachHang.maKh");
        } else {
            listKH = new KhachHangDAO().select("Select DISTINCT dbo.KhachHang.* FROM dbo.KhachHang JOIN dbo.HoaDon ON HoaDon.maKH = KhachHang.maKh where tenKh like N'%" + tenKH + "%'");
        }

        DefaultTableModel model = (DefaultTableModel) tblKHTheoDon.getModel();
        model.setRowCount(0);
        listKH.stream().map((khachHang) -> new Object[]{khachHang.getTenKh(), khachHang.getMakh(), khachHang.getDienThoai(), khachHang.getDiaChi(), khachHang.isTrangThai() ? "Hội viên" : "Khách online", khachHang.getDiemThuong()}).forEachOrdered((row) -> {
            model.addRow(row);
        });
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
        tblKHTheoDon = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblKHTheoDon.setForeground(new java.awt.Color(51, 51, 51));
        tblKHTheoDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Anh/Chị", "Mã số", "Điện thoại", "Địa chỉ", "Loại khách", "Điểm thưởng (Hội viên)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKHTheoDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblKHTheoDon.setFocusable(false);
        tblKHTheoDon.setGridColor(new java.awt.Color(0, 0, 0));
        tblKHTheoDon.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblKHTheoDon.setName(""); // NOI18N
        tblKHTheoDon.setRowHeight(25);
        tblKHTheoDon.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblKHTheoDon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblKHTheoDon.setShowHorizontalLines(false);
        tblKHTheoDon.setShowVerticalLines(false);
        tblKHTheoDon.setSurrendersFocusOnKeystroke(true);
        tblKHTheoDon.getTableHeader().setReorderingAllowed(false);
        tblKHTheoDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKHTheoDonMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblKHTheoDon);
        if (tblKHTheoDon.getColumnModel().getColumnCount() > 0) {
            tblKHTheoDon.getColumnModel().getColumn(0).setResizable(false);
            tblKHTheoDon.getColumnModel().getColumn(1).setResizable(false);
            tblKHTheoDon.getColumnModel().getColumn(2).setResizable(false);
            tblKHTheoDon.getColumnModel().getColumn(3).setResizable(false);
            tblKHTheoDon.getColumnModel().getColumn(4).setResizable(false);
            tblKHTheoDon.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TỔNG HỢP KHÁCH HÀNG ĐẶT MUA THEO ĐƠN");

        lblTenKH.setText("Tên KH:");

        lblTongDoanhThu.setText("Tổng Doanh Thu:");

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setText("Tìm Tên KH");
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongDoanhThu)
                    .addComponent(lblTenKH))
                .addGap(13, 13, 13)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        // TODO add your handling code here:
        String tenKH = txtSearch.getText().trim();
        fillToTable(tenKH);
    }//GEN-LAST:event_lblSearchMouseClicked

    private void tblKHTheoDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHTheoDonMousePressed
        // TODO add your handling code here:

        String[] column = {"Mã HĐ", "Ngày lập", "Tên SP", "Size", "Extra", "Số lượng"};
        DefaultTableModel table = new DefaultTableModel(column, ABORT);
        JScrollPane scp = new JScrollPane();
        JTable tbl = new JTable(table); 
        scp.setViewportView(tbl);
        scp.setPreferredSize(new Dimension(580, 550)); 
        JPanel pnl = new JPanel(new BorderLayout(5, 5));
        
        pnl.add(scp, BorderLayout.NORTH);
        JDialog dl = new JDialog(SwingUtilities.windowForComponent(this));
//        dl.setModal(true); 
        dl.setSize(new Dimension(600, 600));
        dl.add(pnl);
        dl.setVisible(true);
        dl.setLocationRelativeTo(null);
        int index = tblKHTheoDon.getSelectedRow();
        String maKH = (String) tblKHTheoDon.getValueAt(index, 1);
        ResultSet rs = JDBCHelper.executeQuery("SELECT HoaDon.maHD, ngayHD, tenSp, maSize, ten, soLuong FROM dbo.KhachHang"
                + " JOIN dbo.HoaDon ON HoaDon.maKH = KhachHang.maKh"
                + " JOIN dbo.CTHoaDon ON CTHoaDon.maHD = HoaDon.maHD"
                + " JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp"
                + " JOIN dbo.Extra ON Extra.id = CTHoaDon.extra"
                + " WHERE HoaDon.maKH = ?", maKH);
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tblKHTheoDonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JTable tblKHTheoDon;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
