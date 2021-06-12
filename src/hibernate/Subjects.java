package hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subjects {
    private int fMaMh;
    private String fidMh;


    private String fTenMh;
    private int fSoTinChi;


    @Id
    @Column(name = "f_maMH", nullable = false)
    public int getfMaMh() {
        return fMaMh;
    }

    public void setfMaMh(int fMaMh) {
        this.fMaMh = fMaMh;
    }

    @Basic
    @Column(name = "f_idMH", nullable = false, length = 255)
    public String getFidMh() {
        return fidMh;
    }

    public void setFidMh(String fidMh) {
        this.fidMh = fidMh;
    }

    @Basic
    @Column(name = "f_tenMH", nullable = false, length = 255)
    public String getfTenMh() {
        return fTenMh;
    }

    public void setfTenMh(String fTenMh) {
        this.fTenMh = fTenMh;
    }

    @Basic
    @Column(name = "f_soTinChi", nullable = false)
    public int getfSoTinChi() {
        return fSoTinChi;
    }

    public void setfSoTinChi(int fSoTinChi) {
        this.fSoTinChi = fSoTinChi;
    }

    // liên kết với 1 biến bên class Course tên là private Course _monHoc
    @OneToMany(mappedBy = "_monHoc", cascade = CascadeType.ALL)
    private List<Course> _listHocPhan = new ArrayList<Course>();

    public List<Course> get_listHocPhan() {
        return _listHocPhan;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "fMaMh=" + fMaMh +
                ", fidMh='" + fidMh + '\'' +
                ", fTenMh='" + fTenMh + '\'' +
                ", fSoTinChi=" + fSoTinChi +
                ", _listHocPhan=" + _listHocPhan +
                '}';
    }

    public void set_listHocPhan(List<Course> _listHocPhan) {
        this._listHocPhan = _listHocPhan;
    }
}
