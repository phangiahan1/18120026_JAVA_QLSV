package dao;

import hibernate.AccountsStu;
import hibernate.Clazz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class ClassStudentDAO {
    public static int TongHS1lop(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int kq = 0;
        try {
            final String hql = "select count(*) from AccountsStu gd where gd.fMaLop = " + clazz.getfMaLh();
            //final String hql = "select count(gd.fTaiKhoan) from AccountsStu gd";
            Query query = session.createQuery(hql);
//            for(Iterator it=query.iterate();it.hasNext();)
//            {
//                long row = 0;
//                row = (Long) it.next();
//                System.out.print("Count: " + row);
//            }
            kq = query.uniqueResult().hashCode();

        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

    public static int TongHS1lopNu(Clazz clazz) {
        int kq = 0;
        kq = ClassStudentDAO.TongHS1lop(clazz) - ClassStudentDAO.TongHS1lopNam(clazz);
        return kq;
    }

    public static int TongHS1lopNam(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int kq = 0;
        try {
            //final String hql = "select count(gd.fTaiKhoan) from AccountsStu gd where gd.fMaLop = "+ clazz.getfMaLh() +" and gd.fGioiTinh = \"Nam\"";
            final String hql = "select count(gd.fTaiKhoan) from AccountsStu gd where gd.fMaLop = " + clazz.getfMaLh() + " and gd.fGioiTinh = :gioiTinh";
            Query query = session.createQuery(hql);
            query.setParameter("gioiTinh", "Nam");
            kq = query.uniqueResult().hashCode();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

    public static void updateAccount(AccountsStu acc) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(acc);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<AccountsStu> getAcc_Lop(String maLop) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Clazz clazz = ClazzDAO.getClassTen(maLop);

        List<AccountsStu> accountsStus = null;
        try {

            final String hql = "select acc from AccountsStu acc where acc.fMaLop = :maLH";
            Query query = session.createQuery(hql);
            query.setParameter("maLH", clazz.getfMaLh());
            //Get all accounts
            accountsStus = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return accountsStus;
    }

    public static List<AccountsStu> getAllAcc() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<AccountsStu> accountsStus = null;
        try {

            final String hql = "select acc from AccountsStu acc order by acc.fMaLop ";
            Query query = session.createQuery(hql);
            //Get all accounts
            accountsStus = query.list();
            for (AccountsStu accountsStu : accountsStus) {
                accountsStu.set_lopHoc(ClazzDAO.getClassMa(accountsStu.getfMaLop()));
                ClassStudentDAO.updateAccount(accountsStu);
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return accountsStus;
    }

    public static AccountsStu getAccByName(int name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AccountsStu accountsStu = new AccountsStu();
        try {

            final String hql = "select acc from AccountsStu acc where acc.fMaTkSV = :ten ";
            Query query = session.createQuery(hql);
            query.setParameter("ten", name);
            accountsStu = (AccountsStu) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return accountsStu;
    }


    public static void main(String[] args) {
        List<AccountsStu> list = ClassStudentDAO.getAllAcc();
        for (AccountsStu clazz : list) {
            System.out.println(clazz.toString());
        }
    }
}
