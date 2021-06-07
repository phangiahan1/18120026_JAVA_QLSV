package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Semester {
    private int fMaHk;
    private String fTenHk;
    private String fNamHoc;
    private Date fNgayBd;
    private Date fNgayKt;
    private Integer fHKhienTai;

    @Id
    @Column(name = "f_maHK", nullable = false)
    public int getfMaHk() {
        return fMaHk;
    }

    public void setfMaHk(int fMaHk) {
        this.fMaHk = fMaHk;
    }

    @Basic
    @Column(name = "f_tenHK", nullable = true, length = 5)
    public String getfTenHk() {
        return fTenHk;
    }

    public void setfTenHk(String fTenHk) {
        this.fTenHk = fTenHk;
    }

    @Basic
    @Column(name = "f_namHoc", nullable = false, length = 15)
    public String getfNamHoc() {
        return fNamHoc;
    }

    public void setfNamHoc(String fNamHoc) {
        this.fNamHoc = fNamHoc;
    }

    @Basic
    @Column(name = "f_ngayBD", nullable = false)
    public Date getfNgayBd() {
        return fNgayBd;
    }

    public void setfNgayBd(Date fNgayBd) {
        this.fNgayBd = fNgayBd;
    }

    @Basic
    @Column(name = "f_ngayKT", nullable = false)
    public Date getfNgayKt() {
        return fNgayKt;
    }

    public void setfNgayKt(Date fNgayKt) {
        this.fNgayKt = fNgayKt;
    }

    @Basic
    @Column(name = "f_HKhienTai", nullable = true)
    public Integer getfHKhienTai() {
        return fHKhienTai;
    }

    public void setfHKhienTai(Integer fHKhienTai) {
        this.fHKhienTai = fHKhienTai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return fMaHk == semester.fMaHk && fNamHoc == semester.fNamHoc && Objects.equals(fTenHk, semester.fTenHk) && Objects.equals(fNgayBd, semester.fNgayBd) && Objects.equals(fNgayKt, semester.fNgayKt) && Objects.equals(fHKhienTai, semester.fHKhienTai);
    }

    @Override
    public String toString() {
        return "Semester{" +
                "fMaHk=" + fMaHk +
                ", fTenHk='" + fTenHk + '\'' +
                ", fNamHoc='" + fNamHoc + '\'' +
                ", fNgayBd=" + fNgayBd +
                ", fNgayKt=" + fNgayKt +
                ", fHKhienTai=" + fHKhienTai +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaHk, fTenHk, fNamHoc, fNgayBd, fNgayKt, fHKhienTai);
    }

}
