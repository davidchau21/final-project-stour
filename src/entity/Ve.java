/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author LE PHUC HAU
 */
public class Ve {

    int MaVe;
    String MaDK;
    String TenTour;
    String MaLoTrinh;
    double giaVe;
    String GhiChu;

    public Ve() {
    }

    public int getMaVe() {
        return MaVe;
    }

    public void setMaVe(int MaVe) {
        this.MaVe = MaVe;
    }

    public String getMaDK() {
        return MaDK;
    }

    public void setMaDK(String MaDK) {
        this.MaDK = MaDK;
    }

    public String getTenTour() {
        return TenTour;
    }

    public void setTenTour(String TenTour) {
        this.TenTour = TenTour;
    }

    public String getMaLoTrinh() {
        return MaLoTrinh;
    }

    public void setMaLoTrinh(String MaLoTrinh) {
        this.MaLoTrinh = MaLoTrinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.GhiChu = ghiChu;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public double getGiaVe() {
        return this.giaVe;
    }

    public Ve(int maVe, String maDK, String tenTour, String maLoTrinh, double giaVe, String ghiChu) {
        MaVe = maVe;
        MaDK = maDK;
        TenTour = tenTour;
        MaLoTrinh = maLoTrinh;
        this.giaVe = giaVe;
        GhiChu = ghiChu;
    }
    public Ve(int maVe) {
        this.MaVe = maVe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.MaVe;
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
        final Ve other = (Ve) obj;
        return this.MaVe == other.MaVe;
    }
    
    
}
