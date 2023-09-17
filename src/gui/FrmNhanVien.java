/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import entity.NhanVien;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.NhanVien_DAO;
import javax.swing.JOptionPane;
import model_table.ModelTableNhanVien;
import model_table.TableNhanVien;

/**
 *
 * @author Asus
 */
public class FrmNhanVien extends javax.swing.JFrame {

    private Color labelColor = new Color(153, 153, 153);
    private Color labelFocusColor = Color.BLUE;
    private Object listTextbox[];
    private JLabel listLabelForTextBox[];
    private JLabel listLineForTextBox[]; 
    
    
    /**
     * Creates new form frmNhanVien
     */
    public FrmNhanVien() {
        initComponents();
        
        addControls();
    }

    private void addControls() {
        btnBack.setSVGImage("svg/arrow-left-solid.svg", 25, 25);
        btnBack.setColor(Color.WHITE);
        
        setlblErroEmpty();
    }
    
    private void setlblErroEmpty() {
        lblMaNhanVienError.setText("");
        lblTenNhanVienError.setText("");
        lblSoDienThoaiError.setText("");
        lblEmailError.setText("");
        lblMatKhauError.setText("");
        lblXacNhanMatKhauEror.setText("");
    }

    private boolean checkInput(String maNV, String tenNV, String sdt, String email, String matKhau, String xacNhanMatKhau) {
        setlblErroEmpty();
        
        if(maNV.isEmpty())
        {
            lblMaNhanVienError.setText("Mã nhân viên không được để trống");
            return false;
        }
        else if(!maNV.matches("^(NV|QL)\\d{2}$"))
        {
            lblMaNhanVienError.setText("Mã nhân viên sai định dạng");
            return false;
        }
        
        
        else if(tenNV.isEmpty())
        {
            lblTenNhanVienError.setText("Tên nhân viên không được để trống");
            return false;
        }
        
        
        else if(sdt.isEmpty())
        {
            lblSoDienThoaiError.setText("Số điện thoại không được để trống");
            return false;
        }
        else if(!sdt.matches("^0\\d{9}$"))
        {
            lblSoDienThoaiError.setText("Số điện thoại sai định dạng");
            return false;
        }
        
        
        else if(email.isEmpty())
        {
            lblEmailError.setText("Email không được để trống");
            return false;
        }
        
        
        else if(matKhau.isEmpty())
        {
            lblMatKhauError.setText("Mật khẩu không được để trống");
            return false;
        }
        else if(xacNhanMatKhau.isEmpty())
        {
            lblXacNhanMatKhauEror.setText("Xác nhận mật khẩu không được để trống");
            return false;
        }
        else if(matKhau.compareTo(xacNhanMatKhau) != 0)
        {
            lblXacNhanMatKhauEror.setText("Mật khẩu không trùng khớp");
            return false;
        }
        
        else if(TableNhanVien.dsNhanVien.indexOf(new NhanVien(maNV)) >= 0)
        {
            lblMaNhanVienError.setText("Mã nhân viên đã tồn tại");
            return false;
        }
        
        return true;
    }
    
