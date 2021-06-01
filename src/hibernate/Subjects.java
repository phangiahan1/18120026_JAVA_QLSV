package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Subjects {
    private int fMaMh;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return fMaMh == subjects.fMaMh && fSoTinChi == subjects.fSoTinChi && Objects.equals(fTenMh, subjects.fTenMh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaMh, fTenMh, fSoTinChi);
    }
}
