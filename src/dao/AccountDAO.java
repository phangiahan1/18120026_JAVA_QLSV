package dao;

import hibernate.Accounts;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.Date;
import java.util.List;

public class AccountDAO {
    public static List<Accounts> getAllAccounts() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Accounts> accounts = null;
        try {
            final String hql = "select acc from Accounts acc";
            Query query = session.createQuery(hql);

            //Get all accounts
            accounts = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return accounts;
    }

    public static List<Accounts> getAllAccountsGV() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Accounts> accounts = null;
        try {
            final String hql = "select acc from Accounts acc where acc.fType=2 or acc.fType=1";
            Query query = session.createQuery(hql);

            //Get all accounts
            accounts = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return accounts;
    }

    public static Accounts getAccount(int fTaiKhoan) {
        Accounts acc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            acc = session.get(Accounts.class, fTaiKhoan);

        } catch (HibernateException e) {
            System.err.println();
        } finally {
            session.close();
        }
        return acc;
    }

    public static Accounts getAccountbyName(String fTaiKhoan) {
        Accounts acc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
//            accounts = (Accounts) session.get(Accounts.class,tk);
//            final  String hql = "select acc.fMaTk   from Accounts acc where acc.fTaiKhoan="+tk;
//            Query query = session.createQuery(hql);

//            String hql = "SELECT u.fMaTk FROM Accounts u WHERE u.fTaiKhoan = :tk";
//            String id = session.createQuery(hql, String.class).setParameter("tk", tk).uniqueResult();
//
//            acc = (Accounts) session.get(Accounts.class,id);

            List<Accounts> list = session.createQuery("FROM Accounts WHERE fTaiKhoan LIKE :fTaiKhoan")
                    .setParameter("fTaiKhoan", "%" + fTaiKhoan + "%").list();
            for (Accounts obj : list) {
                acc = obj;
            }
            // acc = (Accounts) session.get(Accounts.class, fTaiKhoan);

        } catch (HibernateException e) {
            System.err.println();
        } finally {
            session.close();
        }
        return acc;
    }

    public static void UpdateThongTin(int maSo, String mk, Date ngaySinh, String dt, String dc, int loai) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        Accounts tam = getAccount(maSo);

        Date date = ngaySinh;

        Accounts s = tam;
        s.setfPass(mk);
        s.setfDiaChi(dc);
        s.setfDienThoai(dt);
        s.setfNgaySinh((java.sql.Date) date);

        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
        session.close();
    }

    public static boolean isExistedAcc(Accounts accounts) {
        boolean kq = false;
        List<Accounts> list = AccountDAO.getAllAccounts();
        for (Accounts accounts1 : list) {
            if (accounts1.getfTaiKhoan().equals(accounts.getfTaiKhoan())) {
                kq = true;
            }
        }
        return kq;
    }

    public static boolean saveAccount(Accounts accounts) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (AccountDAO.isExistedAcc(accounts)) {
            return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(accounts);

            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            kq = false;
        } finally {
            session.close();
        }
        return kq;
    }

    public static void deleteAccount(Accounts acc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (acc != null) {
                session.remove(acc);
                System.out.println("Xoa thanh cong ");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void updateAccount(Accounts acc) {
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
}
