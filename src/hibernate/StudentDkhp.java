package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StudentDkhp {
    private int fMaHSHP;
    private int fMaCourse;
    private int fMaTK;
    private Date fngayDKhp;

    @Id
    @Column(name = "f_maHSHP", nullable = false)
    public int getfMaHSHP() {
        return fMaHSHP;
    }

    public void setfMaHSHP(int fMaHSHP) {
        this.fMaHSHP = fMaHSHP;
    }

    @Basic
    @Column(name = "f_maCourse", nullable = false)
    public int getfMaCourse() {
        return fMaCourse;
    }

    public void setfMaCourse(int fMaCourse) {
        this.fMaCourse = fMaCourse;
    }

    @Basic
    @Column(name = "f_maTKSV", nullable = false)
    public int getfMaTK() {
        return fMaTK;
    }

    public void setfMaTK(int fMaTK) {
        this.fMaTK = fMaTK;
    }

    @Basic
    @Column(name = "f_ngayDKhp", nullable = false)
    public Date getFngayDKhp() {
        return fngayDKhp;
    }

    public void setFngayDKhp(Date fngayDKhp) {
        this.fngayDKhp = fngayDKhp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDkhp that = (StudentDkhp) o;
        return fMaCourse == that.fMaCourse && fMaTK == that.fMaTK;
    }

    @Override
    public String toString() {
        return "StudentDkhp{" +
                "fMaHSHP=" + fMaHSHP +
                ", fMaCourse=" + fMaCourse +
                ", fMaTK=" + fMaTK +
                ", fngayDKhp=" + fngayDKhp +
                '}';
    }
}
