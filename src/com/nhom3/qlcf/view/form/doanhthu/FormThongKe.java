/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.doanhthu;

import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.view.form.login.FormLogin;
import com.nhom3.qlcf.view.form.menu.FormMenu;
import com.nhom3.qlcf.view.Run;
import static com.nhom3.qlcf.view.form.menu.FormMenu.jfMain;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author baotri1998
 */
public class FormThongKe extends javax.swing.JPanel {

    private DefaultCategoryDataset barChartLoadata; // set du lieu cho bieu do hinh line
    private JFreeChart Chart; // Hien thi do hoa,cot, ten cot, hinh
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    /**
     * Creates new form FormLogin
     */
    public static FormThongKe login;

    public FormThongKe() {
        initComponents();
        // jpnLogin1.setBackground(new Color(0, 0, 0, 134));
        //jpnNenButton_login1.setBackground(new Color(0, 0, 0, 64));
        login = this;
        Loadcombo();
        tblHoatDongBanHang.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
        tblHoatDongBanHang.setFont(new Font("Tohoma", Font.PLAIN, 10));
        tblHoatDongBanHang.getTableHeader().setOpaque(false);
        tblHoatDongBanHang.getTableHeader().setBackground(new Color(0, 0, 0));
        tblHoatDongBanHang.getTableHeader().setForeground(new Color(255, 255, 255));
        tblHoatDongBanHang.setRowHeight(25);
        String[] items = {"Hôm Nay", "Hôm Qua", "7 Ngày Trước", "Chọn Trong Ngày "};
        for (String item : items) {
            cboDate.addItem(item);
        }
        cboDate.setSelectedIndex(0);
         for(int i =1; i<32;i++){
            coxngay.addItem(String.valueOf(i));
        }
        coxngay.setSelectedIndex(0);
        ThongkeHomNay();
       
    }

