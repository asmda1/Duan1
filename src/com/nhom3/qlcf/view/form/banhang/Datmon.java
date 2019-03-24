/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.banhang;

import com.nhom3.qlcf.helper.Designhelper;
import static com.nhom3.qlcf.helper.Designhelper.bruteforce;
import com.nhom3.qlcf.model.CTHoaDon;
import com.nhom3.qlcf.model.Extra;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.model.SizeSP;
import com.nhom3.qlcf.test.SelectSIze;

import com.nhom3.qlcf.test.testSQL;
import com.nhom3.qlcf.view.form.banhang.FormBanHang;
import static com.nhom3.qlcf.view.form.banhang.FormBanHang.DongCTHD;
import static com.nhom3.qlcf.view.form.banhang.FormBanHang.jpldonhang;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author baotri1998
 */
public class Datmon extends javax.swing.JDialog {

    /**
     * Creates new form Datmon
     */
    public Datmon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    String maString, ten, gia, img, soluong;
    public List<CTHoaDon> list1;
    public List<SanPham> showSP = null;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");

    int so;
    public static Datmon datmon;

    public Datmon(java.awt.Frame parent, boolean modal, String ma, String gia, String ten, String img, String soluong) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.maString = ma;
        this.gia = gia;
        this.ten = ten;
        this.img = img;
        this.soluong = soluong;
        datmon = this;
        lblgia.setText(this.gia);
        lblten.setName(maString);
        lblten.setText(this.ten);

