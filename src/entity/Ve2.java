/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Ve2 {

    private String maVe;
    private String tenTK;
    private String maTour;
    private String ngayDatVe;
    private String ghiChu;

    public Ve2(String maVe, String tenTK, String maTour, String ngayDatVe, String ghiChu) {
        this.maVe = maVe;
        this.tenTK = tenTK;
        this.maTour = maTour;
        this.ngayDatVe = ngayDatVe;
        this.ghiChu = ghiChu;
    }

    public Ve2() {
    }
    
    public Ve2(String maVe) {
        this.maVe = maVe;
    }
    
    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(String ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.maVe);
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
        final Ve2 other = (Ve2) obj;
        return Objects.equals(this.maVe, other.maVe);
    }

    
    
}
