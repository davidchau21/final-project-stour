/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.LoTrinh;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.HashCode;

/**
 *
 * @author DAVID
 */
public class LoTrinh_DAO {
    public static List<LoTrinh> getAllLoTrinh() {
        List<LoTrinh> dsLoTrinh = new ArrayList<LoTrinh>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from LoTrinh";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String maLT = rs.getString("MALOTRINH").trim();
                Date TgKT = rs.getDate("NGAYKETTHUC");
                Date TgXP = rs.getDate("NGAYXUATPHAT");
                String diemXP = rs.getString("DIEMXUATPHAT");
                String diemKT = rs.getString("DIEMDEN");
                String maTour = rs.getString("MATOUR");
                LoTrinh loTrinh = new LoTrinh(maLT, TgXP, TgKT, diemXP, diemKT, maTour);
                dsLoTrinh.add(loTrinh);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsLoTrinh;
    }

    public static boolean addLoTrinh(LoTrinh loTrinh) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into LoTrinh values(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, loTrinh.getMaLoTrinh());
            stmt.setDate(2, (java.sql.Date) loTrinh.getThoiGianXuatPhat());
            stmt.setDate(3, (java.sql.Date) loTrinh.getThoiGianKetThuc());
            stmt.setString(4, loTrinh.getDiemXuatPhat());
            stmt.setString(5, loTrinh.getDiemDen());
            stmt.setString(6, loTrinh.getMaTour());
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

    public static boolean updateLoTrinh(LoTrinh loTrinh) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update LoTrinh set TGXP=?, TGKT=?, DiemXP=?, DiemDen=?, MATOUR=? where MALT=?");
            stmt.setString(1, loTrinh.getMaLoTrinh());
            stmt.setDate(2, (java.sql.Date) loTrinh.getThoiGianXuatPhat());
            stmt.setDate(3, (java.sql.Date) loTrinh.getThoiGianKetThuc());
            stmt.setString(4, loTrinh.getDiemXuatPhat());
            stmt.setString(5, loTrinh.getDiemDen());
            stmt.setString(6, loTrinh.getMaTour());
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

    public static boolean removeLoTrinh(String maLT) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from LoTrinh where maLT=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, maLT);
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
    
    public static LoTrinh getLoTrinh(String maLT) {
            List<LoTrinh> dsLoTrinh = new ArrayList<LoTrinh>();
            ConnectDB.getInstance();
            Connection connection = ConnectDB.getConnection();
            try
            {
                    String sqlQuery = "Select * from LoTrinh where MALT='" + maLT + "'";
                    Statement statement = connection.createStatement();

                    ResultSet rs = statement.executeQuery(sqlQuery);
                    while(rs.next())
                    {
                            String maLoTrinh = rs.getString("MALT");
                            Date tgXP = rs.getDate("TGXP");
                            Date tgKT = rs.getDate("TGKT");
                            String DiemXP = rs.getString("DIEMXP");
                            String DiemKT = rs.getString("DIEMDEN");
                            String maTour = rs.getString("MATOUR");
                            LoTrinh loTrinh = new LoTrinh(maLoTrinh, tgXP, tgKT,maTour, DiemXP, DiemKT);
                            dsLoTrinh.add(loTrinh);
                    }
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
            }
            
            if(dsLoTrinh.size() == 0)
                return null;
            else
                return dsLoTrinh.get(0);
    }
}

