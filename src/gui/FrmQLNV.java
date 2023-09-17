/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import model_table.ModelTableNhanVien;
import model_table.TableNhanVien;
import custom_components.SVGImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Asus
 */
public class FrmQLNV extends javax.swing.JFrame {

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
    
    /**
     * Creates new form frmQLNV
     */
    public FrmQLNV() {
        initComponents();
        
        addControls();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cardItem2 = new custom_components.PanelCustom();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonCustom1 = new custom_components.ButtonCustom();
        pnCardItem = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblTenTour = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cardItem = new javax.swing.JPanel();
        lblTT = new javax.swing.JLabel();
        lblTenTour1 = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        lblMaTour = new javax.swing.JLabel();
        lblMV = new javax.swing.JLabel();
        lblMaVe = new javax.swing.JLabel();
        lblTTT = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblNgayKhoiHanh = new javax.swing.JLabel();
        lblNKH = new javax.swing.JLabel();
        lblTG = new javax.swing.JLabel();
        lblThoiGian = new javax.swing.JLabel();
        lblNgayDatVe = new javax.swing.JLabel();
        lblTTV = new javax.swing.JLabel();
        btnHuyTour = new custom_components.ButtonCustom();
        btnXemChiTiet = new custom_components.ButtonCustom();
        lblGT = new javax.swing.JLabel();
        lblGiaTour = new javax.swing.JLabel();
        lblVND = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý tour du lịch");
        setMaximumSize(new java.awt.Dimension(300, 400));
        setMinimumSize(new java.awt.Dimension(300, 400));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 400));
        setSize(new java.awt.Dimension(300, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardItem2.setBackground(new java.awt.Color(255, 255, 255));
        cardItem2.setBorderColor(new java.awt.Color(204, 204, 204));
        cardItem2.setColorClick(new java.awt.Color(240, 240, 240));
        cardItem2.setColorHover(new java.awt.Color(240, 240, 240));

        jLabel2.setFont(new java.awt.Font("Mulish ExtraBold", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ÐÀ LAT");

        jLabel3.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        jLabel3.setText("Gia ve 500.000vnd");

        jLabel4.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        jLabel4.setText("Ngay khoi hanh: 24/05/2022");

        jLabel5.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        jLabel5.setText("Ma tour: DL123");

        jLabel6.setFont(new java.awt.Font("Mulish Light", 0, 14)); // NOI18N
        jLabel6.setText("Thoi gian tour: 2 ngày 1 dem");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_login3.jpg"))); // NOI18N

        buttonCustom1.setBorder(null);
        buttonCustom1.setText("XEM THONG TIN CHI TIET");
        buttonCustom1.setBorderColor(new java.awt.Color(255, 153, 0));
        buttonCustom1.setFont(new java.awt.Font("Mulish Light", 0, 12)); // NOI18N
        buttonCustom1.setRadius(35);

        javax.swing.GroupLayout cardItem2Layout = new javax.swing.GroupLayout(cardItem2);
        cardItem2.setLayout(cardItem2Layout);
        cardItem2Layout.setHorizontalGroup(
            cardItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardItem2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardItem2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(cardItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardItem2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        cardItem2Layout.setVerticalGroup(
            cardItem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardItem2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(buttonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(cardItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 300, 410));

        pnCardItem.setBackground(new java.awt.Color(255, 255, 255));
        pnCardItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_login3.jpg"))); // NOI18N

        lblTenTour.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTenTour.setForeground(new java.awt.Color(61, 95, 123));
        lblTenTour.setText("Tour Châu Âu 11N10Đ: Trải Nghiệm");

        jLabel8.setBackground(new java.awt.Color(231, 231, 231));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Thời gian");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(85, 85, 85));
        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("4 ngày 3 đêm");
        jLabel9.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(40, 163, 181));
        jLabel10.setText("Ma tour: DL123");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(40, 163, 181));
        jLabel11.setText("Ngay khoi hanh: 24/05/2022");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Giá TOUR");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(233, 154, 62));
        jLabel13.setText("10.000.000");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(233, 154, 62));
        jLabel14.setText("VND");

        javax.swing.GroupLayout pnCardItemLayout = new javax.swing.GroupLayout(pnCardItem);
        pnCardItem.setLayout(pnCardItemLayout);
        pnCardItemLayout.setHorizontalGroup(
            pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pnCardItemLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCardItemLayout.createSequentialGroup()
                        .addGroup(pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCardItemLayout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnCardItemLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        pnCardItemLayout.setVerticalGroup(
            pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardItemLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel1.add(pnCardItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 320, 440));

        cardItem.setBackground(new java.awt.Color(255, 255, 255));

        lblTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTT.setForeground(new java.awt.Color(102, 102, 102));
        lblTT.setText("Tên Tour");

        lblTenTour1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenTour1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenTour1.setText("20019561");
        lblTenTour1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblMT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMT.setForeground(new java.awt.Color(102, 102, 102));
        lblMT.setText("Mã Tour");

        lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaTour.setText("20019561");

        lblMV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMV.setForeground(new java.awt.Color(102, 102, 102));
        lblMV.setText("Mã vé");

        lblMaVe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaVe.setForeground(new java.awt.Color(255, 0, 0));
        lblMaVe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaVe.setText("20019561");

        lblTTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTTT.setForeground(new java.awt.Color(102, 102, 102));
        lblTTT.setText("Trạng thái");

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(0, 204, 0));
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTrangThai.setText("Chưa thanh toán");

        lblNgayKhoiHanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayKhoiHanh.setForeground(new java.awt.Color(0, 153, 51));
        lblNgayKhoiHanh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayKhoiHanh.setText("20/05/2022");

        lblNKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNKH.setForeground(new java.awt.Color(102, 102, 102));
        lblNKH.setText("Ngày khởi hành");

        lblTG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTG.setForeground(new java.awt.Color(102, 102, 102));
        lblTG.setText("Thời gian");

        lblThoiGian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblThoiGian.setText("20019561");

        lblNgayDatVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayDatVe.setForeground(new java.awt.Color(0, 102, 255));
        lblNgayDatVe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayDatVe.setText("Ngày đặt vé: 12/05/2022");

        lblTTV.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblTTV.setForeground(new java.awt.Color(0, 153, 51));
        lblTTV.setText("Thông tin vé");

        btnHuyTour.setBorder(null);
        btnHuyTour.setForeground(new java.awt.Color(153, 153, 153));
        btnHuyTour.setText("Hủy TOUR");
        btnHuyTour.setBorderColor(new java.awt.Color(204, 204, 204));
        btnHuyTour.setColorClick(new java.awt.Color(245, 245, 245));
        btnHuyTour.setColorHover(new java.awt.Color(245, 245, 245));
        btnHuyTour.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnHuyTour.setRadius(35);
        btnHuyTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHuyTourMousePressed(evt);
            }
        });

        btnXemChiTiet.setBackground(new java.awt.Color(51, 153, 255));
        btnXemChiTiet.setBorder(null);
        btnXemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("XEM CHI TIẾT");
        btnXemChiTiet.setBorderColor(new java.awt.Color(240, 240, 240));
        btnXemChiTiet.setColor(new java.awt.Color(51, 153, 255));
        btnXemChiTiet.setColorClick(new java.awt.Color(102, 153, 255));
        btnXemChiTiet.setColorHover(new java.awt.Color(102, 153, 255));
        btnXemChiTiet.setFont(new java.awt.Font("Mulish", 1, 12)); // NOI18N
        btnXemChiTiet.setRadius(35);
        btnXemChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXemChiTietMousePressed(evt);
            }
        });

        lblGT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGT.setForeground(new java.awt.Color(255, 0, 51));
        lblGT.setText("Giá TOUR");

        lblGiaTour.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGiaTour.setForeground(new java.awt.Color(233, 154, 62));
        lblGiaTour.setText("10.000.000");

        lblVND.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVND.setForeground(new java.awt.Color(233, 154, 62));
        lblVND.setText("VND");

        javax.swing.GroupLayout cardItemLayout = new javax.swing.GroupLayout(cardItem);
        cardItem.setLayout(cardItemLayout);
        cardItemLayout.setHorizontalGroup(
            cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardItemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardItemLayout.createSequentialGroup()
                        .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTT, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTG, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblNKH, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblTTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardItemLayout.createSequentialGroup()
                        .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTTV)
                            .addGroup(cardItemLayout.createSequentialGroup()
                                .addComponent(lblGT, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGiaTour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVND, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardItemLayout.createSequentialGroup()
                                .addComponent(btnHuyTour, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
        cardItemLayout.setVerticalGroup(
            cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardItemLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTTV)
                    .addComponent(lblNgayDatVe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMV)
                    .addComponent(lblTTT)
                    .addComponent(lblMaVe)
                    .addComponent(lblTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMT)
                    .addComponent(lblNKH)
                    .addComponent(lblMaTour)
                    .addComponent(lblNgayKhoiHanh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTT)
                        .addComponent(lblTG)
                        .addComponent(lblThoiGian))
                    .addComponent(lblTenTour1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaTour)
                    .addComponent(lblVND)
                    .addComponent(lblGT)
                    .addComponent(btnHuyTour, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel1.add(cardItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 1040, 220));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1238, 819));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyTourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyTourMousePressed

    }//GEN-LAST:event_btnHuyTourMousePressed

    private void btnXemChiTietMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXemChiTietMousePressed

    }//GEN-LAST:event_btnXemChiTietMousePressed

    private void addControls() {
        
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
            java.util.logging.Logger.getLogger(FrmQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLNV().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnHuyTour;
    private custom_components.ButtonCustom btnXemChiTiet;
    private custom_components.ButtonCustom buttonCustom1;
    private javax.swing.JPanel cardItem;
    private custom_components.PanelCustom cardItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblGT;
    private javax.swing.JLabel lblGiaTour;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblMV;
    private javax.swing.JLabel lblMaTour;
    private javax.swing.JLabel lblMaVe;
    private javax.swing.JLabel lblNKH;
    private javax.swing.JLabel lblNgayDatVe;
    private javax.swing.JLabel lblNgayKhoiHanh;
    private javax.swing.JLabel lblTG;
    private javax.swing.JLabel lblTT;
    private javax.swing.JLabel lblTTT;
    private javax.swing.JLabel lblTTV;
    private javax.swing.JLabel lblTenTour;
    private javax.swing.JLabel lblTenTour1;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblVND;
    private javax.swing.JPanel pnCardItem;
    // End of variables declaration//GEN-END:variables
}