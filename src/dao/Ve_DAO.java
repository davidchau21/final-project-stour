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
import entity.Ve2;


public class Ve_DAO {
    public static List<Ve2> getAllVe() {
        List<Ve2> dsVe = new ArrayList<Ve2>();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from VE2";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String maVe = rs.getString("MAVE").trim();
                String tenTK = rs.getString("TENTK");
                String maTour = rs.getString("MATOUR");
                String ngayDatVe = rs.getString("NGAYDATVE");                
                String ghiChu = rs.getString("GHICHU");
                Ve2 ve = new Ve2(maVe, tenTK, maTour, ngayDatVe, ghiChu);
                dsVe.add(ve);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsVe;
    }

    public static boolean addVe(Ve2 ve) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into VE2 values(?, ?, ?, ?, ?)");
            stmt.setString(1, ve.getMaVe());
            stmt.setString(2, ve.getTenTK());
            stmt.setString(3, ve.getMaTour());
            stmt.setString(4, ve.getNgayDatVe());
            stmt.setString(5, ve.getGhiChu());
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

    public static boolean updateVe(Ve2 ve) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update VE2 set TENTK=?, MATOUR=?, NGAYDATVE=?, GHICHU=?,  where MAVE=?");
            stmt.setString(1, ve.getTenTK());
            stmt.setString(2, ve.getMaTour());
            stmt.setString(3, ve.getNgayDatVe());
            stmt.setString(4, ve.getGhiChu());
            stmt.setString(5, ve.getMaVe());
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

    public static boolean removeVe(String maVe) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from VE2 where maVe=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, maVe);
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
    
    public static Ve2 getVe(String maVe) {
            List<Ve2> dsVe = new ArrayList<Ve2>();
            ConnectDB.getInstance();
            Connection connection = ConnectDB.getConnection();
            try
            {
                    String sqlQuery = "Select * from Tour where VE2='" + maVe + "'";
                    Statement statement = connection.createStatement();

                    ResultSet rs = statement.executeQuery(sqlQuery);
                    while (rs.next()) {
                        String _maVe = rs.getString("MAVE").trim();
                        String tenTK = rs.getString("TENTK");
                        String maTour = rs.getString("MATOUR");
                        String ngayDatVe = rs.getString("NGAYDATVE");                
                        String ghiChu = rs.getString("GHICHU");
                        Ve2 ve = new Ve2(_maVe, tenTK, maTour, ngayDatVe, ghiChu);
                        dsVe.add(ve);
                    }
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
            }
            
            if(dsVe.size() == 0)
                return null;
            else
                return dsVe.get(0);
    }
}
