package hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AccountsStu implements java.io.Serializable {
    private int fMaTkSV;
    private String fTaiKhoan;
    private String fPass;
    private String fHoTen;
    private Date fNgaySinh;
    private int fType;
    private String fDiaChi;
    private String fDienThoai;
    private String fGioiTinh;
    private int fMaLop;
    // liên kết với 1 biến bên class Clazz tên là private List<SinhVien> _listSinhVien
    // mappedBy = "_lopHoc"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_maLH")
    private Clazz _lopHoc;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_dkhp",
            joinColumns = {@JoinColumn(name = "f_maTKSV")},
            inverseJoinColumns = {@JoinColumn(name = "f_maCourse")})
    private Set<Course> hocPhanList = new HashSet<>();

    public Set<Course> getHocPhanList() {
        return hocPhanList;
    }

    public void setHocPhanList(Set<Course> hocPhanList) {
        this.hocPhanList = hocPhanList;
    }

    @Id
    @Column(name = "f_maTKSV", nullable = false)
    public int getfMaTkSV() {
        return fMaTkSV;
    }

    public void setfMaTkSV(int fMaTkSV) {
        this.fMaTkSV = fMaTkSV;
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

    @Basic
    @Column(name = "f_maLH", nullable = true)
    public int getfMaLop() {
        return fMaLop;
    }

    public void setfMaLop(int fMaLop) {
        this.fMaLop = fMaLop;
    }

    @Override
    public String toString() {
        return "AccountsStu{" +
                "fMaTkSV=" + fMaTkSV +
                ", fTaiKhoan='" + fTaiKhoan + '\'' +
                ", fPass='" + fPass + '\'' +
                ", fHoTen='" + fHoTen + '\'' +
                ", fNgaySinh=" + fNgaySinh +
                ", fType=" + fType +
                ", fDiaChi='" + fDiaChi + '\'' +
                ", fDienThoai='" + fDienThoai + '\'' +
                ", fGioiTinh='" + fGioiTinh + '\'' +
                ", fMaLop=" + fMaLop +
                ", _lopHoc=" + _lopHoc +
                '}';
    }

    public Clazz get_lopHoc() {
        return _lopHoc;
    }

    public void set_lopHoc(Clazz _lopHoc) {
        this._lopHoc = _lopHoc;
    }


}
