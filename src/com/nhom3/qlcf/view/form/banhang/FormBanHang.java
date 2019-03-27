/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.banhang;

import com.nhom3.qlcf.dao.CTHoaDonDAO;
import com.nhom3.qlcf.dao.HoaDonDAO;
import com.nhom3.qlcf.dao.KhachHangDAO;
import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.helper.Soundhelper;
import com.nhom3.qlcf.helper.Designhelper;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.helper.Timehelper;
import com.nhom3.qlcf.model.CTHoaDon;
import com.nhom3.qlcf.model.HoaDon;
import com.nhom3.qlcf.model.KhachHang;
import com.nhom3.qlcf.model.NguoiDung;
import com.nhom3.qlcf.model.SanPham;

import com.nhom3.qlcf.test.testInsert;
import com.nhom3.qlcf.test.testSQL;
import com.nhom3.qlcf.view.form.login.FormLogin;

import com.nhom3.qlcf.view.Run;
import com.nhom3.qlcf.view.form.menu.FormMenu;
import static com.nhom3.qlcf.view.form.menu.FormMenu.jfMain;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Array;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author baotri1998
 */
public class FormBanHang extends javax.swing.JPanel {

    Soundhelper mp3;
    /**
     * Creates new form FormLogin
     */
    public static FormBanHang banhang;
    public static List<SanPham> list = new ArrayList<>();
    public static List<CTHoaDon> DongCTHD = new ArrayList<>();
    public static List<HoaDon> SavehoaDon = new ArrayList<>();
    public static List<HoaDon> hd = new ArrayList<>();
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    int so;

    public FormBanHang() {
        initComponents();
        // jpnLogin1.setBackground(new Color(0, 0, 0, 134));
        //jpnNenButton_login1.setBackground(new Color(0, 0, 0, 64));
        banhang = this;
        LoadDataSanPham();
        getTongTien();
        CountSoLuongHoaDonTrenWeb();
    }

