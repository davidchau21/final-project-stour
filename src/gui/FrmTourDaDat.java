/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import app.Application;
import connectDB.ConnectDB;
import custom_components.SVGImage;
import custom_components.ScrollBarCustom;
import dao.NhanVien_DAO;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TimerTask;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import javax.swing.table.TableColumn;
import model_table.ModelTableNhanVien;
import model_table.TableNhanVien;
import static model_table.TableNhanVien.indexColDelete;
import static model_table.TableNhanVien.indexColEdit;


import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import java.util.Arrays;

import entity.Tour;
import entity.Ve2;
import dao.Tour_DAO;
import dao.Ve_DAO;
import connectDB.ConnectDB;
import custom_components.ButtonCustom;
import java.awt.Panel;
import java.util.Locale;
import java.text.NumberFormat;
import javax.swing.JButton;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import utils.VNCharacterUtils;


/**
 *
 * @author Asus
 */
public class FrmTourDaDat extends javax.swing.JFrame implements MouseListener {

    private Color mouseHoverColor = new Color(45, 45, 45);
    private Color sidebarMenuColor = new Color(40, 50, 60);
    private Color mouseClickColor = new Color(0, 0, 0);
    private Color tabPanelHoverColor = new Color(230, 230, 230);
    private Color tabPanelLeaveColor = new Color(255, 255, 255);
    private Color lineTabHoverColor = new Color(51, 153, 255);
    private Color lineTabLeaveColor = new Color(255, 255, 255);
    
    private List<Ve2> dsVe;
    private JPanel[] cardItems;
    private int cardItemWidth = 1040;
    private int cardItemHeight = 220;
    private int marginCenterItem = 30;
    
