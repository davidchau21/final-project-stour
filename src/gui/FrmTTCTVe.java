/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;


import entity.Ve2;
import entity.TaiKhoanKH;
import entity.DuKhach;
import utils.RandomString;
import connectDB.ConnectDB;
import dao.Ve_DAO;
import dao.DuKhach_DAO;
import dao.TaiKhoanKH_DAO;
import dao.Tour_DAO;
import entity.Tour;
import java.util.Locale;
import java.text.NumberFormat;
import app.Application;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class FrmTTCTVe extends javax.swing.JFrame {

    private Ve2 ve;
    
    public FrmTTCTVe() {
        initComponents();
        
        ConnectDB.connect();
        
        addControls();
        
    }

  
    public FrmTTCTVe(Tour tour) {
        initComponents();
        
        String tenTK = Application.taiKhoanKH.getTenTK();
        String maTour = tour.getMaTour();
        
        TaiKhoanKH taiKhoanKH = TaiKhoanKH_DAO.getTaiKhoanKH(tenTK);
        DuKhach duKhach;
        
        if(taiKhoanKH != null && tour != null)
        {
            duKhach = DuKhach_DAO.getDuKhach(taiKhoanKH.getMaDK());
            
            if(duKhach != null)
            {
                RandomString randString = new RandomString();
                String maVe = randString.randomAlphaNumeric(10);
                ve = new Ve2(maVe, tenTK, maTour, java.util.Calendar.getInstance().getTime().toString(), "");
                
                ImageIcon imageIcon = new ImageIcon(getClass().getResource(tour.getGhiChu()));
                Image image = imageIcon.getImage().getScaledInstance(300,300 * imageIcon.getIconHeight() / imageIcon.getIconWidth(), Image.SCALE_DEFAULT);
                ImageIcon imageIcon1 = new ImageIcon(image);
                imageTour.setIcon(imageIcon1);
                
                lblMaKH.setText(duKhach.getMaDK());
                lblHoTen.setText(duKhach.getTenDK());
                lblSDT.setText(duKhach.getSDT());
                lblEmail.setText(duKhach.getEmail());           
                lblMaVe.setText(ve.getMaVe());
                lblMaTour.setText(tour.getMaTour());
                lblTenTour.setText("<html>" + tour.getTenTour() + "</html>");
                lblThoiGian.setText(Integer.toString(tour.getSoNgay()) + " ngày");
                lblNgayDatVe.setText(ve.getNgayDatVe());

                Locale localVN = new Locale("vi", "VN");
                NumberFormat vn = NumberFormat.getInstance(localVN);

                lblGiaTour.setText(vn.format(tour.getGiaTour()));
            }
        }
    }
    
    public FrmTTCTVe(Ve2 ve) {
        initComponents();
        
        btnHuyBo.setVisible(false);
        btnXacNhanDatTour.setVisible(false);
        
        String tenTK = Application.taiKhoanKH.getTenTK();
        String maTour = ve.getMaTour();
        
        TaiKhoanKH taiKhoanKH = TaiKhoanKH_DAO.getTaiKhoanKH(tenTK);
        Tour tour = Tour_DAO.getTour(maTour);
        DuKhach duKhach;
        
        if(taiKhoanKH != null && tour != null)
        {
            duKhach = DuKhach_DAO.getDuKhach(taiKhoanKH.getMaDK());
            
            if(duKhach != null)
            {
                ve = new Ve2(ve.getMaVe(), tenTK, maTour, java.util.Calendar.getInstance().getTime().toString(), "");
                
                ImageIcon imageIcon = new ImageIcon(getClass().getResource(tour.getGhiChu()));
                Image image = imageIcon.getImage().getScaledInstance(300,300 * imageIcon.getIconHeight() / imageIcon.getIconWidth(), Image.SCALE_DEFAULT);
                ImageIcon imageIcon1 = new ImageIcon(image);
                imageTour.setIcon(imageIcon1);
                
                lblMaKH.setText(duKhach.getMaDK());
                lblHoTen.setText(duKhach.getTenDK());
                lblSDT.setText(duKhach.getSDT());
                lblEmail.setText(duKhach.getEmail());           
                lblMaVe.setText(ve.getMaVe());
                lblMaTour.setText(tour.getMaTour());
                lblTenTour.setText("<html>" + tour.getTenTour() + "</html>");
                lblThoiGian.setText(Integer.toString(tour.getSoNgay()) + " ngày");
                lblNgayDatVe.setText(ve.getNgayDatVe());

                Locale localVN = new Locale("vi", "VN");
                NumberFormat vn = NumberFormat.getInstance(localVN);

                lblGiaTour.setText(vn.format(tour.getGiaTour()));
            }
        }
    }
    
    private void addControls() {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        imageTour = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNgayDatVe = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblMaTour = new javax.swing.JLabel();
        lblMaVe = new javax.swing.JLabel();
        lblTenTour = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblThoiGian = new javax.swing.JLabel();
        lblNgayKhoiHanh = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblGiaTour = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnXacNhanDatTour = new custom_components.ButtonCustom();
        btnHuyBo = new custom_components.ButtonCustom();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(910, 50));

        jLabel1.setFont(new java.awt.Font("Mulish Black", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin chi tiết vé");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(247, 248, 250));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel16.setText("Thông tin khách hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Email");

        lblHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHoTen.setText("Nguyen Thanh Tam");

        lblMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaKH.setText("20019561");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSDT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSDT.setText("0966002637");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmail.setText("thanhtam1102@hotmail.com");

        imageTour.setText("jLabel6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageTour, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblMaKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblHoTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblSDT))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblEmail)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(imageTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 51));
        jLabel17.setText("Thông tin vé");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Mã vé");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Mã Tour");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Tên Tour");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Trạng thái");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Ngày khởi hành");

        lblNgayDatVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayDatVe.setForeground(new java.awt.Color(0, 102, 255));
        lblNgayDatVe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayDatVe.setText("Ngày đặt vé: 12/05/2022");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Thời gian");

        lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaTour.setText("20019561");

        lblMaVe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaVe.setForeground(new java.awt.Color(255, 0, 0));
        lblMaVe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMaVe.setText("20019561");

        lblTenTour.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenTour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenTour.setText("20019561");
        lblTenTour.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(0, 204, 0));
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTrangThai.setText("Chưa thanh toán");

        lblThoiGian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblThoiGian.setText("20019561");

        lblNgayKhoiHanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayKhoiHanh.setForeground(new java.awt.Color(0, 153, 51));
        lblNgayKhoiHanh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNgayKhoiHanh.setText("20/05/2022");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNgayDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblNgayDatVe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(lblMaVe)
                    .addComponent(lblTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(lblMaTour)
                    .addComponent(lblNgayKhoiHanh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(lblThoiGian))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTenTour, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblGiaTour.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblGiaTour.setForeground(new java.awt.Color(233, 154, 62));
        lblGiaTour.setText("10.000.000");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(233, 154, 62));
        jLabel21.setText("VND");

        btnXacNhanDatTour.setBackground(new java.awt.Color(51, 153, 255));
        btnXacNhanDatTour.setBorder(null);
        btnXacNhanDatTour.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanDatTour.setText("XÁC NHẬN ĐẶT TOUR");
        btnXacNhanDatTour.setBorderColor(new java.awt.Color(240, 240, 240));
        btnXacNhanDatTour.setColor(new java.awt.Color(51, 153, 255));
        btnXacNhanDatTour.setColorClick(new java.awt.Color(102, 153, 255));
        btnXacNhanDatTour.setColorHover(new java.awt.Color(102, 153, 255));
        btnXacNhanDatTour.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnXacNhanDatTour.setRadius(40);
        btnXacNhanDatTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXacNhanDatTourMousePressed(evt);
            }
        });

        btnHuyBo.setBorder(null);
        btnHuyBo.setForeground(new java.awt.Color(153, 153, 153));
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.setBorderColor(new java.awt.Color(204, 204, 204));
        btnHuyBo.setColorClick(new java.awt.Color(245, 245, 245));
        btnHuyBo.setColorHover(new java.awt.Color(245, 245, 245));
        btnHuyBo.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnHuyBo.setRadius(45);
        btnHuyBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHuyBoMousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("Giá TOUR");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGiaTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXacNhanDatTour, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGiaTour)
                        .addComponent(jLabel21)
                        .addComponent(jLabel19))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXacNhanDatTour, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanDatTourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXacNhanDatTourMousePressed
        if(Ve_DAO.addVe(ve))
        {
            FrmTBDatTourThanhCong frmTBDatTourThanhCong = new FrmTBDatTourThanhCong();
            frmTBDatTourThanhCong.setVisible(true);
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Đặt Tour không thành công");
    }//GEN-LAST:event_btnXacNhanDatTourMousePressed

    private void btnHuyBoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyBoMousePressed
        this.dispose();
    }//GEN-LAST:event_btnHuyBoMousePressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTTCTVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTTCTVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTTCTVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTTCTVe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTTCTVe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnHuyBo;
    private custom_components.ButtonCustom btnXacNhanDatTour;
    private javax.swing.JLabel imageTour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGiaTour;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblMaTour;
    private javax.swing.JLabel lblMaVe;
    private javax.swing.JLabel lblNgayDatVe;
    private javax.swing.JLabel lblNgayKhoiHanh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenTour;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JLabel lblTrangThai;
    // End of variables declaration//GEN-END:variables
}
