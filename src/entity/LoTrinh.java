/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author LE PHUC HAU
 */
public class LoTrinh {

    private String MaLoTrinh;
    private Date ThoiGianXuatPhat;
    private Date ThoiGianKetThuc;
    private String MaTour;
    private String DiemXuatPhat;
    private String DiemDen;
    

    public LoTrinh() {
    }

    public LoTrinh(String MaLoTrinh, Date ThoiGianXuatPhat, Date ThoiGianKetThuc,String MaTour, String DiemXuatPhat, String DiemDen) {
        this.MaLoTrinh = MaLoTrinh;
        this.ThoiGianXuatPhat = ThoiGianXuatPhat;
        this.ThoiGianKetThuc = ThoiGianKetThuc;
        this.DiemXuatPhat = DiemXuatPhat;
        this.DiemDen = DiemDen;
        this.MaTour = MaTour;
    }

    public LoTrinh(String maLT) {
        this.MaLoTrinh = maLT;
    }

    public void setMaLoTrinh(String MaLoTrinh) {
        this.MaLoTrinh = MaLoTrinh;
    }
    
    public String getMaLoTrinh() {
        return MaLoTrinh;
    }

    public Date getThoiGianXuatPhat() {
        return ThoiGianXuatPhat;
    }

    public void setThoiGianXuatPhat(Date ThoiGianXuatPhat) {
        this.ThoiGianXuatPhat = ThoiGianXuatPhat;
    }

    public Date getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public String getDiemXuatPhat() {
        return DiemXuatPhat;
    }

    public void setDiemXuatPhat(String DiemXuatPhat) {
        this.DiemXuatPhat = DiemXuatPhat;
    }

    public String getDiemDen() {
        return DiemDen;
    }

    public void setDiemDen(String DiemDen) {
        this.DiemDen = DiemDen;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String MaTour) {
        this.MaTour = MaTour;
    }

    @Override
    public String toString() {
        return this.MaLoTrinh;
    }

}
