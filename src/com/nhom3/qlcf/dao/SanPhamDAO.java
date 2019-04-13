/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.dao;

import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.model.LoaiSanPham;
import com.nhom3.qlcf.model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kanbi
 */
public class SanPhamDAO implements DAO<SanPham> {

    @Override
    public boolean insert(SanPham t) {
        String sql = "Insert into dbo.SanPham values (?,?,N'?',?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getMaSanPham(), t.getMaLoaiSanPham().getMaLoai(), t.getTenSp(), t.getGiaBan(), t.isTrangThai(), t.getHinhAnh());
    }

    @Override
    public boolean delete(SanPham t) {
        String sql = "Delete from dbo.SanPham where maSp=?";
        return JDBCHelper.executeUpdate(sql, t.getMaSanPham());
    }

    @Override
    public boolean update(SanPham t) {
        String sql = "Update dbo.SanPham set maLoai=?, tenSp=?, giaBan=?, trangThai=?, hinhAnh=? where  maSp=?";
        return JDBCHelper.executeUpdate(sql, t.getMaLoaiSanPham().getMaLoai(), t.getTenSp(), t.getGiaBan(), t.isTrangThai(), t.getHinhAnh(), t.getMaSanPham());
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "Select * from SanPham";
        return select(sql);
    }

    @Override
    public List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public SanPham readFromResultSet(ResultSet rs) {
        SanPham model = new SanPham();
        try {
            model.setMaSanPham(rs.getString(1));

            LoaiSanPham lsp = new LoaiSanPham();
            lsp.setMaLoai(rs.getString(2));
            model.setMaLoaiSanPham(lsp);

            model.setTenSp(rs.getString(3));
            model.setGiaBan(rs.getDouble(4));
            model.setTrangThai(rs.getBoolean(5));
            model.setHinhAnh(rs.getString(6));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return model;

    }

    @Override
    public SanPham selectID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //bổ sung
    public List<SanPham> selecttheoLoai(String loai) {
        String sql = "Select * from SanPham where maLoai =?";
        return select(sql, loai);
    }
//bổ sung

    public List<SanPham> selectSearch(String loai) {
        String sql = "Select * from dbo.SanPham where tenSp like '%" + loai +"%'";
        return select(sql);
    }
}
