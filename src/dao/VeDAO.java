/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.HashCode;
import entity.Ve;

/**
 *
 * @author ADMIN
 */
public class VeDAO {

    public static List<Ve> getAllVe() {
        List<Ve> lst = new ArrayList<Ve>();
        ConnectDB.getInstance();
        Connection conn = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from Ve";
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                int ma = rs.getInt("MAVE");
                String maDK = rs.getString("MADK");
                String tenTour = rs.getString("TENTOUR");
                String maLT = rs.getString("MALOTRINH");
                double giave = rs.getDouble("GIAVE");
                String ghiChu = rs.getString("GHICHU");
                Ve v = new Ve(ma, maDK, tenTour, maLT, giave, ghiChu);
                lst.add(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lst;
    }

    public static boolean addVe(Ve v) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into VE values(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, v.getMaVe());
            stmt.setString(2, v.getMaDK());
            stmt.setString(3, v.getTenTour());
            stmt.setString(4, v.getMaLoTrinh());
            stmt.setDouble(5, v.getGiaVe());
            stmt.setString(6, v.getGhiChu());
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

    public static boolean removeVe(int ma) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from VE where MAVE=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setInt(1, ma);
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
public static boolean updateVe(Ve ve) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update VE set MAVE=?, MADK=?, TENTOUR=?, MALOTRINH=?, GIAVE=?, GHICHU=? where MAVE=?");
            stmt.setInt(1, ve.getMaVe());
            stmt.setString(2, ve.getMaDK());
            stmt.setString(3, ve.getTenTour());
            stmt.setString(4, ve.getMaLoTrinh());
            stmt.setDouble(5, ve.getGiaVe());
            stmt.setString(6, ve.getGhiChu());
            stmt.setInt(7, ve.getMaVe());
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
    public static Ve getVe(String maVE) {
        List<Ve> lst = new ArrayList<Ve>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from VE where MAVE='" + maVE + "'";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                int ma = rs.getInt("MAVE");
                String ten = rs.getString("MADK");
                String tenTour = rs.getString("TENTOUR");
                String maLT = rs.getString("MALOTRINH");
                double giave = rs.getDouble("GIAVE");
                String ghiChu = rs.getString("GHICHU");
                Ve v = new Ve(ma, maLT, tenTour, maLT, giave, ghiChu);
                lst.add(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (lst.size() == 0) {
            return null;
        } else {
            return lst.get(0);
        }
    }

    public static List<Ve> selectfindVe(int ma) {
        List<Ve> lstVe = new ArrayList<Ve>();
        String sql = "select * from Ve where MAVE like ? or TENTOUR like ?";
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + ma + "%");
            stmt.setString(2, "%" + ma + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int ma1 = rs.getInt("MAVE");
                String ten = rs.getString("MADK");
                String tenTour = rs.getString("TENTOUR");
                String maLT = rs.getString("MALOTRINH");
                double giave = rs.getDouble("GIAVE");
                String ghiChu = rs.getString("GHICHU");
                Ve v = new Ve(ma1, maLT, tenTour, maLT, giave, ghiChu);
                lstVe.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lstVe;
    }

}
