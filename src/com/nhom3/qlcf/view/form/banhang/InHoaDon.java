/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.banhang;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nhom3.qlcf.dao.CTHoaDonDAO;
import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.model.CTHoaDon;
import com.nhom3.qlcf.model.Extra;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.model.SizeSP;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFontFormatting;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author baotri1998
 */
public class InHoaDon extends javax.swing.JDialog {

    String hdString;
    List<CTHoaDon> listCTHD = null;
    DefaultTableModel model;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    java.sql.Timestamp date = new java.sql.Timestamp(System.currentTimeMillis());

    /**
     * Creates new form InHoaDon
     */
    public InHoaDon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fillChiTietSP("HD002");
    }

    public InHoaDon(java.awt.Frame parent, boolean modal, String hd, String thanhTien, String tenkh, String sdt, String tienkhach, String tienthoi, String chietkhau) {
        super(parent, modal);
        initComponents();
        this.hdString = hd;
        setLocationRelativeTo(parent);
        tblInHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblInHoaDon.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tblInHoaDon.getTableHeader().setOpaque(false);
        tblInHoaDon.getTableHeader().setBackground(new Color(0, 0, 0));
        tblInHoaDon.getTableHeader().setForeground(new Color(255, 255, 255));
        tblInHoaDon.setRowHeight(25);
        fillChiTietSP(hdString);
        double tien = Double.parseDouble(thanhTien);
        lblthanhtienhd.setText(String.valueOf(chuyentien.format(tien)) + " VND");
        lblmahd.setText(hdString);
        lblten.setText(tenkh);
        lblngay.setText(String.valueOf(date));
        lblchietkhau.setText(chietkhau);
        if (sdt == "true") {
            lblsdt.setText("");
        } else {
            lblsdt.setText(sdt);
        }
        if (!tienkhach.matches("[0-9]+")) {
            tienkhach = "0";
        }
        double tienkhach1 = Double.parseDouble(tienkhach);

        if (tienkhach == null || tienthoi == null || tienkhach1 == 0) {
            lbltienkhach.setText("0");
            lblTienthoi.setText("0");
        } else {

            lbltienkhach.setText(String.valueOf(chuyentien.format(tienkhach1)) + " VND");
            lblTienthoi.setText(tienthoi);
        }

    }

    public InHoaDon(java.awt.Frame parent, boolean modal, String hd, String thanhTien, String tenkh, String sdt) {
        super(parent, modal);
        initComponents();
        this.hdString = hd;
        setLocationRelativeTo(parent);
        tblInHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblInHoaDon.setFont(new Font("Tohoma", Font.PLAIN, 12));
        tblInHoaDon.getTableHeader().setOpaque(false);
        tblInHoaDon.getTableHeader().setBackground(new Color(0, 0, 0));
        tblInHoaDon.getTableHeader().setForeground(new Color(255, 255, 255));
        tblInHoaDon.setRowHeight(25);
        fillChiTietSP(hdString);
        double tien = Double.parseDouble(thanhTien);
        lblthanhtienhd.setText(String.valueOf(chuyentien.format(tien)) + " VND");
        lblmahd.setText(hdString);
        lblten.setText(tenkh);
        lblngay.setText(String.valueOf(date));
        if (sdt == "true") {
            lblsdt.setText("");
        } else {
            lblsdt.setText(sdt);
        }

    }

    public void fillChiTietSP(String hd) {
        ResultSet rs = JDBCHelper.executeQuery("EXEC dbo.ChitietKHdatSP @maHD ='" + hd + "'");
        model = (DefaultTableModel) tblInHoaDon.getModel();
        listCTHD = new ArrayList<>();

        try {
            model.setRowCount(0);
            while (rs.next()) {
                SanPham sp = new SanPham();
                SizeSP sz = new SizeSP();
                CTHoaDon cthd = new CTHoaDon();
                Extra ex = new Extra();
                sp.setTenSp(rs.getString(1));
                sp.setGiaBan(rs.getDouble(2));
                sz.setMaSize(rs.getString(3));
                cthd.setSoLuong(rs.getInt(4));
                sp.setHinhAnh(rs.getString(5));
                ex.setTen(rs.getString(6));
                cthd.setSizeSP(sz);
                cthd.setMaSanPham(sp);
                cthd.setExtra(ex);
                listCTHD.add(cthd);
                Object[] row = new Object[]{rs.getString(1), chuyentien.format(rs.getDouble(2)) + " VND", rs.getString(3), rs.getInt(4), rs.getString(6)};
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //tao kieu font cho exec
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
        HSSFSheet sheet = workbook.createSheet("Hoa Don");
        //set độ rộng
        sheet.setColumnWidth(0, 10300); //hàng A
        sheet.setColumnWidth(1, 6500); //hàng B
        sheet.setColumnWidth(2, 5500); //hàng C
        sheet.setColumnWidth(3, 5500); //hàng D
        sheet.setColumnWidth(4, 5500); //hàng E
        sheet.setColumnWidth(5, 5500); //hàng F
        int rowcount = 0; //hang 1
        Cell cell, cellHD, cellSDT, celltenKH, cellTile, cellcongty, cellngay;
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
        cellcongty = rowcongty.createCell(3, CellType.STRING);
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
        cellcongty = rowdiachi.createCell(3, CellType.STRING);
        cellcongty.setCellValue("23 Nguyễn Huệ, Bến Nghé, Quận 1, TP HCM");
        HSSFFont fontdiachi = workbook.createFont();
        fontdiachi.setBold(true);
        fontdiachi.setItalic(true);
        fontdiachi.setFontHeightInPoints((short) 12);
        HSSFCellStyle styleDiachi = workbook.createCellStyle();
        styleDiachi.setAlignment(HorizontalAlignment.CENTER);
        styleDiachi.setFont(fontdiachi);
        cellcongty.setCellStyle(styleDiachi);

        // mã Hóa Đơn:
        HSSFFont font2 = workbook.createFont();
        font2.setItalic(true);
        font2.setFontHeightInPoints((short) 10);
        HSSFCellStyle styleHD = workbook.createCellStyle();
        styleHD.setAlignment(HorizontalAlignment.LEFT);
        styleHD.setFont(font2);
        rowcount = 4; //hàng 3
        row = sheet.createRow(rowcount);
        cellHD = row.createCell(1, CellType.STRING);
        cellHD.setCellValue("Mã Hóa Đơn: " + lblmahd.getText());
        cellHD.setCellStyle(styleHD);
        //ngày
        cellngay = row.createCell(4, CellType.STRING); //cột D
        cellngay.setCellValue("Ngày Tạo: " + lblngay.getText());
        cellngay.setCellStyle(styleHD);

        //tên khách
        rowcount = 5; //hàng 4
        row = sheet.createRow(rowcount);
        celltenKH = row.createCell(1, CellType.STRING); //cột D
        celltenKH.setCellValue("Tên Khách : " + lblten.getText());
        celltenKH.setCellStyle(styleHD);

        //ngày
        celltenKH = row.createCell(4, CellType.STRING); //4= cột D
        celltenKH.setCellValue("Chiết Khấu(%): " + lblchietkhau.getText());
        celltenKH.setCellStyle(styleHD);
        //SDT 
        rowcount = 6; //hàng 5
        row = sheet.createRow(rowcount);
        cellSDT = row.createCell(1, CellType.STRING);
        cellSDT.setCellValue("SDT : " + lblsdt.getText());
        cellSDT.setCellStyle(styleHD);
        //setBorder table
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        //table

        rowcount = 7;
        row = sheet.createRow(rowcount);
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên");
        cell.setCellStyle(style);

//
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Giá");
        cell.setCellStyle(style);
        //
        cell = (Cell) row.createCell(3, CellType.STRING);
        cell.setCellValue("Size.");
        cell.setCellStyle(style);
//
        cell = (Cell) row.createCell(4, CellType.STRING);
        cell.setCellValue("Số Lượng.");
        cell.setCellStyle(style);
//
        cell = (Cell) row.createCell(5, CellType.STRING);
        cell.setCellValue("Ghi chú");
        cell.setCellStyle(style);
        rowcount = 8;

        //data
        for (CTHoaDon hd : listCTHD) {
            row = sheet.createRow(rowcount++);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(hd.getMaSanPham().getTenSp());
            cell.setCellStyle(style);
            //
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(String.valueOf(chuyentien.format(hd.getMaSanPham().getGiaBan()) + " VND "));
            cell.setCellStyle(style);
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(String.valueOf(hd.getSizeSP().getMaSize()));
            cell.setCellStyle(style);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(String.valueOf(hd.getSoLuong()));
            cell.setCellStyle(style);

            // 
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(hd.getExtra().getTen());
            cell.setCellStyle(style);

        }//Thành tiền
        Cell cellTongTien;
        Row row1, row2, row3;
        //tạo font , style thành tiền
        HSSFFont fontThanhTien = workbook.createFont();
        fontThanhTien.setBold(true);
        fontThanhTien.setFontHeightInPoints((short) 10);
        HSSFCellStyle styleThanhTien = workbook.createCellStyle();
        styleThanhTien.setAlignment(HorizontalAlignment.CENTER);
        styleThanhTien.setFont(fontThanhTien);
        //tông tiền
        row1 = sheet.createRow((rowcount++) + 1);
        cellTongTien = row1.createCell(4);
        cellTongTien.setCellValue("Tổng Tiền: ");
        cellTongTien.setCellStyle(styleThanhTien);
        Cell soTien = row1.createCell(5);
        soTien.setCellValue(lblthanhtienhd.getText());
        soTien.setCellStyle(styleThanhTien);
        //tiền khách
        row2 = sheet.createRow(rowcount++ + 1);
        cellTongTien = row2.createCell(4);
        cellTongTien.setCellValue("Tiền Khách: ");
        cellTongTien.setCellStyle(styleThanhTien);
        Cell tienkhach = row2.createCell(5);
        tienkhach.setCellValue(lbltienkhach.getText());
        tienkhach.setCellStyle(styleThanhTien);

        //Tiền thối
        row3 = sheet.createRow(rowcount++ + 1);
        cellTongTien = row3.createCell(4);
        cellTongTien.setCellValue("Tiền Thối: ");
        cellTongTien.setCellStyle(styleThanhTien);
        Cell tienthoi = row3.createCell(5);
        tienthoi.setCellValue(lblTienthoi.getText());
        tienthoi.setCellStyle(styleThanhTien);

        //write
        File file = new File("src/com/nhom3/qlcf/reported/HoaDon.xls");
        file.getParentFile().mkdirs();
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        //mở file
        if (Desktop.isDesktopSupported()) {
            File pdf = new File("src/com/nhom3/qlcf/reported/HoaDon.xls");
            try {
                Desktop.getDesktop().open(pdf);
            } catch (Exception e) {
            }

        }
    }

    public void pdf() {
        String opObjects[] = {"OK"};
        Document document = new Document();
        try {

            // Tạo đối tượng PdfWriter
            PdfWriter.getInstance(document, new FileOutputStream("src/com/nhom3/qlcf/reported/HoaDon.pdf"));
            // Mở file để thực hiện ghi
            document.open();
            PdfPTable table = new PdfPTable(5);
            table.setSpacingBefore(30);
            table.setSpacingAfter(30);

            PdfPCell row1 = new PdfPCell(new Phrase("Ten SP"));
            table.addCell(row1);
            PdfPCell row2 = new PdfPCell(new Phrase("Gia Ban"));
            table.addCell(row2);
            PdfPCell row4 = new PdfPCell(new Phrase("Ma Size"));
            table.addCell(row4);
            PdfPCell row3 = new PdfPCell(new Phrase("So Luong"));
            table.addCell(row3);
            PdfPCell row5 = new PdfPCell(new Phrase("Ghi Chu"));
            table.addCell(row5);

//du lieu SP
            for (CTHoaDon hd : listCTHD) {
                table.addCell(String.valueOf(hd.getMaSanPham().getTenSp()));
                table.addCell(String.valueOf(chuyentien.format(hd.getMaSanPham().getGiaBan())) + " VND ");
                table.addCell(String.valueOf(hd.getSizeSP().getMaSize()));
                table.addCell(String.valueOf(hd.getSoLuong()));
                table.addCell(String.valueOf(hd.getExtra().getTen()));
            }
            //Tua de
            Paragraph tuade = new Paragraph("TNP-Coffee",
                    FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 16, Font.BOLD, new CMYKColor(87, 45, 75, 17)));

            Paragraph tencongty = new Paragraph("Cong Ty Trach Nhiem Huu Han 1 Thanh Vien",
                    FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, new CMYKColor(87, 45, 75, 17)));
            tencongty.setAlignment(Element.ALIGN_CENTER);
            Paragraph diachi = new Paragraph("Dia Chi: 23 Nguyen Hue, Ben Nghe, Quan 1, TP HCM",
                    FontFactory.getFont(FontFactory.HELVETICA, 11, Font.ITALIC, new CMYKColor(87, 45, 75, 17)));
            diachi.setAlignment(Element.ALIGN_CENTER);
            Paragraph SDT = new Paragraph("SDT: 090099009",
                    FontFactory.getFont(FontFactory.HELVETICA, 11, Font.ITALIC, new CMYKColor(87, 45, 75, 17)));
            SDT.setAlignment(Element.ALIGN_LEFT);
            SDT.setIndentationLeft(130);
            //Thong tin hd va sp
            Paragraph maHD = new Paragraph("Ma HD: " + lblmahd.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
            Paragraph Ten = new Paragraph("Ten Khach Hang: " + lblten.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
            Paragraph SDTKH = new Paragraph("Dien Thoai: " + lblsdt.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD));
            Paragraph ngay = new Paragraph("Ngay Tao: " + lblngay.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 7, Font.ITALIC));
            ngay.setAlignment(Element.ALIGN_RIGHT);
            ngay.setIndentationRight(40);
            Paragraph chietkhau = new Paragraph("Chiet Khau(%): " + lblchietkhau.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 7, Font.ITALIC));
            chietkhau.setAlignment(Element.ALIGN_RIGHT);
            chietkhau.setIndentationRight(40);
            Paragraph tieudeHD = new Paragraph("THONG TIN HOA DON",
                    FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD));
            tieudeHD.setAlignment(Element.ALIGN_CENTER);
            document.add(tuade);
            document.add(tencongty);
            document.add(diachi);
            document.add(SDT);
            document.add(maHD);
            document.add(Ten);
            document.add(SDTKH);
            document.add(ngay);
            document.add(chietkhau);
            document.add(tieudeHD);
            document.add(table);
            //Thanh Tiền
            Paragraph title1 = new Paragraph("Tong Tien: " + lblthanhtienhd.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD));
            title1.setAlignment(Element.ALIGN_RIGHT);
            title1.setIndentationRight(45);
            document.add(title1);
            //
            Paragraph title2 = new Paragraph("Tien Khach: " + lbltienkhach.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD));
            title2.setAlignment(Element.ALIGN_RIGHT);
            title2.setIndentationRight(45);
            document.add(title2);
            //
            Paragraph title3 = new Paragraph("Tien Thoi: " + lblTienthoi.getText(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD));
            title3.setAlignment(Element.ALIGN_RIGHT);
            title3.setIndentationRight(60);
            document.add(title3);

            // Đóng File
            document.close();

            JOptionPane.showOptionDialog(null,
                    "Ghi Thành Công",
                    "Ghi Dữ Liệu PDF",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opObjects,
                    opObjects[0]);

            if (Desktop.isDesktopSupported()) {
                File pdf = new File("src/com/nhom3/qlcf/reported/HoaDon.pdf");
                try {
                    Desktop.getDesktop().open(pdf);
                } catch (Exception e) {
                }

            }

        } catch (FileNotFoundException e) {
            JOptionPane.showOptionDialog(null,
                    "Có Sự Cố! File PDF đang sữ dụng, close để ghi dữ liệu mới.",
                    "Ghi Dữ Liệu PDF Thất Bại",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opObjects,
                    opObjects[0]);
        } catch (DocumentException ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
        lblThanhTien2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblthanhtienhd = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblmahd = new javax.swing.JLabel();
        lblten = new javax.swing.JLabel();
        lblngay = new javax.swing.JLabel();
        lblsdt = new javax.swing.JLabel();
        lblTienthoi = new javax.swing.JLabel();
        lbltienkhach = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblchietkhau = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        lblThanhTien2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThanhTien2.setText("...");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tblInHoaDon.setForeground(new java.awt.Color(51, 51, 51));
        tblInHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Giá Bán", "maSize", "Số Lượng", "Ghi chú"
            }
        ));
        tblInHoaDon.setToolTipText("");
        tblInHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblInHoaDon.setFocusable(false);
        tblInHoaDon.setGridColor(new java.awt.Color(0, 0, 0));
        tblInHoaDon.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblInHoaDon.setRowHeight(25);
        tblInHoaDon.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblInHoaDon.setShowHorizontalLines(false);
        tblInHoaDon.setShowVerticalLines(false);
        tblInHoaDon.setSurrendersFocusOnKeystroke(true);
        tblInHoaDon.getTableHeader().setReorderingAllowed(false);
        tblInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblInHoaDonMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblInHoaDon);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 128, -1, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText(" Tiền Thối:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 70, 20));

        lblthanhtienhd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblthanhtienhd.setText("...");
        jPanel2.add(lblthanhtienhd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 119, 20));

        jLabel2.setBackground(new java.awt.Color(0, 51, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/pdf.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 70, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("IN HÓA ĐƠN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 475, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Close");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 548, 105, -1));

        jLabel6.setBackground(new java.awt.Color(0, 51, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom3/qlcf/img/excel.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 72, 60));

        jLabel7.setText("Mã HD: ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 63, -1, 20));

        jLabel8.setText("TenKH");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 85, 49, 17));

        jLabel9.setText("SĐT:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 108, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("Ngày Tạo:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        lblmahd.setText("...");
        jPanel2.add(lblmahd, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 66, 136, -1));

        lblten.setText("..");
        jPanel2.add(lblten, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 200, 20));

        lblngay.setText("...");
        jPanel2.add(lblngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 140, -1));

        lblsdt.setText("..");
        jPanel2.add(lblsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, 20));

        lblTienthoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTienthoi.setText("...");
        jPanel2.add(lblTienthoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 119, 30));

        lbltienkhach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltienkhach.setText("...");
        jPanel2.add(lbltienkhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 119, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tổng Tiền:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Tiền Khách:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Chiết Khấu: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 80, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Bao gồm VAT");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 100, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Thuế:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 60, -1));

        lblchietkhau.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblchietkhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblchietkhau.setText(".");
        jPanel2.add(lblchietkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblInHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInHoaDonMousePressed
        // TODO add your handling code here:

        //cbxTrangThai.setSelectedItem(hd.isTrangThai());
    }//GEN-LAST:event_tblInHoaDonMousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        String opObjects[] = {"Đồng Ý", "Trở Lại"};

        if (0 == JOptionPane.showOptionDialog(null,
                "Bạn có chắc chắn không in hóa đơn?",
                "Cảnh Báo!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opObjects,
                opObjects[0])) {
            dispose();
        }

    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:

        pdf();

    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        try {
            // TODO add your handling code here:

            Excec();
        } catch (IOException ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MousePressed

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
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InHoaDon dialog = new InHoaDon(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblThanhTien2;
    private javax.swing.JLabel lblTienthoi;
    private javax.swing.JLabel lblchietkhau;
    private javax.swing.JLabel lblmahd;
    private javax.swing.JLabel lblngay;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JLabel lblten;
    private javax.swing.JLabel lblthanhtienhd;
    private javax.swing.JLabel lbltienkhach;
    private javax.swing.JTable tblInHoaDon;
    // End of variables declaration//GEN-END:variables
}
