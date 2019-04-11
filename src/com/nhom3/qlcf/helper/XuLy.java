/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.helper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Kanbi
 */
public class XuLy {

    public static void placeHolder(JTextField field, String msg) {
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(msg)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);

                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(msg);

                }
            }
        });
    }

    public static JTable popupDialog(JPanel parentFrame, String[] column) {
        DefaultTableModel table = new DefaultTableModel(column, 0);
        JScrollPane scp = new JScrollPane();
        JTable tbl = new JTable(table);
        scp.setViewportView(tbl);
        scp.setPreferredSize(new Dimension(580, 550));
        JPanel pnl = new JPanel(new BorderLayout(5, 5));

        pnl.add(scp, BorderLayout.NORTH);
        JDialog dl = new JDialog(SwingUtilities.windowForComponent(parentFrame));
//        dl.setModal(true); 
        dl.setSize(new Dimension(600, 600));
        dl.add(pnl);
        dl.setVisible(true);
        dl.setLocationRelativeTo(null);
        return tbl;
    }

    public static String xuLyTen(String ten) {
        String[] c;
        String kq = "";
        ten = ten.trim().toLowerCase();
        c = ten.split(" ");
        for (String i : c) {
            if (i.length() != 0) {
                String a = i.substring(0, 1).toUpperCase();
                String b = i.substring(1, i.length());
                i = a + b;
                kq += i + " ";
            }
        }
        return kq.trim();
    }
}
