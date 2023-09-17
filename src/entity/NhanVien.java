
package entity;

import java.util.Objects;

public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String SDT;
    private boolean VaiTro;
    private String MatKhau;
    private String Email;
    private String GhiChu;
    
    public NhanVien(String MaNV, String TenNV, String SDT, boolean VaiTro, String MatKhau, String Email, String GhiChu) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.VaiTro = VaiTro;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.GhiChu = GhiChu;
    }
    
    public NhanVien(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public NhanVien() {
        
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
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
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.MaNV);
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.MaNV, other.MaNV);
    }
    
    
}
