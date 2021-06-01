package dao;

import hibernate.Accounts;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

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

    public static Accounts getAccount(String fTaiKhoan) {
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

        } catch (HibernateException e) {
            System.err.println();
        } finally {
            session.close();
        }
        return acc;
    }

}
