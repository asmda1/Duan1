/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.hanghoa;

import com.nhom3.qlcf.dao.HangHoaDAO;
import com.nhom3.qlcf.model.HangHoa;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class ListHang extends javax.swing.JPanel {

    /**
     * Creates new form ThemKhachHang
     */
    public static ListHang nhapHang1;
    public static String tenMatHang;
    static List<HangHoa> list;

    public ListHang() {
        initComponents();
        nhapHang1 = this;
        tblKhoHang.setOpaque(false);
        ((DefaultTableCellRenderer) tblKhoHang.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        tblKhoHang.setShowGrid(false);
//        this.setOpaque(false);
        fillToTable(tenMatHang);
    }

    private void fillToTable(String tenHH) {
        if (tenHH.isEmpty() || tenHH.equals("Tên mặt hàng")) {
            list = new HangHoaDAO().selectAll();
        } else {
            list = new HangHoaDAO().select("SELECT * FROM  dbo.HangHoa where tenHangHoa like '%" + tenHH + "%'");
        }
        DefaultTableModel table = (DefaultTableModel) tblKhoHang.getModel();

        table.setRowCount(0);
        list.stream().map((hangHoa) -> new Object[]{hangHoa.getTenHangHoa(), hangHoa.getDonViTinh(), hangHoa.getSoLuong(), hangHoa.getGiaVon(), hangHoa.getMoTa(), hangHoa.getMaHangHoa()}).forEachOrdered((row) -> {
            table.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(520, 582));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblKhoHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKhoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên mặt hàng", "Đơn vị tính", "Số lượng", "Giá vốn", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhoHang.setSelectionForeground(new java.awt.Color(255, 0, 51));
        tblKhoHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblKhoHang.setShowHorizontalLines(false);
        tblKhoHang.setShowVerticalLines(false);
        tblKhoHang.getTableHeader().setReorderingAllowed(false);
        tblKhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhoHangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhoHang);
        if (tblKhoHang.getColumnModel().getColumnCount() > 0) {
            tblKhoHang.getColumnModel().getColumn(0).setResizable(false);
            tblKhoHang.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblKhoHang.getColumnModel().getColumn(1).setResizable(false);
            tblKhoHang.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblKhoHang.getColumnModel().getColumn(2).setResizable(false);
            tblKhoHang.getColumnModel().getColumn(2).setPreferredWidth(75);
            tblKhoHang.getColumnModel().getColumn(3).setResizable(false);
            tblKhoHang.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quay về");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhoHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoHangMousePressed
        // TODO add your handling code here:
        int index = tblKhoHang.getSelectedRow();
        NhapHang.matHang = list.get(index);
        
        FormNhapHang.jpnThemHoangHoa.removeAll();
        FormNhapHang.jpnThemHoangHoa.add(new NhapHang());
        FormNhapHang.jpnThemHoangHoa.repaint();
        FormNhapHang.jpnThemHoangHoa.revalidate();
        this.hide();
    }//GEN-LAST:event_tblKhoHangMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        FormNhapHang.jpnThemHoangHoa.removeAll();
        FormNhapHang.jpnThemHoangHoa.add(new NhapHang());
        FormNhapHang.jpnThemHoangHoa.repaint();
        FormNhapHang.jpnThemHoangHoa.revalidate();
        this.hide();
    }//GEN-LAST:event_jLabel1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhoHang;
    // End of variables declaration//GEN-END:variables
}
