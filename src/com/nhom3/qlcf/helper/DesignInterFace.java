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
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author baotri1998
 */
public interface DesignInterFace {

    public void DesignSanPham(JPanel sanphamUI, List<SanPham> data);

    public void DesignPage(JPanel PageUI, List<SanPham> limit);

    public List<SanPham> LimitPage(List<SanPham> LimitUI, int start, int end);

    public void DesigDonHang(JPanel donhangUI, List<CTHoaDon> data);

    public JPanel DesigMenuThucDon(JLabel lblgia, JLabel lblTen, JLabel lblImg);

    public void DesignSizeSP(JPanel size, List<SizeSP> data,List<SanPham> showGia, JLabel giaDieuChinh,JLabel showSize,int soluongdat,JTextField lblgetSoluong,JLabel giaEtra);

   public void DesignExtra(JPanel jplExtra, List<Extra> data,JLabel lblExtra, JLabel tenExtra,JLabel lblTongTien,JLabel lblTinhThem,JTextField txtsoluong, int so);
    
    public JDialog DesignDatMon();

}