    public void ThongkeHomNay() {
        int index = cboDate.getSelectedIndex();

        switch (index) {
            case 0:
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy ");
                    Calendar day = Calendar.getInstance();
                    day.add(Calendar.DATE, 0);
                    lblngay.setText(String.valueOf(day.getTime()));
                    coxngay.hide();
                    String sql = " SELECT tenSp, SUM(soLuong),SUM(giaBan*soLuong) FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.maHD = HoaDon.maHD JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp\n"
                            + "												 WHERE ngayHD Between '" + sdf.format(day.getTime()) + "' and GETDATE() AND HoaDon.trangThai=1 GROUP BY tenSp,giaBan ";
                    ResultSet rs = JDBCHelper.executeQuery(sql);
                    DefaultTableModel model = (DefaultTableModel) tblHoatDongBanHang.getModel();
                    model.setRowCount(0);
                    double loinhuan = 0;
                    while (rs.next()) {
                        Object[] row = new Object[]{rs.getString(1), rs.getInt(2), chuyentien.format(rs.getDouble(3)) + " VNĐ"};
                        loinhuan += rs.getDouble(3);
                        model.addRow(row);
                        lblloiNhuan.setText(String.valueOf(chuyentien.format(loinhuan)) + " VNĐ");
                    }
                } catch (Exception e) {
                }

                break;
            case 1:
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy ");
                    Calendar day = Calendar.getInstance();
                    day.add(Calendar.DATE, -1);
                    lblngay.setText(String.valueOf(day.getTime()));
                    coxngay.hide();
                    String sql = " SELECT tenSp, SUM(soLuong),SUM(giaBan*soLuong) FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.maHD = HoaDon.maHD JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp\n"
                            + "												 WHERE ngayHD Between '" + sdf.format(day.getTime()) + "' and GETDATE() AND HoaDon.trangThai=1 GROUP BY tenSp,giaBan ";
                    ResultSet rs = JDBCHelper.executeQuery(sql);
                    DefaultTableModel model = (DefaultTableModel) tblHoatDongBanHang.getModel();
                    model.setRowCount(0);
                    double loinhuan = 0;
                    while (rs.next()) {
                        Object[] row = new Object[]{rs.getString(1), rs.getInt(2), chuyentien.format(rs.getDouble(3)) + " VNĐ"};
                        loinhuan += rs.getDouble(3);
                        model.addRow(row);
                        lblloiNhuan.setText(String.valueOf(chuyentien.format(loinhuan)) + " VNĐ");
                    }
                } catch (Exception e) {
                }
                break;
            case 2:
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy ");
                    Calendar day = Calendar.getInstance();
                    day.add(Calendar.DAY_OF_YEAR, -6);
                    lblngay.setText(String.valueOf(day.getTime()));
                    coxngay.hide();
                    String sql = " SELECT tenSp, SUM(soLuong),SUM(giaBan*soLuong) FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.maHD = HoaDon.maHD JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp\n"
                            + "												 WHERE ngayHD Between '" + sdf.format(day.getTime()) + "' and GETDATE() AND HoaDon.trangThai=1 GROUP BY tenSp,giaBan ";
                    ResultSet rs = JDBCHelper.executeQuery(sql);
                    DefaultTableModel model = (DefaultTableModel) tblHoatDongBanHang.getModel();
                    model.setRowCount(0);
                    double loinhuan = 0;
                    while (rs.next()) {
                        Object[] row = new Object[]{rs.getString(1), rs.getInt(2), chuyentien.format(rs.getDouble(3)) + " VNĐ"};
                        loinhuan += rs.getDouble(3);
                        model.addRow(row);
                        lblloiNhuan.setText(String.valueOf(chuyentien.format(loinhuan)) + " VNĐ");
                    }
                } catch (Exception e) {
                }

                break;
            case 3:
                try {
                    coxngay.show();
                } catch (Exception e) {
                }
                break;
        }

    }

    public void Bieu_Do_Duong_Line() {

        Chart = ChartFactory.createLineChart("BIỂU ĐỒ LINE", "DOANH THU THEO TỪNG THÁNG", "(VNĐ)", barChartLoadata, PlotOrientation.VERTICAL, true, true, true);
        TextTitle charttitle = new TextTitle("BIỂU ĐỒ THỐNG KÊ DOANH THU", new Font("Verdana", Font.ITALIC, 14));
        charttitle.setPaint(Color.blue);
        Chart.setTitle(charttitle);
        CategoryPlot chart = Chart.getCategoryPlot(); // tao bieu do
        chart.setBackgroundPaint(Color.white); // nen bieu trang
        //chart.setRangeGridlinePaint(Color.GREEN); // duong vach
        //chart.setDomainGridlinePaint(Color.GREEN);
        chart.setOutlineStroke(null); // loai bo khung bieu dieu
        //set tickunit Domain
        CategoryAxis axis = chart.getDomainAxis();
        Font font = new Font("Dialog", Font.BOLD, 13);
        axis.setTickLabelFont(font);
        axis.setTickLabelPaint(Color.blue);
        //set tickunit Domain
        axis.setLabelFont(font);
        axis.setLabelPaint(Color.red);
        //set text cho lin
        LineAndShapeRenderer ren = new LineAndShapeRenderer();

        chart = (CategoryPlot) Chart.getPlot();
        ren = (LineAndShapeRenderer) chart.getRenderer();
        ren.setBaseItemLabelsVisible(Boolean.TRUE);
        ren.setBaseItemLabelGenerator((CategoryItemLabelGenerator) new StandardCategoryItemLabelGenerator());
        ren.setBaseItemLabelPaint(Color.blue);
        ren.setBaseItemLabelFont(new Font("Dialog", 1, 9));

        //set tickunit Range Axis     
        NumberAxis range = (NumberAxis) chart.getRangeAxis();
        range.setTickUnit(new NumberTickUnit(1500000));// phạm vi 
        Font font2 = new Font("Dialog", Font.BOLD, 12);
        range.setTickLabelFont(font);
        range.setTickLabelPaint(Color.blue);
        //set label Range Axis 
        Font font3 = new Font("Dialog", Font.ITALIC, 12);
        range.setLabelPaint(Color.blue);
        range.setLabelFont(font3);

        ChartPanel barPanel = new ChartPanel(Chart);
        barPanel.setVisible(true);
        barPanel.setSize(900, 500);
        jpnBieuDoLINE.removeAll();
        jpnBieuDoLINE.add(barPanel);
        jpnBieuDoLINE.updateUI();
    }

    public void LoadData() {
        try {
            int min, max;
            if (Integer.parseInt(cbotunam.getSelectedItem().toString()) <= Integer.parseInt(cbodennam.getSelectedItem().toString())) {
                min = Integer.parseInt(cbotunam.getSelectedItem().toString());
                max = Integer.parseInt(cbodennam.getSelectedItem().toString());

            } else {
                min = Integer.parseInt(cbodennam.getSelectedItem().toString());
                max = Integer.parseInt(cbotunam.getSelectedItem().toString());

            }
            ResultSet re = JDBCHelper.executeQuery("EXEC BieuDoDoanhSo");
            barChartLoadata = new DefaultCategoryDataset();

            while (re.next()) {
                for (int i = min; i <= max; i++) {
                    if (re.getString(2).equals(Integer.toString(i))) {
                        barChartLoadata.addValue(Double.parseDouble(re.getString(3)), "Doanh thu năm " + i, re.getString(1));
                    }
                }

            }
            Bieu_Do_Duong_Line();

        } catch (Exception e) {
        
        }
    }

    public void Loadcombo() {
        try {
            ResultSet re = JDBCHelper.executeQuery("SELECT year(dbo.hoaDon.ngayHD), SUM(giaBan* soluong) AS gia FROM dbo.hoaDon JOIN dbo.CTHoaDon ON CTHoaDon.maHD = hoaDon.maHD JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp\n"
                    + "                                      GROUP BY year(dbo.hoaDon.ngayHD)");

            while (re.next()) {
                cbotunam.addItem(re.getString(1));
                cbodennam.addItem(re.getString(1));

            }
            LoadData();
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

        jfThongKe = new javax.swing.JPanel();
        jpnShowMenuOut = new javax.swing.JPanel();
        jpnQuayVe = new javax.swing.JPanel();
        lblQuayVeBangHang = new javax.swing.JLabel();
        jpnTenDangNhap = new javax.swing.JPanel();
        lblTenDangNhapBangHang = new javax.swing.JLabel();
        jpnDangXuat = new javax.swing.JPanel();
        lblDangXuatBangHang = new javax.swing.JLabel();
        jpnToolbar19 = new javax.swing.JPanel();
        lblAn_BanHang = new javax.swing.JLabel();
        lblOutBangHang = new javax.swing.JLabel();
        jpnNen = new javax.swing.JPanel();
        lblthongkedoangthu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnBieuDoLINE = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoatDongBanHang = new javax.swing.JTable();
        lblngay = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblloiNhuan = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cbodennam = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        cbotunam = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        cboDate = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        coxngay = new javax.swing.JComboBox<>();
        lblanhGiaoDien = new javax.swing.JLabel();
        Card = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jfThongKe.setBackground(new java.awt.Color(255, 255, 255));
        jfThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jfThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnShowMenuOut.setBackground(new java.awt.Color(255, 255, 255));
        jpnShowMenuOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jpnShowMenuOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnShowMenuOutMouseExited(evt);
            }
        });
        jpnShowMenuOut.setLayout(null);

        jpnQuayVe.setBackground(new java.awt.Color(255, 255, 255));

        lblQuayVeBangHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblQuayVeBangHang.setForeground(new java.awt.Color(51, 102, 255));
        lblQuayVeBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuayVeBangHang.setText("Quay Về");
        lblQuayVeBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuayVeBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuayVeBangHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuayVeBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuayVeBangHangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnQuayVeLayout = new javax.swing.GroupLayout(jpnQuayVe);
        jpnQuayVe.setLayout(jpnQuayVeLayout);
        jpnQuayVeLayout.setHorizontalGroup(
            jpnQuayVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVeBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnQuayVeLayout.setVerticalGroup(
            jpnQuayVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVeBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnQuayVe);
        jpnQuayVe.setBounds(10, 90, 150, 40);

        jpnTenDangNhap.setBackground(new java.awt.Color(255, 255, 255));

        lblTenDangNhapBangHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTenDangNhapBangHang.setForeground(new java.awt.Color(51, 102, 255));
        lblTenDangNhapBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenDangNhapBangHang.setText("Tên NV");
        lblTenDangNhapBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTenDangNhapBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTenDangNhapBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTenDangNhapBangHangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnTenDangNhapLayout = new javax.swing.GroupLayout(jpnTenDangNhap);
        jpnTenDangNhap.setLayout(jpnTenDangNhapLayout);
        jpnTenDangNhapLayout.setHorizontalGroup(
            jpnTenDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenDangNhapBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnTenDangNhapLayout.setVerticalGroup(
            jpnTenDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenDangNhapBangHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnTenDangNhap);
        jpnTenDangNhap.setBounds(10, 9, 150, 40);

        jpnDangXuat.setBackground(new java.awt.Color(255, 255, 255));

        lblDangXuatBangHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDangXuatBangHang.setForeground(new java.awt.Color(51, 102, 255));
        lblDangXuatBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangXuatBangHang.setText("Đăng Xuất");
        lblDangXuatBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDangXuatBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatBangHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDangXuatBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDangXuatBangHangMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnDangXuatLayout = new javax.swing.GroupLayout(jpnDangXuat);
        jpnDangXuat.setLayout(jpnDangXuatLayout);
        jpnDangXuatLayout.setHorizontalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuatBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnDangXuatLayout.setVerticalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuatBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnDangXuat);
        jpnDangXuat.setBounds(10, 50, 150, 40);

        jfThongKe.add(jpnShowMenuOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 170, 140));
        jpnShowMenuOut.hide();

        jpnToolbar19.setBackground(new java.awt.Color(255, 255, 255));
        jpnToolbar19.setOpaque(false);

        lblAn_BanHang.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAn_BanHang.setForeground(new java.awt.Color(255, 255, 255));
        lblAn_BanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAn_BanHang.setText("-");
        lblAn_BanHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAn_BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAn_BanHangMouseClicked(evt);
            }
        });

        lblOutBangHang.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblOutBangHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout.png"))); // NOI18N
        lblOutBangHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOutBangHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblOutBangHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblOutBangHangMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jpnToolbar19Layout = new javax.swing.GroupLayout(jpnToolbar19);
        jpnToolbar19.setLayout(jpnToolbar19Layout);
        jpnToolbar19Layout.setHorizontalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnToolbar19Layout.createSequentialGroup()
                .addContainerGap(1006, Short.MAX_VALUE)
                .addComponent(lblAn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOutBangHang)
                .addGap(17, 17, 17))
        );
        jpnToolbar19Layout.setVerticalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblOutBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jfThongKe.add(jpnToolbar19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 50));

        jpnNen.setBackground(new java.awt.Color(255, 255, 255));
        jpnNen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblthongkedoangthu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblthongkedoangthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblthongkedoangthu.setText("THỐNG KÊ DOANG THU");
        jpnNen.add(lblthongkedoangthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 770, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel1.setText("Biểu Đồ");
        jpnNen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 147, 38));

        jpnBieuDoLINE.setBackground(new java.awt.Color(255, 255, 255));
        jpnBieuDoLINE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpnBieuDoLINE.setLayout(new javax.swing.BoxLayout(jpnBieuDoLINE, javax.swing.BoxLayout.LINE_AXIS));
        jpnNen.add(jpnBieuDoLINE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 750, 520));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Hoạt Động Trong Tháng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("Tổng doanh thu bán hàng theo tên sản phẩm");

        jScrollPane1.setBorder(null);

        tblHoatDongBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sản phẩm", "SL", "Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoatDongBanHang.setOpaque(false);
        tblHoatDongBanHang.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHoatDongBanHang);
        if (tblHoatDongBanHang.getColumnModel().getColumnCount() > 0) {
            tblHoatDongBanHang.getColumnModel().getColumn(1).setMinWidth(40);
            tblHoatDongBanHang.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblHoatDongBanHang.getColumnModel().getColumn(1).setMaxWidth(40);
            tblHoatDongBanHang.getColumnModel().getColumn(2).setMinWidth(80);
            tblHoatDongBanHang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblHoatDongBanHang.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        lblngay.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Lợi Nhuận Tạm Tính: ");

        lblloiNhuan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblloiNhuan.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblngay, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblloiNhuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblngay, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblloiNhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jpnNen.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, 520));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        cbodennam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbodennamItemStateChanged(evt);
            }
        });
        cbodennam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbodennamActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Thống kê từ năm:");

        cbotunam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotunamItemStateChanged(evt);
            }
        });
        cbotunam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotunamActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("đến năm");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbotunam, 0, 53, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbodennam, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(cbotunam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(cbodennam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jpnNen.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 320, -1));

        cboDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboDateMousePressed(evt);
            }
        });
        cboDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDateActionPerformed(evt);
            }
        });
        jpnNen.add(cboDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tùy Chọn:");
        jpnNen.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 20));

        coxngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coxngayActionPerformed(evt);
            }
        });
        jpnNen.add(coxngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 50, -1));
        coxngay.hide();

        jfThongKe.add(jpnNen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1080, 630));

        lblanhGiaoDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/nenDao.png"))); // NOI18N
        jfThongKe.add(lblanhGiaoDien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        add(jfThongKe);

        Card.setBackground(new java.awt.Color(255, 255, 255));
        Card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Card.setLayout(new java.awt.CardLayout());
        add(Card);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAn_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAn_BanHangMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblAn_BanHangMouseClicked

    private void lblOutBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseClicked
        // TODO add your handling code here:
        jpnShowMenuOut.show();
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout.png")));
    }//GEN-LAST:event_lblOutBangHangMouseClicked

    private void lblOutBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseEntered
        // TODO add your handling code here:
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout_hover.png")));
    }//GEN-LAST:event_lblOutBangHangMouseEntered

    private void lblOutBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseExited
        // TODO add your handling code here:
        lblOutBangHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/logout.png")));
    }//GEN-LAST:event_lblOutBangHangMouseExited

    private void lblOutBangHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutBangHangMousePressed

    private void lblOutBangHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutBangHangMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblOutBangHangMouseReleased

    private void lblQuayVeBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseClicked
        // TODO add your handling code here:

        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(new FormMenu());
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        /*jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));
        jpnBanHang_Button.setBackground(new Color(0, 0, 0));
        jpnBanHang_Button.setOpaque(false);
        lblBanHang_txt.setForeground(Color.WHITE);*/
        jpnQuayVe.setBackground(Color.white);
        lblQuayVeBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblQuayVeBangHangMouseClicked

    private void lblQuayVeBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseEntered
        // TODO add your handling code here:
        jpnQuayVe.setBackground(new Color(51, 102, 255));
        lblQuayVeBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblQuayVeBangHangMouseEntered

    private void lblQuayVeBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseExited
        // TODO add your handling code here:
        jpnQuayVe.setBackground(Color.white);
        lblQuayVeBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblQuayVeBangHangMouseExited

    private void lblTenDangNhapBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenDangNhapBangHangMouseEntered
        // TODO add your handling code here:
        jpnTenDangNhap.setBackground(new Color(51, 102, 255));
        lblTenDangNhapBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblTenDangNhapBangHangMouseEntered

    private void lblTenDangNhapBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenDangNhapBangHangMouseExited
        // TODO add your handling code here:

        jpnTenDangNhap.setBackground(Color.white);
        lblTenDangNhapBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblTenDangNhapBangHangMouseExited

    private void lblDangXuatBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseClicked
        // TODO add your handling code here:
        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(FormLogin.login.jfLogin);
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        jfMain.hide();
        jfThongKe.hide();
        /* jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);
        jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));*/
        jpnShowMenuOut.hide();
        jpnDangXuat.setBackground(Color.white);
        lblDangXuatBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblDangXuatBangHangMouseClicked

    private void lblDangXuatBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseEntered
        // TODO add your handling code here:

        jpnDangXuat.setBackground(new Color(51, 102, 255));
        lblDangXuatBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblDangXuatBangHangMouseEntered

    private void lblDangXuatBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseExited
        // TODO add your handling code here:

        jpnDangXuat.setBackground(Color.white);
        lblDangXuatBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblDangXuatBangHangMouseExited

    private void jpnShowMenuOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnShowMenuOutMouseExited
        // TODO add your handling code here:
        jpnShowMenuOut.hide();
    }//GEN-LAST:event_jpnShowMenuOutMouseExited

    private void cbodennamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbodennamItemStateChanged
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_cbodennamItemStateChanged

    private void cbodennamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbodennamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbodennamActionPerformed

    private void cbotunamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotunamItemStateChanged
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_cbotunamItemStateChanged

    private void cbotunamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotunamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotunamActionPerformed

    private void cboDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboDateMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboDateMousePressed

    private void cboDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDateActionPerformed
        // TODO add your handling code here:
        ThongkeHomNay();
    }//GEN-LAST:event_cboDateActionPerformed

    private void coxngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coxngayActionPerformed
        // TODO add your handling code here:
     
           try {
              int ngay = coxngay.getSelectedIndex()+1;
 
                Calendar day = Calendar.getInstance();
                    day.add(Calendar.DATE, ngay);
                    lblngay.setText("Ngày " + String.valueOf(ngay) + " trong tháng (  " + String.valueOf(day.getTime()).substring(24) + ")");
                    String sql = " SELECT tenSp, SUM(soLuong),SUM(giaBan*soLuong) FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.maHD = HoaDon.maHD JOIN dbo.SanPham ON SanPham.maSp = CTHoaDon.maSp\n"
                            + "												 WHERE Day(ngayHD)=? AND HoaDon.trangThai=1 GROUP BY tenSp,giaBan ";
                    ResultSet rs = JDBCHelper.executeQuery(sql, ngay);
                    DefaultTableModel model = (DefaultTableModel) tblHoatDongBanHang.getModel();
                    model.setRowCount(0);
                    double loinhuan = 0;
                    while (rs.next()) {
                        Object[] row = new Object[]{rs.getString(1), rs.getInt(2), chuyentien.format(rs.getDouble(3)) + " VNĐ"};
                        loinhuan += rs.getDouble(3);
                        model.addRow(row);
                  
                       
                      
                       
                    }
                      lblloiNhuan.setText(String.valueOf(chuyentien.format(loinhuan)) + " VNĐ");
           } catch (Exception e) {
           }
       
        
        
    }//GEN-LAST:event_coxngayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel Card;
    private javax.swing.JComboBox<String> cboDate;
    private javax.swing.JComboBox<String> cbodennam;
    private javax.swing.JComboBox<String> cbotunam;
    private javax.swing.JComboBox<String> coxngay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    protected static javax.swing.JPanel jfThongKe;
    private javax.swing.JPanel jpnBieuDoLINE;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnNen;
    private javax.swing.JPanel jpnQuayVe;
    private javax.swing.JPanel jpnShowMenuOut;
    private javax.swing.JPanel jpnTenDangNhap;
    private javax.swing.JPanel jpnToolbar19;
    private javax.swing.JLabel lblAn_BanHang;
    private javax.swing.JLabel lblDangXuatBangHang;
    private javax.swing.JLabel lblOutBangHang;
    private javax.swing.JLabel lblQuayVeBangHang;
    private javax.swing.JLabel lblTenDangNhapBangHang;
    private javax.swing.JLabel lblanhGiaoDien;
    private javax.swing.JLabel lblloiNhuan;
    private javax.swing.JLabel lblngay;
    private javax.swing.JLabel lblthongkedoangthu;
    private javax.swing.JTable tblHoatDongBanHang;
    // End of variables declaration//GEN-END:variables
}
