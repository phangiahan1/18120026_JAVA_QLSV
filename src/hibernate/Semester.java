package hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    // liên kết với 1 biến bên class Dkhp tên là private Dkhp _hocki
    @OneToMany(mappedBy = "_hocki", cascade = CascadeType.ALL)
    private List<Dkhp> _listDKHP = new ArrayList<Dkhp>();
    // liên kết với 1 biến bên class Course tên là private Course _hocKi
    @OneToMany(mappedBy = "_hocKi", cascade = CascadeType.ALL)
    private List<Course> _listHocPhanHocKi = new ArrayList<Course>();

    public List<Dkhp> get_listDKHP() {
        return _listDKHP;
    }

    public void set_listDKHP(List<Dkhp> _listDKHP) {
        this._listDKHP = _listDKHP;
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
                ", _listDKHP=" + _listDKHP +
                '}';
    }

    public List<Course> get_listHocPhanHocKi() {
        return _listHocPhanHocKi;
    }

    public void set_listHocPhanHocKi(List<Course> _listHocPhanHocKi) {
        this._listHocPhanHocKi = _listHocPhanHocKi;
    }
}
