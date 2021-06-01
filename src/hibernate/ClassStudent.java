package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "class_student", schema = "qlsv", catalog = "")
public class ClassStudent {
    private int fMaCS;

    @Id
    @Column(name = "f_maC_S", nullable = false)
    public int getfMaCS() {
        return fMaCS;
    }

    public void setfMaCS(int fMaCS) {
        this.fMaCS = fMaCS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassStudent that = (ClassStudent) o;
        return fMaCS == that.fMaCS;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaCS);
    }
}
