/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LE PHUC HAU
 */
public class jdbcHelper {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    static String url = "jdbc:sqlserver://localhost;database=Data_DichVuDL";
    static String user = "sa";
    static String pass = "sapassword"; 
    static{
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static PreparedStatement getStmt(String sql, Object...args)throws SQLException{
    Connection conn = DriverManager.getConnection(url,user, pass);
    PreparedStatement stmt;
    if(sql.trim().startsWith("{")){
        stmt = conn.prepareCall(sql);
    }else{
        stmt = conn.prepareStatement(sql);
    }
    for(int i=0; i < args.length; i++){
        stmt.setObject(i+1, args[i]);
    }
    return stmt;
    }
    public static ResultSet query(String sql, Object...args)throws SQLException{
        PreparedStatement stmt = jdbcHelper.getStmt(sql,args);
        return stmt.executeQuery();
    }
    public static Object value(String sql, Object...args){
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }
    public static int update(String sql, Object...args){
        try {
            PreparedStatement stmt = jdbcHelper.getStmt(sql,args);
            try {
                return stmt.executeUpdate();
            } finally{
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection()throws SQLException{
    Connection conn = DriverManager.getConnection(url,user, pass);
    return conn;
    }
}
