package dao;

import hibernate.Subjects;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class SubjectDAO {
    public static List<Subjects> getAllSubjects() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Subjects> subjects = null;
        try {
            final String hql = "select sj from Subjects sj";
            Query query = session.createQuery(hql);

            //Get all accounts
            subjects = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return subjects;
    }

    public static boolean isExistedSub(Subjects subjects) {
        boolean kq = false;
        List<Subjects> list = SubjectDAO.getAllSubjects();
        for (Subjects subjects1 : list) {
            if (subjects1.getFidMh().equals(subjects.getFidMh())) {
                kq = true;
            }
        }
        return kq;
    }

    public static boolean isExistedName(Subjects subjects) {
        boolean kq = false;
        List<Subjects> list = SubjectDAO.getAllSubjects();
        for (Subjects subjects1 : list) {
            if (subjects1.getfTenMh().equals(subjects.getfTenMh())) {
                kq = true;
            }
        }
        return kq;
    }

    public static boolean saveSub(Subjects subjects) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.isExistedSub(subjects)) {
            return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(subjects);

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

    public static void deleteSub(Subjects subjects) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (subjects != null) {
                session.remove(subjects);
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

    public static void updateSub(Subjects subjects) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(subjects);
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
