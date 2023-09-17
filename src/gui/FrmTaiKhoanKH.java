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
import java.awt.Image;
import javax.swing.ImageIcon;
import utils.RandomString;
import utils.HashCode;

public class FrmTaiKhoanKH extends javax.swing.JFrame {

    
    private TaiKhoanKH taiKhoanKH;
    private DuKhach duKhach;
    
    public FrmTaiKhoanKH() {
        initComponents();
        
        addControls();
        
        ConnectDB.connect();
    }
    
    private void addControls() {
        iconHoTen.setOpaque(false);
        iconTenTaiKhoan.setOpaque(false);
        iconPass.setOpaque(false);
        iconEmail.setOpaque(false);
        iconSDT.setOpaque(false);
        
        iconHoTen.setSVGImage("svg/badge.svg", 25, 25);
        iconHoTen.setColor(new Color(200, 200, 200));
        iconTenTaiKhoan.setSVGImage("svg/person.svg", 25, 25);
        iconTenTaiKhoan.setColor(new Color(200, 200, 200));
        iconPass.setSVGImage("svg/key.svg", 25, 25);
        iconPass.setColor(new Color(200, 200, 200));
        iconEmail.setSVGImage("svg/email.svg", 25, 25);
        iconEmail.setColor(new Color(200, 200, 200));
        iconSDT.setSVGImage("svg/phone.svg", 25, 25);
        iconSDT.setColor(new Color(200, 200, 200));
        
        boxAvatar.setSVGImage("svg/add_a_photo.svg", 100, 100);
        boxAvatar.setIconColor(new Color(153,204,255));
        
        btnHuy.setVisible(false);
        
        setlblErrorEmpty();
        xoaTrang();
        loadThongTinTaiKhoan();
        
        btnHuyDoiMatKhau.setVisible(false);
    }

    private void loadThongTinTaiKhoan() {
        taiKhoanKH = Application.taiKhoanKH;
        if(taiKhoanKH != null)
        {
            if(!taiKhoanKH.getAvatar().isEmpty())
            {
                ImageIcon imageIcon = new ImageIcon(getClass().getResource(taiKhoanKH.getAvatar()));
                Image image = imageIcon.getImage().getScaledInstance(170,170 * imageIcon.getIconHeight() / imageIcon.getIconWidth(), Image.SCALE_DEFAULT);
                ImageIcon imageIcon1 = new ImageIcon(image);
                boxAvatar.setIcon(imageIcon1);
            }
            
            txtTenTaiKhoan.setText(taiKhoanKH.getTenTK());
            txtPass.setText(taiKhoanKH.getMatKhau());
            
            duKhach = DuKhach_DAO.getDuKhach(taiKhoanKH.getMaDK());
            if(duKhach != null)
            {
                txtHoTen.setText(duKhach.getTenDK());
                txtSoDienThoai.setText(duKhach.getSDT());
                txtEmail.setText(duKhach.getEmail());
            }
        }
    }
    
    private void xuLyCapNhatThongTin() {
        String hoTen = txtHoTen.getText().trim();
        String tenTK = txtTenTaiKhoan.getText().trim();
        String email = txtEmail.getText().trim();
        String sdt = txtSoDienThoai.getText().trim();
        
        if(checkInput(hoTen, email, sdt))
        {
            if(duKhach != null)
            {
                DuKhach duKhachNew = new DuKhach(duKhach.getMaDK(), hoTen, sdt, email, "");
                if(DuKhach_DAO.updateDuKhach(duKhachNew))
                {
                    loadThongTinTaiKhoan();
                    
                    btnHuy.setVisible(false);
                    btnSuaThongTin.setText("Sửa thông tin");
                    setlblErrorEmpty();
                    textFiledEditEnable(false);
                    
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin tài khoản thành công");
                }
                else
                    JOptionPane.showMessageDialog(null, "Cập nhật thông tin tài khoản không thành công");
            }
        }
    }
    
