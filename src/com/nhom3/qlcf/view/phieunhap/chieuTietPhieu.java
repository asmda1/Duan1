/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.phieunhap;

import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.model.CTPhieuNhap;
import com.nhom3.qlcf.model.HangHoa;
import com.nhom3.qlcf.model.NguoiDung;
import com.nhom3.qlcf.model.NhaCungCap;
import com.nhom3.qlcf.model.PhieuNhap;
import com.nhom3.qlcf.view.Run;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author baotri1998
 */
public class chieuTietPhieu extends javax.swing.JDialog {

    public List<CTPhieuNhap> addCTList = null;
    String maphieu;

    /**
     * Creates new form chieuTietPhieu
     */
    public chieuTietPhieu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Show();
    }
    DefaultTableModel model = null;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");

    public chieuTietPhieu(java.awt.Frame parent, boolean modal, String maPhieu) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.maphieu = maPhieu;
        Show();
    }

    public void Addlist() {
        ResultSet rs = null;
        if (maphieu != null) {
            rs = JDBCHelper.executeQuery("EXEC proCTPhieuNhap @maphieu ='" + maphieu + "'");
        } else {
            rs = JDBCHelper.executeQuery("EXEC proshowCTPhieuNhap ");
        }
        try {
            addCTList = new ArrayList<>();
            while (rs.next()) {
                PhieuNhap phieu = new PhieuNhap();
                CTPhieuNhap ctp = new CTPhieuNhap();
                NguoiDung nd = new NguoiDung();
                HangHoa hh = new HangHoa();
                NhaCungCap ncc = new NhaCungCap();
                phieu.setMaPhieu(rs.getString(1));
                hh.setMaHangHoa(rs.getString(2));
                hh.setTenHangHoa(rs.getString(3));
                hh.setGiaVon(rs.getDouble(4));
                ncc.setTenNhaCC(rs.getString(5));
                ncc.setDiaChi(rs.getString(6));
                ctp.setSoLuong(rs.getInt(7));
                phieu.setNgayNhap(rs.getDate(9));
                phieu.setTongTien(rs.getDouble(8));
                nd.setMaNguoidung(rs.getString(10));
                phieu.setMaNguoiDung(nd);
                phieu.setMaNhaCungCap(ncc);
                ctp.setMaPhieuNhap(phieu);
                ctp.setMaHangHoa(hh);
                addCTList.add(ctp);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Show() {
        try {
            Addlist();
            model = (DefaultTableModel) tblquanlyphieu.getModel();
            model.setRowCount(0);
            try {
                addCTList.stream().map((kh) -> new Object[]{
                    kh.getMaPhieuNhap().getMaPhieu(), kh.getMaHangHoa().getMaHangHoa(),
                    kh.getMaHangHoa().getTenHangHoa(), String.valueOf(chuyentien.format(kh.getMaHangHoa().getGiaVon()) + " VND "),
                    kh.getMaPhieuNhap().getMaNhaCungCap().getTenNhaCC(), kh.getMaPhieuNhap().getMaNhaCungCap().getDiaChi(),
                    kh.getSoLuong(), kh.getMaPhieuNhap().getNgayNhap(), kh.getMaPhieuNhap().getMaNguoiDung().getMaNguoidung()
                }).forEachOrdered((row) -> {
                    model.addRow(row);
                });
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
        }
    }

    public HSSFCellStyle creat(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);
        HSSFCellStyle style = book.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);
        return style;
    }

    public void Excec() throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Phieu Nhap");
        //set độ rộng
        sheet.setColumnWidth(0, 10300); //hàng A
        sheet.setColumnWidth(1, 5500); //hàng B
        sheet.setColumnWidth(2, 7500); //hàng C
        if (maphieu == null) {
            sheet.setColumnWidth(3, 7500); //hàng D
        } else {
            sheet.setColumnWidth(3, 5500); //hàng D
        }

        sheet.setColumnWidth(4, 7500); //hàng E
        sheet.setColumnWidth(5, 7500); //hàng F
        sheet.setColumnWidth(6, 3500); //hàng G
        sheet.setColumnWidth(7, 7500); //hàng H
        sheet.setColumnWidth(8, 7500); //hàngI
        sheet.setColumnWidth(9, 7500); //hàng j
        int rowcount = 0; //hang 1
        Cell cell, cellMP, cellInHD, cellTile, cellcongty, cellngay;
        Row row;
        HSSFCellStyle style = creat(workbook);

//ten quán
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 15);
        HSSFCellStyle styleTile = workbook.createCellStyle();
        styleTile.setAlignment(HorizontalAlignment.CENTER);
        styleTile.setFont(font);
        row = sheet.createRow(rowcount);
        cellTile = row.createCell(0, CellType.STRING);// 0 = cột A
        cellTile.setCellValue("TNP COFFE");
        cellTile.setCellStyle(styleTile);

        //Ten congty
        rowcount = 1; //hang2
        Row rowcongty = sheet.createRow(rowcount++);
        cellcongty = rowcongty.createCell(5, CellType.STRING);
        cellcongty.setCellValue("CÔNG TY TRÁCH NHIỆM HỮU HẠN MỘT THÀNH VIÊN");
        HSSFFont fontcongty = workbook.createFont();
        fontcongty.setBold(true);
        fontcongty.setFontHeightInPoints((short) 13);
        HSSFCellStyle stylecongty = workbook.createCellStyle();
        stylecongty.setAlignment(HorizontalAlignment.CENTER);
        stylecongty.setFont(fontcongty);
        cellcongty.setCellStyle(stylecongty);
        //diachi
        rowcount = 2; //hang2
        Row rowdiachi = sheet.createRow(rowcount++);
        cellcongty = rowdiachi.createCell(5, CellType.STRING);
        cellcongty.setCellValue("23 Nguyễn Huệ, Bến Nghé, Quận 1, TP HCM");
        HSSFFont fontdiachi = workbook.createFont();
        fontdiachi.setBold(true);
        fontdiachi.setItalic(true);
        fontdiachi.setFontHeightInPoints((short) 12);
        HSSFCellStyle styleDiachi = workbook.createCellStyle();
        styleDiachi.setAlignment(HorizontalAlignment.CENTER);
        styleDiachi.setFont(fontdiachi);
        cellcongty.setCellStyle(styleDiachi);

        HSSFFont font2 = workbook.createFont();
        font2.setItalic(true);
        font2.setFontHeightInPoints((short) 10);
        HSSFCellStyle styleHD = workbook.createCellStyle();
        styleHD.setAlignment(HorizontalAlignment.LEFT);
        styleHD.setFont(font2);
        //ngày
        rowcount = 5; //hàng 4
        row = sheet.createRow(rowcount);
        java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());
        cellngay = row.createCell(7, CellType.STRING); //cột D
        cellngay.setCellValue("Ngày Tạo: " + date);
        cellngay.setCellStyle(styleHD);

        //In Hoa Don
        cellInHD = row.createCell(5, CellType.STRING); //4= cột D
        cellInHD.setCellValue("PHIẾU NHẬP HÀNG ");
        HSSFFont fontIN = workbook.createFont();
        fontIN.setBold(true);
        fontIN.setFontHeightInPoints((short) 14);
        HSSFCellStyle stylein = workbook.createCellStyle();
        stylein.setAlignment(HorizontalAlignment.CENTER);
        stylein.setFont(fontIN);
        cellInHD.setCellStyle(stylein);
        //mã Phiếu
        rowcount = 6; //hàng 5
        row = sheet.createRow(rowcount);
        cellMP = row.createCell(1, CellType.STRING);
        rowcount = 7;
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        if (maphieu == null) {
            cellMP.setCellValue("Mã Phiếu: Tất cả Phiếu ");
            row = sheet.createRow(rowcount);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã Phiếu");
            cell.setCellStyle(style);
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã Hàng");
            cell.setCellStyle(style);

//
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên Hàng");
            cell.setCellStyle(style);
            //
            cell = (Cell) row.createCell(4, CellType.STRING);
            cell.setCellValue("Đơn Giá.");
            cell.setCellStyle(style);
//
            cell = (Cell) row.createCell(5, CellType.STRING);
            cell.setCellValue("Tên Công Ty.");
            cell.setCellStyle(style);
//
            cell = (Cell) row.createCell(6, CellType.STRING);
            cell.setCellValue("Địa Chỉ");
            cell.setCellStyle(style);
            cell = (Cell) row.createCell(7, CellType.STRING);
            cell.setCellValue("Số Lượng");
            cell.setCellStyle(style);
            cell = (Cell) row.createCell(8, CellType.STRING);
            cell.setCellValue("Ngày Nhập");
            cell.setCellStyle(style);
        } else {
            cellMP.setCellValue("Mã Phiếu:" + maphieu);
            row = sheet.createRow(rowcount);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã Hàng");
            cell.setCellStyle(style);

//
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên Hàng");
            cell.setCellStyle(style);
            //
            cell = (Cell) row.createCell(3, CellType.STRING);
            cell.setCellValue("Đơn Giá.");
            cell.setCellStyle(style);
//
            cell = (Cell) row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên Công Ty.");
            cell.setCellStyle(style);
//
            cell = (Cell) row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa Chỉ");
            cell.setCellStyle(style);
            cell = (Cell) row.createCell(6, CellType.STRING);
            cell.setCellValue("Số Lượng");
            cell.setCellStyle(style);
            cell = (Cell) row.createCell(7, CellType.STRING);
            cell.setCellValue("Ngày Nhập");
            cell.setCellStyle(style);
        }

        cellMP.setCellStyle(styleHD);
        //setBorder table

        //table
        rowcount = 8;
        double tongthanhtien = 0;
        //data
        for (CTPhieuNhap ctpn : addCTList) {
            if (maphieu == null) {
                row = sheet.createRow(rowcount++);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ctpn.getMaPhieuNhap().getMaPhieu());
                cell.setCellStyle(style);
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ctpn.getMaHangHoa().getMaHangHoa());
                cell.setCellStyle(style);
                //
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(ctpn.getMaHangHoa().getTenHangHoa());
                cell.setCellStyle(style);
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(String.valueOf(chuyentien.format(ctpn.getMaHangHoa().getGiaVon()) + " VND "));
                cell.setCellStyle(style);
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(ctpn.getMaPhieuNhap().getMaNhaCungCap().getTenNhaCC());
                cell.setCellStyle(style);
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(ctpn.getMaPhieuNhap().getMaNhaCungCap().getDiaChi());
                cell.setCellStyle(style);

                // 
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(ctpn.getSoLuong());
                cell.setCellStyle(style);
                //

                //
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(String.valueOf(ctpn.getMaPhieuNhap().getNgayNhap()));
                cell.setCellStyle(style);
                ////////////////

            } else {
                row = sheet.createRow(rowcount++);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ctpn.getMaHangHoa().getMaHangHoa());
                cell.setCellStyle(style);
                //
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ctpn.getMaHangHoa().getTenHangHoa());
                cell.setCellStyle(style);
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(String.valueOf(chuyentien.format(ctpn.getMaHangHoa().getGiaVon()) + " VND "));
                cell.setCellStyle(style);
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(ctpn.getMaPhieuNhap().getMaNhaCungCap().getTenNhaCC());
                cell.setCellStyle(style);
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(ctpn.getMaPhieuNhap().getMaNhaCungCap().getDiaChi());
                cell.setCellStyle(style);

                // 
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(ctpn.getSoLuong());
                cell.setCellStyle(style);
                //

                //
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(String.valueOf(ctpn.getMaPhieuNhap().getNgayNhap()));
                cell.setCellStyle(style);
            }

        }//Thành tiền
        Cell tennv;
        Row row1, row2, row3;
        //tạo font , style thành tiền
        HSSFFont fontThanhTien = workbook.createFont();
        fontThanhTien.setBold(true);
        fontThanhTien.setFontHeightInPoints((short) 10);
        HSSFCellStyle styleThanhTien = workbook.createCellStyle();
        styleThanhTien.setAlignment(HorizontalAlignment.CENTER);
        styleThanhTien.setFont(fontThanhTien);
        //tong tien

        row3 = sheet.createRow((rowcount++) + 1);
        tennv = row3.createCell(6);
        tennv.setCellValue("Tổng Tiền: ");
        tennv.setCellStyle(styleThanhTien);
       for(PhieuNhap phieuNhap: new FormQuanLyPhieuNhap().listPhieu) {
           tongthanhtien+= phieuNhap.getTongTien();
       };
        Cell tongtien = row3.createCell(7);
        if (maphieu == null) {

            tongtien.setCellValue(chuyentien.format(tongthanhtien) + " VNĐ");
            tongtien.setCellStyle(styleThanhTien);
        } else {
            tongtien.setCellValue(chuyentien.format(addCTList.get(0).getMaPhieuNhap().getTongTien()) + " VNĐ");
            tongtien.setCellStyle(styleThanhTien);
        }

        //tên Nhan Viên
        row1 = sheet.createRow((rowcount++) + 3);
        tennv = row1.createCell(2);
        tennv.setCellValue("Tên Nhân Viên: ");
        tennv.setCellStyle(styleThanhTien);
        //ký tên
        row2 = sheet.createRow(rowcount++ + 5);
        tennv = row2.createCell(2);
        tennv.setCellValue(" ................... ");
        tennv.setCellStyle(styleThanhTien);

        Cell TenNhaSX = row1.createCell(7);
        TenNhaSX.setCellValue("Tên Đối Tác");
        TenNhaSX.setCellStyle(styleThanhTien);
        //tiền khách

        Cell tienkhach = row2.createCell(7);
        tienkhach.setCellValue("____________________");
        tienkhach.setCellStyle(styleThanhTien);

        //write
        File file = new File(Run.folderPAth + "\\" + "PhieuNhap.xls");
        file.getParentFile().mkdirs();
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        //mở file
        if (Desktop.isDesktopSupported()) {
            File pdf = new File(Run.folderPAth + "\\" + "PhieuNhap.xls");
            try {
                Desktop.getDesktop().open(pdf);
            } catch (Exception e) {
            }

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
        tblquanlyphieu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblquanlyphieu.setForeground(new java.awt.Color(51, 51, 51));
        tblquanlyphieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu", "Mã HH", "Tên Hàng", "Đơn Giá", "Tên Công Ty", "Địa Chỉ", "SL", "Ngày Nhập", "Mã NV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblquanlyphieu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblquanlyphieu.setFocusable(false);
        tblquanlyphieu.setGridColor(new java.awt.Color(0, 0, 0));
        tblquanlyphieu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblquanlyphieu.setRowHeight(25);
        tblquanlyphieu.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblquanlyphieu.setShowHorizontalLines(false);
        tblquanlyphieu.setShowVerticalLines(false);
        tblquanlyphieu.setSurrendersFocusOnKeystroke(true);
        tblquanlyphieu.getTableHeader().setReorderingAllowed(false);
        tblquanlyphieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblquanlyphieuMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblquanlyphieu);
        if (tblquanlyphieu.getColumnModel().getColumnCount() > 0) {
            tblquanlyphieu.getColumnModel().getColumn(0).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblquanlyphieu.getColumnModel().getColumn(1).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblquanlyphieu.getColumnModel().getColumn(2).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblquanlyphieu.getColumnModel().getColumn(3).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(3).setPreferredWidth(60);
            tblquanlyphieu.getColumnModel().getColumn(4).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblquanlyphieu.getColumnModel().getColumn(5).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblquanlyphieu.getColumnModel().getColumn(6).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(6).setPreferredWidth(35);
            tblquanlyphieu.getColumnModel().getColumn(7).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(7).setPreferredWidth(65);
            tblquanlyphieu.getColumnModel().getColumn(8).setResizable(false);
            tblquanlyphieu.getColumnModel().getColumn(8).setPreferredWidth(40);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/excel.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Print:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

    private void tblquanlyphieuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblquanlyphieuMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tblquanlyphieuMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        try {
            // TODO add your handling code here:
            Excec();
        } catch (IOException ex) {
            Logger.getLogger(chieuTietPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MousePressed

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
            java.util.logging.Logger.getLogger(chieuTietPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chieuTietPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chieuTietPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chieuTietPhieu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                chieuTietPhieu dialog = new chieuTietPhieu(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblquanlyphieu;
    // End of variables declaration//GEN-END:variables
}
