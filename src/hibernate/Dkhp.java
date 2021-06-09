package hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Dkhp {
    private int fMaDkhp;
    private Date fNgayDbdk;
    private Date fNgayKtdk;
    private int fMaHK;

    @Id
    @Column(name = "f_maDKHP", nullable = false)
    public int getfMaDkhp() {
        return fMaDkhp;
    }

    public void setfMaDkhp(int fMaDkhp) {
        this.fMaDkhp = fMaDkhp;
    }

    @Basic
    @Column(name = "f_ngayDBDK", nullable = true)
    public Date getfNgayDbdk() {
        return fNgayDbdk;
    }

    public void setfNgayDbdk(Date fNgayDbdk) {
        this.fNgayDbdk = fNgayDbdk;
    }

    @Basic
    @Column(name = "f_ngayKTDK", nullable = true)
    public Date getfNgayKtdk() {
        return fNgayKtdk;
    }

    public void setfNgayKtdk(Date fNgayKtdk) {
        this.fNgayKtdk = fNgayKtdk;
    }

    // liên kết với 1 biến bên class Semester tên là private List<Dkhp> _listDKHP
    // mappedBy = "_hocki"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_maHK")
    private Semester _hocki;

    @Basic
    @Column(name = "f_maHK", nullable = false)

    public int getfMaHK() {
        return fMaHK;
    }

    public void setfMaHK(int fMaHK) {
        this.fMaHK = fMaHK;
    }

    public Semester get_hocki() {
        return _hocki;
    }

    public void set_hocki(Semester _hocki) {
        this._hocki = _hocki;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dkhp dkhp = (Dkhp) o;
        return fMaDkhp == dkhp.fMaDkhp && Objects.equals(fNgayDbdk, dkhp.fNgayDbdk) && Objects.equals(fNgayKtdk, dkhp.fNgayKtdk) && Objects.equals(_hocki, dkhp._hocki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaDkhp, fNgayDbdk, fNgayKtdk, _hocki);
    }

    @Override
    public String toString() {
        return "Dkhp{" +
                "fMaDkhp=" + fMaDkhp +
                ", fNgayDbdk=" + fNgayDbdk +
                ", fNgayKtdk=" + fNgayKtdk +
                ", _hocki=" + _hocki +
                '}';
    }
}
