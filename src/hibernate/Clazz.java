package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "qlsv", catalog = "")
public class Clazz {
    private int fMaLh;
    private String fTenLh;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return fMaLh == clazz.fMaLh && Objects.equals(fTenLh, clazz.fTenLh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaLh, fTenLh);
    }
}
