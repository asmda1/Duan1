/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.nhacungcap;

import com.nhom3.qlcf.dao.NhaCungCapDAO;
import com.nhom3.qlcf.model.NhaCungCap;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baotri1998
 */
public class DanhSachSuaNhaCC extends javax.swing.JDialog {

    List<NhaCungCap> list = null;

    /**
     * Creates new form DanhSachSuaNhaCC
     */
    public DanhSachSuaNhaCC(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        showKHHV();
        setLocationRelativeTo(parent);
    }
    DefaultTableModel model = null;

    public void showKHHV() {
        list = new NhaCungCapDAO().selectAll();
        model = (DefaultTableModel) tblnhacungcap.getModel();
        model.setRowCount(0);
        try {
            list.stream().map((kh) -> new Object[]{
                kh.getMaNhaCungCap(), kh.getTenNhaCC(), kh.getDienThoai(), kh.getDiaChi(), kh.isTrangThai()
            }).forEachOrdered((row) -> {
                model.addRow(row);
            });
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
        tblnhacungcap = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblnhacungcap.setForeground(new java.awt.Color(51, 51, 51));
        tblnhacungcap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MNCC", "Tên", "Điện Thoại", "Chi Nhánh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnhacungcap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblnhacungcap.setFocusable(false);
        tblnhacungcap.setGridColor(new java.awt.Color(102, 102, 102));
        tblnhacungcap.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblnhacungcap.setRowHeight(25);
        tblnhacungcap.setSelectionForeground(new java.awt.Color(204, 204, 204));
        tblnhacungcap.setShowVerticalLines(false);
        tblnhacungcap.getTableHeader().setReorderingAllowed(false);
        tblnhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblnhacungcapMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblnhacungcap);
        if (tblnhacungcap.getColumnModel().getColumnCount() > 0) {
            tblnhacungcap.getColumnModel().getColumn(0).setResizable(false);
            tblnhacungcap.getColumnModel().getColumn(1).setResizable(false);
            tblnhacungcap.getColumnModel().getColumn(2).setResizable(false);
            tblnhacungcap.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Close");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblnhacungcapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhacungcapMousePressed
        // TODO add your handling code here:
        int index = tblnhacungcap.getSelectedRow();
        list = new NhaCungCapDAO().selectAll();
        String sdt = list.get(index).getMaNhaCungCap();
        ChinhSuaNhaCungCap.txttimnhacc.setText(sdt);
        ChinhSuaNhaCungCap.txttimnhacc.setForeground(Color.BLACK);
        ChinhSuaNhaCungCap.csncc.timNhaCungCap();
        dispose();
    }//GEN-LAST:event_tblnhacungcapMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MousePressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhSachSuaNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachSuaNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachSuaNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachSuaNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachSuaNhaCC dialog = new DanhSachSuaNhaCC(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblnhacungcap;
    // End of variables declaration//GEN-END:variables
}