    public void LoadDataSanPham() {

        try {
            jpnDSsanpham.setLayout(new GridLayout(9, 4, 3, 3));
            testSQL sql = new testSQL();
            int start = 0;
            int end = 9;
            // List Show sp từ dữ liệu SQL

            if (sql.select().size() < 9) {
                end = sql.select().size();
                //jpnDSsanpham.setLayout(new GridLayout(2, 3, 4, 4));
            }
            Designhelper designhelper = new Designhelper();
            designhelper.DesignPage(jpnNext, sql.select());
            list = designhelper.LimitPage(sql.select(), start, end);
            designhelper.DesignSanPham(jpnDSsanpham, testSQL.select());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String AutogetMaHD() {
        HoaDonDAO hdDao = new HoaDonDAO();
        String chuoi = "";
        List<HoaDon> list = hdDao.selectAll();
        if (list.isEmpty()) {
            chuoi = "HD001";
            lblbuton_thanhToan.setToolTipText(chuoi);
            return lblbuton_thanhToan.getToolTipText();
        } else {
            int index = list.size() - 1;
            int so = Integer.parseInt(list.get(index).getMaHoaDon().substring(2)) + 1;
            switch (String.valueOf(so).length()) {
                case 1:
                    chuoi = "HD00" + so;
                    break;
                case 2:
                    chuoi = "HD0" + so;
                    break;
                case 3:
                    chuoi = "HD" + so;
                    break;
            }
            System.out.println("dmio " + chuoi);
            lblbuton_thanhToan.setToolTipText(chuoi);
            return lblbuton_thanhToan.getToolTipText();
        }
    }

    public void getTongTien() {
        double tongtien = 0;
        for (int i = 0; i < DongCTHD.size(); i++) {
            tongtien += (DongCTHD.get(i).getMaHoaDon().getTongTien());
        }
        double ChietKhau;
        if (txtChietKhau.getText().trim().equals("")) {
            ChietKhau = 0;
            lblThanhTien.setText(String.valueOf(chuyentien.format(tongtien * (100 - ChietKhau) / 100)) + " VNĐ");
            lblThanhTien.setName(String.valueOf(tongtien * (100 - ChietKhau) / 100));
            lblThanhTien.setToolTipText(String.valueOf(tongtien * (100 - ChietKhau) / 100));
        } else {
            ChietKhau = Double.parseDouble(txtChietKhau.getText().substring(1));
            lblThanhTien.setText(String.valueOf(chuyentien.format(tongtien * (100 - ChietKhau) / 100)) + " VNĐ");
            lblThanhTien.setName(String.valueOf(tongtien * (100 - ChietKhau) / 100));
            lblThanhTien.setToolTipText(String.valueOf(tongtien * (100 - ChietKhau) / 100));
        }

    }

    public void GetHD() {
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        HoaDon hoadon = new HoaDon();
        KhachHang kh = new KhachHang();
        NguoiDung nd = new NguoiDung();
        hoadon.setMaHoaDon(AutogetMaHD());
        nd.setMaNguoidung("ND001");
        double ChietKhau = Double.parseDouble(txtChietKhau.getText());
        hoadon.setChietKhau(ChietKhau);
        hoadon.setTongTien(Double.parseDouble(lblThanhTien.getToolTipText()));
        System.out.println(lblThanhTien.getToolTipText());
        kh.setMakh(lbltenKH.getName());
        hoadon.setMaKhachHang(kh);
        hoadon.setTrangThai(true);
        hoadon.setMaNguoiDung(nd);
        hoadon.setNgayHD(date);
        hd.add(hoadon);

    }

    public void DongGoiHD() {
        HoaDon hoadon = new HoaDon();
        for (int i = 0; i < hd.size(); i++) {
            hoadon.setMaHoaDon(hd.get(i).getMaHoaDon());
            hoadon.setChietKhau(hd.get(i).getChietKhau());
            hoadon.setMaNguoiDung(hd.get(i).getMaNguoiDung());
            hoadon.setMaKhachHang(hd.get(i).getMaKhachHang());
            hoadon.setTrangThai(hd.get(i).isTrangThai());
            hoadon.setTongTien(hd.get(i).getTongTien());
            hoadon.setNgayHD(hd.get(i).getNgayHD());

        }
        SavehoaDon.add(hoadon);
    }

    public void InsertHD() {
        try {
            HoaDon hd = new HoaDon();
            for (int i = 0; i < SavehoaDon.size(); i++) {
                HoaDonDAO in = new HoaDonDAO();
                hd.setMaHoaDon(SavehoaDon.get(i).getMaHoaDon());
                hd.setMaKhachHang(SavehoaDon.get(i).getMaKhachHang());
                hd.setMaNguoiDung(SavehoaDon.get(i).getMaNguoiDung());
                hd.setChietKhau(SavehoaDon.get(i).getChietKhau());
                hd.setTongTien(SavehoaDon.get(i).getTongTien());
                hd.setTrangThai(SavehoaDon.get(i).isTrangThai());
                hd.setNgayHD(SavehoaDon.get(i).getNgayHD());
                in.insert(hd);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void InsertHDCT() {
        try {

            CTHoaDon cthd = new CTHoaDon();
            for (int i = 0; i < DongCTHD.size(); i++) {
                CTHoaDonDAO insert = new CTHoaDonDAO();
                cthd.setMaHoaDon(DongCTHD.get(i).getMaHoaDon());
                cthd.setMaSanPham(DongCTHD.get(i).getMaSanPham());
                cthd.setSoLuong(DongCTHD.get(i).getSoLuong());
                cthd.setSizeSP(DongCTHD.get(i).getSizeSP());
                cthd.setExtra(DongCTHD.get(i).getExtra());
                insert.insert(cthd);
                System.out.println(DongCTHD.get(i).getMaSanPham().getMaSanPham());

            }
        } catch (Exception e) {
            System.out.println("Not: " + e);
        }
    }

    public void Reset() {
        jpldonhang.removeAll();
        DongCTHD.removeAll(DongCTHD);
        SavehoaDon.removeAll(SavehoaDon);
        lblTamTinh.setText("0 VNĐ");
        lblThanhTien.setText("0 VNĐ");
        lblThanhTien.setToolTipText("0");
        lbltenKH.setText(" x Khách lẻ");
        lbltenKH.setName("KH001");
        txtChietKhau.setText("-0");
    }

    public void CountSoLuongHoaDonTrenWeb() {

        Timehelper time = new Timehelper();
        time.DatLichTimer(lblorderweb, "EXEC dbo.SoLuongDatMuaTrenWeb");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfBangHang = new javax.swing.JPanel();
        jpnShowMenuOut = new javax.swing.JPanel();
        jpnQuayVeBanHang = new javax.swing.JPanel();
        lblQuayVeBangHang = new javax.swing.JLabel();
        jpnTenDangNhapBanHang = new javax.swing.JPanel();
        lblUsers = new javax.swing.JLabel();
        jpnDangXuatBanHang = new javax.swing.JPanel();
        lblDangXuatBangHang = new javax.swing.JLabel();
        jpnToolbar19 = new javax.swing.JPanel();
        lblAn_BanHang = new javax.swing.JLabel();
        lblOutBangHang = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblorderweb = new javax.swing.JLabel();
        lblShoworderweb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jplDonHang = new javax.swing.JPanel();
        jSDonHang = new javax.swing.JScrollPane();
        jpldonhang = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jplHoaDon = new javax.swing.JPanel();
        lbltenKH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTimSDT = new javax.swing.JTextField();
        lblTamTinh = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        lbltimSDT = new javax.swing.JLabel();
        txtChietKhau = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblbuton_thanhToan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblVienTxt = new javax.swing.JLabel();
        jpnNext = new javax.swing.JPanel();
        jSSanPham = new javax.swing.JScrollPane();
        jpnDSsanpham = new javax.swing.JPanel();
        lblThongBao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Card = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jfBangHang.setBackground(new java.awt.Color(255, 255, 255));
        jfBangHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jfBangHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnShowMenuOut.setBackground(new java.awt.Color(255, 255, 255));
        jpnShowMenuOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jpnShowMenuOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnShowMenuOutMouseExited(evt);
            }
        });
        jpnShowMenuOut.setLayout(null);

        jpnQuayVeBanHang.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jpnQuayVeBanHangLayout = new javax.swing.GroupLayout(jpnQuayVeBanHang);
        jpnQuayVeBanHang.setLayout(jpnQuayVeBanHangLayout);
        jpnQuayVeBanHangLayout.setHorizontalGroup(
            jpnQuayVeBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVeBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnQuayVeBanHangLayout.setVerticalGroup(
            jpnQuayVeBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVeBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnQuayVeBanHang);
        jpnQuayVeBanHang.setBounds(10, 90, 150, 40);

        jpnTenDangNhapBanHang.setBackground(new java.awt.Color(255, 255, 255));

        lblUsers.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsers.setForeground(new java.awt.Color(51, 102, 255));
        lblUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsers.setText("Tên NV");
        lblUsers.setToolTipText("ND001");
        lblUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUsersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnTenDangNhapBanHangLayout = new javax.swing.GroupLayout(jpnTenDangNhapBanHang);
        jpnTenDangNhapBanHang.setLayout(jpnTenDangNhapBanHangLayout);
        jpnTenDangNhapBanHangLayout.setHorizontalGroup(
            jpnTenDangNhapBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnTenDangNhapBanHangLayout.setVerticalGroup(
            jpnTenDangNhapBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnTenDangNhapBanHang);
        jpnTenDangNhapBanHang.setBounds(10, 9, 150, 40);

        jpnDangXuatBanHang.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jpnDangXuatBanHangLayout = new javax.swing.GroupLayout(jpnDangXuatBanHang);
        jpnDangXuatBanHang.setLayout(jpnDangXuatBanHangLayout);
        jpnDangXuatBanHangLayout.setHorizontalGroup(
            jpnDangXuatBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuatBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jpnDangXuatBanHangLayout.setVerticalGroup(
            jpnDangXuatBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangXuatBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpnShowMenuOut.add(jpnDangXuatBanHang);
        jpnDangXuatBanHang.setBounds(10, 50, 150, 40);

        jfBangHang.add(jpnShowMenuOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 170, 140));
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

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        jTextField1.setText("Tìm kiếm");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tìm Kiếm");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Nhom San Pham");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 40));

        lblorderweb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblorderweb.setForeground(new java.awt.Color(255, 102, 0));
        lblorderweb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblorderweb.setText("0");
        jPanel9.add(lblorderweb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 20));

        lblShoworderweb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblShoworderweb.setForeground(new java.awt.Color(255, 255, 255));
        lblShoworderweb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblShoworderweb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/cartWeb.png"))); // NOI18N
        lblShoworderweb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblShoworderweb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblShoworderwebMousePressed(evt);
            }
        });
        jPanel9.add(lblShoworderweb, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 50, 40));

        javax.swing.GroupLayout jpnToolbar19Layout = new javax.swing.GroupLayout(jpnToolbar19);
        jpnToolbar19.setLayout(jpnToolbar19Layout);
        jpnToolbar19Layout.setHorizontalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnToolbar19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(lblAn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblOutBangHang)
                .addGap(17, 17, 17))
        );
        jpnToolbar19Layout.setVerticalGroup(
            jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lblOutBangHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnToolbar19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnToolbar19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jfBangHang.add(jpnToolbar19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jplDonHang.setBackground(new java.awt.Color(255, 255, 255));

        jSDonHang.setBackground(Color.decode("#e6e6e6"));
        jSDonHang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jSDonHang.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpldonhang.setBackground(new java.awt.Color(255, 255, 255));
        jpldonhang.setAutoscrolls(true);
        jpldonhang.setMaximumSize(new java.awt.Dimension(32767, 400));

        javax.swing.GroupLayout jpldonhangLayout = new javax.swing.GroupLayout(jpldonhang);
        jpldonhang.setLayout(jpldonhangLayout);
        jpldonhangLayout.setHorizontalGroup(
            jpldonhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        jpldonhangLayout.setVerticalGroup(
            jpldonhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jSDonHang.setViewportView(jpldonhang);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("#Mã/TênSP                                             Giá Niêm Yết                                                   Thành Tiền  /SL            ");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jplDonHangLayout = new javax.swing.GroupLayout(jplDonHang);
        jplDonHang.setLayout(jplDonHangLayout);
        jplDonHangLayout.setHorizontalGroup(
            jplDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jplDonHangLayout.setVerticalGroup(
            jplDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplDonHangLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jplHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        jplHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbltenKH.setBackground(new java.awt.Color(255, 255, 255));
        lbltenKH.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbltenKH.setForeground(new java.awt.Color(0, 51, 204));
        lbltenKH.setText(" x Khách lẻ");
        lbltenKH.setToolTipText("KH001");
        lbltenKH.setOpaque(true);
        jplHoaDon.add(lbltenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 174, -1));
        lbltenKH.setName("KH001");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tạm Tính:");
        jLabel5.setToolTipText("1");
        jplHoaDon.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 116, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Chiết Khấu:");
        jplHoaDon.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 98, -1, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Tổng Thành Tiền: ");
        jplHoaDon.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 133, 116, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("Ngày tạo:");
        jplHoaDon.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 42, 131, -1));

        txtTimSDT.setText("Tìm SĐT KH");
        txtTimSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimSDTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimSDTFocusLost(evt);
            }
        });
        txtTimSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTimSDTMouseEntered(evt);
            }
        });
        jplHoaDon.add(txtTimSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 215, 31));

        lblTamTinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTamTinh.setText("....");
        jplHoaDon.add(lblTamTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 190, 30));

        lblThanhTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThanhTien.setText("0 VNĐ");
        jplHoaDon.add(lblThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 129, 143, 23));

        lbltimSDT.setBackground(new java.awt.Color(0, 51, 255));
        lbltimSDT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltimSDT.setForeground(new java.awt.Color(255, 255, 255));
        lbltimSDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltimSDT.setText("Tìm Kiếm");
        lbltimSDT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbltimSDT.setOpaque(true);
        lbltimSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbltimSDTMousePressed(evt);
            }
        });
        jplHoaDon.add(lbltimSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 0, 72, 31));

        txtChietKhau.setEditable(false);
        txtChietKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtChietKhau.setText("-0");
        txtChietKhau.setOpaque(false);
        txtChietKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChietKhauActionPerformed(evt);
            }
        });
        jplHoaDon.add(txtChietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 50, 20));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("%");
        jplHoaDon.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 20, 20));

        jLabel13.setBackground(new java.awt.Color(0, 102, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("-");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        jplHoaDon.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 30, 20));

        jLabel15.setBackground(new java.awt.Color(0, 51, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("+");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jplHoaDon.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 30, 20));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Tiền Khách Trả:");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, -1, 34));

        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel7.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 15, 155, 34));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 0, 255));
        jLabel10.setText("Tiềm Thừa:");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 93, 27));

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        lblbuton_thanhToan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblbuton_thanhToan.setForeground(new java.awt.Color(255, 255, 255));
        lblbuton_thanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbuton_thanhToan.setText("THANH TOÁN");
        lblbuton_thanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblbuton_thanhToanMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbuton_thanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbuton_thanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, 244, 51));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("0");
        jLabel12.setOpaque(true);
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 55, 155, 27));

        lblVienTxt.setForeground(new java.awt.Color(0, 102, 255));
        lblVienTxt.setText("_________________________");
        jPanel7.add(lblVienTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 24, 150, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jplHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnNext.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnNextLayout = new javax.swing.GroupLayout(jpnNext);
        jpnNext.setLayout(jpnNextLayout);
        jpnNextLayout.setHorizontalGroup(
            jpnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnNextLayout.setVerticalGroup(
            jpnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jSSanPham.setBackground(Color.decode("#e6e6e6"));
        jSSanPham.setBorder(null);
        jSSanPham.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jpnDSsanpham.setBackground(new java.awt.Color(255, 255, 255));
        jpnDSsanpham.setAutoscrolls(true);
        jpnDSsanpham.setMaximumSize(new java.awt.Dimension(32767, 400));
        jpnDSsanpham.setLayout(new javax.swing.BoxLayout(jpnDSsanpham, javax.swing.BoxLayout.LINE_AXIS));
        jSSanPham.setViewportView(jpnDSsanpham);

        lblThongBao.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 0, 51));
        lblThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jplDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addComponent(jpnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jplDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jfBangHang.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1080, 630));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/nenThuNgan.png"))); // NOI18N
        jfBangHang.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        add(jfBangHang);

        Card.setBackground(new java.awt.Color(255, 255, 255));
        Card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Card.setLayout(new java.awt.CardLayout());
        add(Card);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAn_BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAn_BanHangMouseClicked
        // TODO add your handling code here:
        Run.main.setState(JFrame.ICONIFIED);
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
        if (DongCTHD.isEmpty()) {
            FormLogin.login.Card.removeAll();
            FormLogin.login.Card.add(new FormMenu());
            FormLogin.login.Card.repaint();
            FormLogin.login.Card.revalidate();
            FormLogin.login.Card.show();
        } else {

            lblThongBao.setText("Hãy Thanh Toán Hóa Đơn Trước Khi Rời Khỏi");
            jpnShowMenuOut.hide();
        }


        /*jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));
        jpnBanHang_Button.setBackground(new Color(0, 0, 0));
        jpnBanHang_Button.setOpaque(false);
        lblBanHang_txt.setForeground(Color.WHITE);*/
        jpnQuayVeBanHang.setBackground(Color.white);
        lblQuayVeBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblQuayVeBangHangMouseClicked

    private void lblQuayVeBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseEntered
        // TODO add your handling code here:
        jpnQuayVeBanHang.setBackground(new Color(51, 102, 255));
        lblQuayVeBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblQuayVeBangHangMouseEntered

    private void lblQuayVeBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuayVeBangHangMouseExited
        // TODO add your handling code here:
        jpnQuayVeBanHang.setBackground(Color.white);
        lblQuayVeBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblQuayVeBangHangMouseExited

    private void lblUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsersMouseEntered
        // TODO add your handling code here:
        jpnTenDangNhapBanHang.setBackground(new Color(51, 102, 255));
        lblUsers.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblUsersMouseEntered

    private void lblUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsersMouseExited
        // TODO add your handling code here:

        jpnTenDangNhapBanHang.setBackground(Color.white);
        lblUsers.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblUsersMouseExited

    private void lblDangXuatBangHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseClicked
        // TODO add your handling code here:
        FormLogin.login.Card.removeAll();
        FormLogin.login.Card.add(FormLogin.login.jfLogin);
        FormLogin.login.Card.repaint();
        FormLogin.login.Card.revalidate();
        FormLogin.login.Card.show();
        jfMain.hide();
        jfBangHang.hide();
        /* jpnNenButton_login.setBackground(new Color(0, 0, 0));
        jpnNenButton_login.setOpaque(false);
        lblLogin.setForeground(Color.white);
        jpnDangXuat.setBackground(Color.white);
        lblDangXuat.setForeground(new Color(51, 102, 255));*/
        jpnShowMenuOut.hide();
        jpnDangXuatBanHang.setBackground(Color.white);
        lblDangXuatBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblDangXuatBangHangMouseClicked

    private void lblDangXuatBangHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseEntered
        // TODO add your handling code here:

        jpnDangXuatBanHang.setBackground(new Color(51, 102, 255));
        lblDangXuatBangHang.setForeground(Color.white);
        jpnShowMenuOut.show();
    }//GEN-LAST:event_lblDangXuatBangHangMouseEntered

    private void lblDangXuatBangHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatBangHangMouseExited
        // TODO add your handling code here:

        jpnDangXuatBanHang.setBackground(Color.white);
        lblDangXuatBangHang.setForeground(new Color(51, 102, 255));
    }//GEN-LAST:event_lblDangXuatBangHangMouseExited

    private void jpnShowMenuOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnShowMenuOutMouseExited
        // TODO add your handling code here:
        jpnShowMenuOut.hide();
    }//GEN-LAST:event_jpnShowMenuOutMouseExited

    private void lblbuton_thanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblbuton_thanhToanMousePressed
        // TODO add your handling code here:
        GetHD();
        DongGoiHD();
        InsertHD();
        InsertHDCT();
        Reset();
        Designhelper designhelper = new Designhelper();
        designhelper.DesigDonHang(jpldonhang, DongCTHD);
    }//GEN-LAST:event_lblbuton_thanhToanMousePressed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void txtChietKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChietKhauActionPerformed
        // TODO add your handling code here:
        GetHD();
        DongGoiHD();
        getTongTien();
    }//GEN-LAST:event_txtChietKhauActionPerformed
    KhachHang nd = null;
    private void lbltimSDTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltimSDTMousePressed
        // TODO add your handling code here:
        KhachHangDAO khDao = new KhachHangDAO();
        nd = khDao.selectID(txtTimSDT.getText());
        lbltenKH.setText(nd.getTenKh());
        lbltenKH.setName(nd.getMakh());
    }//GEN-LAST:event_lbltimSDTMousePressed

    private void txtTimSDTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimSDTMouseEntered
        // TODO add your handling code here:


    }//GEN-LAST:event_txtTimSDTMouseEntered

    private void txtTimSDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimSDTFocusGained
        // TODO add your handling code here:
        if (txtTimSDT.getText().equals("Tìm SĐT KH")) {
            txtTimSDT.setText("");
        }
    }//GEN-LAST:event_txtTimSDTFocusGained

    private void txtTimSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimSDTFocusLost
        // TODO add your handling code here:
        if (txtTimSDT.getText().equals("")) {
            txtTimSDT.setText("Tìm SĐT KH");

        }

    }//GEN-LAST:event_txtTimSDTFocusLost

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        so = Integer.parseInt(txtChietKhau.getText().substring(1));
        if (so < 100) {
            so++;
            txtChietKhau.setText("-" + String.valueOf((so + 5) - 1));
            getTongTien();

        }

    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:

        so = Integer.parseInt(txtChietKhau.getText().substring(1));
        if (so != 0 && so != 1) {
            so--;
            txtChietKhau.setText("-" + String.valueOf(so - 4));
            getTongTien();

        }
    }//GEN-LAST:event_jLabel13MousePressed

    private void lblShoworderwebMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShoworderwebMousePressed
        // TODO add your handling code here:

        CapNhatHoaDon hd = new CapNhatHoaDon(null, true);
        hd.setVisible(true);
    }//GEN-LAST:event_lblShoworderwebMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel Card;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jSDonHang;
    private javax.swing.JScrollPane jSSanPham;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    protected static javax.swing.JPanel jfBangHang;
    private javax.swing.JPanel jplDonHang;
    private javax.swing.JPanel jplHoaDon;
    protected static javax.swing.JPanel jpldonhang;
    private javax.swing.JPanel jpnDSsanpham;
    private javax.swing.JPanel jpnDangXuatBanHang;
    private javax.swing.JPanel jpnNext;
    private javax.swing.JPanel jpnQuayVeBanHang;
    private javax.swing.JPanel jpnShowMenuOut;
    private javax.swing.JPanel jpnTenDangNhapBanHang;
    private javax.swing.JPanel jpnToolbar19;
    private javax.swing.JLabel lblAn_BanHang;
    private javax.swing.JLabel lblDangXuatBangHang;
    private javax.swing.JLabel lblOutBangHang;
    private javax.swing.JLabel lblQuayVeBangHang;
    private javax.swing.JLabel lblShoworderweb;
    protected static javax.swing.JLabel lblTamTinh;
    protected static javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblUsers;
    private javax.swing.JLabel lblVienTxt;
    protected static javax.swing.JLabel lblbuton_thanhToan;
    private javax.swing.JLabel lblorderweb;
    private javax.swing.JLabel lbltenKH;
    private javax.swing.JLabel lbltimSDT;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtTimSDT;
    // End of variables declaration//GEN-END:variables
}

//Code//

