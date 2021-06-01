package hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Dkhp {
    private int fMaDkhp;
    private Date fNgayDbdk;
    private Date fNgayKtdk;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dkhp dkhp = (Dkhp) o;
        return fMaDkhp == dkhp.fMaDkhp && Objects.equals(fNgayDbdk, dkhp.fNgayDbdk) && Objects.equals(fNgayKtdk, dkhp.fNgayKtdk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fMaDkhp, fNgayDbdk, fNgayKtdk);
    }
}
