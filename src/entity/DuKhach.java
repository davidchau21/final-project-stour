/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author LE PHUC HAU
 */
public class DuKhach {

    private String MaDK;
    private String TenDK;
    private String SDT;
    private String Email;
    private String GhiChu;

    public DuKhach(String MaDK, String TenDK, String SDT, String Email, String GhiChu) {
        this.MaDK = MaDK;
        this.TenDK = TenDK;
        this.SDT = SDT;
        this.Email = Email;
        this.GhiChu = GhiChu;
    }

    public DuKhach() {
    }
    
    public DuKhach(String maDK) {
        this.MaDK = maDK;
    }

    public String getMaDK() {
        return MaDK;
    }

    public void setMaDK(String MaDK) {
        this.MaDK = MaDK;
    }

    public String getTenDK() {
        return TenDK;
    }

    public void setTenDK(String TenDK) {
        this.TenDK = TenDK;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return this.TenDK + " (" + this.MaDK.trim() + ")";
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.MaDK);
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
        final DuKhach other = (DuKhach) obj;
        return Objects.equals(this.MaDK, other.MaDK);
    }
}
