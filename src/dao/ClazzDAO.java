package dao;

import hibernate.Clazz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class ClazzDAO {
    public static List<Clazz> getAllClass() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Clazz> clazzes = null;
        try {
            final String hql = "select sj from Clazz sj";
            Query query = session.createQuery(hql);

            //Get all accounts
            clazzes = query.list();
            for (Clazz clazz : clazzes) {
                ClazzDAO.updateClass(clazz);
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return clazzes;
    }

    public static void updateClass(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            clazz.setF_tongNam(ClassStudentDAO.TongHS1lopNam(clazz));
            clazz.setF_tongNu(ClassStudentDAO.TongHS1lopNu(clazz));
            clazz.setF_tongSV(ClassStudentDAO.TongHS1lop(clazz));

            session.beginTransaction();
            session.update(clazz);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean isExists(String str) {
        boolean kq = true;
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            final String hql = "select sj.fMaLh from Clazz sj where sj.fTenLh = :tenLop";
            Query query = session.createQuery(hql);
            query.setParameter("tenLop", str);
            if (query.uniqueResultOptional().isEmpty()) {
                kq = false;
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

    public static boolean saveLop(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClazzDAO.isExists(clazz.getfTenLh())) {
            return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(clazz);

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

    public static boolean deleteLop(Clazz clazz) {
        boolean kq = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (clazz != null) {
                session.remove(clazz);
                kq = true;
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
        return kq;
    }

    public static void main(String[] args) {
        System.out.println(ClazzDAO.isExists("18"));
        System.out.println(ClazzDAO.isExists("18CTT1"));

    }
}


