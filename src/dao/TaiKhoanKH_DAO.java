/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.TaiKhoanKH;
import connectDB.ConnectDB;
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


public class TaiKhoanKH_DAO {
    
    public static List<TaiKhoanKH> getAllTaiKhoanKH() {
        List<TaiKhoanKH> dsTaiKhoanKH = new ArrayList<TaiKhoanKH>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try {
            String sqlQuery = "Select * from TAIKHOANKH";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String tenTK = rs.getString("TENTK");
                String maDK = rs.getString("MADK");
                String matKhau = rs.getString("MATKHAU");
                String avatar = rs.getString("AVATAR");
                TaiKhoanKH taiKhoanKH = new TaiKhoanKH(tenTK, maDK, matKhau, avatar);
                dsTaiKhoanKH.add(taiKhoanKH);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsTaiKhoanKH;
    }

    public static boolean addTaiKhoanKH(TaiKhoanKH taiKhoanKH) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("insert into TAIKHOANKH values(?, ?, ?, ?)");
            stmt.setString(1, taiKhoanKH.getTenTK());
            stmt.setString(2, taiKhoanKH.getMaDK());
            stmt.setString(3, HashCode.toHashCode(taiKhoanKH.getMatKhau()));
            stmt.setString(4, taiKhoanKH.getAvatar());
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

    public static boolean updateTaiKhoanKH(TaiKhoanKH taiKhoanKH) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement("update TAIKHOANKH set MADK=?, MATKHAU=?, AVATAR=? where TENTK=?");
            stmt.setString(1, taiKhoanKH.getMaDK());
            stmt.setString(2, HashCode.toHashCode(taiKhoanKH.getMatKhau()));
            stmt.setString(3, taiKhoanKH.getAvatar());
            stmt.setString(4, taiKhoanKH.getTenTK());
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

    public static boolean removeTaiKhoanKH(String tenTK) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        String sqlQuery = "delete from TAIKHOANKH where TENTK=?";
        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, tenTK);
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
    
    public static TaiKhoanKH getTaiKhoanKH(String tenTK) {
        List<TaiKhoanKH> dsTaiKhoanKH = new ArrayList<TaiKhoanKH>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try
        {
                String sqlQuery = "Select * from TAIKHOANKH where TENTK='" + tenTK + "'";
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    String _tenTK = rs.getString("TENTK");
                    String maDK = rs.getString("MADK");
                    String matKhau = rs.getString("MATKHAU");
                    String avatar = rs.getString("AVATAR");
                    TaiKhoanKH taiKhoanKH = new TaiKhoanKH(_tenTK, maDK, matKhau, avatar);
                    dsTaiKhoanKH.add(taiKhoanKH);
                }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        if(dsTaiKhoanKH.size() == 0)
            return null;
        else
            return dsTaiKhoanKH.get(0);
    }
    
    public static TaiKhoanKH getTaiKhoanKHTheoMaDK(String maDK) {
        List<TaiKhoanKH> dsTaiKhoanKH = new ArrayList<TaiKhoanKH>();
        ConnectDB.getInstance();
        Connection connection = ConnectDB.getConnection();
        try
        {
                String sqlQuery = "Select * from TAIKHOANKH where MADK='" + maDK + "'";
                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(sqlQuery);
                while (rs.next()) {
                    String tenTK = rs.getString("TENTK");
                    String _maDK = rs.getString("MADK");
                    String matKhau = rs.getString("MATKHAU");
                    String avatar = rs.getString("AVATAR");
                    TaiKhoanKH taiKhoanKH = new TaiKhoanKH(tenTK, _maDK, matKhau, avatar);
                    dsTaiKhoanKH.add(taiKhoanKH);
                }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        if(dsTaiKhoanKH.size() == 0)
            return null;
        else
            return dsTaiKhoanKH.get(0);
    }
}
