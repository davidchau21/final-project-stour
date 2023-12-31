/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.Tour_DAO;
import entity.Tour;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model_table.TableTour;

/**
 *
 * @author ADMIN
 */
public class FrmTour extends javax.swing.JFrame {

    
    private Color labelColor = new Color(153, 153, 153);
    private Color labelFocusColor = Color.BLUE;
    private Object listTextbox[];
    private JLabel listLabelForTextBox[];
    private JLabel listLineForTextBox[]; 
    /**
     * Creates new form FrmTour
     */
    public FrmTour() {
        initComponents();
        
        addControls();
    }
    
    
    private void setlblErroEmpty() {
        lblMaTourError.setText("");
        lblTenTourError.setText("");
        lblSoNgayError.setText("");
        lblGiaTourError.setText("");
        
    }
    
    private void addControls() {
        btnBack.setSVGImage("svg/arrow-left-solid.svg", 25, 25);
        btnBack.setColor(Color.WHITE);
        
        setlblErroEmpty();
    }
    
    private void luuTour(){
        String maTour = txtMaTour.getText().trim();
        String tenTour = txtTenTour.getText().trim();
        float giaTour = Float.parseFloat(txtGiaTour.getText().trim());
        int soNgay = Integer.parseInt(txtSoNgay.getText().trim());
        String ghiChu = txtGhiChu.getText().trim();
        if(validTour(maTour, tenTour, giaTour, soNgay)){
            Tour t = new Tour(maTour, tenTour, soNgay, giaTour, ghiChu);
            if(Tour_DAO.addTour(t)){
                FrmQLTour.loadData();
                JOptionPane.showMessageDialog(this, "Thêm Tour thành công");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Thêm Tour thất bại");
            }
        }
    }
    
    
    private boolean validTour(String ma, String ten, double gia, int ngay ){
        setlblErroEmpty();
        
        if(ma.equals("")){
            lblMaTourError.setText("Mã Tour không được để trống");
            return false;
        }
        
        if(ma.matches("T[0-9]{1,}")){
            lblMaTourError.setText("Mã tour không đúng định dạng (vd: T03)");
            return false;
        }
        Tour t = new Tour(ma.toUpperCase());
        System.out.println(t.getMaTour());
        System.out.println(TableTour.lstTour.indexOf(t));
        if(TableTour.lstTour.indexOf(t) >= 0){
            lblMaTourError.setText("Mã Tour đã tồn tại");
            return false;
        }
        
        if(ten.equals("")){
            lblTenTourError.setText("Tên Tour không được để trống");
            return false;
        }
        
        
        
        if(gia <= 200000){
            lblGiaTourError.setText("Giá tour không được dưới 200000");
            return false;
        }
        
        if(ngay<1){
            lblSoNgayError.setText("Số ngày không được nhỏ hơn 1");
            return false;
        }
        
        return true;
    }
    