    public FrmTourDaDat() {
        initComponents();
        
        ConnectDB.connect();
        dsVe = Ve_DAO.getAllVe();
        addControls();
        addEvents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnMain = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        menuBarIcon = new javax.swing.JPanel();
        pnLogo = new javax.swing.JPanel();
        logo = new custom_components.SVGImage();
        btnTrangChu = new javax.swing.JPanel();
        iconTrangChu = new custom_components.SVGImage();
        btnVeDaDat = new javax.swing.JPanel();
        iconVeDaDat = new custom_components.SVGImage();
        sidebarMenu = new javax.swing.JPanel();
        pnTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnTrangChuChild = new javax.swing.JPanel();
        lblTrangChu = new javax.swing.JLabel();
        btnVeDaDatChild = new javax.swing.JPanel();
        lblVeDaDat = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblPageTitle = new javax.swing.JLabel();
        btnThongTin = new custom_components.SVGImage();
        btnThongBao = new custom_components.SVGImage();
        btnCaiDat = new custom_components.SVGImage();
        btnTaiKhoan = new custom_components.SVGImage();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        pnBody = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");
        setMinimumSize(new java.awt.Dimension(1100, 750));
        setName(""); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setLayout(new java.awt.BorderLayout());

        menuBar.setBackground(new java.awt.Color(204, 0, 204));
        menuBar.setPreferredSize(new java.awt.Dimension(65, 600));
        menuBar.setLayout(new java.awt.BorderLayout());

        menuBarIcon.setBackground(new java.awt.Color(40, 50, 60));
        menuBarIcon.setPreferredSize(new java.awt.Dimension(65, 732));

        pnLogo.setBackground(new java.awt.Color(24, 120, 189));
        pnLogo.setPreferredSize(new java.awt.Dimension(65, 60));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnLogoLayout = new javax.swing.GroupLayout(pnLogo);
        pnLogo.setLayout(pnLogoLayout);
        pnLogoLayout.setHorizontalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pnLogoLayout.setVerticalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        btnTrangChu.setBackground(new java.awt.Color(40, 50, 60));
        btnTrangChu.setPreferredSize(new java.awt.Dimension(65, 48));
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrangChuMousePressed(evt);
            }
        });

        iconTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnTrangChuLayout = new javax.swing.GroupLayout(btnTrangChu);
        btnTrangChu.setLayout(btnTrangChuLayout);
        btnTrangChuLayout.setHorizontalGroup(
            btnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTrangChuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnTrangChuLayout.setVerticalGroup(
            btnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTrangChuLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(iconTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btnVeDaDat.setBackground(new java.awt.Color(40, 50, 60));
        btnVeDaDat.setPreferredSize(new java.awt.Dimension(65, 48));

        iconVeDaDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout btnVeDaDatLayout = new javax.swing.GroupLayout(btnVeDaDat);
        btnVeDaDat.setLayout(btnVeDaDatLayout);
        btnVeDaDatLayout.setHorizontalGroup(
            btnVeDaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVeDaDatLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconVeDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnVeDaDatLayout.setVerticalGroup(
            btnVeDaDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVeDaDatLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(iconVeDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menuBarIconLayout = new javax.swing.GroupLayout(menuBarIcon);
        menuBarIcon.setLayout(menuBarIconLayout);
        menuBarIconLayout.setHorizontalGroup(
            menuBarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarIconLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(menuBarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVeDaDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        menuBarIconLayout.setVerticalGroup(
            menuBarIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarIconLayout.createSequentialGroup()
                .addComponent(pnLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVeDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 587, Short.MAX_VALUE))
        );

        menuBar.add(menuBarIcon, java.awt.BorderLayout.LINE_START);

        sidebarMenu.setBackground(new java.awt.Color(40, 50, 60));

        pnTitle.setBackground(new java.awt.Color(70, 150, 220));
        pnTitle.setPreferredSize(new java.awt.Dimension(175, 60));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("TOURS");

        javax.swing.GroupLayout pnTitleLayout = new javax.swing.GroupLayout(pnTitle);
        pnTitle.setLayout(pnTitleLayout);
        pnTitleLayout.setHorizontalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnTitleLayout.setVerticalGroup(
            pnTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTrangChuChild.setBackground(new java.awt.Color(40, 50, 60));
        btnTrangChuChild.setPreferredSize(new java.awt.Dimension(175, 48));
        btnTrangChuChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTrangChuChildMousePressed(evt);
            }
        });

        lblTrangChu.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        lblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangChu.setText("Trang chủ");

        javax.swing.GroupLayout btnTrangChuChildLayout = new javax.swing.GroupLayout(btnTrangChuChild);
        btnTrangChuChild.setLayout(btnTrangChuChildLayout);
        btnTrangChuChildLayout.setHorizontalGroup(
            btnTrangChuChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTrangChuChildLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnTrangChuChildLayout.setVerticalGroup(
            btnTrangChuChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTrangChuChildLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTrangChu)
                .addContainerGap())
        );

        btnVeDaDatChild.setBackground(new java.awt.Color(40, 50, 60));
        btnVeDaDatChild.setPreferredSize(new java.awt.Dimension(175, 48));

        lblVeDaDat.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        lblVeDaDat.setForeground(new java.awt.Color(255, 255, 255));
        lblVeDaDat.setText("Tour đã đặt");

        javax.swing.GroupLayout btnVeDaDatChildLayout = new javax.swing.GroupLayout(btnVeDaDatChild);
        btnVeDaDatChild.setLayout(btnVeDaDatChildLayout);
        btnVeDaDatChildLayout.setHorizontalGroup(
            btnVeDaDatChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVeDaDatChildLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblVeDaDat, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnVeDaDatChildLayout.setVerticalGroup(
            btnVeDaDatChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVeDaDatChildLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblVeDaDat)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidebarMenuLayout = new javax.swing.GroupLayout(sidebarMenu);
        sidebarMenu.setLayout(sidebarMenuLayout);
        sidebarMenuLayout.setHorizontalGroup(
            sidebarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sidebarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrangChuChild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVeDaDatChild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        sidebarMenuLayout.setVerticalGroup(
            sidebarMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarMenuLayout.createSequentialGroup()
                .addComponent(pnTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTrangChuChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVeDaDatChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 587, Short.MAX_VALUE))
        );

        menuBar.add(sidebarMenu, java.awt.BorderLayout.CENTER);

        pnMain.add(menuBar, java.awt.BorderLayout.LINE_START);

        panel.setOpaque(false);
        panel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1092, 60));

        lblPageTitle.setFont(new java.awt.Font("Mulish ExtraBold", 1, 27)); // NOI18N
        lblPageTitle.setText("Tour đã đặt");

        btnThongTin.setBackground(new java.awt.Color(204, 204, 204));
        btnThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThongTin.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnThongTin.setOpaque(true);

        btnThongBao.setBackground(new java.awt.Color(204, 204, 204));
        btnThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnThongBao.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnThongBao.setOpaque(true);

        btnCaiDat.setBackground(new java.awt.Color(204, 204, 204));
        btnCaiDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCaiDat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCaiDat.setOpaque(true);
        btnCaiDat.setPreferredSize(new java.awt.Dimension(40, 40));

        btnTaiKhoan.setBackground(new java.awt.Color(204, 204, 204));
        btnTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnTaiKhoan.setOpaque(true);
        btnTaiKhoan.setPreferredSize(new java.awt.Dimension(40, 40));
        btnTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTaiKhoanMousePressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(240, 240, 240));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblPageTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 664, Short.MAX_VALUE)
                        .addComponent(btnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCaiDat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblPageTitle))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCaiDat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setBorder(null);

        pnBody.setBackground(new java.awt.Color(247, 248, 250));
        pnBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        scroll.setViewportView(pnBody);

        jPanel3.add(scroll, java.awt.BorderLayout.CENTER);

        panel.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnMain.add(panel, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1200, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaiKhoanMousePressed
        FrmTaiKhoanKH taiKhoanKH = new FrmTaiKhoanKH();
        taiKhoanKH.setVisible(true);
    }//GEN-LAST:event_btnTaiKhoanMousePressed

    private void btnTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMousePressed
        Application.frmTrangChu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTrangChuMousePressed

    private void btnTrangChuChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuChildMousePressed
        Application.frmTrangChu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTrangChuChildMousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        dsVe = Ve_DAO.getAllVe();
        loadListVe(dsVe);
    }//GEN-LAST:event_formWindowActivated

    private int sidebarMenuChildShow = 175;
    private boolean sidebarMouseHover = false;
    private int sidebarIconWidth = 23;
    private int sidebarIconHeigth = 23;
    private Color sidebarIconColor = Color.WHITE;

    private void addControls() {

        iconTrangChu.setSVGImage("svg/house-solid.svg", sidebarIconWidth, sidebarIconHeigth);
        iconTrangChu.setColor(sidebarIconColor);
        iconVeDaDat.setSVGImage("svg/ticket-simple-solid.svg", sidebarIconWidth, sidebarIconHeigth);
        iconVeDaDat.setColor(sidebarIconColor);

        logo.setSVGImage("svg/atom-solid.svg", 32, 32);
        logo.setColor(Color.WHITE);
        
        btnTaiKhoan.setOpaque(false);
        btnTaiKhoan.setSVGImage("svg/circle-user-solid.svg", 35, 35);
        btnTaiKhoan.setColor(Color.ORANGE);
        btnCaiDat.setOpaque(false);
        btnCaiDat.setSVGImage("svg/gear-solid.svg", 23, 23);
        btnCaiDat.setColor(Color.ORANGE);
        btnThongBao.setOpaque(false);
        btnThongBao.setSVGImage("svg/bell-solid.svg", 23, 23);
        btnThongBao.setColor(Color.orange);
        btnThongTin.setOpaque(false);
        btnThongTin.setSVGImage("svg/circle-info-solid.svg", 23, 23);
        btnThongTin.setColor(Color.orange);
        
        scroll.setVerticalScrollBar(new ScrollBarCustom());
//        ScrollBarCustom sp = new ScrollBarCustom();
//        sp.setOrientation(JScrollBar.HORIZONTAL);
//        scroll.setHorizontalScrollBar(sp);

//        JPanel cardItem1 = createCardItem("/img/background_login3.jpg", "Tour Châu Âu 11N10Đ: Trải Nghiệm Pháp - Thụy Sĩ - Ý",
//                "5 ngày", "D21", "22/06/2022", "20.500.000");
//        jPanel4.add(cardItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 440));


        loadListVe(dsVe);
    }
    
    private void addEvents() {
        menuBarIcon.addMouseListener(this);
        sidebarMenu.addMouseListener(this);
        
        btnTrangChu.addMouseListener(this);
        btnVeDaDat.addMouseListener(this);
        
        btnTrangChuChild.addMouseListener(this);
        btnVeDaDat.addMouseListener(this);
    }

    private void sidebarMenuShow() {
        Thread th = new Thread() {
            @Override
            public void run() {
                try
                {
                        for(sidebarMenuChildShow = sidebarMenu.getSize().width; sidebarMenuChildShow <= 175; sidebarMenuChildShow++)
                        {
                            Thread.sleep(1);
                            menuBar.setSize(sidebarMenuChildShow + 65, menuBar.getHeight()); //System.out.println(menuBar.getWidth());
                            sidebarMenu.setSize(sidebarMenuChildShow, sidebarMenu.getSize().height);
                            if(sidebarMouseHover == false)
                                break;
                        }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        };
        th.start();
    }

    private void sidebarMenuHide() {
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    for (sidebarMenuChildShow = sidebarMenu.getSize().width; sidebarMenuChildShow >= 0; sidebarMenuChildShow--) {
                        Thread.sleep(1);
                        menuBar.setSize(sidebarMenuChildShow + 65, menuBar.getHeight());  //System.out.println(menuBar.getWidth());
                        sidebarMenu.setSize(sidebarMenuChildShow, sidebarMenu.getSize().height);
                        if (sidebarMouseHover == true) {
                            break;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        th.start();
    }
    
    private JPanel createCardItem(Ve2 ve) {
        Tour tour = Tour_DAO.getTour(ve.getMaTour());
        if(tour == null)
            return null;
        
        JPanel cardItem = new JPanel(); cardItem.setName(ve.getMaVe());
        JLabel lblTT = new JLabel();
        JLabel lblTenTour = new JLabel();
        JLabel lblMT = new JLabel();
        JLabel lblMaTour = new JLabel();
        JLabel lblNgayKhoiHanh = new JLabel();
        JLabel lblGiaTour = new JLabel();
        JLabel lblMV = new JLabel();
        JLabel lblVND = new JLabel();
        JLabel lblMaVe = new JLabel();
        JLabel lblTTT = new JLabel();
        JLabel lblTrangThai = new JLabel();
        JLabel lblNKH = new JLabel();
        JLabel lblTG = new JLabel();
        JLabel lblThoiGian = new JLabel();
        JLabel lblNgayDatVe = new JLabel();
        JLabel lblTTV = new JLabel();
        JLabel lblGT = new JLabel();
        ButtonCustom btnHuyTour = new ButtonCustom();
        ButtonCustom btnXemChiTiet = new ButtonCustom();
        
        cardItem.setBackground(new Color(255, 255, 255));

        lblTT.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblTT.setForeground(new Color(102, 102, 102));
        lblTT.setText("Tên Tour");

        lblTenTour.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblTenTour.setHorizontalAlignment(SwingConstants.LEFT);
        lblTenTour.setText("<html>" + tour.getTenTour() + "</html>");
        lblTenTour.setVerticalAlignment(SwingConstants.TOP);

        lblMT.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblMT.setForeground(new Color(102, 102, 102));
        lblMT.setText("Mã Tour");

        lblMaTour.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblMaTour.setHorizontalAlignment(SwingConstants.LEFT);
        lblMaTour.setText(tour.getMaTour());

        lblMV.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblMV.setForeground(new Color(102, 102, 102));
        lblMV.setText("Mã vé");

        lblMaVe.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        lblMaVe.setForeground(new Color(255, 0, 0));
        lblMaVe.setHorizontalAlignment(SwingConstants.LEFT);
        lblMaVe.setText(ve.getMaVe());

        lblTTT.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblTTT.setForeground(new Color(102, 102, 102));
        lblTTT.setText("Trạng thái");

        lblTrangThai.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblTrangThai.setForeground(new Color(0, 204, 0));
        lblTrangThai.setHorizontalAlignment(SwingConstants.LEFT);
        lblTrangThai.setText("Chưa thanh toán");

        lblNgayKhoiHanh.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayKhoiHanh.setForeground(new Color(0, 153, 51));
        lblNgayKhoiHanh.setHorizontalAlignment(SwingConstants.LEFT);
        lblNgayKhoiHanh.setText("20/05/2022");

        lblNKH.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblNKH.setForeground(new Color(102, 102, 102));
        lblNKH.setText("Ngày khởi hành");

        lblTG.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblTG.setForeground(new Color(102, 102, 102));
        lblTG.setText("Thời gian");

        lblThoiGian.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblThoiGian.setHorizontalAlignment(SwingConstants.LEFT);
        lblThoiGian.setText(Integer.toString(tour.getSoNgay()) + " ngày");

        lblNgayDatVe.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayDatVe.setForeground(new Color(0, 102, 255));
        lblNgayDatVe.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNgayDatVe.setText(ve.getNgayDatVe());

        lblTTV.setFont(new Font("Segoe UI", 1, 17)); // NOI18N
        lblTTV.setForeground(new Color(0, 153, 51));
        lblTTV.setText("Thông tin vé");

        btnHuyTour.setBorder(null);
        btnHuyTour.setForeground(new Color(153, 153, 153));
        btnHuyTour.setText("Hủy TOUR");
        btnHuyTour.setBorderColor(new Color(204, 204, 204));
        btnHuyTour.setColorClick(new Color(245, 245, 245));
        btnHuyTour.setColorHover(new Color(245, 245, 245));
        btnHuyTour.setFont(new Font("Mulish", 1, 12)); // NOI18N
        btnHuyTour.setRadius(35);

        btnXemChiTiet.setBackground(new Color(51, 153, 255));
        btnXemChiTiet.setBorder(null);
        btnXemChiTiet.setForeground(new Color(255, 255, 255));
        btnXemChiTiet.setText("XEM CHI TIẾT");
        btnXemChiTiet.setBorderColor(new Color(240, 240, 240));
        btnXemChiTiet.setColor(new Color(51, 153, 255));
        btnXemChiTiet.setColorClick(new Color(102, 153, 255));
        btnXemChiTiet.setColorHover(new Color(102, 153, 255));
        btnXemChiTiet.setFont(new Font("Mulish", 1, 12)); // NOI18N
        btnXemChiTiet.setRadius(35);

        lblGT.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        lblGT.setForeground(new Color(255, 0, 51));
        lblGT.setText("Giá TOUR");

        lblGiaTour.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        lblGiaTour.setForeground(new Color(233, 154, 62));
        Locale localVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getNumberInstance(localVN);
        lblGiaTour.setText(vn.format(tour.getGiaTour()));

        lblVND.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        lblVND.setForeground(new Color(233, 154, 62));
        lblVND.setText("VND");

        GroupLayout cardItemLayout = new GroupLayout(cardItem);
        cardItem.setLayout(cardItemLayout);
        cardItemLayout.setHorizontalGroup(
            cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cardItemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(cardItemLayout.createSequentialGroup()
                        .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMT, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMV, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTT, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaTour, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaVe, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTour, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTG, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblNKH, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblTTT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addGroup(cardItemLayout.createSequentialGroup()
                                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNgayKhoiHanh, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblThoiGian, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(238, 238, 238))
                    .addGroup(GroupLayout.Alignment.TRAILING, cardItemLayout.createSequentialGroup()
                        .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblTTV)
                            .addGroup(cardItemLayout.createSequentialGroup()
                                .addComponent(lblGT, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGiaTour)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVND, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, cardItemLayout.createSequentialGroup()
                                .addComponent(btnHuyTour, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXemChiTiet, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNgayDatVe, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
        cardItemLayout.setVerticalGroup(
            cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(cardItemLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTTV)
                    .addComponent(lblNgayDatVe))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMV)
                    .addComponent(lblTTT)
                    .addComponent(lblMaVe)
                    .addComponent(lblTrangThai))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMT)
                    .addComponent(lblNKH)
                    .addComponent(lblMaTour)
                    .addComponent(lblNgayKhoiHanh))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTT)
                        .addComponent(lblTG)
                        .addComponent(lblThoiGian))
                    .addComponent(lblTenTour, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaTour)
                    .addComponent(lblVND)
                    .addComponent(lblGT)
                    .addGroup(cardItemLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHuyTour, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXemChiTiet, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        
        cardItem.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                cardItem.setBackground(new Color(240, 240, 240));
                cardItem.setBorder(BorderFactory.createLineBorder(new Color(51, 153, 255)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cardItem.setBackground(new Color(255, 255, 255));
                cardItem.setBorder(BorderFactory.createLineBorder(new Color(247, 248, 250)));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                FrmTTCTVe frmVe = new FrmTTCTVe(ve);
                frmVe.setVisible(true);
            }
            
        });
        
        btnXemChiTiet.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                FrmTTCTVe frmVe = new FrmTTCTVe(ve);
                frmVe.setVisible(true);
            }
        
        });
        
        btnHuyTour.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Bạn có chắn chắn muốn hủy Tour này?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION)
                {
                    if(Ve_DAO.removeVe(ve.getMaVe()))
                    {
                        dsVe = Ve_DAO.getAllVe();
                        loadListVe(dsVe);
                        JOptionPane.showMessageDialog(null, "Hủy vé thành công");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Hủy vé không thành công");
                }
            }
        
        });
        
        
        return cardItem;
    }
     
    public Ve2 getVe(String maVe) {
        Ve2 ve = new Ve2(maVe);
        int index = dsVe.indexOf(ve);
        if(index >= 0)
            return dsVe.get(index);
        return null;
    }
    
    public void loadListVe(List<Ve2> ves) {

        pnBody.removeAll();
        
        if(ves.size() > 0)
        {
            cardItems = new JPanel[ves.size()];
            
            for(int i = 0; i < ves.size(); i++)
            {
                Locale localVN = new Locale("vi", "VN");
                NumberFormat vn = NumberFormat.getInstance(localVN);

                Ve2 ve = ves.get(i);

                cardItems[i] = createCardItem(ve);
                pnBody.add(cardItems[i], new AbsoluteConstraints(
                        40, 
                        30 + i * (cardItemHeight + marginCenterItem), 
                        cardItemWidth, cardItemHeight));
            }
        }
        else
        {
            JLabel lblError = new JLabel();
            lblError.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblError.setForeground(new java.awt.Color(153, 153, 153));
            lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblError.setText("Không có Tour đã đặt nào để hiển thị");
            pnBody.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 320, -1));
        }
        
        pnBody.revalidate();
    }
    
    
    
    
    
    
    
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTourDaDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTourDaDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTourDaDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTourDaDat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTourDaDat().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.SVGImage btnCaiDat;
    private custom_components.SVGImage btnTaiKhoan;
    private custom_components.SVGImage btnThongBao;
    private custom_components.SVGImage btnThongTin;
    private javax.swing.JPanel btnTrangChu;
    private javax.swing.JPanel btnTrangChuChild;
    private javax.swing.JPanel btnVeDaDat;
    private javax.swing.JPanel btnVeDaDatChild;
    private custom_components.SVGImage iconTrangChu;
    private custom_components.SVGImage iconVeDaDat;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblVeDaDat;
    private custom_components.SVGImage logo;
    private javax.swing.JPanel menuBar;
    private javax.swing.JPanel menuBarIcon;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel sidebarMenu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object o = e.getSource();

        
        if(o.equals(btnTaiKhoan))
        {
            Application.frmQLTTTaiKhoan.setVisible(true);
        }
        else if(o.equals(btnThongBao))
        {
            Application.frmThongBao.setVisible(true);
        }
        else if(o.equals(btnThongTin))
        {
            Application.frmThongTin.setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object o = e.getSource();
        
        if(o.equals(btnTrangChu) || o.equals(btnVeDaDat) || o.equals(btnTrangChuChild) || o.equals(btnVeDaDatChild)
                || o.equals(lblTrangChu) || o.equals(lblVeDaDat) || o.equals(iconTrangChu) || o.equals(iconVeDaDat)) {
            JPanel jPanel = (JPanel)o;
            jPanel.setBackground(mouseHoverColor);
            sidebarMouseHover = true;
            sidebarMenuShow();
        }
        
        else if(o.equals(menuBarIcon) || o.equals(sidebarMenu))
        {
            sidebarMouseHover = true;
            sidebarMenuShow();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object o = e.getSource();
        
        if(o.equals(btnTrangChu) || o.equals(btnVeDaDat) || o.equals(btnTrangChuChild) || o.equals(btnVeDaDatChild)
                || o.equals(lblTrangChu) || o.equals(lblVeDaDat) || o.equals(iconTrangChu) || o.equals(iconVeDaDat)) {
            JPanel jPanel = (JPanel)o;
            jPanel.setBackground(sidebarMenuColor);
            sidebarMouseHover = false;
            sidebarMenuHide();
        }

        else if(o.equals(menuBarIcon) || o.equals(sidebarMenu))
        {
            sidebarMouseHover = false;
            sidebarMenuHide();
        }
    }
}
