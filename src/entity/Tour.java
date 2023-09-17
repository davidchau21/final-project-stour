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
public class Tour {

    private String MaTour;
    private String TenTour;
    private int SoNgay;
    private float GiaTour;
    private String GhiChu;

    public Tour() {
    }

    public Tour(String maTour) {
        this.MaTour = maTour;
    }
    
    public Tour(String MaTour, String TenTour, int SoNgay, float GiaTour, String GhiChu) {
        this.MaTour = MaTour;
        this.TenTour = TenTour;
        this.SoNgay = SoNgay;
        this.GiaTour = GiaTour;
        this.GhiChu = GhiChu;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String MaTour) {
        this.MaTour = MaTour;
    }

    public String getTenTour() {
        return TenTour;
    }

    public void setTenTour(String TenTour) {
        this.TenTour = TenTour;
    }

    public int getSoNgay() {
        return SoNgay;
    }

    public void setSoNgay(int SoNgay) {
        this.SoNgay = SoNgay;
    }

    public float getGiaTour() {
        return GiaTour;
    }

    public void setGiaTour(float GiaTour) {
        this.GiaTour = GiaTour;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return this.getTenTour();
    }
    
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.MaTour);
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
        final Tour other = (Tour) obj;
        return Objects.equals(this.MaTour, other.MaTour);
    }
}
