/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.test;

import com.nhom3.qlcf.helper.JDBCHelper;
import com.nhom3.qlcf.model.CTHoaDon;
import com.nhom3.qlcf.model.HoaDon;
import com.nhom3.qlcf.model.SanPham;
import com.nhom3.qlcf.model.SizeSP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baotri1998
 */
public class SelectSIze {
    
    public static List<SizeSP> select() {
        String sql = "SELECT * FROM dbo.SizeSP";
        return select(sql);
    }

    private static List<SizeSP> select(String sql, Object... args) {
        List<SizeSP> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                 rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SizeSP model = readFromResulSet(rs);
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

    private static SizeSP readFromResulSet(ResultSet rs) throws SQLException {
        SizeSP model = new SizeSP();
      
        model.setMaSize(rs.getString("maSize"));
        model.setHeSo(rs.getFloat("heSo"));
        model.setTenSize(rs.getString("tenSize"));
        return model;
    }
}
