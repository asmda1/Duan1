/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.hanghoa;

import com.nhom3.qlcf.dao.CTPhieuNhapDAO;
import com.nhom3.qlcf.dao.HangHoaDAO;
import com.nhom3.qlcf.dao.NhaCungCapDAO;
import com.nhom3.qlcf.dao.PhieuNhapDAO;
import com.nhom3.qlcf.helper.XuLy;
import com.nhom3.qlcf.model.CTPhieuNhap;
import com.nhom3.qlcf.model.HangHoa;
import com.nhom3.qlcf.model.NhaCungCap;
import com.nhom3.qlcf.model.PhieuNhap;
import com.nhom3.qlcf.view.form.login.Login;
import java.awt.Color;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Nghia
 */
public class NhapHang extends javax.swing.JPanel {

    public static NhapHang nhapHang;
    public static HangHoa matHang;
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    Date day = new Date();
    static List<HangHoa> listHH = new ArrayList<>();

    /**
     * Creates new form NhapHang
     */
    public NhapHang() {
        initComponents();
        nhapHang = this;
        List<NhaCungCap> listNCC = new NhaCungCapDAO().selectAll();
        cboNhaCungCap.addItem("Chọn nhà cung cấp");
        cboNhaCungCap.setSelectedIndex(0);
        listNCC.forEach((nhaCungCap) -> {
            cboNhaCungCap.addItem(nhaCungCap.getMaNhaCungCap() + " - " + nhaCungCap.getTenNhaCC());
        });

        txtSearch.setText("Tên mặt hàng");
        txtSearch.setForeground(Color.GRAY);
        XuLy.placeHolder(txtSearch, "Tên mặt hàng");
        fillToTable();
        lblTongTien.setText("Tổng Tiền Chi: " + FormNhapHang.tongTienPhieuNhap);
        if (matHang != null) {
            lblTenHang.setText("Tên mặt hàng: " + matHang.getTenHangHoa());

            lblNgayNhap.setText("Ngày Nhập: " + df.format(day));

            lblDVT.setText("ĐVT: " + matHang.getDonViTinh());
            lblGiaNhap.setText("<html>Giá Nhập: " + String.valueOf(new DecimalFormat("#,###,###").format(matHang.getGiaVon())) + " <span><sup>vnđ</sup></span></html>");
            lblSoLuongKho.setText("Số Lượng Trong Kho: " + matHang.getSoLuong());
            txtSoLuongNhap.setText("0");
            lblNguoiNhap.setText("Người Nhập Hàng: " + Login.user.getHoTen());
            lblTongTien.setText("Tổng Tiền Chi: " + 0);

        }
    }

    private String taoPhieuNhapMoi() {
        String maPhieuMoi;
        List<PhieuNhap> list = new PhieuNhapDAO().selectAll();
        if (list.isEmpty()) {
            maPhieuMoi = "PN001";
        } else {
            String maPhieu = list.get(list.size() - 1).getMaPhieu().replaceAll("\\D+", "");
            System.out.println("cu " + maPhieu);
            int ma = Integer.parseInt(maPhieu) + 1;
            System.out.println("moi " + ma);

            switch (String.valueOf(ma).length()) {
                case 1:
                    maPhieuMoi = "PN00" + ma;
                    break;
                case 2:
                    maPhieuMoi = "PN0" + ma;
                    break;
                default:
                    maPhieuMoi = "PN" + ma;
            }
        }
        return maPhieuMoi;
    }

    //Class chứa thông tin trong table 
    public class CTPNTam {

        private HangHoa tenHH;
        private float soLuong;
        private String dvt;

        public CTPNTam() {
        }

        public HangHoa getTenHH() {
            return tenHH;
        }

        public void setTenHH(HangHoa tenHH) {
            this.tenHH = tenHH;
        }

        public float getSoLuong() {
            return soLuong;
        }

        public void setSoLuong(float soLuong) {
            this.soLuong = soLuong;
        }

        public String getDvt() {
            return dvt;
        }

        public void setDvt(String dvt) {
            this.dvt = dvt;
        }

    }

