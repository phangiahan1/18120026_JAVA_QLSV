package hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@Table(name = "class", schema = "qlsv", catalog = "")
@Table(name = "class", schema = "qlsv")
public class Clazz {
    private int fMaLh;
    private String fTenLh;

    private int f_tongSV;
    private int f_tongNam;
    private int f_tongNu;

    @Id
    @Column(name = "f_maLH", nullable = false)
    public int getfMaLh() {
        return fMaLh;
    }

    public void setfMaLh(int fMaLh) {
        this.fMaLh = fMaLh;
    }

    @Basic
    @Column(name = "f_tenLH", nullable = true, length = 10)
    public String getfTenLh() {
        return fTenLh;
    }

    public void setfTenLh(String fTenLh) {
        this.fTenLh = fTenLh;
    }

    // liên kết với 1 biến bên class AccountsStu tên là private Clazz _lopHoc
    @OneToMany(mappedBy = "_lopHoc", cascade = CascadeType.ALL)
    private List<AccountsStu> _listSinhVien = new ArrayList<AccountsStu>();

    @Basic
    @Column(name = "f_tongSV", nullable = true)
    public int getF_tongSV() {
        return f_tongSV;
    }

    public void setF_tongSV(int f_tongSV) {
        this.f_tongSV = f_tongSV;
    }

    @Basic
    @Column(name = "f_tongNam", nullable = true)
    public int getF_tongNam() {
        return f_tongNam;
    }

    public void setF_tongNam(int f_tongNam) {
        this.f_tongNam = f_tongNam;
    }

    @Basic
    @Column(name = "f_tongNu", nullable = true)

    public int getF_tongNu() {
        return f_tongNu;
    }

    public void setF_tongNu(int f_tongNu) {
        this.f_tongNu = f_tongNu;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "fMaLh=" + fMaLh +
                ", fTenLh='" + fTenLh + '\'' +
                ", f_tongSV=" + f_tongSV +
                ", f_tongNam=" + f_tongNam +
                ", f_tongNu=" + f_tongNu +
                ", _listSinhVien=" + _listSinhVien +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return fMaLh == clazz.fMaLh && f_tongSV == clazz.f_tongSV && f_tongNam == clazz.f_tongNam && f_tongNu == clazz.f_tongNu && Objects.equals(fTenLh, clazz.fTenLh) && Objects.equals(_listSinhVien, clazz._listSinhVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaLh, fTenLh, f_tongSV, f_tongNam, f_tongNu, _listSinhVien);
    }

    public List<AccountsStu> get_listSinhVien() {
        return _listSinhVien;
    }

    public void set_listSinhVien(List<AccountsStu> _listSinhVien) {
        this._listSinhVien = _listSinhVien;
    }

    public void addSinhVien(AccountsStu sv) {
        sv.set_lopHoc(this);
        _listSinhVien.add(sv);
    }
}
