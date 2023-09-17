/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.HashCode;

import connectDB.ConnectDB;

public class NhanVien_DAO {

    public static List<NhanVien> getAllNhanVien() {
        List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from NhanVien";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String maNV = rs.getString("MANV").trim();
                String tenNV = rs.getString("TENNV");
                String sdt = rs.getString("SDT");
                boolean vaiTro = rs.getBoolean("VAITRO");
                String matKhau = rs.getString("MATKHAU");
                String email = rs.getString("EMAIL");
                String ghiChu = rs.getString("GHICHU");
                NhanVien nhanVien = new NhanVien(maNV, tenNV, sdt, vaiTro, matKhau, email, ghiChu);
                dsNhanVien.add(nhanVien);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsNhanVien;
    }

    public static boolean addNhanVien(NhanVien nhanVien) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into NhanVien values(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nhanVien.getMaNV());
            stmt.setString(2, nhanVien.getTenNV());
            stmt.setString(3, nhanVien.getSDT());
            stmt.setBoolean(4, nhanVien.getVaiTro());
            stmt.setString(5, HashCode.toHashCode(nhanVien.getMatKhau()));
            stmt.setString(6, nhanVien.getEmail());
            stmt.setString(7, nhanVien.getGhiChu());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public static boolean updateNhanVien(NhanVien nhanVien) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update NhanVien set TENNV=?, SDT=?, VAITRO=?, MATKHAU=?, EMAIL=?, GHICHU=? where MANV=?");
            stmt.setString(1, nhanVien.getTenNV());
            stmt.setString(2, nhanVien.getSDT());
            stmt.setBoolean(3, nhanVien.getVaiTro());
            stmt.setString(4, HashCode.toHashCode(nhanVien.getMatKhau()));
            stmt.setString(5, nhanVien.getEmail());
            stmt.setString(6, nhanVien.getGhiChu());
            stmt.setString(7, nhanVien.getMaNV());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public static boolean removeNhanVien(String maNV) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from NhanVien where maNV=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, maNV);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static NhanVien getNhanVien(String maNV) {
            List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
            ConnectDB.getInstance();
            Connection connection = ConnectDB.getConnection();
            try
            {
                    String sqlQuery = "Select * from NhanVien where MANV='" + maNV + "'";
                    Statement statement = connection.createStatement();

                    ResultSet rs = statement.executeQuery(sqlQuery);
                    while(rs.next())
                    {
                            String maNhanVien = rs.getString("MANV");
                            String tenNV = rs.getString("TENNV");
                            String std = rs.getString("SDT");
                            boolean vaiTro = rs.getBoolean("EMAIL");
                            String matKhau = rs.getString("MATKHAU");
                            String email = rs.getString("EMAIL");
                            String ghiChu = rs.getString("GHICHU");
                            NhanVien nhanVien = new NhanVien(maNV, tenNV, std, vaiTro, matKhau, email, ghiChu);
                            dsNhanVien.add(nhanVien);
                    }
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
            }
            
            if(dsNhanVien.size() == 0)
                return null;
            else
                return dsNhanVien.get(0);
    }
}