    private void xuLyCapNhatMatKhau() {
        String matKhau = txtPass.getText();
        if (checkPass(matKhau)) {
            String xacNhanMatKhau = JOptionPane.showInputDialog("Nhập mật khẩu cũ để xác nhận thay đổi mật khẩu");
            if (HashCode.toHashCode(xacNhanMatKhau).compareTo(Application.taiKhoanKH.getMatKhau()) == 0) {

                TaiKhoanKH taiKhoanNew = new TaiKhoanKH(Application.taiKhoanKH.getTenTK(), Application.taiKhoanKH.getMaDK(), matKhau, Application.taiKhoanKH.getAvatar());

                if (TaiKhoanKH_DAO.updateTaiKhoanKH(taiKhoanNew)) {
                    Application.taiKhoanKH = TaiKhoanKH_DAO.getTaiKhoanKH(taiKhoanNew.getTenTK());
                    loadThongTinTaiKhoan();

                    btnHuyDoiMatKhau.setVisible(false);
                    btnDoiMatKhau.setText("Đổi mật khẩu?");
                    lblPassError.setText("");
                    txtPass.setEditable(false);

                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không đúng");
            }
        }
    }
    
    private void setlblErrorEmpty() {
        lblHoTenError.setText("");
        lblTenTaiKhoanError.setText("");
        lblPassError.setText("");
        lblEmailError.setText("");
        lblSoDienThoaiError.setText("");
    }
    
    private void textFiledEditEnable(boolean b) {
        txtHoTen.setEditable(b);
        txtSoDienThoai.setEditable(b);
        txtEmail.setEditable(b);
    }
    
    private void xoaTrang() {
        txtHoTen.setText("");
        txtTenTaiKhoan.setText("");
        txtPass.setText("");
        txtEmail.setText("");
        txtSoDienThoai.setText("");
    }
    
    private boolean checkInput(String hoTen, String email, String sdt) {
        setlblErrorEmpty();
        
        if(hoTen.isEmpty())
        {
            lblHoTenError.setText("<html>Họ tên không được để trống</html>");
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
        else if(DuKhach_DAO.getDuKhachTheoSDT(sdt) != null 
                && DuKhach_DAO.getDuKhach(duKhach.getMaDK()).getSDT().compareToIgnoreCase(sdt) != 0)
        {
            lblSoDienThoaiError.setText("<html>Số điện thoại này đã được đăng ký tài khoản</html>");
            return false;
        }
        
        
        return true;
    }
    
    private boolean checkPass(String pass) {
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
        else if(HashCode.toHashCode(pass).compareTo(Application.taiKhoanKH.getMatKhau()) == 0)
        {
            lblPassError.setText("<html>Mật khẩu mới trùng với mật khẩu cũ</html>");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        iconHoTen = new custom_components.SVGImage();
        txtHoTen = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        iconTenTaiKhoan = new custom_components.SVGImage();
        txtTenTaiKhoan = new javax.swing.JTextField();
        btnDangXuat = new custom_components.ButtonCustom();
        btnSuaThongTin = new custom_components.ButtonCustom();
        jPanel5 = new javax.swing.JPanel();
        iconPass = new custom_components.SVGImage();
        txtPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnEmail = new javax.swing.JPanel();
        iconEmail = new custom_components.SVGImage();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        iconSDT = new custom_components.SVGImage();
        txtSoDienThoai = new javax.swing.JTextField();
        lblHoTenError = new javax.swing.JLabel();
        lblTenTaiKhoanError = new javax.swing.JLabel();
        lblPassError = new javax.swing.JLabel();
        lblSoDienThoaiError = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        boxAvatar = new custom_components.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnHuyDoiMatKhau = new javax.swing.JLabel();
        btnHuy = new custom_components.ButtonCustom();
        btnXoaTaiKhoan1 = new custom_components.ButtonCustom();
        btnDoiMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin tài khoản");
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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconHoTen.setBackground(new java.awt.Color(204, 204, 204));
        iconHoTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconHoTen.setOpaque(true);

        txtHoTen.setEditable(false);
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconTenTaiKhoan.setBackground(new java.awt.Color(204, 204, 204));
        iconTenTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconTenTaiKhoan.setOpaque(true);

        txtTenTaiKhoan.setEditable(false);
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
                .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 372, -1));

        btnDangXuat.setBorder(null);
        btnDangXuat.setForeground(new java.awt.Color(102, 102, 102));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setBorderColor(new java.awt.Color(240, 240, 240));
        btnDangXuat.setColorClick(new java.awt.Color(245, 245, 245));
        btnDangXuat.setColorHover(new java.awt.Color(245, 245, 245));
        btnDangXuat.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnDangXuat.setRadius(15);
        btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDangXuatMousePressed(evt);
            }
        });
        jPanel1.add(btnDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 174, 30));

        btnSuaThongTin.setBorder(null);
        btnSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.setBorderColor(new java.awt.Color(240, 240, 240));
        btnSuaThongTin.setColor(new java.awt.Color(62, 140, 251));
        btnSuaThongTin.setColorClick(new java.awt.Color(102, 153, 255));
        btnSuaThongTin.setColorHover(new java.awt.Color(102, 153, 255));
        btnSuaThongTin.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnSuaThongTin.setRadius(15);
        btnSuaThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSuaThongTinMousePressed(evt);
            }
        });
        jPanel1.add(btnSuaThongTin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 172, 41));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconPass.setBackground(new java.awt.Color(204, 204, 204));
        iconPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPass.setOpaque(true);

        txtPass.setEditable(false);
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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, -1, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Họ và tên *");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 64, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Tên tài khoản *");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 89, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Mật khẩu *");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 89, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Email *");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 46, -1));

        pnEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconEmail.setBackground(new java.awt.Color(204, 204, 204));
        iconEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconEmail.setOpaque(true);

        txtEmail.setEditable(false);
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

        jPanel1.add(pnEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Số điện thoại *");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        iconSDT.setBackground(new java.awt.Color(204, 204, 204));
        iconSDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSDT.setOpaque(true);

        txtSoDienThoai.setEditable(false);
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

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, -1, -1));

        lblHoTenError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblHoTenError.setForeground(new java.awt.Color(255, 0, 0));
        lblHoTenError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHoTenError.setText("Họ và tên không được để trống");
        jPanel1.add(lblHoTenError, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 277, -1));

        lblTenTaiKhoanError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblTenTaiKhoanError.setForeground(new java.awt.Color(255, 0, 0));
        lblTenTaiKhoanError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTenTaiKhoanError.setText("Họ và tên không được để trống");
        jPanel1.add(lblTenTaiKhoanError, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 277, -1));

        lblPassError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblPassError.setForeground(new java.awt.Color(255, 0, 0));
        lblPassError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassError.setText("Họ và tên không được để trống");
        jPanel1.add(lblPassError, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 277, 20));

        lblSoDienThoaiError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblSoDienThoaiError.setForeground(new java.awt.Color(255, 0, 0));
        lblSoDienThoaiError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoDienThoaiError.setText("Họ và tên không được để trống");
        jPanel1.add(lblSoDienThoaiError, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 277, -1));

        lblEmailError.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmailError.setText("Họ và tên không được để trống");
        jPanel1.add(lblEmailError, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 277, -1));

        boxAvatar.setBorder(null);
        boxAvatar.setForeground(new java.awt.Color(255, 255, 255));
        boxAvatar.setBorderColor(new java.awt.Color(102, 102, 102));
        boxAvatar.setColorClick(new java.awt.Color(225, 225, 225));
        boxAvatar.setColorHover(new java.awt.Color(225, 225, 225));
        boxAvatar.setRadius(200);
        jPanel1.add(boxAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 170, 170));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 770, 2));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel9.setFont(new java.awt.Font("Mulish Medium", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thông tin tài khoản");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(414, 414, 414))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 50));

        btnHuyDoiMatKhau.setForeground(new java.awt.Color(0, 51, 255));
        btnHuyDoiMatKhau.setText("Hủy");
        btnHuyDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHuyDoiMatKhauMousePressed(evt);
            }
        });
        jPanel1.add(btnHuyDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, 40, -1));

        btnHuy.setBorder(null);
        btnHuy.setForeground(new java.awt.Color(62, 140, 251));
        btnHuy.setText("Hủy");
        btnHuy.setBorderColor(new java.awt.Color(240, 240, 240));
        btnHuy.setColorClick(new java.awt.Color(245, 245, 245));
        btnHuy.setColorHover(new java.awt.Color(245, 245, 245));
        btnHuy.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnHuy.setRadius(15);
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHuyMousePressed(evt);
            }
        });
        jPanel1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 174, 41));

        btnXoaTaiKhoan1.setBorder(null);
        btnXoaTaiKhoan1.setForeground(new java.awt.Color(102, 102, 102));
        btnXoaTaiKhoan1.setText("Xóa tài khoản");
        btnXoaTaiKhoan1.setBorderColor(new java.awt.Color(240, 240, 240));
        btnXoaTaiKhoan1.setColorClick(new java.awt.Color(245, 245, 245));
        btnXoaTaiKhoan1.setColorHover(new java.awt.Color(245, 245, 245));
        btnXoaTaiKhoan1.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnXoaTaiKhoan1.setRadius(15);
        btnXoaTaiKhoan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXoaTaiKhoan1MousePressed(evt);
            }
        });
        jPanel1.add(btnXoaTaiKhoan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 174, 30));

        btnDoiMatKhau.setForeground(new java.awt.Color(0, 51, 255));
        btnDoiMatKhau.setText("Đổi mật khẩu?");
        btnDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDoiMatKhauMousePressed(evt);
            }
        });
        jPanel1.add(btnDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void btnDangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMousePressed
        Application.frmDangNhapKH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDangXuatMousePressed

    private void btnSuaThongTinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinMousePressed
        if(btnSuaThongTin.getText().compareToIgnoreCase("Cập nhật") == 0)
        {
            setlblErrorEmpty();
            xuLyCapNhatThongTin();
        }
        else
        {
            btnHuy.setVisible(true);
            btnSuaThongTin.setText("Cập nhật");

            textFiledEditEnable(true);
        }
        
    }//GEN-LAST:event_btnSuaThongTinMousePressed

    private void btnHuyMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMousePressed
        btnHuy.setVisible(false);
        btnSuaThongTin.setText("Sửa thông tin");
        setlblErrorEmpty();
        textFiledEditEnable(false);
    }//GEN-LAST:event_btnHuyMousePressed

    private void btnXoaTaiKhoan1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaTaiKhoan1MousePressed
        int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tài khoản này?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION)
        {
            if(TaiKhoanKH_DAO.removeTaiKhoanKH(Application.taiKhoanKH.getTenTK())
                    && DuKhach_DAO.removeDuKhach(Application.taiKhoanKH.getMaDK()))
            {
                Application.frmDangNhapKH.setVisible(true);
                this.dispose();
                JOptionPane.showMessageDialog(null, "Xóa tài khoản thành công");
            }
            else
                JOptionPane.showMessageDialog(null, "Xóa tài khoản không thành công");
        }
    }//GEN-LAST:event_btnXoaTaiKhoan1MousePressed

    private void btnHuyDoiMatKhauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyDoiMatKhauMousePressed
        btnHuyDoiMatKhau.setVisible(false);
        btnDoiMatKhau.setText("Đổi mật khẩu?");
        lblPassError.setText("");
        txtPass.setEditable(false);
    }//GEN-LAST:event_btnHuyDoiMatKhauMousePressed

    private void btnDoiMatKhauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMatKhauMousePressed
        if(btnDoiMatKhau.getText().compareToIgnoreCase("Cập nhật") == 0)
        {
            lblPassError.setText("");
            xuLyCapNhatMatKhau();
        }
        else
        {
            btnHuyDoiMatKhau.setVisible(true);
            btnDoiMatKhau.setText("Cập nhật");
            txtPass.setEditable(true);
        }
    }//GEN-LAST:event_btnDoiMatKhauMousePressed

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
            java.util.logging.Logger.getLogger(FrmTaiKhoanKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTaiKhoanKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTaiKhoanKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTaiKhoanKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTaiKhoanKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom boxAvatar;
    private custom_components.ButtonCustom btnDangXuat;
    private javax.swing.JLabel btnDoiMatKhau;
    private custom_components.ButtonCustom btnHuy;
    private javax.swing.JLabel btnHuyDoiMatKhau;
    private custom_components.ButtonCustom btnSuaThongTin;
    private custom_components.ButtonCustom btnXoaTaiKhoan1;
    private custom_components.SVGImage iconEmail;
    private custom_components.SVGImage iconHoTen;
    private custom_components.SVGImage iconPass;
    private custom_components.SVGImage iconSDT;
    private custom_components.SVGImage iconTenTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblHoTenError;
    private javax.swing.JLabel lblPassError;
    private javax.swing.JLabel lblSoDienThoaiError;
    private javax.swing.JLabel lblTenTaiKhoanError;
    private javax.swing.JPanel pnEmail;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
