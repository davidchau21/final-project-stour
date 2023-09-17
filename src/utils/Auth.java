/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.NhanVien;


/**
 *
 * @author educity
 */
public class Auth {
    
    public static NhanVien user = null; // Duy trì user đăng nhập vào hệ thống
    public static void clear() {
        Auth.user = null;
    }
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin() && user.getVaiTro();
    }
}
