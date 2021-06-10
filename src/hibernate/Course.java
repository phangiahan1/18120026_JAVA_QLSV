package hibernate;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Course {
    private int fMaHp;
    private String fPhongHoc;
    private Integer fCaHoc;
    private String fThuHoc;
    private int fMaHk;
    private int fMaMH;
    private int fSoSlot;


    private int fMaGv;

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

    // liên kết với 1 biến bên class Subjects tên là private List<Course> _listHocPhan
    // mappedBy = "_lopHoc"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_maMH")
    private Subjects _monHoc;
    // liên kết với 1 biến bên class Subjects tên là private List<Course> _listHocPhan
    // mappedBy = "_lopHoc"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_maHK")
    private Semester _hocKi;

    @Basic
    @Column(name = "f_maHK", nullable = false)
    public int getfMaHk() {
        return fMaHk;
    }

    public void setfMaHk(int fMaHk) {
        this.fMaHk = fMaHk;
    }

    @Basic
    @Column(name = "f_maMH", nullable = false)
    public int getfMaMH() {
        return fMaMH;
    }

    public void setfMaMH(int fMaMH) {
        this.fMaMH = fMaMH;
    }

    @Basic
    @Column(name = "f_idGV", nullable = false)
    public int getfMaGv() {
        return fMaGv;
    }

    public void setfMaGv(int fMaGv) {
        this.fMaGv = fMaGv;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_dkhp",
            joinColumns = {@JoinColumn(name = "f_maCourse")},
            inverseJoinColumns = {@JoinColumn(name = "f_maTKSV")})
    private Set<AccountsStu> sinhvienList = new HashSet<>();

    @Basic
    @Column(name = "f_soSlot", nullable = false)
    public int getfSoSlot() {
        return fSoSlot;
    }

    public Subjects get_monHoc() {
        return _monHoc;
    }

    public void set_monHoc(Subjects _monHoc) {
        this._monHoc = _monHoc;
    }

    public Semester get_hocKi() {
        return _hocKi;
    }

    public void set_hocKi(Semester _hocKi) {
        this._hocKi = _hocKi;
    }

    public void setfSoSlot(int fSoSlot) {
        this.fSoSlot = fSoSlot;
    }

    @Override
    public String toString() {
        return "Course{" +
                "fMaHp=" + fMaHp +
                ", fPhongHoc='" + fPhongHoc + '\'' +
                ", fCaHoc=" + fCaHoc +
                ", fThuHoc='" + fThuHoc + '\'' +
                ", fMaHk=" + fMaHk +
                ", fMaMH=" + fMaMH +
                ", fSoSlot=" + fSoSlot +
                ", fMaGv=" + fMaGv +
                ", _monHoc=" + _monHoc +
                ", _hocKi=" + _hocKi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return fMaHk == course.fMaHk && fMaMH == course.fMaMH && fSoSlot == course.fSoSlot && fMaGv == course.fMaGv && fPhongHoc.equals(course.fPhongHoc) && fCaHoc.equals(course.fCaHoc) && fThuHoc.equals(course.fThuHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fPhongHoc, fCaHoc, fThuHoc, fMaHk, fMaMH, fSoSlot, fMaGv);
    }

    public Set<AccountsStu> getSinhvienList() {
        return sinhvienList;
    }

    public void setSinhvienList(Set<AccountsStu> sinhvienList) {
        this.sinhvienList = sinhvienList;
    }
}