    private void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblCTPN.getModel();
        model.setRowCount(0);
        FormNhapHang.listCTPNTam.stream().map((cTPNTam) -> new Object[]{cTPNTam.getTenHH().getTenHangHoa(), cTPNTam.getSoLuong(), cTPNTam.getDvt()}).forEachOrdered((row) -> {
            model.addRow(row);
        });

    }

    private void clearForm() {
        lblTenHang.setText("Tên mặt hàng: ");
        lblNgayNhap.setText("Ngày Nhập: ");
        lblDVT.setText("ĐVT: ");
        lblGiaNhap.setText("Giá Nhập: ");
        txtSoLuongNhap.setText("0");
        lblSoLuongKho.setText("Số Lượng Trong Kho: ");
        lblNguoiNhap.setText("Người Nhập Hàng: ");
        cboNhaCungCap.setSelectedIndex(0);
        matHang = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        lblNguoiNhap = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNhapHang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboNhaCungCap = new javax.swing.JComboBox<>();
        lblNgayNhap = new javax.swing.JLabel();
        lblTenHang = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        lblSoLuongKho = new javax.swing.JLabel();
        lblGiaNhap = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblThem = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuongNhap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTPN = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblXoa = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();
        lblLoiNhapSo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NHẬP HÀNG");

        lblNguoiNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNguoiNhap.setText("Người Nhập Hàng:");

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(240, 240, 240));
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setText("Tìm kiếm");
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSearchMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(51, 0, 255));

        lblNhapHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNhapHang.setForeground(new java.awt.Color(240, 240, 240));
        lblNhapHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNhapHang.setText("Nhập Hàng");
        lblNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNhapHangMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nhà Cung Cấp: ");

        cboNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblNgayNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNgayNhap.setText("Ngày Nhập:");

        lblTenHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenHang.setText("Tên Mặt Hàng: ");

        lblDVT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDVT.setText("ĐVT:");

        lblSoLuongKho.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSoLuongKho.setText("Số Lượng Trong Kho: ");

        lblGiaNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGiaNhap.setText("Giá Nhập: ");

        jPanel3.setBackground(new java.awt.Color(51, 0, 255));

        lblThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThem.setForeground(new java.awt.Color(240, 240, 240));
        lblThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem.setText("Thêm");
        lblThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblThemMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Số Lượng Nhập: ");

        txtSoLuongNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSoLuongNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoLuongNhapFocusGained(evt);
            }
        });
        txtSoLuongNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuongNhapKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongNhapKeyReleased(evt);
            }
        });

        tblCTPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên mặt hàng", "Số lượng", "ĐVT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTPN.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCTPN.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCTPN);
        if (tblCTPN.getColumnModel().getColumnCount() > 0) {
            tblCTPN.getColumnModel().getColumn(0).setResizable(false);
            tblCTPN.getColumnModel().getColumn(1).setResizable(false);
            tblCTPN.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblCTPN.getColumnModel().getColumn(2).setResizable(false);
            tblCTPN.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        jPanel4.setBackground(new java.awt.Color(51, 0, 255));

        lblXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblXoa.setForeground(new java.awt.Color(240, 240, 240));
        lblXoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblXoa.setText("Xóa");
        lblXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblXoaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongTien.setText("Tổng Tiền Chi:");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 0, 51));
        lblThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBao.setText(" ");

        lblLoiNhapSo.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblLoiNhapSo.setForeground(new java.awt.Color(255, 0, 51));
        lblLoiNhapSo.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblTenHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNguoiNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblSoLuongKho, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 6, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLoiNhapSo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSoLuongNhap))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNguoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuongKho, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLoiNhapSo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblThongBao)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMousePressed
        // TODO add your handling code here:
        ListHang.tenMatHang = txtSearch.getText().trim();
        ListHang.checkForm = "Nhập hàng";

        FormNhapHang.jpnThemHoangHoa.removeAll();
        FormNhapHang.jpnThemHoangHoa.add(new ListHang());
        FormNhapHang.jpnThemHoangHoa.repaint();
        FormNhapHang.jpnThemHoangHoa.revalidate();
        new NhapHang().hide();
    }//GEN-LAST:event_lblSearchMousePressed

    private void lblNhapHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhapHangMousePressed
        // TODO add your handling code here:
        //mặt hàng
        boolean updateHH = false;
        for (HangHoa hangHoa : listHH) {
            updateHH = new HangHoaDAO().update(hangHoa);
            if (!updateHH) {
                lblThongBao.setText("Nhập hàng không thành công!!");
                  lblThongBao.setForeground(Color.red);
                return;
            }
        }
        //Phiếu nhập
        String NhaCungCap = (String) cboNhaCungCap.getSelectedItem();
        if (NhaCungCap.equals("Chọn nhà cung cấp")) {
            lblThongBao.setText("Chưa chọn nhà cung cấp hàng!!!");
            lblThongBao.setForeground(Color.red);
            return;
        }else if(listHH.isEmpty()){
           lblThongBao.setText("Không có hàng hóa nào!!!");
            lblThongBao.setForeground(Color.red);
            return; 
        }
        String maNhaCungCap = NhaCungCap.substring(0, NhaCungCap.indexOf(" "));

        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setMaPhieu(taoPhieuNhapMoi());

        phieuNhap.setMaNhaCungCap(new NhaCungCapDAO().selectID(maNhaCungCap));

        phieuNhap.setMaNguoiDung(Login.user);

        phieuNhap.setNgayNhap(day);

        phieuNhap.setTongTien(Double.parseDouble(lblTongTien.getText().substring(lblTongTien.getText().indexOf(":") + 2)));

        boolean updatePN = new PhieuNhapDAO().insert(phieuNhap);

        //CT phiếu nhập
        boolean updateCTPN = false;
        for (CTPNTam cTPNTam : FormNhapHang.listCTPNTam) {
            CTPhieuNhap cTPN = new CTPhieuNhap();
            cTPN.setMaPhieuNhap(phieuNhap);
            cTPN.setMaHangHoa(cTPNTam.getTenHH());
            cTPN.setSoLuong(cTPNTam.getSoLuong());
            updateCTPN = new CTPhieuNhapDAO().insert(cTPN);
            if (!updateCTPN) {
                lblThongBao.setText("Nhập hàng không thành công!!");
                return;
            }
        }

        if (updateHH && updatePN && updateCTPN) {
            lblThongBao.setText("Nhập hàng hoàn tất!!");
            lblThongBao.setForeground(Color.GREEN);
        } else {
            lblThongBao.setText("Nhập hàng không thành công!!");
             lblThongBao.setForeground(Color.red);
        }
    }//GEN-LAST:event_lblNhapHangMousePressed

    private void txtSoLuongNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongNhapKeyReleased

