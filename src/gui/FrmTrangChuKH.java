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
import java.awt.Color;

import java.util.Arrays;

import entity.Tour;
import dao.Tour_DAO;
import connectDB.ConnectDB;
import java.util.Locale;
import java.text.NumberFormat;
import utils.VNCharacterUtils;


/**
 *
 * @author Asus
 */
public class FrmTrangChuKH extends javax.swing.JFrame implements MouseListener {

    private Color mouseHoverColor = new Color(45, 45, 45);
    private Color sidebarMenuColor = new Color(40, 50, 60);
    private Color mouseClickColor = new Color(0, 0, 0);
    private Color tabPanelHoverColor = new Color(230, 230, 230);
    private Color tabPanelLeaveColor = new Color(255, 255, 255);
    private Color lineTabHoverColor = new Color(51, 153, 255);
    private Color lineTabLeaveColor = new Color(255, 255, 255);

    private Color labelColor = new Color(153, 153, 153);
    private Color labelFocusColor = Color.BLUE;
    private Object listTextbox[];
    private JLabel listLabelForTextBox[];
    private JLabel listLineForTextBox[];

    private Object tabSelected;
    
    private List<Tour> dsTour;
    
    private int itemsInLine = 3;
    private int marginCenterItem = 30;
    private int cardItemWidth = 320;
    private int cardItemHeigh = 440;
    private JPanel[] cardItems;
    private String[] images = new String[] {"/img/ivivu-cau-chapel.gif", "/img/ivivu-cau-than-tho.gif", "/img/ivivu-cay-cau-ponte-vecchio.gif",
                                            "/img/ivivu-dai-kenh-grand-canal.gif", "/img/ivivu-dai-phun-nuoc-trevi-roma.gif", "/img/ivivu-dau-truong-coloseum.gif",
                                            "/img/ivivu-dong-song-seine-2.gif", "/img/ivivu-ho-lucerne.gif", "/img/ivivu-quang-truong-saint-peter.gif",
                                           "/img/ivivu-strasbourg-petite-france.gif", "/img/ivivu-venice-tren-thuyen-gondola.gif", "/img/ivivu-zermatt.gif"};