    private void luuNhanVien() {
        String maNV = txtMaNhanVien.getText().trim();
        String tenNV = txtTenNhanVien.getText().trim();
        String strVaiTro = cbxVaiTro.getSelectedItem().toString();
        
        boolean vaiTro = true;
        if(strVaiTro.compareToIgnoreCase("Nhân viên") == 0)
            vaiTro = false;
        
        String sdt = txtSoDienThoai.getText().trim();
        String email = txtEmail.getText().trim();
        String matKhau = txtMatKhau.getText().trim();
        String xacNhanMatKhau = txtXacNhanMatKhau.getText().trim();
        String txtGhiChu = this.txtGhiChu.getText().trim();
        
        if(checkInput(maNV, tenNV, sdt, email, matKhau, xacNhanMatKhau))
        {
            NhanVien nhanVien = new NhanVien(maNV, tenNV, sdt, vaiTro, matKhau, email, txtGhiChu);
            if(NhanVien_DAO.addNhanVien(nhanVien))
            {
                FrmQLNhanVien.loadData();
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Lưu nhân viên không thành công");
        }
    }
    
    private void xemThongTinNhanVien() {
        
    }
    
    private void suaThongTinhNhanVien() {
        
    }
    
    private void timKiemNhanVien() {
        
    }
    
    private void sapXepNhanVien() {
        
    }
    
    private void xoaTrang() {
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        txtEmail.setText("");
        txtSoDienThoai.setText("");
        txtMatKhau.setText("");
        txtXacNhanMatKhau.setText("");
        txtGhiChu.setText("");
    }
    
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
        pnMaNhanVien = new javax.swing.JPanel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        lineMaNhanVien = new javax.swing.JLabel();
        lblMaNhanVienError = new javax.swing.JLabel();
        pnTenNhanVien = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        lineTenNhanVien = new javax.swing.JLabel();
        lblTenNhanVienError = new javax.swing.JLabel();
        pnVaiTro = new javax.swing.JPanel();
        lblVaiTro = new javax.swing.JLabel();
        cbxVaiTro = new custom_components.ComboBoxSuggestion();
        pnEmail = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lineEmail = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        btnXoaTrang = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnSoDienThoai = new javax.swing.JPanel();
        lblSoDienThoai = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        lineSoDienThoai = new javax.swing.JLabel();
        lblSoDienThoaiError = new javax.swing.JLabel();
        pnGhiChu = new javax.swing.JPanel();
        lblGhiChu = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        lineGhiChu = new javax.swing.JLabel();
        pnSoDienThoai1 = new javax.swing.JPanel();
        lblMatKhau = new javax.swing.JLabel();
        lineSoDienThoai1 = new javax.swing.JLabel();
        lblMatKhauError = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        pnSoDienThoai2 = new javax.swing.JPanel();
        lblXacNhanMatKhau = new javax.swing.JLabel();
        lineSoDienThoai2 = new javax.swing.JLabel();
        lblXacNhanMatKhauEror = new javax.swing.JLabel();
        txtXacNhanMatKhau = new javax.swing.JPasswordField();
        btnLuu = new custom_components.ButtonCustom();
        btnHuy = new custom_components.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm nhân viên");

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        btnBack.setBorder(null);
        btnBack.setBorderColor(new java.awt.Color(255, 255, 255));
        btnBack.setRadius(45);

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
                .addContainerGap(534, Short.MAX_VALUE))
        );

        pnMain.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 80));

        lblPageTitle.setFont(new java.awt.Font("Mulish ExtraBold", 1, 27)); // NOI18N
        lblPageTitle.setText("Thêm nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblPageTitle)
                .addContainerGap(556, Short.MAX_VALUE))
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

        pnMaNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnMaNhanVien.setPreferredSize(new java.awt.Dimension(350, 83));

        lblMaNhanVien.setBackground(new java.awt.Color(255, 204, 0));
        lblMaNhanVien.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblMaNhanVien.setForeground(new java.awt.Color(102, 153, 255));
        lblMaNhanVien.setText("Mã nhân viên *");

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMaNhanVien.setForeground(new java.awt.Color(51, 51, 51));
        txtMaNhanVien.setBorder(null);
        txtMaNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaNhanVienMouseClicked(evt);
            }
        });

        lineMaNhanVien.setBackground(new java.awt.Color(102, 153, 255));
        lineMaNhanVien.setOpaque(true);
        lineMaNhanVien.setPreferredSize(new java.awt.Dimension(400, 1));

        lblMaNhanVienError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblMaNhanVienError.setForeground(new java.awt.Color(255, 0, 0));
        lblMaNhanVienError.setText("Mã nhân viên đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnMaNhanVienLayout = new javax.swing.GroupLayout(pnMaNhanVien);
        pnMaNhanVien.setLayout(pnMaNhanVienLayout);
        pnMaNhanVienLayout.setHorizontalGroup(
            pnMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMaNhanVienLayout.createSequentialGroup()
                        .addComponent(lblMaNhanVienError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnMaNhanVienLayout.createSequentialGroup()
                        .addComponent(lineMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnMaNhanVienLayout.createSequentialGroup()
                        .addGroup(pnMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNhanVien)
                            .addComponent(lblMaNhanVien))
                        .addGap(46, 46, 46))))
        );
        pnMaNhanVienLayout.setVerticalGroup(
            pnMaNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMaNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMaNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblMaNhanVienError)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pnTenNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        pnTenNhanVien.setPreferredSize(new java.awt.Dimension(350, 77));

        lblTenNhanVien.setBackground(new java.awt.Color(255, 204, 0));
        lblTenNhanVien.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(102, 153, 255));
        lblTenNhanVien.setText("Tên nhân viên *");

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenNhanVien.setForeground(new java.awt.Color(51, 51, 51));
        txtTenNhanVien.setBorder(null);
        txtTenNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenNhanVienMouseClicked(evt);
            }
        });

        lineTenNhanVien.setBackground(new java.awt.Color(102, 153, 255));
        lineTenNhanVien.setOpaque(true);
        lineTenNhanVien.setPreferredSize(new java.awt.Dimension(400, 1));

        lblTenNhanVienError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblTenNhanVienError.setForeground(new java.awt.Color(255, 0, 0));
        lblTenNhanVienError.setText("Mã nhân viên đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnTenNhanVienLayout = new javax.swing.GroupLayout(pnTenNhanVien);
        pnTenNhanVien.setLayout(pnTenNhanVienLayout);
        pnTenNhanVienLayout.setHorizontalGroup(
            pnTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTenNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnTenNhanVienLayout.createSequentialGroup()
                        .addGroup(pnTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenNhanVien))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnTenNhanVienLayout.createSequentialGroup()
                        .addComponent(lblTenNhanVienError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnTenNhanVienLayout.setVerticalGroup(
            pnTenNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTenNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblTenNhanVienError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnVaiTro.setBackground(new java.awt.Color(255, 255, 255));
        pnVaiTro.setPreferredSize(new java.awt.Dimension(350, 60));

        lblVaiTro.setBackground(new java.awt.Color(255, 204, 0));
        lblVaiTro.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblVaiTro.setForeground(new java.awt.Color(102, 153, 255));
        lblVaiTro.setText("Vai trò *");

        cbxVaiTro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nhân viên", "Quản lý" }));
        cbxVaiTro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnVaiTroLayout = new javax.swing.GroupLayout(pnVaiTro);
        pnVaiTro.setLayout(pnVaiTroLayout);
        pnVaiTroLayout.setHorizontalGroup(
            pnVaiTroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVaiTroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVaiTro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnVaiTroLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(cbxVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnVaiTroLayout.setVerticalGroup(
            pnVaiTroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnVaiTroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVaiTro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pnEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnEmail.setPreferredSize(new java.awt.Dimension(350, 77));

        lblEmail.setBackground(new java.awt.Color(255, 204, 0));
        lblEmail.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(102, 153, 255));
        lblEmail.setText("Email *");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setBorder(null);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });

        lineEmail.setBackground(new java.awt.Color(102, 153, 255));
        lineEmail.setOpaque(true);
        lineEmail.setPreferredSize(new java.awt.Dimension(400, 1));

        lblEmailError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setText("Mã nhân viên đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnEmailLayout = new javax.swing.GroupLayout(pnEmail);
        pnEmail.setLayout(pnEmailLayout);
        pnEmailLayout.setHorizontalGroup(
            pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnEmailLayout.createSequentialGroup()
                        .addGroup(pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnEmailLayout.createSequentialGroup()
                        .addComponent(lblEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnEmailLayout.setVerticalGroup(
            pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblEmailError)
                .addContainerGap(11, Short.MAX_VALUE))
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
                    .addComponent(pnTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(pnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnXoaTrang)
                .addGap(49, 49, 49))
        );

        jPanel6.setOpaque(false);

        pnSoDienThoai.setBackground(new java.awt.Color(255, 255, 255));
        pnSoDienThoai.setPreferredSize(new java.awt.Dimension(350, 77));

        lblSoDienThoai.setBackground(new java.awt.Color(255, 204, 0));
        lblSoDienThoai.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblSoDienThoai.setForeground(new java.awt.Color(102, 153, 255));
        lblSoDienThoai.setText("Số điện thoại *");

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSoDienThoai.setForeground(new java.awt.Color(51, 51, 51));
        txtSoDienThoai.setBorder(null);
        txtSoDienThoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSoDienThoaiMouseClicked(evt);
            }
        });

        lineSoDienThoai.setBackground(new java.awt.Color(102, 153, 255));
        lineSoDienThoai.setOpaque(true);
        lineSoDienThoai.setPreferredSize(new java.awt.Dimension(400, 1));

        lblSoDienThoaiError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSoDienThoaiError.setForeground(new java.awt.Color(255, 0, 0));
        lblSoDienThoaiError.setText("Mã nhân viên đã tồn tại trong danh sách");

        javax.swing.GroupLayout pnSoDienThoaiLayout = new javax.swing.GroupLayout(pnSoDienThoai);
        pnSoDienThoai.setLayout(pnSoDienThoaiLayout);
        pnSoDienThoaiLayout.setHorizontalGroup(
            pnSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoDienThoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnSoDienThoaiLayout.createSequentialGroup()
                        .addGroup(pnSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoDienThoai))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnSoDienThoaiLayout.createSequentialGroup()
                        .addComponent(lblSoDienThoaiError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnSoDienThoaiLayout.setVerticalGroup(
            pnSoDienThoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoDienThoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoDienThoai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lineSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblSoDienThoaiError)
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

        pnSoDienThoai1.setBackground(new java.awt.Color(255, 255, 255));
        pnSoDienThoai1.setPreferredSize(new java.awt.Dimension(350, 77));

        lblMatKhau.setBackground(new java.awt.Color(255, 204, 0));
        lblMatKhau.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(102, 153, 255));
        lblMatKhau.setText("Mật khẩu *");

        lineSoDienThoai1.setBackground(new java.awt.Color(102, 153, 255));
        lineSoDienThoai1.setOpaque(true);
        lineSoDienThoai1.setPreferredSize(new java.awt.Dimension(400, 1));

        lblMatKhauError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblMatKhauError.setForeground(new java.awt.Color(255, 0, 0));
        lblMatKhauError.setText("Mã nhân viên đã tồn tại trong danh sách");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMatKhau.setBorder(null);

        javax.swing.GroupLayout pnSoDienThoai1Layout = new javax.swing.GroupLayout(pnSoDienThoai1);
        pnSoDienThoai1.setLayout(pnSoDienThoai1Layout);
        pnSoDienThoai1Layout.setHorizontalGroup(
            pnSoDienThoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoDienThoai1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSoDienThoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSoDienThoai1Layout.createSequentialGroup()
                        .addGroup(pnSoDienThoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineSoDienThoai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMatKhau))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnSoDienThoai1Layout.createSequentialGroup()
                        .addGroup(pnSoDienThoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatKhauError, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnSoDienThoai1Layout.setVerticalGroup(
            pnSoDienThoai1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoDienThoai1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSoDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblMatKhauError)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnSoDienThoai2.setBackground(new java.awt.Color(255, 255, 255));
        pnSoDienThoai2.setPreferredSize(new java.awt.Dimension(350, 77));

        lblXacNhanMatKhau.setBackground(new java.awt.Color(255, 204, 0));
        lblXacNhanMatKhau.setFont(new java.awt.Font("Comfortaa", 0, 12)); // NOI18N
        lblXacNhanMatKhau.setForeground(new java.awt.Color(102, 153, 255));
        lblXacNhanMatKhau.setText("Xác nhận mật khẩu *");

        lineSoDienThoai2.setBackground(new java.awt.Color(102, 153, 255));
        lineSoDienThoai2.setOpaque(true);
        lineSoDienThoai2.setPreferredSize(new java.awt.Dimension(400, 1));

        lblXacNhanMatKhauEror.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblXacNhanMatKhauEror.setForeground(new java.awt.Color(255, 0, 0));
        lblXacNhanMatKhauEror.setText("Mã nhân viên đã tồn tại trong danh sách");

        txtXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtXacNhanMatKhau.setBorder(null);

        javax.swing.GroupLayout pnSoDienThoai2Layout = new javax.swing.GroupLayout(pnSoDienThoai2);
        pnSoDienThoai2.setLayout(pnSoDienThoai2Layout);
        pnSoDienThoai2Layout.setHorizontalGroup(
            pnSoDienThoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoDienThoai2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSoDienThoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSoDienThoai2Layout.createSequentialGroup()
                        .addGroup(pnSoDienThoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineSoDienThoai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblXacNhanMatKhau))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnSoDienThoai2Layout.createSequentialGroup()
                        .addGroup(pnSoDienThoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblXacNhanMatKhauEror, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnSoDienThoai2Layout.setVerticalGroup(
            pnSoDienThoai2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSoDienThoai2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblXacNhanMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineSoDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblXacNhanMatKhauEror)
                .addContainerGap(10, Short.MAX_VALUE))
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
                    .addComponent(pnSoDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnSoDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(pnSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnSoDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnSoDienThoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
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
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(950, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienMouseClicked

    private void txtTenNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhanVienMouseClicked

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtSoDienThoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoDienThoaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiMouseClicked

    private void txtGhiChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGhiChuMouseClicked

    }//GEN-LAST:event_txtGhiChuMouseClicked

    private void btnXoaTrangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTrangMousePressed
        xoaTrang();
    }//GEN-LAST:event_btnXoaTrangMousePressed

    private void btnHuyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMousePressed
        this.dispose();
    }//GEN-LAST:event_btnHuyMousePressed

    private void btnLuuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMousePressed
        luuNhanVien();
    }//GEN-LAST:event_btnLuuMousePressed

    private void textboxMousePress(MouseEvent evt) {
        Object o = evt.getSource();
        for(int i = 0; i < listTextbox.length; i++)
        {
            if(o.equals(listTextbox[i]))
            {
                Font font = listLabelForTextBox[i].getFont();
                listLabelForTextBox[i].setFont(new Font(font.getName(), Font.BOLD, font.getSize()));
                listLabelForTextBox[i].setForeground(labelFocusColor);
                listLineForTextBox[i].setBackground(labelFocusColor);
            }
            else
            {
                 Font font = listLabelForTextBox[i].getFont();
                listLabelForTextBox[i].setFont(new Font(font.getName(), Font.PLAIN, font.getSize()));
                listLabelForTextBox[i].setForeground(labelColor);
                listLineForTextBox[i].setBackground(labelColor);
            }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnBack;
    private custom_components.ButtonCustom btnHuy;
    private custom_components.ButtonCustom btnLuu;
    private javax.swing.JLabel btnXoaTrang;
    private custom_components.ComboBoxSuggestion cbxVaiTro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblGhiChu;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMaNhanVienError;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblMatKhauError;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblSoDienThoaiError;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTenNhanVienError;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JLabel lblXacNhanMatKhau;
    private javax.swing.JLabel lblXacNhanMatKhauEror;
    private javax.swing.JLabel lineEmail;
    private javax.swing.JLabel lineGhiChu;
    private javax.swing.JLabel lineMaNhanVien;
    private javax.swing.JLabel lineSoDienThoai;
    private javax.swing.JLabel lineSoDienThoai1;
    private javax.swing.JLabel lineSoDienThoai2;
    private javax.swing.JLabel lineTenNhanVien;
    private javax.swing.JPanel pnEmail;
    private javax.swing.JPanel pnGhiChu;
    private javax.swing.JPanel pnMaNhanVien;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnSoDienThoai;
    private javax.swing.JPanel pnSoDienThoai1;
    private javax.swing.JPanel pnSoDienThoai2;
    private javax.swing.JPanel pnTenNhanVien;
    private javax.swing.JPanel pnVaiTro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JPasswordField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables


}
