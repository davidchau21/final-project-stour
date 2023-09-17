/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.DuKhach;
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

public class DuKhach_DAO {
    public static List<DuKhach> getAllDuKhach() {
        List<DuKhach> dsDuKhach = new ArrayList<DuKhach>();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from DUKHACH";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String maDK = rs.getString("MADK").trim();
                String tenDK = rs.getString("TENDK");
                String sdt = rs.getString("SDT");
                String email = rs.getString("EMAIL");
                String ghiChu = rs.getString("GHICHU");
                DuKhach duKhach = new DuKhach(maDK, tenDK, sdt, email, ghiChu);
                dsDuKhach.add(duKhach);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsDuKhach;
    }

    public static boolean addDuKhach(DuKhach duKhach) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into DuKhach values(?, ?, ?, ?, ?)");
            stmt.setString(1, duKhach.getMaDK());
            stmt.setString(2, duKhach.getTenDK());
            stmt.setString(3, duKhach.getSDT());
            stmt.setString(4, duKhach.getEmail());
            stmt.setString(5, duKhach.getGhiChu());
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

    public static boolean updateDuKhach(DuKhach duKhach) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update DuKhach set TENDK=?, SDT=?, EMAIL=?, GHICHU=? where MADK=?");
            stmt.setString(1, duKhach.getTenDK());
            stmt.setString(2, duKhach.getSDT());
            stmt.setString(3, duKhach.getEmail());
            stmt.setString(4, duKhach.getGhiChu());
            stmt.setString(5, duKhach.getMaDK());
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

    public static boolean removeDuKhach(String maDK) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from DUKHACH where maDK=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, maDK);
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
    
    public static DuKhach getDuKhach(String maDK) {
        List<DuKhach> dsDuKhach = new ArrayList<DuKhach>();
        Connection connection = ConnectDB.getConnection();
        try
        {
                String sqlQuery = "Select * from DUKHACH where MADK='" + maDK + "'";
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    String _maDK = rs.getString("MADK").trim();
                    String tenDK = rs.getString("TENDK");
                    String sdt = rs.getString("SDT");
                    String email = rs.getString("EMAIL");
                    String ghiChu = rs.getString("GHICHU");
                    DuKhach duKhach = new DuKhach(_maDK, tenDK, sdt, email, ghiChu);
                    dsDuKhach.add(duKhach);
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }

        if(dsDuKhach.size() == 0)
            return null;
        else
            return dsDuKhach.get(0);
    }
    
    public static DuKhach getDuKhachTheoSDT(String sdt) {
        List<DuKhach> dsDuKhach = new ArrayList<DuKhach>();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from DUKHACH where SDT='" + sdt + "'";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String maDK = rs.getString("MADK").trim();
                String tenDK = rs.getString("TENDK");
                String _sdt = rs.getString("SDT");
                String email = rs.getString("EMAIL");
                String ghiChu = rs.getString("GHICHU");
                DuKhach duKhach = new DuKhach(maDK, tenDK, sdt, email, ghiChu);
                dsDuKhach.add(duKhach);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (dsDuKhach.size() == 0)
            return null;
        else
            return dsDuKhach.get(0);
    }
}
