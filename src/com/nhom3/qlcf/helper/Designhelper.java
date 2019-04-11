/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import com.nhom3.qlcf.model.CTHoaDon;
import com.nhom3.qlcf.model.Extra;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.model.SizeSP;
import com.nhom3.qlcf.view.form.banhang.Datmon;
import com.nhom3.qlcf.view.form.banhang.FormBanHang;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author baotri1998
 */
public class Designhelper implements DesignInterFace {

    private JLabel lblgia, lbltenSP, lblImg;
    public JLabel lblsoluong, lblSize, giaExtra, lbltenExtra;
    private JPanel sanphamUI;
    private List<CTHoaDon> CTHD;
    private List<SanPham> data;
    String tenspString, giaSP, img, so;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    int s1;
    double tienEx;

    @Override
    public void DesignSanPham(JPanel sanphamUI, List<SanPham> data) {
        this.sanphamUI = sanphamUI;
        this.data = data;
        this.sanphamUI.removeAll();
        this.sanphamUI.updateUI();
        this.sanphamUI.setVisible(true);
        JPanel[] pnlSanPham = new JPanel[this.data.size()];
        // int x = Integer.parseInt(String.valueOf(data.size() / 3)); //1.2
        sanphamUI.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int x = 0, y = 0;
        for (int i = 0; i < this.data.size(); i++) {
            try {
                pnlSanPham[i] = new JPanel();
                lbltenSP = new JLabel(this.data.get(i).getTenSp());
                lblgia = new JLabel(String.valueOf(chuyentien.format(this.data.get(i).getGiaBan())) + " VNĐ");
                lblImg = new JLabel();
                BufferedImage image = ImageIO.read(getClass().getResource("/com/nhom3/qlcf/img/" + data.get(i).getHinhAnh()));
                int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
                BufferedImage HinhAnh = new ReSizehelper().buffImage(image, type, 150, 150);
                ImageIcon icon = new ImageIcon(HinhAnh);
                lblImg.setIcon(icon);
                pnlSanPham[i].setName(this.data.get(i).getMaSanPham());
                pnlSanPham[i].setPreferredSize(new Dimension(140, 175)); //
                pnlSanPham[i].setLayout(new BoxLayout(pnlSanPham[i], javax.swing.BoxLayout.LINE_AXIS));
                pnlSanPham[i].setBackground(new Color(255, 255, 255));
                pnlSanPham[i].setBorder(new LineBorder(Color.BLUE, 1));
                //Action
                pnlSanPham[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pnlSanPham[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {

                        Datmon dt = new Datmon(null, true, e.getComponent().getName(), giaSP, tenspString, img);
                        dt.setVisible(true);

                    }
                ;
                } );
               DesigMenuThucDon(lblgia, lbltenSP, lblImg);
                pnlSanPham[i].add(DesigMenuThucDon(lblgia, lbltenSP, lblImg));

                gbc.insets = new Insets(3, 3, 7, 7);
                gbc.gridx = x;
                gbc.gridy = y;
                this.sanphamUI.add(pnlSanPham[i], gbc);
                this.sanphamUI.updateUI();
                if (y < 2) {
                    y++;
                } else if (y == 2) {
                    x++;
                    y = 0;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public List<SanPham> LimitPage(List<SanPham> LimitUI, int start, int end) {
        ArrayList<SanPham> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(LimitUI.get(i));
        }
        return list;
    }

    @Override
    public void DesignPage(JPanel PageUI, List<SanPham> limit) {

        PageUI.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        PageUI.removeAll();
        PageUI.updateUI();
        PageUI.setVisible(true);
        int gioihan = limit.size() / 9;
        if (gioihan * 9 < limit.size()) {
            gioihan += 1;
        }
        JPanel[] jplNext = new JPanel[limit.size()];

        for (int i = 0; i < gioihan; i++) {
            jplNext[i] = new JPanel();
            jplNext[i].setBorder(new LineBorder(Color.gray));
            jplNext[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            jplNext[i].setBackground(Color.WHITE);
            JLabel next = new JLabel();
            next.setText(String.valueOf(i + 1));
            jplNext[i].add(next);
            jplNext[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    int size = Integer.parseInt(next.getText());
                    int start = (size - 1) * 9;
                    int end = start + 9;
                    if (end > limit.size()) {
                        end = limit.size();
                    }
                    data = LimitPage(limit, start, end);

                    DesignSanPham(sanphamUI, data);

                }

            });
            PageUI.add(jplNext[i]);
            PageUI.updateUI();

        }

    }

    @Override
    public void DesigDonHang(JPanel donhangUI, List<CTHoaDon> CTHD) {
        this.CTHD = CTHD;

        donhangUI.removeAll();
        donhangUI.updateUI();
        donhangUI.setVisible(true);
        donhangUI.setLayout(new BoxLayout(donhangUI, BoxLayout.PAGE_AXIS));
        JPanel[] pnl = new JPanel[this.CTHD.size()];
        //   donhangUI.removeAll();
        for (int i = 0; i < this.CTHD.size(); i++) {
            //Set JPanel
            pnl[i] = new JPanel();
            // pnl[i].setBorder(BorderFactory.createLineBorder(new Color(204, 7, 140), 1));
            pnl[i].setBackground(Color.WHITE);
            pnl[i].setLayout(new GridLayout(2, 4, 1, 3));
            pnl[i].setPreferredSize(new Dimension(600, 40));
            pnl[i].setMaximumSize(new Dimension(600, 40));
            pnl[i].setMinimumSize(new Dimension(600, 40));
            // So Luong SP
            lblsoluong = new JLabel();
            lblsoluong = new JLabel(String.valueOf(this.CTHD.get(i).getSoLuong()));
            lblsoluong.setFont(new Font("Tahoma", 1, 11));
            lblsoluong.setPreferredSize(new Dimension(50, 20));
            //Set Ten SP
            JLabel lbltenSP = new JLabel(this.CTHD.get(i).getMaSanPham().getTenSp());
            //Set ma SP
            JLabel lblmaSP = new JLabel(this.CTHD.get(i).getMaSanPham().getMaSanPham());
            //Set Size M XL L
            JLabel lblSize = new JLabel(this.CTHD.get(i).getSizeSP().getMaSize());
            //Show mã SP, Tên SP và Size
            JLabel lbltenSPmaSP = new JLabel(lblmaSP.getText() + "/" + lbltenSP.getText() + " (" + lblSize.getText() + ")");
            lbltenSPmaSP.setName(this.CTHD.get(i).getMaSanPham().getMaSanPham());
            lbltenSPmaSP.setForeground(Color.BLUE);
            lbltenSPmaSP.setFont(new Font("Tahoma", 1, 11));
            //Tổng Tiền 
            double tongtien = this.CTHD.get(i).getMaSanPham().getGiaBan();
            if (tongtien == this.CTHD.get(i).getMaSanPham().getGiaBan()) {
                tongtien += this.CTHD.get(i).getMaSanPham().getGiaBan() * this.CTHD.get(i).getSoLuong() * this.CTHD.get(i).getSizeSP().getHeSo();
            }
            JLabel lbltongtien = new JLabel(String.valueOf(chuyentien.format(tongtien - this.CTHD.get(i).getMaSanPham().getGiaBan()) + " VNĐ/" + lblsoluong.getText()));
            lbltongtien.setFont(new Font("Tahoma", 1, 11));
            lbltongtien.setForeground(Color.RED);
            lbltongtien.setToolTipText(String.valueOf(chuyentien.format(tongtien - this.CTHD.get(i).getMaSanPham().getGiaBan())));
            //Xóa
            JLabel lblXoa = new JLabel("");
            int index = i;
            lblXoa.setName(String.valueOf(index));
            lblXoa.setToolTipText(String.valueOf(index));
            lblXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
            BufferedImage image;
            try {
                image = ImageIO.read(getClass().getResource("/com/nhom3/qlcf/img/xoa.png"));
                int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
                BufferedImage HinhAnh = new ReSizehelper().buffImage(image, type, 30, 22);
                ImageIcon icon = new ImageIcon(HinhAnh);
                lblXoa.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(Designhelper.class.getName()).log(Level.SEVERE, null, ex);
            }

            JLabel lblgiaSP = new JLabel(String.valueOf(chuyentien.format(this.CTHD.get(i).getMaSanPham().getGiaBan())) + " VNĐ (*" + this.CTHD.get(i).getSizeSP().getHeSo() + ")");
            lblgiaSP.setFont(new Font("Tahoma", 1, 11));

            //show Extra
            JLabel lblghiChu = new JLabel("Ghi Chú: " + CTHD.get(i).getExtra().getTen() + " ( " + chuyentien.format(CTHD.get(i).getExtra().getGia()) + " VNĐ)");
            if (!lblghiChu.getText().equals("Ghi Chú: Trống ( 0 VNĐ)")) {
                lblghiChu.setText("Ghi Chú: " + CTHD.get(i).getExtra().getTen() + " ( " + chuyentien.format(CTHD.get(i).getExtra().getGia()) + " VNĐ*" + lblsoluong.getText() + ")");
            }
            lblghiChu.setName(CTHD.get(i).getExtra().getId());
            lblghiChu.setForeground(Color.GRAY);
            lblghiChu.setFont(new Font("Tahoma", 2, 11));

            //Add
            pnl[i].add(lbltenSPmaSP);
            pnl[i].add(lblgiaSP);
            pnl[i].add(lbltongtien);
            pnl[i].add(lblghiChu);
            pnl[i].add(lblXoa).addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    CTHD.remove(CTHD.get(Integer.parseInt(e.getComponent().getName())));
                    Datmon d = new Datmon(null, true);
                    d.getTamTinh();
                    FormBanHang.banhang.diemtichluy();
                    DesigDonHang(donhangUI, CTHD);
                }

            });;
            // so = lblsoluong.getText();
            // pnl[i].setToolTipText(so);

            donhangUI.add(pnl[i]);
            donhangUI.updateUI();
        }

    }

    @Override
    public JPanel DesigMenuThucDon(JLabel lblgia, JLabel lblten, JLabel lblimg) {
        this.lbltenSP = lblten;
        this.lblgia = lblgia;
        this.lblImg = lblimg;

        JPanel pnlthucdon = new JPanel();
        pnlthucdon.setLayout(new BoxLayout(pnlthucdon, BoxLayout.LINE_AXIS));
        JPanel pnlAblayout = new JPanel();
        JPanel pnlNen = new JPanel();
        pnlNen.setBackground(new Color(0, 0, 0, 65));
        pnlAblayout.setLayout(new AbsoluteLayout());
        pnlAblayout.setPreferredSize(new Dimension(140, 175));
        pnlAblayout.setBackground(Color.gray);
        //Ten
        lblten.setForeground(Color.white);
        lblten.setBackground(new Color(0, 0, 0, 65));
        lblten.setFont(new Font("Tahoma", 1, 12));
        lblten.setHorizontalAlignment(SwingConstants.CENTER);
        //gia SP
        lblgia.setBackground(new Color(0, 0, 0, 65));
        lblgia.setForeground(Color.WHITE);
        lblgia.setFont(new Font("Tahoma", 1, 11));
        lblgia.setOpaque(true);
        lblgia.setHorizontalAlignment(SwingConstants.CENTER);
        //Anh
        lblimg.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout pnlLayout = new GroupLayout(pnlNen);
        pnlLayout.setHorizontalGroup(
                pnlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblten, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE));
        pnlLayout.setVerticalGroup(
                pnlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblten, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        pnlAblayout.add(pnlNen, new AbsoluteConstraints(0, 140, 150, 39));
        pnlAblayout.add(lblgia, new AbsoluteConstraints(60, 10, 90, 30));

        pnlAblayout.add(lblimg, new AbsoluteConstraints(0, 0, 150, 170));
        pnlthucdon.add(pnlAblayout);
        return pnlAblayout;
    }

    @Override
    public JDialog DesignDatMon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DesignSizeSP(JPanel size, List<SizeSP> dataSize, List<SanPham> dataSP, JLabel giaSize, JLabel showSize, int so, JTextField txtsoluong, JLabel giaEtra) {
        this.lblSize = giaSize;
        this.data = dataSP;
        s1 = so;

        size.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 7));
        size.removeAll();
        size.updateUI();
        size.setVisible(true);
        JPanel[] jplNext = new JPanel[dataSize.size()];
        for (int i = 0; i < dataSize.size(); i++) {
            jplNext[i] = new JPanel();
            jplNext[i].setBorder(new LineBorder(Color.gray));
            jplNext[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            jplNext[i].setBackground(Color.WHITE);
            JLabel M = new JLabel();
            M.setText(dataSize.get(i).getTenSize());
            M.setName(dataSize.get(i).getMaSize());
            JLabel Heso = new JLabel(String.valueOf(dataSize.get(i).getHeSo()));

            jplNext[i].setName(String.valueOf(dataSize.get(i).getHeSo()));
            jplNext[i].add(M);
            jplNext[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    s1 = Integer.parseInt(txtsoluong.getText());

                    giaSize.setText(String.valueOf(chuyentien.format(((dataSP.get(0).getGiaBan()) * s1) * Float.parseFloat(e.getComponent().getName()))) + " VNĐ");
                    showSize.setText(M.getText());
                    showSize.setName(M.getName());
                    if (showSize.getText().equals("Lớn")) {
                        showSize.setForeground(Color.orange);
                        giaSize.setForeground(Color.orange);
                    } else if (showSize.getText().equals("Vừa")) {
                        showSize.setForeground(Color.green);
                        giaSize.setForeground(Color.green);
                    } else {
                        showSize.setForeground(Color.red);
                        giaSize.setForeground(Color.red);

                    }
                    showSize.setToolTipText(Heso.getText());
                    giaSize.setName(String.valueOf(((dataSP.get(0).getGiaBan()) * s1) * Float.parseFloat(e.getComponent().getName())));
                    giaSize.setToolTipText(String.valueOf(((dataSP.get(0).getGiaBan())) * Float.parseFloat(e.getComponent().getName())));

                }
            });

            size.add(jplNext[i]);
            size.updateUI();

        }
    }

    @Override
    public void DesignExtra(JPanel jplExtra, List<Extra> data, JLabel lblgiaExtra, JLabel tenExtra, JLabel lblTongTien, JLabel lblTinhThem, JTextField txtsoluong, int so) {
        this.giaExtra = lblgiaExtra;
        this.lbltenExtra = tenExtra;
        s1 = so;
        jplExtra.setLayout(new GridLayout(2,4));
        jplExtra.removeAll();
        jplExtra.updateUI();
        jplExtra.setVisible(true);
        JPanel[] jplNext = new JPanel[data.size()];
        for (int i = 0; i < data.size(); i++) {
            jplNext[i] = new JPanel();
            jplNext[i].setBorder(new LineBorder(Color.gray));
            jplNext[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            jplNext[i].setBackground(Color.WHITE);
            JLabel id = new JLabel(data.get(i).getId());
            JLabel tenEx = new JLabel(data.get(i).getTen());
            tenEx.setForeground(Color.blue);
            int ten = i;
            giaExtra = new JLabel(String.valueOf(data.get(i).getGia()));
            tenEx.setFont(new Font("Tahoma", 1, 11));
            jplNext[i].setName(String.valueOf(chuyentien.format(data.get(i).getGia())) + " VNĐ");
            jplNext[i].add(tenEx);
            jplNext[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    s1 = Integer.parseInt(txtsoluong.getText());
                    lblgiaExtra.setText("+ " + e.getComponent().getName());
                    lblgiaExtra.setName(String.valueOf(data.get(ten).getGia()));
                    tenExtra.setToolTipText(id.getText());
                    tenExtra.setText(data.get(ten).getTen());
                    //lblTongTien.setText(String.valueOf(chuyentien.format(data.get(ten).getGia())) + " VNĐ");
                    lblTinhThem.setText(String.valueOf(chuyentien.format(data.get(ten).getGia() * s1)) + " VNĐ");

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    tenEx.setBackground(Color.BLUE);
                    tenEx.setForeground(Color.white);
                    tenEx.setOpaque(true);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    tenEx.setBackground(Color.white);
                    tenEx.setForeground(Color.blue);
                    tenEx.setOpaque(false);

                }

            });

            jplExtra.add(jplNext[i]);
            jplExtra.updateUI();

        }
    }

}
