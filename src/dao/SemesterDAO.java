package dao;

import hibernate.Semester;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class SemesterDAO {
    public static List<Semester> getAllSemester() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Semester> semesters = null;
        try {
            final String hql = "select acc from Semester acc";
            Query query = session.createQuery(hql);

            //Get all accounts
            semesters = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return semesters;
    }

    public static Semester findHocKiHienTai() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Semester semesters = new Semester();

        try {
            final String hql = "select acc from Semester acc where acc.fHKhienTai = 1";
            Query query = session.createQuery(hql);

            //Get all accounts
            semesters = (Semester) query.getSingleResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return semesters;
    }

    public static void updateSemester(Semester semester) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(semester);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean isExistedSemester(Semester semester) {
        boolean kq = false;
        List<Semester> list = SemesterDAO.getAllSemester();
        for (Semester semester1 : list) {
            if (semester1.getfTenHk().equals(semester.getfTenHk()) && semester1.getfNamHoc().equals(semester.getfNamHoc())) {
                kq = true;
            }
        }
        return kq;
    }

    public static Semester findHK(int maHK) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        Semester semesters = new Semester();
        try {
            final String hql = "select acc from Semester acc where acc.fMaHk = :so";
            Query query = session.createQuery(hql);
            query.setParameter("so", maHK);
            semesters = (Semester) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return semesters;
    }

    public static boolean setHocKiHienTai(Semester semester) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean kq = false;

        List<Semester> semestersGoc = SemesterDAO.getAllSemester();

        //Set tất cả thành 0
        for (Semester i : semestersGoc) {
            i.setfHKhienTai(0);
            SemesterDAO.updateSemester(i);
        }
        try {
            if (SemesterDAO.isExistedSemester(semester)) {
                semester.setfHKhienTai(1);
                SemesterDAO.updateSemester(semester);
                kq = true;
            } else {
                kq = false;
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

    public static boolean saveSem(Semester semester) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SemesterDAO.isExistedSemester(semester)) {
            return false;
        }
        boolean kq = true;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(semester);

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

    public static void deleteSem(Semester semester) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (semester != null) {
                session.remove(semester);
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

    public static Semester getSemester(int maHK) {
        Semester acc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            acc = session.get(Semester.class, maHK);

        } catch (HibernateException e) {
            System.err.println();
        } finally {
            session.close();
        }
        return acc;
    }

    public static void main(String[] args) {
        System.out.println(SemesterDAO.getSemester(1));
    }
}


