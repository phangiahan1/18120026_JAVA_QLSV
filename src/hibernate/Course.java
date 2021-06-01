package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Course {
    private int fMaHp;
    private String fPhongHoc;
    private Integer fCaHoc;
    private String fThuHoc;

    @Id
    @Column(name = "f_maHP", nullable = false)
    public int getfMaHp() {
        return fMaHp;
    }

    public void setfMaHp(int fMaHp) {
        this.fMaHp = fMaHp;
    }

    @Basic
    @Column(name = "f_phongHoc", nullable = true, length = 255)
    public String getfPhongHoc() {
        return fPhongHoc;
    }

    public void setfPhongHoc(String fPhongHoc) {
        this.fPhongHoc = fPhongHoc;
    }

    @Basic
    @Column(name = "f_caHoc", nullable = true)
    public Integer getfCaHoc() {
        return fCaHoc;
    }

    public void setfCaHoc(Integer fCaHoc) {
        this.fCaHoc = fCaHoc;
    }

    @Basic
    @Column(name = "f_thuHoc", nullable = true, length = 255)
    public String getfThuHoc() {
        return fThuHoc;
    }

    public void setfThuHoc(String fThuHoc) {
        this.fThuHoc = fThuHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return fMaHp == course.fMaHp && Objects.equals(fPhongHoc, course.fPhongHoc) && Objects.equals(fCaHoc, course.fCaHoc) && Objects.equals(fThuHoc, course.fThuHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaHp, fPhongHoc, fCaHoc, fThuHoc);
    }
}