    /**
     * Creates new form frmQLNV
     */
    public FrmTrangChuKH() {
        initComponents();
        
        ConnectDB.connect();
        dsTour = Tour_DAO.getAllTour();
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
        pnChucNang = new javax.swing.JPanel();
        txtTimKiem = new custom_components.TextFieldSuggestion();
        btnTimKiem = new custom_components.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        cbxSapXep = new custom_components.ComboBoxSuggestion();
        lblSoLuongKetQuaTimKiem = new javax.swing.JLabel();
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
        btnVeDaDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVeDaDatMousePressed(evt);
            }
        });

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
        btnVeDaDatChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVeDaDatChildMousePressed(evt);
            }
        });

        lblVeDaDat.setFont(new java.awt.Font("Segoe UI", 0, 19)); // NOI18N
        lblVeDaDat.setForeground(new java.awt.Color(255, 255, 255));
        lblVeDaDat.setText("Vé đã đặt");

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
        lblPageTitle.setText("Trang chủ");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 686, Short.MAX_VALUE)
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

        pnChucNang.setPreferredSize(new java.awt.Dimension(1121, 70));

        txtTimKiem.setForeground(new java.awt.Color(140, 140, 140));
        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTimKiem.setRound(35);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setBorder(null);
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setBorderColor(new java.awt.Color(255, 255, 255));
        btnTimKiem.setColor(new java.awt.Color(0, 153, 255));
        btnTimKiem.setColorClick(new java.awt.Color(0, 153, 255));
        btnTimKiem.setColorHover(new java.awt.Color(102, 153, 255));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setRadius(35);
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTimKiemMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Sắp xếp:");

        cbxSapXep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tăng dần theo giá Tour", "Giảm dần theo giá Tour" }));
        cbxSapXep.setSelectedIndex(1);
        cbxSapXep.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbxSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSapXepActionPerformed(evt);
            }
        });

        lblSoLuongKetQuaTimKiem.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSoLuongKetQuaTimKiem.setForeground(new java.awt.Color(102, 102, 102));
        lblSoLuongKetQuaTimKiem.setText("Đã tìm thấy 2 tour phù hợp");

        javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
        pnChucNang.setLayout(pnChucNangLayout);
        pnChucNangLayout.setHorizontalGroup(
            pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChucNangLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChucNangLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblSoLuongKetQuaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnChucNangLayout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        pnChucNangLayout.setVerticalGroup(
            pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChucNangLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSoLuongKetQuaTimKiem))
        );

        jPanel3.add(pnChucNang, java.awt.BorderLayout.PAGE_START);

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

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbxSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSapXepActionPerformed
        int type = cbxSapXep.getSelectedIndex();
        if(type >= 0) 
            sapXepListTour(type);
    }//GEN-LAST:event_cbxSapXepActionPerformed

    private void btnTimKiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMousePressed
        String strTimKiem = txtTimKiem.getText().trim();
        if(!strTimKiem.isEmpty())
        {
            List<Tour> tours = timKiemTour(strTimKiem);
            System.out.println(tours.size());
            loadListTour(tours);
            if(tours.size() > 0)
                sapXepListTour(cbxSapXep.getSelectedIndex());
        }
        else
        {
            loadListTour(dsTour);
            sapXepListTour(cbxSapXep.getSelectedIndex());
        }
    }//GEN-LAST:event_btnTimKiemMousePressed

    private void btnVeDaDatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVeDaDatMousePressed
        Application.frmTourDaDat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVeDaDatMousePressed

    private void btnVeDaDatChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVeDaDatChildMousePressed
        Application.frmTourDaDat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVeDaDatChildMousePressed

    private int sidebarMenuChildShow = 175;
    private boolean sidebarMouseHover = false;
    private int sidebarIconWidth = 23;
    private int sidebarIconHeigth = 23;
    private Color sidebarIconColor = Color.WHITE;

    private void addControls() {

        btnTimKiem.setSVGImage("svg/search.svg", 20, 20, Color.WHITE);
        
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

        for (Tour tour : dsTour) {
            txtTimKiem.addItemSuggestion(tour.getTenTour());
        }

        loadListTour(dsTour);
        sapXepListTour(cbxSapXep.getSelectedIndex());
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
    
    private JPanel createCardItem(String cardImageURL, String tenTour, String thoiGian, String maTour, String ngayKhoiHanh, String giaTour) {
        JPanel panel = new JPanel(); panel.setName(maTour);
        JLabel cardImage = new JLabel();
        JLabel lblTenTour = new JLabel();
        JLabel lblThoiGian = new JLabel();
        JLabel lblThoiGianValue = new JLabel();
        JLabel lblMaTour = new JLabel();
        JLabel lblNgayKhoiHanh = new JLabel();
        JLabel lblGiaTour = new JLabel();
        JLabel lblGiaTourValue = new JLabel();
        JLabel lblVND = new JLabel();
        
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        
        cardImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(cardImageURL))); // "/img/background_login3.jpg"
        
        lblTenTour.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTenTour.setForeground(new java.awt.Color(61, 95, 123));
        lblTenTour.setText("<html>" + tenTour + "</html>");

        lblThoiGian.setBackground(new java.awt.Color(231, 231, 231));
        lblThoiGian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        lblThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoiGian.setText("Thời gian");
        lblThoiGian.setOpaque(true);

        lblThoiGianValue.setBackground(new java.awt.Color(85, 85, 85));
        lblThoiGianValue.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        lblThoiGianValue.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGianValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoiGianValue.setText(thoiGian + " ngày");
        lblThoiGianValue.setOpaque(true);

        lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMaTour.setForeground(new java.awt.Color(40, 163, 181));
        lblMaTour.setText("Mã tour: " + maTour);

        lblNgayKhoiHanh.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNgayKhoiHanh.setForeground(new java.awt.Color(40, 163, 181));
        lblNgayKhoiHanh.setText("Ngay khoi hanh: " + ngayKhoiHanh);

        lblGiaTour.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGiaTour.setForeground(new java.awt.Color(255, 0, 51));
        lblGiaTour.setText("Giá TOUR");

        lblGiaTourValue.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblGiaTourValue.setForeground(new java.awt.Color(233, 154, 62));
        lblGiaTourValue.setText(giaTour);

        lblVND.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblVND.setForeground(new java.awt.Color(233, 154, 62));
        lblVND.setText("VND");

        
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(cardImage, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgayKhoiHanh, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTour, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                                    .addComponent(lblThoiGian, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(lblThoiGianValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lblMaTour, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lblGiaTour, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGiaTourValue)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVND, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(cardImage, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenTour, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblThoiGian, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThoiGianValue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaTour)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgayKhoiHanh)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaTour)
                    .addComponent(lblGiaTourValue)
                    .addComponent(lblVND))
                .addGap(0, 19, Short.MAX_VALUE))
        );


        //jPanel4.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 440));
        
        panel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(new Color(240, 240, 240));
                panel.setBorder(BorderFactory.createLineBorder(new Color(51, 153, 255)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panel.setBackground(new Color(255, 255, 255));
                panel.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                String maTour = ((JPanel)e.getSource()).getName();
                Tour tour = getTour(maTour);
                
                FrmThongTinTour frmTour = new FrmThongTinTour(tour);
                frmTour.setVisible(true);
            }
            
        });
        
        
        return panel;
    }
    
    public List<Tour> timKiemTour(String strTimKiem) {
        List<Tour> ketQuaTimKiem = new ArrayList<Tour>();
        String newStrTimKiem = VNCharacterUtils.removeAccent(strTimKiem).toLowerCase();
        
        for (Tour tour : dsTour) 
        {
            if(VNCharacterUtils.removeAccent(tour.getTenTour()).toLowerCase().contains(newStrTimKiem))
                ketQuaTimKiem.add(tour);
                
        }
        return ketQuaTimKiem;
    }
    
    public Tour getTour(String maTour) {
        Tour tour = new Tour(maTour);
        int index = dsTour.indexOf(tour);
        if(index >= 0)
            return dsTour.get(index);
        return null;
    }
    
    public void loadListTour(List<Tour> tours) {
        lblSoLuongKetQuaTimKiem.setText("Đã tìm thấy " + tours.size() + " Tour phù hợp");
        
        pnBody.removeAll();
        
        if(tours.size() > 0)
        {
            cardItems = new JPanel[tours.size()];
            
            int row = 1;
            int col = 1;
            for(int i = 1; i <= tours.size(); i++)
            {
                Locale localVN = new Locale("vi", "VN");
                NumberFormat vn = NumberFormat.getInstance(localVN);

                Tour tour = tours.get(i - 1);

                cardItems[i - 1] = createCardItem(tour.getGhiChu(), tour.getTenTour()
                        , Integer.toString(tour.getSoNgay()), tour.getMaTour(), "20/11/2022"
                        , vn.format(tour.getGiaTour()));
                pnBody.add(cardItems[i - 1], new org.netbeans.lib.awtextra.AbsoluteConstraints(
                        50 + (col - 1) * (cardItemWidth + marginCenterItem), 
                        30 + (row - 1) * (cardItemHeigh + marginCenterItem), 
                        cardItemWidth, cardItemHeigh));

                col++;
                if(i % itemsInLine == 0)
                {
                    row++;
                    col = 1;
                }
            }
        }
        else
        {
            JLabel lblError = new JLabel();
             lblError.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblError.setForeground(new java.awt.Color(153, 153, 153));
            lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblError.setText("Không có Tour nào để hiển thị");
            pnBody.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 320, -1));
        }
        
        pnBody.revalidate();
    }
    
    private void sapXepListTour(int type) {
       
        List<String> dsMaTour = new ArrayList<String>();
        
        for(int i = 0; i < cardItems.length; i++)
            dsMaTour.add(cardItems[i].getName());
        
        List<Tour> tours = new ArrayList<Tour>();
        for (String maTour : dsMaTour) {
            Tour tour = getTour(maTour);
            if(tour != null)
                tours.add(tour);
        }
        
        if(tours.size() > 0)
        {
            if(type == 0)
            {
                for(int i = 0; i < tours.size() - 1; i++)
                    for(int j = i + 1; j < tours.size(); j++)
                    {
                        if(tours.get(i).getGiaTour() > tours.get(j).getGiaTour())
                        {
                            Tour temp = tours.get(i);
                            tours.set(i, tours.get(j));
                            tours.set(j, temp);
                        }
                    }
            }
            else if(type == 1)
            {
                for(int i = 0; i < tours.size() - 1; i++)
                    for(int j = i + 1; j < tours.size(); j++)
                    {
                        if(tours.get(i).getGiaTour() < tours.get(j).getGiaTour())
                        {
                            Tour temp = tours.get(i);
                            tours.set(i, tours.get(j));
                            tours.set(j, temp);
                        }
                    }
            }
            
            loadListTour(tours);
        }
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
            java.util.logging.Logger.getLogger(FrmTrangChuKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChuKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChuKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTrangChuKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmTrangChuKH().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.SVGImage btnCaiDat;
    private custom_components.SVGImage btnTaiKhoan;
    private custom_components.SVGImage btnThongBao;
    private custom_components.SVGImage btnThongTin;
    private custom_components.ButtonCustom btnTimKiem;
    private javax.swing.JPanel btnTrangChu;
    private javax.swing.JPanel btnTrangChuChild;
    private javax.swing.JPanel btnVeDaDat;
    private javax.swing.JPanel btnVeDaDatChild;
    private custom_components.ComboBoxSuggestion cbxSapXep;
    private custom_components.SVGImage iconTrangChu;
    private custom_components.SVGImage iconVeDaDat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblSoLuongKetQuaTimKiem;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTrangChu;
    private javax.swing.JLabel lblVeDaDat;
    private custom_components.SVGImage logo;
    private javax.swing.JPanel menuBar;
    private javax.swing.JPanel menuBarIcon;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnChucNang;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnTitle;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel sidebarMenu;
    private custom_components.TextFieldSuggestion txtTimKiem;
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
