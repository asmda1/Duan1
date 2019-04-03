/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom3.qlcf.view.form.users;

import com.nhom3.qlcf.dao.NguoiDungDAO;
import com.nhom3.qlcf.model.NguoiDung;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author baotri1998
 */
public class Quanlyusers extends javax.swing.JPanel {

    public List<NguoiDung> listUser = new ArrayList<>();

    /**
     * Creates new form Quanlyusers
     */
    public Quanlyusers() {
        initComponents();
        showAccount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void showAccount() {
        pnlAccounts.removeAll();
        NguoiDungDAO nd = new NguoiDungDAO();
        listUser = null;
        listUser = nd.selectAll();
        int x = Integer.parseInt(String.valueOf(listUser.size() / 3));
        pnlAccounts.setLayout(new GridLayout(x + 1, 3, 20, 20));
        JPanel[] pnlUsers = new JPanel[listUser.size()];
        for (int i = 0; i < listUser.size(); i++) {
            pnlUsers[i] = new JPanel();
            pnlUsers[i].setPreferredSize(new Dimension(300, 200)); //w = 200 hei = 250
            pnlUsers[i].setLayout(null);
            pnlUsers[i].setBackground(new Color(255, 255, 255));
            pnlUsers[i].setBorder(new LineBorder(Color.BLACK, 1));
            pnlUsers[i].setName(listUser.get(i).getMaNguoidung());

            // Name User
            JLabel lblName = new JLabel(listUser.get(i).getHoTen());
            lblName.setBounds(0, 25, 300, 20);
            lblName.setFont(new Font("Tahoma", 1, 18));
            lblName.setForeground(Color.BLACK);
            lblName.setName(listUser.get(i).getMaNguoidung());
            lblName.setHorizontalTextPosition(SwingConstants.CENTER);
            lblName.setHorizontalAlignment(SwingConstants.CENTER);
            //Title
            JLabel lblManv = new JLabel("Mã Nhân Viên: ");
            JLabel lbltendn = new JLabel("Tên Đăng Nhập :");
            lblManv.setFont(new Font("Tahoma", 1, 13));
            lbltendn.setFont(new Font("Tahoma", 1, 13));
            lblManv.setBounds(60, 90, 170, 20);
            lbltendn.setBounds(60, 125, 170, 20);
            lblManv.setForeground(Color.BLUE);
            lbltendn.setForeground(Color.BLUE);

            JLabel lblMa = new JLabel(listUser.get(i).getMaNguoidung());
            JLabel lblTen = new JLabel(listUser.get(i).getTaiKhoan());
            lblMa.setBounds(170, 90, 150, 20);
            lblTen.setBounds(170, 125, 150, 20);
            lblMa.setForeground(Color.BLUE);
            lblTen.setForeground(Color.BLUE);
            lblMa.setFont(new Font("Tahoma", 0, 13));
            lblTen.setFont(new Font("Tahoma", 0, 13));
            pnlUsers[i].add(lblMa);
            pnlUsers[i].add(lblTen);
            pnlUsers[i].add(lbltendn);
            pnlUsers[i].add(lblManv);
            // Button Xem Chi Tiết
            JPanel pnlUDetail = new JPanel(new BorderLayout());
            pnlUDetail.setBounds(125, 200, 120, 35);
            pnlUDetail.setBackground(Color.BLACK);
            pnlUDetail.setName(listUser.get(i).getMaNguoidung());
            JLabel lblUdetail = new JLabel("Xem Chi Tiết", SwingConstants.CENTER);
            lblUdetail.setForeground(Color.WHITE);
            lblUdetail.setFont(new Font("Tahoma", 1, 15));
            lblUdetail.setVerticalAlignment(SwingConstants.CENTER);
            pnlUDetail.add(lblUdetail);
            pnlUsers[i].add(lblName);
            pnlUsers[i].add(pnlUDetail);
            pnlUDetail.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {

                }
            });
            pnlUsers[i].add(lblName);
            pnlUsers[i].add(pnlUDetail);

            pnlAccounts.add(pnlUsers[i]);

            //
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSSanPham = new javax.swing.JScrollPane();
        pnlAccounts = new javax.swing.JPanel();

        jSSanPham.setBackground(Color.decode("#e6e6e6"));
        jSSanPham.setBorder(null);
        jSSanPham.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlAccounts.setBackground(new java.awt.Color(255, 255, 255));
        pnlAccounts.setAutoscrolls(true);
        pnlAccounts.setMaximumSize(new java.awt.Dimension(32767, 400));

        javax.swing.GroupLayout pnlAccountsLayout = new javax.swing.GroupLayout(pnlAccounts);
        pnlAccounts.setLayout(pnlAccountsLayout);
        pnlAccountsLayout.setHorizontalGroup(
            pnlAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1753, Short.MAX_VALUE)
        );
        pnlAccountsLayout.setVerticalGroup(
            pnlAccountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jSSanPham.setViewportView(pnlAccounts);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jSSanPham;
    private javax.swing.JPanel pnlAccounts;
    // End of variables declaration//GEN-END:variables
}
