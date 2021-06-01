package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Accounts implements java.io.Serializable {
    private int fMaTk;
    private String fTaiKhoan;
    private String fPass;
    private String fHoTen;
    private Date fNgaySinh;
    private int fType;
    private String fDiaChi;
    private String fDienThoai;
    private String fGioiTinh;

    @Id
    @Column(name = "f_maTK", nullable = false)
    public int getfMaTk() {
        return fMaTk;
    }

    public void setfMaTk(int fMaTk) {
        this.fMaTk = fMaTk;
    }

    @Basic
    @Column(name = "f_taiKhoan", nullable = false, length = 10)
    public String getfTaiKhoan() {
        return fTaiKhoan;
    }

    public void setfTaiKhoan(String fTaiKhoan) {
        this.fTaiKhoan = fTaiKhoan;
    }

    @Basic
    @Column(name = "f_pass", nullable = false, length = 255)
    public String getfPass() {
        return fPass;
    }

    public void setfPass(String fPass) {
        this.fPass = fPass;
    }

    @Basic
    @Column(name = "f_hoTen", nullable = false, length = 255)
    public String getfHoTen() {
        return fHoTen;
    }

    public void setfHoTen(String fHoTen) {
        this.fHoTen = fHoTen;
    }

    @Basic
    @Column(name = "f_ngaySinh", nullable = true)
    public Date getfNgaySinh() {
        return fNgaySinh;
    }

    public void setfNgaySinh(Date fNgaySinh) {
        this.fNgaySinh = fNgaySinh;
    }

    @Basic
    @Column(name = "f_type", nullable = false)
    public int getfType() {
        return fType;
    }

    public void setfType(int fType) {
        this.fType = fType;
    }

    @Basic
    @Column(name = "f_diaChi", nullable = true, length = 255)
    public String getfDiaChi() {
        return fDiaChi;
    }

    public void setfDiaChi(String fDiaChi) {
        this.fDiaChi = fDiaChi;
    }

    @Basic
    @Column(name = "f_dienThoai", nullable = true, length = 12)
    public String getfDienThoai() {
        return fDienThoai;
    }

    public void setfDienThoai(String fDienThoai) {
        this.fDienThoai = fDienThoai;
    }

    @Basic
    @Column(name = "f_gioiTinh", nullable = true, length = 5)
    public String getfGioiTinh() {
        return fGioiTinh;
    }

    public void setfGioiTinh(String fGioiTinh) {
        this.fGioiTinh = fGioiTinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return fMaTk == accounts.fMaTk && fType == accounts.fType && Objects.equals(fTaiKhoan, accounts.fTaiKhoan) && Objects.equals(fPass, accounts.fPass) && Objects.equals(fHoTen, accounts.fHoTen) && Objects.equals(fNgaySinh, accounts.fNgaySinh) && Objects.equals(fDiaChi, accounts.fDiaChi) && Objects.equals(fDienThoai, accounts.fDienThoai) && Objects.equals(fGioiTinh, accounts.fGioiTinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaTk, fTaiKhoan, fPass, fHoTen, fNgaySinh, fType, fDiaChi, fDienThoai, fGioiTinh);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "fMaTk=" + fMaTk +
                ", fTaiKhoan='" + fTaiKhoan + '\'' +
                ", fPass='" + fPass + '\'' +
                ", fHoTen='" + fHoTen + '\'' +
                ", fNgaySinh=" + fNgaySinh +
                ", fType=" + fType +
                ", fDiaChi='" + fDiaChi + '\'' +
                ", fDienThoai='" + fDienThoai + '\'' +
                ", fGioiTinh='" + fGioiTinh + '\'' +
                '}';
    }
}
