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
import entity.Tour;

/**
 *
 * @author Asus
 */
public class Tour_DAO {
    public static List<Tour> getAllTour() {
        List<Tour> dsTour = new ArrayList<Tour>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from Tour";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String maTour = rs.getString("MATOUR").trim();
                String tenTour = rs.getString("TENTOUR");
                int soNgay = rs.getInt("SONGAY");
                float giaTour = rs.getFloat("GIATOUR");
                String ghiChu = rs.getString("GHICHU");
                Tour tour = new Tour(maTour, tenTour, soNgay, giaTour, ghiChu);
                dsTour.add(tour);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsTour;
    }

    public static boolean addTour(Tour tour) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into Tour values(?, ?, ?, ?, ?)");
            stmt.setString(1, tour.getMaTour());
            stmt.setString(2, tour.getTenTour());
            stmt.setInt(3, tour.getSoNgay());
            stmt.setFloat(4, tour.getGiaTour());
            stmt.setString(5, tour.getGhiChu());
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

    public static boolean updateTour(Tour tour) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update Tour set TENTOUR=?, SONGAY=?, GIATOUR=?, GHICHU=? where MATOUR=?");
            stmt.setString(1, tour.getTenTour());
            stmt.setInt(2, tour.getSoNgay());
            stmt.setFloat(3, tour.getGiaTour());
            stmt.setString(4, tour.getGhiChu());
            stmt.setString(5, tour.getMaTour());
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

    public static boolean removeTour(String maTour) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from Tour where maTour=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, maTour);
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
    
    public static Tour getTour(String maTour) {
            List<Tour> dsTour = new ArrayList<Tour>();
            ConnectDB.getInstance();
            Connection connection = ConnectDB.getConnection();
            try
            {
                    String sqlQuery = "Select * from Tour where MATOUR='" + maTour + "'";
                    Statement statement = connection.createStatement();

                    ResultSet rs = statement.executeQuery(sqlQuery);
                    while(rs.next())
                    {
                            String ma_Tour = rs.getString("MATOUR");
                            String tenTour = rs.getString("TENTOUR");
                            int soNgay = rs.getInt("SONGAY");
                            float giaTour = rs.getFloat("GIATOUR");
                            String ghiChu = rs.getString("GHICHU");
                            Tour tour = new Tour(maTour, tenTour, soNgay, giaTour, ghiChu);
                            dsTour.add(tour);
                    }
            }
            catch(Exception ex)
            {
                    ex.printStackTrace();
            }
            
            if(dsTour.size() == 0)
                return null;
            else
                return dsTour.get(0);
    }
    
    public static List<Tour> selectfindTours(String ma){
       List<Tour> lst = new ArrayList<Tour>();
       String sql = "select * from Tour where MATOUR like ? or TENTOUR like ?";
       Connection connection = ConnectDB.getConnection();
       PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + ma + "%");
            stmt.setString(2,"%" + ma + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
                    {
                            String ma1 = rs.getString("MATOUR").trim();
                            String ten = rs.getString("TENTOUR");
                            int soNgay = rs.getInt("SONGAY");
                            float gia = rs.getFloat("GIATOUR");
                            String ghiChu = rs.getString("GHICHU");
                            Tour t = new Tour(ma1, ten, soNgay, gia, ghiChu);
                            lst.add(t);
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
        return lst;
    }
}
