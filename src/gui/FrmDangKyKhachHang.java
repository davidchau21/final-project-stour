/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import custom_components.SVGImage;
import custom_components.TableCustom;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connectDB.ConnectDB;
import dao.TaiKhoanKH_DAO;
import dao.DuKhach_DAO;
import app.Application;
import entity.DuKhach;
import entity.TaiKhoanKH;
import utils.RandomString;

public class FrmDangKyKhachHang extends javax.swing.JFrame {

    
    private List<TaiKhoanKH> dsTaiKhoanKH;
    
    public FrmDangKyKhachHang() {
        initComponents();
        
        addControls();
        
        ConnectDB.connect();
    }
    
    private void addControls() {
        iconHoTen.setOpaque(false);
        iconTenTaiKhoan.setOpaque(false);
        iconPass.setOpaque(false);
        iconPass2.setOpaque(false);
        iconEmail.setOpaque(false);
        iconSDT.setOpaque(false);
        
        iconHoTen.setSVGImage("svg/badge.svg", 25, 25);
        iconHoTen.setColor(new Color(200, 200, 200));
        iconTenTaiKhoan.setSVGImage("svg/person.svg", 25, 25);
        iconTenTaiKhoan.setColor(new Color(200, 200, 200));
        iconPass.setSVGImage("svg/key.svg", 25, 25);
        iconPass.setColor(new Color(200, 200, 200));
        iconPass2.setSVGImage("svg/key.svg", 25, 25);
        iconPass2.setColor(new Color(200, 200, 200));
        iconEmail.setSVGImage("svg/email.svg", 25, 25);
        iconEmail.setColor(new Color(200, 200, 200));
        iconSDT.setSVGImage("svg/phone.svg", 25, 25);
        iconSDT.setColor(new Color(200, 200, 200));
        
        setlblErrorEmpty();
        xoaTrang();
    }

    
    private void xuLyDangKy() {
        String hoTen = txtHoTen.getText().trim();
        String tenTK = txtTenTaiKhoan.getText().trim();
        String pass = txtPass.getText().trim();
        String xacNhanPass = txtXacNhanPass.getText().trim();
        String email = txtEmail.getText().trim();
        String sdt = txtSoDienThoai.getText().trim();
        
        if(checkInput(hoTen, tenTK, pass, xacNhanPass, email, sdt))
        {
            RandomString randString = new RandomString();
            String maDK = randString.randomAlphaNumeric(4);
            
            while(DuKhach_DAO.getDuKhach(maDK) != null)
                maDK = randString.randomAlphaNumeric(10);
            
            DuKhach duKhach = new DuKhach(maDK, hoTen, sdt, email, "");
            if(DuKhach_DAO.addDuKhach(duKhach))
            {
                TaiKhoanKH taiKhoanKH = new TaiKhoanKH(tenTK, duKhach.getMaDK(), pass);
                if(TaiKhoanKH_DAO.addTaiKhoanKH(taiKhoanKH))
                {
                    JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công");
                    Application.frmDangNhapKH.setVisible(true);
                    this.dispose();
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Đăng ký tài khoản không thành công");
        }
    }
    
    private void setlblErrorEmpty() {
        lblHoTenError.setText("");
        lblTenTaiKhoanError.setText("");
        lblPassError.setText("");
        lblXacNhanPassError.setText("");
        lblEmailError.setText("");
        lblSoDienThoaiError.setText("");
        lblDieuKhoanError.setText("");
    }
    
    private void xoaTrang() {
        txtHoTen.setText("");
        txtTenTaiKhoan.setText("");
        txtPass.setText("");
        txtXacNhanPass.setText("");
        txtEmail.setText("");
        txtSoDienThoai.setText("");
    }
    
    private boolean checkInput(String hoTen, String tenTK, String pass, String xacNhanPass, String email, String sdt) {
        setlblErrorEmpty();
        
        if(hoTen.isEmpty())
        {
            lblHoTenError.setText("<html>Họ tên không được để trống</html>");
            return false;
        }
        
        
        if(tenTK.isEmpty())
        {
            lblTenTaiKhoanError.setText("<html>Tên tài khoản không được để trống</html>");
            return false;
        }
        else if(tenTK.length() < 5)
        {
            lblTenTaiKhoanError.setText("<html>Tên tài khoản phải từ 5 ký tự trở lên</html>");
            return false;
        }
        else if(TaiKhoanKH_DAO.getTaiKhoanKH(tenTK) != null)
        {
            lblTenTaiKhoanError.setText("<html>Tên tài khoản này đã được sử dụng</html>");
            return false;
        }
        
        
        if(pass.isEmpty())
        {
            lblPassError.setText("<html>Mật khẩu không được để trống");
            return false;
        }
        else if(pass.length() < 5)
        {
            lblPassError.setText("<html>Mật khẩu phải từ 5 ký tự trở lên");
            return false;
        }
        else if(xacNhanPass.isEmpty())
        {
            lblXacNhanPassError.setText("<html>Xác nhận mật khẩu không được để trống</html>");
            return false;
        }
        else if(pass.compareTo(xacNhanPass) != 0)
        {
            lblXacNhanPassError.setText("<html>Xác nhận mật khẩu không trùng khớp</html>");
            return false;
        }
     
        
        if(email.isEmpty())
        {
            lblEmailError.setText("<html>Email không được để trống</html>");
            return false;
        }
        

        if(sdt.isEmpty())
        {
            lblSoDienThoaiError.setText("<html>Số điện thoại không được để trống</html>");
            return false;
        }
        else if(!sdt.matches("^0\\d{9}$"))
        {
            lblSoDienThoaiError.setText("<html>Số điện thoại sai định dạng</html>");
            return false;
        }
        else if(DuKhach_DAO.getDuKhachTheoSDT(sdt) != null)
        {
            lblSoDienThoaiError.setText("<html>Số điện thoại này đã được đăng ký tài khoản</html>");
            return false;
        }
        
        
        if(!checkDieuKhoan.isSelected())
        {
            lblDieuKhoanError.setText("<html>Bạn phải đồng ý với các điều khoản của công ty</html>");
            return false;
        }
        
        
        return true;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        iconHoTen = new custom_components.SVGImage();
        txtHoTen = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        iconTenTaiKhoan = new custom_components.SVGImage();
        txtTenTaiKhoan = new javax.swing.JTextField();
        btnDangNhap = new custom_components.ButtonCustom();
        btnDangKy = new custom_components.ButtonCustom();
        checkDieuKhoan = new custom_components.JCheckBoxCustom();
        jPanel5 = new javax.swing.JPanel();
        iconPass = new custom_components.SVGImage();
        txtPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        iconPass2 = new custom_components.SVGImage();
        txtXacNhanPass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnEmail = new javax.swing.JPanel();
        iconEmail = new custom_components.SVGImage();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        iconSDT = new custom_components.SVGImage();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblHoTenError = new javax.swing.JLabel();
        lblTenTaiKhoanError = new javax.swing.JLabel();
        lblPassError = new javax.swing.JLabel();
        lblSoDienThoaiError = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblXacNhanPassError = new javax.swing.JLabel();
        lblDieuKhoanError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(51, 153, 255));
        setMinimumSize(new java.awt.Dimension(900, 550));
        setSize(new java.awt.Dimension(900, 550));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Mulish Medium", 0, 28)); // NOI18N
        jLabel1.setText("Welcom to");

        jLabel2.setFont(new java.awt.Font("Mulish ExtraBold", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 143, 243));
        jLabel2.setText("Stour");

        jLabel9.setFont(new java.awt.Font("Mulish Medium", 1, 28)); // NOI18N
        jLabel9.setText("ĐĂNG KÝ");

        jLabel4.setBackground(new java.awt.Color(0, 153, 255));
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(229, 229, 229));
        jLabel5.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconHoTen.setBackground(new java.awt.Color(204, 204, 204));
        iconHoTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconHoTen.setOpaque(true);

        txtHoTen.setFont(new java.awt.Font("Mulish Light", 0, 15)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(100, 100, 100));
        txtHoTen.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(iconHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconTenTaiKhoan.setBackground(new java.awt.Color(204, 204, 204));
        iconTenTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconTenTaiKhoan.setOpaque(true);

        txtTenTaiKhoan.setFont(new java.awt.Font("Mulish Light", 0, 15)); // NOI18N
        txtTenTaiKhoan.setForeground(new java.awt.Color(100, 100, 100));
        txtTenTaiKhoan.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenTaiKhoan)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenTaiKhoan)
                    .addComponent(iconTenTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnDangNhap.setBorder(null);
        btnDangNhap.setForeground(new java.awt.Color(62, 140, 251));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setBorderColor(new java.awt.Color(240, 240, 240));
        btnDangNhap.setColorClick(new java.awt.Color(245, 245, 245));
        btnDangNhap.setColorHover(new java.awt.Color(245, 245, 245));
        btnDangNhap.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnDangNhap.setRadius(15);
        btnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDangNhapMousePressed(evt);
            }
        });

        btnDangKy.setBorder(null);
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setText("Đăng ký");
        btnDangKy.setBorderColor(new java.awt.Color(240, 240, 240));
        btnDangKy.setColor(new java.awt.Color(62, 140, 251));
        btnDangKy.setColorClick(new java.awt.Color(102, 153, 255));
        btnDangKy.setColorHover(new java.awt.Color(102, 153, 255));
        btnDangKy.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnDangKy.setRadius(15);
        btnDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDangKyMousePressed(evt);
            }
        });

        checkDieuKhoan.setBackground(new java.awt.Color(71, 143, 243));
        checkDieuKhoan.setForeground(new java.awt.Color(120, 120, 120));
        checkDieuKhoan.setText("Đồng ý với các điều khoản của công ty");
        checkDieuKhoan.setFont(new java.awt.Font("Mulish Light", 0, 12)); // NOI18N
        checkDieuKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkDieuKhoanMousePressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconPass.setBackground(new java.awt.Color(204, 204, 204));
        iconPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPass.setOpaque(true);

        txtPass.setFont(new java.awt.Font("Mulish Light", 0, 15)); // NOI18N
        txtPass.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Họ và tên *");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Tên tài khoản *");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Mật khẩu *");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconPass2.setBackground(new java.awt.Color(204, 204, 204));
        iconPass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPass2.setOpaque(true);

        txtXacNhanPass.setFont(new java.awt.Font("Mulish Light", 0, 15)); // NOI18N
        txtXacNhanPass.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtXacNhanPass, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtXacNhanPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Xác nhận mật khẩu *");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Email *");

        pnEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconEmail.setBackground(new java.awt.Color(204, 204, 204));
        iconEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconEmail.setOpaque(true);

        txtEmail.setFont(new java.awt.Font("Mulish Light", 0, 15)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(100, 100, 100));
        txtEmail.setBorder(null);

        javax.swing.GroupLayout pnEmailLayout = new javax.swing.GroupLayout(pnEmail);
        pnEmail.setLayout(pnEmailLayout);
        pnEmailLayout.setHorizontalGroup(
            pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnEmailLayout.setVerticalGroup(
            pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEmailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(iconEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Số điện thoại *");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconSDT.setBackground(new java.awt.Color(204, 204, 204));
        iconSDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSDT.setOpaque(true);

        txtSoDienThoai.setFont(new java.awt.Font("Mulish Light", 0, 15)); // NOI18N
        txtSoDienThoai.setForeground(new java.awt.Color(100, 100, 100));
        txtSoDienThoai.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(iconSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel13.setBackground(new java.awt.Color(0, 153, 255));
        jLabel13.setOpaque(true);

        lblHoTenError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblHoTenError.setForeground(new java.awt.Color(255, 0, 0));
        lblHoTenError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHoTenError.setText("Họ và tên không được để trống");

        lblTenTaiKhoanError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblTenTaiKhoanError.setForeground(new java.awt.Color(255, 0, 0));
        lblTenTaiKhoanError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenTaiKhoanError.setText("Họ và tên không được để trống");

        lblPassError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblPassError.setForeground(new java.awt.Color(255, 0, 0));
        lblPassError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassError.setText("Họ và tên không được để trống");

        lblSoDienThoaiError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSoDienThoaiError.setForeground(new java.awt.Color(255, 0, 0));
        lblSoDienThoaiError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoDienThoaiError.setText("Họ và tên không được để trống");

        lblEmailError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmailError.setText("Họ và tên không được để trống");

        lblXacNhanPassError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblXacNhanPassError.setForeground(new java.awt.Color(255, 0, 0));
        lblXacNhanPassError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblXacNhanPassError.setText("Họ và tên không được để trống");

        lblDieuKhoanError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblDieuKhoanError.setForeground(new java.awt.Color(255, 0, 0));
        lblDieuKhoanError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDieuKhoanError.setText("Họ và tên không được để trống");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkDieuKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDieuKhoanError, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblSoDienThoaiError, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPassError, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblHoTenError, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblXacNhanPassError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTenTaiKhoanError, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblHoTenError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lblTenTaiKhoanError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lblPassError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblXacNhanPassError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lblEmailError)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(lblSoDienThoaiError))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkDieuKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDieuKhoanError))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setlblErrorEmpty();
        xoaTrang();
    }//GEN-LAST:event_formWindowActivated

    private void btnDangNhapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangNhapMousePressed
        Application.frmDangNhapKH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDangNhapMousePressed

    private void btnDangKyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangKyMousePressed
        xuLyDangKy();
    }//GEN-LAST:event_btnDangKyMousePressed

    private void checkDieuKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkDieuKhoanMousePressed

    }//GEN-LAST:event_checkDieuKhoanMousePressed

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
            java.util.logging.Logger.getLogger(FrmDangKyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDangKyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDangKyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDangKyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FrmDangKyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnDangKy;
    private custom_components.ButtonCustom btnDangNhap;
    private custom_components.JCheckBoxCustom checkDieuKhoan;
    private custom_components.SVGImage iconEmail;
    private custom_components.SVGImage iconHoTen;
    private custom_components.SVGImage iconPass;
    private custom_components.SVGImage iconPass2;
    private custom_components.SVGImage iconSDT;
    private custom_components.SVGImage iconTenTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblDieuKhoanError;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblHoTenError;
    private javax.swing.JLabel lblPassError;
    private javax.swing.JLabel lblSoDienThoaiError;
    private javax.swing.JLabel lblTenTaiKhoanError;
    private javax.swing.JLabel lblXacNhanPassError;
    private javax.swing.JPanel pnEmail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenTaiKhoan;
    private javax.swing.JPasswordField txtXacNhanPass;
    // End of variables declaration//GEN-END:variables
}
