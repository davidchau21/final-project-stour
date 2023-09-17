/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

public class TaiKhoanKH {

    private String tenTK;
    private String maDK;
    private String matKhau;
    private String avatar = "";

    public TaiKhoanKH(String tenTK, String maDK, String matKhau) {
        this.maDK = maDK;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.avatar = "";
    }
    
    public TaiKhoanKH(String tenTK, String maDK, String matKhau, String avatar) {
         this.maDK = maDK;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.avatar = avatar;
    }

    public TaiKhoanKH() {
    }
    
    public TaiKhoanKH(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    public String getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.tenTK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoanKH other = (TaiKhoanKH) obj;
        return Objects.equals(this.tenTK, other.tenTK);
    }

    @Override
    public String toString() {
        return tenTK + " " + maDK;
    }

}
