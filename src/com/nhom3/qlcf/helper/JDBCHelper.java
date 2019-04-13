/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kanbi
 */
public class JDBCHelper {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=QLCF;username=sa;password=123";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        PreparedStatement pst = null;
        if (sql.trim().startsWith("{")) {
            pst = con.prepareCall(sql);

        } else {
            pst = con.prepareStatement(sql);
        }

        for (int i = 0; i < args.length; i++) {
            pst.setObject(i + 1, args[i]);
        }
        return pst;
    }

    public static boolean executeUpdate(String sql, Object... args) {
//        try {
//            PreparedStatement stm = preparedStatement(sql, args);
//            stm.getConnection().setAutoCommit(false);
//            try {
//                stm.executeUpdate();
//            } finally {
//                stm.getConnection().close();
//            }
//            return true;
//        } catch (SQLException e) {
//            return false;
////            throw new RuntimeException(e);
//        }
        PreparedStatement stm = null;
        try {
            stm = preparedStatement(sql, args);
            stm.getConnection().setAutoCommit(false);
            stm.executeUpdate();
            stm.getConnection().commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                stm.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        } finally {
            try {
                stm.getConnection().close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pst = preparedStatement(sql, args);
            return pst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