        fill();

    }

    public Datmon(java.awt.Frame parent, boolean modal, String ma, String gia, String ten, String img) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.maString = ma;
        this.gia = gia;
        this.ten = ten;
        this.img = img;
        datmon = this;
        lblgia.setText(this.gia);
        lblten.setName(maString);
        lblten.setText(this.ten);

        fill();

    }

    public void getCTHD() {
        list1 = new ArrayList<CTHoaDon>();
        CTHoaDon ct = new CTHoaDon();
        SanPham sp = new SanPham();
        Extra Ex = new Extra();
        SizeSP sSP = new SizeSP();
        sp.setTenSp(lblten.getText());
        sp.setMaSanPham(lblten.getName());
        sp.setGiaBan(Double.parseDouble(lblgia.getName()));

        sp.setHinhAnh("/com/qlbhcafe/img/" + lblimg.getText());
        //getClass().getResource("/com/qlbhcafe/img/" + data.get(i).getHinhAnh()))
        Ex.setId("EX001");
        if (lblsize.getText().equals("VỪA")) {
            lblsize.setName("M");
            sSP.setMaSize(lblsize.getName());
            ct.setSizeSP(sSP);
        } else {
            sSP.setMaSize(lblsize.getName());
            ct.setSizeSP(sSP);
        }
        ct.setExtra(Ex);
        ct.setSoLuong(Integer.parseInt(txtsoluong.getText()));
        ct.setMaSanPham(sp);

        list1.add(ct);
    }

    public void DongGoi() {
        CTHoaDon cthd = new CTHoaDon();
        SanPham sp = new SanPham();
        SizeSP sSp = new SizeSP();
        Extra Ex = new Extra();
        for (int i = 0; i < Datmon.datmon.list1.size(); i++) {
            sp.setMaSanPham(Datmon.datmon.list1.get(i).getMaSanPham().getMaSanPham());
            sp.setTenSp(Datmon.datmon.list1.get(i).getMaSanPham().getTenSp());
            sp.setGiaBan(Datmon.datmon.list1.get(i).getMaSanPham().getGiaBan());
            sp.setHinhAnh(Datmon.datmon.list1.get(i).getMaSanPham().getHinhAnh());
            sSp.setMaSize(Datmon.datmon.list1.get(i).getSizeSP().getMaSize());
            Ex.setId(list1.get(i).getExtra().getId());
            cthd.setSoLuong(Datmon.datmon.list1.get(i).getSoLuong());
            cthd.setMaSanPham(sp);
            cthd.setSizeSP(sSp);
            cthd.setExtra(Ex);
        }
        DongCTHD.add(cthd);
    }

    public void fill() {
        showSP = testSQL.FindmaSP(maString);
        lblmaSP.setText(showSP.get(0).getMaSanPham());
        lblten.setName(showSP.get(0).getMaSanPham());
        lblten.setText(showSP.get(0).getTenSp());
        lblgia.setText(String.valueOf(chuyentien.format(showSP.get(0).getGiaBan())) + " VNĐ");
        lblgiagoc.setText(String.valueOf(chuyentien.format(showSP.get(0).getGiaBan())) + " VNĐ");
        lblgia.setToolTipText(String.valueOf(chuyentien.format(showSP.get(0).getGiaBan())) + " VNĐ");
        lblgia.setName(String.valueOf(showSP.get(0).getGiaBan()));
        lblimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/" + showSP.get(0).getHinhAnh())));
        Designhelper designhelper = new Designhelper();
        designhelper.DesignSizeSP(jpnSize, SelectSIze.select(), showSP, lblgia, lblsize, so, txtsoluong);
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
        lblgiagoc = new javax.swing.JLabel();
        lblsize = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblgia = new javax.swing.JLabel();
        lblbutonTat = new javax.swing.JLabel();
        lblbutonThem = new javax.swing.JLabel();
        jpnSize = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblten = new javax.swing.JLabel();
        lblmaSP = new javax.swing.JLabel();
        lblimg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbltengia1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblgiagoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblgiagoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblgiagoc.setText("GIÁ NIÊM YẾT:");
        jPanel1.add(lblgiagoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 180, 30));

        lblsize.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblsize.setText("VỪA");
        lblsize.setToolTipText("");
        jPanel1.add(lblsize, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("SỐ LƯỢNG:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, -1));

        lblgia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblgia.setText("....");
        jPanel1.add(lblgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 140, 30));

        lblbutonTat.setBackground(new java.awt.Color(51, 51, 255));
        lblbutonTat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblbutonTat.setForeground(new java.awt.Color(255, 255, 255));
        lblbutonTat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbutonTat.setText("Tắt");
        lblbutonTat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblbutonTat.setOpaque(true);
        lblbutonTat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblbutonTatMousePressed(evt);
            }
        });
        jPanel1.add(lblbutonTat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 94, 30));

        lblbutonThem.setBackground(new java.awt.Color(51, 51, 255));
        lblbutonThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblbutonThem.setForeground(new java.awt.Color(255, 255, 255));
        lblbutonThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbutonThem.setText("Cập Nhật Vào Giỏ");
        lblbutonThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblbutonThem.setOpaque(true);
        lblbutonThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblbutonThemMousePressed(evt);
            }
        });
        jPanel1.add(lblbutonThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 119, 30));

        jpnSize.setBackground(new java.awt.Color(255, 255, 255));
        jpnSize.setLayout(new javax.swing.BoxLayout(jpnSize, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jpnSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 220, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("KÍCH CỠ:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 30));

        txtsoluong.setEditable(false);
        txtsoluong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtsoluong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsoluong.setText("1");
        jPanel1.add(txtsoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 60, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblten.setBackground(new Color(0,0,0,165));
        lblten.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblten.setForeground(new java.awt.Color(255, 255, 255));
        lblten.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblten.setText("tên:");
        lblten.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        lblten.setOpaque(true);
        jPanel2.add(lblten, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 40));

        lblmaSP.setBackground(new Color(25,0,0,20));
        lblmaSP.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblmaSP.setForeground(new java.awt.Color(0, 51, 255));
        lblmaSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmaSP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblmaSP.setOpaque(true);
        jPanel2.add(lblmaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        lblimg.setBackground(new java.awt.Color(255, 255, 255));
        lblimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblimg.setAutoscrolls(true);
        lblimg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblimg.setOpaque(true);
        jPanel2.add(lblimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 260));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 260));

        jLabel3.setBackground(new java.awt.Color(0, 102, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 30, 30));

        jLabel4.setBackground(new java.awt.Color(0, 102, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("+");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 30, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("THÊM: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 80, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 220, 90));

        lbltengia1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltengia1.setText("GIÁ BÁN:");
        jPanel1.add(lbltengia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lblbutonThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbutonThemMousePressed
        // TODO add your handling code here:
        /*for (Iterator<CTHoaDon> i = DongCTHD.iterator(); i.hasNext();) {
            CTHoaDon a = i.next();
            if (a.getSanPham().getMaSP().equalsIgnoreCase(String.valueOf(lblten.getName()))) {
                i.remove();
            }

        }*/

        getCTHD();
        DongGoi();
        Designhelper designhelper = new Designhelper();
        designhelper.DesigDonHang(jpldonhang, DongCTHD);

        dispose();

    }//GEN-LAST:event_lblbutonThemMousePressed

    private void lblbutonTatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbutonTatMousePressed
        // TODO add your handling code here:

        dispose();
    }//GEN-LAST:event_lblbutonTatMousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        so = Integer.parseInt(txtsoluong.getText());
        if (so < 35) { //tang toi thieu
            so++;
            txtsoluong.setText(String.valueOf(so));
            lblbutonTat.setToolTipText(String.valueOf(so));
            double giaBan = Double.parseDouble(lblgia.getName());
            lblgia.setText(String.valueOf(chuyentien.format(giaBan * (so))) + " VNĐ");
            Designhelper designhelper = new Designhelper();
            designhelper.DesignSizeSP(jpnSize, SelectSIze.select(), showSP, lblgia, lblsize, so, txtsoluong);

        }
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        // TODO add your handling code here:
        so = Integer.parseInt(txtsoluong.getText());
        if (so != 0 && so != 1) { //tang toi thieu
            so--;
            txtsoluong.setText(String.valueOf(so));
            lblbutonTat.setToolTipText(String.valueOf(so));
            double giaBan = Double.parseDouble(lblgia.getName());
            lblgia.setText(String.valueOf(chuyentien.format(giaBan * (so))) + " VNĐ");
            Designhelper designhelper = new Designhelper();
            designhelper.DesignSizeSP(jpnSize, SelectSIze.select(), showSP, lblgia, lblsize, so, txtsoluong);

        }
    }//GEN-LAST:event_jLabel3MousePressed

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
            java.util.logging.Logger.getLogger(Datmon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datmon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datmon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datmon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Datmon dialog = new Datmon(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpnSize;
    private javax.swing.JLabel lblbutonTat;
    private javax.swing.JLabel lblbutonThem;
    private javax.swing.JLabel lblgia;
    private javax.swing.JLabel lblgiagoc;
    private javax.swing.JLabel lblimg;
    private javax.swing.JLabel lblmaSP;
    private javax.swing.JLabel lblsize;
    private javax.swing.JLabel lblten;
    private javax.swing.JLabel lbltengia1;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
