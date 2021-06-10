package dao;

import hibernate.AccountsStu;
import hibernate.Course;
import hibernate.StudentDkhp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class SinhVienHocPhanDAO {
    public static List<StudentDkhp> getAllHp_SVdaDk(int maSv) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<StudentDkhp> studentDkhpList = null;
        try {
            final String hql = "select acc from StudentDkhp acc where acc.fMaTK = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", maSv);
            studentDkhpList = query.list();
//            HashSet hp = new HashSet();
//            for (StudentDkhp s : studentDkhpList){
//                hp.add(CourseDAO.findHP(s.getfMaCourse()));
//            }
//
//
//            AccountsStu accounts = ClassStudentDAO.getAccByName(maSv);
//            Set<Course> courseSet = new HashSet<>();
//            courseSet.addAll(hp);
//            accounts.setHocPhanList(courseSet);
//            session.persist(accounts);
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return studentDkhpList;
    }

    public static boolean findHp_svDk(int maSv, int maHp) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean kq = true;
        StudentDkhp studentDkhpList = new StudentDkhp();
        try {
            final String hql = "select acc from StudentDkhp acc where acc.fMaTK = :ma and acc.fMaCourse = :mahp";
            Query query = session.createQuery(hql);
            query.setParameter("ma", maSv);
            query.setParameter("mahp", maHp);
            studentDkhpList = (StudentDkhp) query.uniqueResult();
            if (query.list().size() == 0) kq = false;
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

    public static List<Course> getAllCoursesHienTaiChuaDk(int maSV) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = null;
        List<Course> moi = new ArrayList<Course>();

        try {
            courses = CourseDAO.getAllCoursesHienTai();
            List<StudentDkhp> courses1 = getAllHp_SVdaDk(maSV);


            for (Course c : courses) {
                int t = 0;
                for (StudentDkhp d : courses1) {
                    if (d.getfMaCourse() == c.getfMaMH()) {
                        t++;
                    }
                }
                if (t == 0) {
                    moi.add(c);
                }
            }

        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return moi;
    }

    public static List<Course> getAllCoursesHienTaiDaDk(int maSV) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = null;
        List<Course> moi = new ArrayList<Course>();

        try {
            courses = CourseDAO.getAllCoursesHienTai();
            List<StudentDkhp> courses1 = getAllHp_SVdaDk(maSV);


            for (Course c : courses) {
                int t = 0;
                for (StudentDkhp d : courses1) {
                    if (d.getfMaCourse() == c.getfMaMH()) {
                        t++;
                    }
                }
                if (t != 0) {
                    moi.add(c);
                }
            }

        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return moi;
    }

    public static void update(StudentDkhp studentDkhp) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(studentDkhp);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean isExisted(StudentDkhp accounts) {
        boolean kq = false;
        List<StudentDkhp> list = SinhVienHocPhanDAO.getAllHp_SVdaDk(accounts.getfMaTK());
        for (StudentDkhp accounts1 : list) {
            if (accounts1.equals(accounts)) {
                kq = true;
            }
        }
        return kq;
    }

    public static boolean save(StudentDkhp course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienHocPhanDAO.isExisted(course)) return false;
        boolean kq = true;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(course);

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

    public static void main(String[] args) {


        AccountsStu a = ClassStudentDAO.getAccByName(1);
        System.out.println(a.toString());

        for (Course c : SinhVienHocPhanDAO.getAllCoursesHienTaiChuaDk(1)) {
            System.out.println(c.get_monHoc().getfTenMh());
        }
    }
}
