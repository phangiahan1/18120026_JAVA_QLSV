package dao;

import hibernate.Dkhp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class DkhpDAO {
    public static List<Dkhp> getAllDKHP() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Dkhp> dkhps = null;
        try {
            final String hql = "select acc from Dkhp acc";
            Query query = session.createQuery(hql);

            //Get all accounts
            dkhps = query.list();

            for (Dkhp dkhp : dkhps) {
                dkhp.set_hocki(SemesterDAO.findHK(dkhp.getfMaHK()));
                DkhpDAO.updateDkhp(dkhp);
            }

        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return dkhps;
    }

    public static void updateDkhp(Dkhp dkhp) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(dkhp);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void deleteDkhp(Dkhp dkhp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (dkhp != null) {
                session.remove(dkhp);
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

//    public static void main(String[] args) {
//        for (Dkhp dkhp : DkhpDAO.getAllDKHP()) {
//            System.out.println(dkhp.get_hocki().toString());
//        }
//    }
}