//        txtSoLuongNhap.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                try {
//                    float soLuongNhap = Float.parseFloat(txtSoLuongNhap.getText().trim().isEmpty() ? "0" : txtSoLuongNhap.getText().trim());
//                    double giaNhap = matHang.getGiaVon();
//                    lblTongTien.setText("Tổng Tiền Chi: " + (soLuongNhap * giaNhap));
//                    lblLoiNhapSo.setText(" ");
//                } catch (NumberFormatException ex) {
//                    lblLoiNhapSo.setText("Chỉ được nhập số!!");
//                }
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                try {
//                    float soLuongNhap = Float.parseFloat(txtSoLuongNhap.getText().trim().isEmpty() ? "0" : txtSoLuongNhap.getText().trim());
//                    double giaNhap = matHang.getGiaVon();
//                    lblTongTien.setText("Tổng Tiền Chi: " + (soLuongNhap * giaNhap));
//                    lblLoiNhapSo.setText(" ");
//                } catch (NumberFormatException ex) {
//                    lblLoiNhapSo.setText("Chỉ được nhập số!!");
//                }
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                try {
//                    float soLuongNhap = Float.parseFloat(txtSoLuongNhap.getText().trim().isEmpty() ? "0" : txtSoLuongNhap.getText().trim());
//                    double giaNhap = matHang.getGiaVon();
//                    lblTongTien.setText("Tổng Tiền Chi: " + (soLuongNhap * giaNhap));
//                    lblLoiNhapSo.setText(" ");
//                } catch (NumberFormatException ex) {
//                    lblLoiNhapSo.setText("Chỉ được nhập số!!");
//                }
//            }
//
//        });
    }//GEN-LAST:event_txtSoLuongNhapKeyReleased

    private void txtSoLuongNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongNhapKeyPressed
        if (matHang != null) {
            txtSoLuongNhap.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    try {
                        float soLuongNhap = Float.parseFloat(txtSoLuongNhap.getText().trim().isEmpty() ? "0" : txtSoLuongNhap.getText().trim());
                        float soLuongKho = matHang.getSoLuong();
                        lblSoLuongKho.setText("Số Lượng Trong Kho: " + (soLuongNhap + soLuongKho));
                        lblLoiNhapSo.setText(" ");
                    } catch (NumberFormatException ex) {
                        lblLoiNhapSo.setText("Chỉ được nhập số!!");
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    try {
                        float soLuongNhap = Float.parseFloat(txtSoLuongNhap.getText().trim().isEmpty() ? "0" : txtSoLuongNhap.getText().trim());
                        float soLuongKho = matHang.getSoLuong();
                        lblSoLuongKho.setText("Số Lượng Trong Kho: " + (soLuongNhap + soLuongKho));
                        lblLoiNhapSo.setText(" ");
                    } catch (NumberFormatException ex) {
                        lblLoiNhapSo.setText("Chỉ được nhập số!!");
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    try {
                        float soLuongNhap = Float.parseFloat(txtSoLuongNhap.getText().trim().isEmpty() ? "0" : txtSoLuongNhap.getText().trim());
                        float soLuongKho = matHang.getSoLuong();
                        lblSoLuongKho.setText("Số Lượng Trong Kho: " + (soLuongNhap + soLuongKho));
                        lblLoiNhapSo.setText(" ");
                    } catch (NumberFormatException ex) {
                        lblLoiNhapSo.setText("Chỉ được nhập số!!");
                    }
                }

            });
        } else {
            lblLoiNhapSo.setText("Không có mặt hàng nào được chọn!!");
        }
    }//GEN-LAST:event_txtSoLuongNhapKeyPressed

    private void lblThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMousePressed
        // TODO add your handling code here:
        if (matHang != null) {

            matHang.setSoLuong(matHang.getSoLuong() + Float.parseFloat(txtSoLuongNhap.getText()));
            listHH.add(matHang);

            CTPNTam cTPNTam = new CTPNTam();
            cTPNTam.setTenHH(matHang);
            if (Float.parseFloat(txtSoLuongNhap.getText().trim()) > 0) {
                cTPNTam.setSoLuong(Float.parseFloat(txtSoLuongNhap.getText().trim()));
            } else {
                lblLoiNhapSo.setText("Nhập số lượng!!!");
                lblThongBao.setForeground(Color.red);
                return;
            }
            cTPNTam.setDvt(matHang.getDonViTinh());
            FormNhapHang.listCTPNTam.add(cTPNTam);
            fillToTable();
            FormNhapHang.tongTienPhieuNhap += matHang.getGiaVon() * Float.parseFloat(txtSoLuongNhap.getText().trim());
            lblTongTien.setText("Tổng Tiền Chi: " + FormNhapHang.tongTienPhieuNhap);
            clearForm();
        } else {
            lblThongBao.setText("Không có mặt hàng nào được chọn!!");
        }
    }//GEN-LAST:event_lblThemMousePressed

    private void lblXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXoaMousePressed
        // TODO add your handling code here:
        int index = tblCTPN.getSelectedRow();
        CTPNTam cTPNTam = FormNhapHang.listCTPNTam.get(index);
        double tienXoa = cTPNTam.getTenHH().getGiaVon() * cTPNTam.getSoLuong();
        FormNhapHang.tongTienPhieuNhap -= tienXoa;
        lblTongTien.setText("Tổng Tiền Chi: " + FormNhapHang.tongTienPhieuNhap);
        FormNhapHang.listCTPNTam.remove(index);
        fillToTable();
    }//GEN-LAST:event_lblXoaMousePressed

    private void txtSoLuongNhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongNhapFocusGained
        // TODO add your handling code here:
        txtSoLuongNhap.setText("");
    }//GEN-LAST:event_txtSoLuongNhapFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNhaCungCap;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblGiaNhap;
    private javax.swing.JLabel lblLoiNhapSo;
    private javax.swing.JLabel lblNgayNhap;
    private javax.swing.JLabel lblNguoiNhap;
    private javax.swing.JLabel lblNhapHang;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSoLuongKho;
    private javax.swing.JLabel lblTenHang;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblXoa;
    private javax.swing.JTable tblCTPN;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuongNhap;
    // End of variables declaration//GEN-END:variables
}
