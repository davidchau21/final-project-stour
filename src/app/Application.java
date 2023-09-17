/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import gui.FrmBaoCaoThongKe;
import gui.FrmCaiDat;
import gui.FrmDangNhapKhachHang;
import gui.FrmQLDuKhach;
import gui.FrmQLLoTrinh;
import gui.FrmQLNV;
import gui.FrmQLLoTrinh;
import gui.FrmQLNhanVien;
import gui.FrmQLTour;
import gui.FrmQLTTTaiKhoan;
import gui.FrmQLTour;
import gui.FrmQLVe;
import gui.FrmThongBao;
import gui.FrmThongTin;
import gui.FrmTrangChuKH;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import java.util.List;

import entity.NhanVien;
import entity.TaiKhoanKH;
import gui.FrmDangKyKhachHang;
import gui.FrmDangNhapNhanVien;
import gui.FrmTourDaDat;
import gui.FrmTrangChuNV;
/**
 *
 * @author Asus
 */
public class Application {
    
    public static FrmTrangChuKH frmTrangChu = new FrmTrangChuKH();
    public static FrmTrangChuNV frmTrangChuNV = new FrmTrangChuNV();
    public static FrmQLNhanVien frmQLNhanVien = new FrmQLNhanVien();
    public static FrmQLDuKhach frmQLDuKhach = new FrmQLDuKhach();
    public static FrmQLTour frmQLTour = new FrmQLTour();
    public static FrmQLVe frmQLVe = new FrmQLVe();
    public static FrmQLLoTrinh frmQLLoTrinh = new FrmQLLoTrinh();
    public static FrmBaoCaoThongKe frmBCTK = new FrmBaoCaoThongKe();
    public static FrmDangNhapKhachHang frmDangNhapKH = new FrmDangNhapKhachHang();
    public static FrmDangNhapNhanVien frmDangNhapNV = new FrmDangNhapNhanVien();
    public static FrmDangKyKhachHang frmDangKyKH = new FrmDangKyKhachHang();
    public static FrmQLTTTaiKhoan frmQLTTTaiKhoan = new FrmQLTTTaiKhoan();
    public static FrmCaiDat frmCaiDat = new FrmCaiDat();
    public static FrmThongBao frmThongBao = new FrmThongBao();
    public static FrmThongTin frmThongTin = new FrmThongTin();
    public static FrmTourDaDat frmTourDaDat = new FrmTourDaDat();
    
    public static TaiKhoanKH taiKhoanKH;
    
    public static void main(String[] args) {
        // Connect Database
//        if(ConnectDB.connect())
//        {
//            System.out.println(ConnectDB.getConnection());
//            List<NhanVien> listNhanVien = NhanVien_DAO.getAllNhanVien();
//            System.out.println(listNhanVien.size());
//        }
//        else
//            System.out.println("false");
        
//        List<NhanVien> listNhanVien = NhanVien_DAO.getAllNhanVien();
//        System.out.println(listNhanVien.size());
        
//        String pass[] = new String[] {"Thanhtam", "Thumo", "Thanhtam@101002"};
//        for (String pas : pass) {
//            System.out.println(utils.HashCode.toHashCode(pas));
//        }

        // Fist dislay form
        frmDangNhapKH.setVisible(true);
        
    }
    
}