    private void xoaTrang(){
        txtMaTour.setText("");
        txtTenTour.setText("");
        txtSoNgay.setText("");
        txtGiaTour.setText("");
        txtGhiChu.setText("");
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnBack = new custom_components.ButtonCustom();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblPageTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnMaTour = new javax.swing.JPanel();
        lblMaTour = new javax.swing.JLabel();
        txtMaTour = new javax.swing.JTextField();
        lineMaNhanVien = new javax.swing.JLabel();
        lblMaTourError = new javax.swing.JLabel();
        pnTenTour = new javax.swing.JPanel();
        lblTenTour = new javax.swing.JLabel();
        txtTenTour = new javax.swing.JTextField();
        lineTenTour = new javax.swing.JLabel();
        lblTenTourError = new javax.swing.JLabel();
        pnGiaTour = new javax.swing.JPanel();
        lblGiaTour = new javax.swing.JLabel();
        txtGiaTour = new javax.swing.JTextField();
        lineGiaTour = new javax.swing.JLabel();
        lblGiaTourError = new javax.swing.JLabel();
        btnXoaTrang = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnSoNgay = new javax.swing.JPanel();
        lblSoNgay = new javax.swing.JLabel();
        txtSoNgay = new javax.swing.JTextField();
        lineSoNgay = new javax.swing.JLabel();
        lblSoNgayError = new javax.swing.JLabel();
        pnGhiChu = new javax.swing.JPanel();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        lineGhiChu = new javax.swing.JLabel();
        btnLuu = new custom_components.ButtonCustom();
        btnHuy = new custom_components.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        btnBack.setBorder(null);
        btnBack.setBorderColor(new java.awt.Color(255, 255, 255));
        btnBack.setRadius(45);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(525, Short.MAX_VALUE))
        );

        pnMain.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 80));

        lblPageTitle.setFont(new java.awt.Font("Mulish ExtraBold", 1, 27)); // NOI18N
        lblPageTitle.setText("Thêm Tour");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblPageTitle)
                .addContainerGap(613, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(lblPageTitle)
                .addGap(21, 21, 21))
        );

        jPanel4.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setOpaque(false);

        pnMaTour.setBackground(new java.awt.Color(255, 255, 255));
        pnMaTour.setPreferredSize(new java.awt.Dimension(350, 83));

        lblMaTour.setBackground(new java.awt.Color(255, 204, 0));
        lblMaTour.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblMaTour.setForeground(new java.awt.Color(102, 153, 255));
        lblMaTour.setText("Mã Tour *");

        txtMaTour.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMaTour.setForeground(new java.awt.Color(51, 51, 51));
        txtMaTour.setBorder(null);
        txtMaTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaTourMouseClicked(evt);
            }
        });

        lineMaNhanVien.setBackground(new java.awt.Color(102, 153, 255));
        lineMaNhanVien.setOpaque(true);
        lineMaNhanVien.setPreferredSize(new java.awt.Dimension(400, 1));

        lblMaTourError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblMaTourError.setForeground(new java.awt.Color(255, 0, 0));
        lblMaTourError.setText("Mã tour đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnMaTourLayout = new javax.swing.GroupLayout(pnMaTour);
        pnMaTour.setLayout(pnMaTourLayout);
        pnMaTourLayout.setHorizontalGroup(
            pnMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMaTourLayout.createSequentialGroup()
                        .addComponent(lblMaTourError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnMaTourLayout.createSequentialGroup()
                        .addComponent(lineMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnMaTourLayout.createSequentialGroup()
                        .addGroup(pnMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaTour)
                            .addComponent(lblMaTour))
                        .addGap(46, 46, 46))))
        );
        pnMaTourLayout.setVerticalGroup(
            pnMaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaTourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblMaTourError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnTenTour.setBackground(new java.awt.Color(255, 255, 255));
        pnTenTour.setPreferredSize(new java.awt.Dimension(350, 77));

        lblTenTour.setBackground(new java.awt.Color(255, 204, 0));
        lblTenTour.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblTenTour.setForeground(new java.awt.Color(102, 153, 255));
        lblTenTour.setText("Tên Tour *");

        txtTenTour.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenTour.setForeground(new java.awt.Color(51, 51, 51));
        txtTenTour.setBorder(null);
        txtTenTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenTourMouseClicked(evt);
            }
        });

        lineTenTour.setBackground(new java.awt.Color(102, 153, 255));
        lineTenTour.setOpaque(true);
        lineTenTour.setPreferredSize(new java.awt.Dimension(400, 1));

        lblTenTourError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblTenTourError.setForeground(new java.awt.Color(255, 0, 0));
        lblTenTourError.setText("Tên Tour đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnTenTourLayout = new javax.swing.GroupLayout(pnTenTour);
        pnTenTour.setLayout(pnTenTourLayout);
        pnTenTourLayout.setHorizontalGroup(
            pnTenTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTenTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTenTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenTour, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnTenTourLayout.createSequentialGroup()
                        .addGroup(pnTenTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineTenTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenTour))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTenTourLayout.createSequentialGroup()
                        .addComponent(lblTenTourError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnTenTourLayout.setVerticalGroup(
            pnTenTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTenTourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblTenTourError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnGiaTour.setBackground(new java.awt.Color(255, 255, 255));
        pnGiaTour.setPreferredSize(new java.awt.Dimension(350, 77));

        lblGiaTour.setBackground(new java.awt.Color(255, 204, 0));
        lblGiaTour.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblGiaTour.setForeground(new java.awt.Color(102, 153, 255));
        lblGiaTour.setText("Giá Tour *");

        txtGiaTour.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGiaTour.setForeground(new java.awt.Color(51, 51, 51));
        txtGiaTour.setBorder(null);
        txtGiaTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGiaTourMouseClicked(evt);
            }
        });

        lineGiaTour.setBackground(new java.awt.Color(102, 153, 255));
        lineGiaTour.setOpaque(true);
        lineGiaTour.setPreferredSize(new java.awt.Dimension(400, 1));

        lblGiaTourError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblGiaTourError.setForeground(new java.awt.Color(255, 0, 0));
        lblGiaTourError.setText("Mã nhân viên đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnGiaTourLayout = new javax.swing.GroupLayout(pnGiaTour);
        pnGiaTour.setLayout(pnGiaTourLayout);
        pnGiaTourLayout.setHorizontalGroup(
            pnGiaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGiaTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGiaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaTour, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnGiaTourLayout.createSequentialGroup()
                        .addGroup(pnGiaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineGiaTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaTour))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnGiaTourLayout.createSequentialGroup()
                        .addComponent(lblGiaTourError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnGiaTourLayout.setVerticalGroup(
            pnGiaTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGiaTourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGiaTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblGiaTourError)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        btnXoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaTrang.setForeground(new java.awt.Color(170, 170, 170));
        btnXoaTrang.setText("Xóa trắng");
        btnXoaTrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXoaTrangMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTenTour, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnXoaTrang)
                .addGap(49, 49, 49))
        );

        jPanel6.setOpaque(false);

        pnSoNgay.setBackground(new java.awt.Color(255, 255, 255));
        pnSoNgay.setPreferredSize(new java.awt.Dimension(350, 77));

        lblSoNgay.setBackground(new java.awt.Color(255, 204, 0));
        lblSoNgay.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblSoNgay.setForeground(new java.awt.Color(102, 153, 255));
        lblSoNgay.setText("Số ngày *");

        txtSoNgay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSoNgay.setForeground(new java.awt.Color(51, 51, 51));
        txtSoNgay.setBorder(null);
        txtSoNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoNgayMouseClicked(evt);
            }
        });

        lineSoNgay.setBackground(new java.awt.Color(102, 153, 255));
        lineSoNgay.setOpaque(true);
        lineSoNgay.setPreferredSize(new java.awt.Dimension(400, 1));

        lblSoNgayError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSoNgayError.setForeground(new java.awt.Color(255, 0, 0));
        lblSoNgayError.setText("Mã nhân viên đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnSoNgayLayout = new javax.swing.GroupLayout(pnSoNgay);
        pnSoNgay.setLayout(pnSoNgayLayout);
        pnSoNgayLayout.setHorizontalGroup(
            pnSoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNgay, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnSoNgayLayout.createSequentialGroup()
                        .addGroup(pnSoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineSoNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgay))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnSoNgayLayout.createSequentialGroup()
                        .addComponent(lblSoNgayError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnSoNgayLayout.setVerticalGroup(
            pnSoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblSoNgayError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnGhiChu.setBackground(new java.awt.Color(255, 255, 255));
        pnGhiChu.setPreferredSize(new java.awt.Dimension(350, 61));

        lblGhiChu.setBackground(new java.awt.Color(255, 204, 0));
        lblGhiChu.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblGhiChu.setForeground(new java.awt.Color(153, 153, 153));
        lblGhiChu.setText("Ghi chú");

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(51, 51, 51));
        txtGhiChu.setBorder(null);
        txtGhiChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGhiChuMouseClicked(evt);
            }
        });

        lineGhiChu.setBackground(new java.awt.Color(102, 153, 255));
        lineGhiChu.setOpaque(true);
        lineGhiChu.setPreferredSize(new java.awt.Dimension(780, 1));

        javax.swing.GroupLayout pnGhiChuLayout = new javax.swing.GroupLayout(pnGhiChu);
        pnGhiChu.setLayout(pnGhiChuLayout);
        pnGhiChuLayout.setHorizontalGroup(
            pnGhiChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGhiChuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGhiChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnGhiChuLayout.createSequentialGroup()
                        .addGroup(pnGhiChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGhiChu))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnGhiChuLayout.setVerticalGroup(
            pnGhiChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGhiChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGhiChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnLuu.setBackground(new java.awt.Color(72, 167, 235));
        btnLuu.setBorder(null);
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("LƯU");
        btnLuu.setBorderColor(new java.awt.Color(255, 255, 255));
        btnLuu.setColor(new java.awt.Color(72, 167, 235));
        btnLuu.setColorClick(new java.awt.Color(102, 153, 255));
        btnLuu.setColorHover(new java.awt.Color(102, 153, 255));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setRadius(35);
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLuuMousePressed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 204, 204));
        btnHuy.setBorder(null);
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY");
        btnHuy.setBorderColor(new java.awt.Color(255, 255, 255));
        btnHuy.setColor(new java.awt.Color(204, 204, 204));
        btnHuy.setColorClick(new java.awt.Color(153, 153, 153));
        btnHuy.setColorHover(new java.awt.Color(153, 153, 153));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setRadius(35);
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHuyMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        pnMain.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaTourMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTourMouseClicked

    private void txtTenTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenTourMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTourMouseClicked

    private void txtGiaTourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaTourMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTourMouseClicked

    private void btnXoaTrangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTrangMousePressed
        xoaTrang();
    }//GEN-LAST:event_btnXoaTrangMousePressed

    private void txtSoNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoNgayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoNgayMouseClicked

    private void txtGhiChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGhiChuMouseClicked

    }//GEN-LAST:event_txtGhiChuMouseClicked

    private void btnLuuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMousePressed
        //luuNhanVien();
        luuTour();
    }//GEN-LAST:event_btnLuuMousePressed

    private void btnHuyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMousePressed
        this.dispose();
    }//GEN-LAST:event_btnHuyMousePressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(FrmTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnBack;
    private custom_components.ButtonCustom btnHuy;
    private custom_components.ButtonCustom btnLuu;
    private javax.swing.JLabel btnXoaTrang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblGiaTour;
    private javax.swing.JLabel lblGiaTourError;
    private javax.swing.JLabel lblMaTour;
    private javax.swing.JLabel lblMaTourError;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblSoNgay;
    private javax.swing.JLabel lblSoNgayError;
    private javax.swing.JLabel lblTenTour;
    private javax.swing.JLabel lblTenTourError;
    private javax.swing.JLabel lineGhiChu;
    private javax.swing.JLabel lineGiaTour;
    private javax.swing.JLabel lineMaNhanVien;
    private javax.swing.JLabel lineSoNgay;
    private javax.swing.JLabel lineTenTour;
    private javax.swing.JPanel pnGhiChu;
    private javax.swing.JPanel pnGiaTour;
    private javax.swing.JPanel pnMaTour;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnSoNgay;
    private javax.swing.JPanel pnTenTour;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGiaTour;
    private javax.swing.JTextField txtMaTour;
    private javax.swing.JTextField txtSoNgay;
    private javax.swing.JTextField txtTenTour;
    // End of variables declaration//GEN-END:variables
}
