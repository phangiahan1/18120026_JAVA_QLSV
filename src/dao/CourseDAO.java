package dao;

import hibernate.Course;
import hibernate.Semester;
import hibernate.Subjects;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public static List<Course> getAllCourses() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = null;

        try {
            final String hql = "select acc from Course acc";
            Query query = session.createQuery(hql);

            //Get all accounts
            courses = query.list();
            for (Course course : courses) {
                course.set_hocKi(SemesterDAO.getSemester(course.getfMaHk()));
                course.set_monHoc(SubjectDAO.getSubject(course.getfMaMH()));
                updateCourse(course);
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return courses;
    }

    public static List<Course> getAllCoursesHienTai() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = null;
        Semester semester = SemesterDAO.findHocKiHienTai();

        try {
            final String hql = "select acc from Course acc where acc.fMaHk = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", semester.getfMaHk());

            //Get all accounts
            courses = query.list();
            for (Course course : courses) {
                course.set_hocKi(SemesterDAO.getSemester(course.getfMaHk()));
                course.set_monHoc(SubjectDAO.getSubject(course.getfMaMH()));
                updateCourse(course);
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return courses;
    }

    public static boolean isCourseHt(Subjects c1) {
        List<Course> courses = getAllCoursesHienTai();
        for (Course c : courses) {
            if (c.getfMaMH() == c1.getfMaMh()) {
                return true;
            }
        }
        return false;
    }

    public static Course get(int fmaHP) {
        Course acc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            acc = session.get(Course.class, fmaHP);
            acc.set_monHoc(SubjectDAO.getSubject(acc.getfMaMH()));

        } catch (HibernateException e) {
            System.err.println();
        } finally {
            session.close();
        }
        return acc;
    }

    public static boolean isExisted(Course accounts) {
        boolean kq = false;
        List<Course> list = CourseDAO.getAllCourses();
        for (Course accounts1 : list) {
            if (accounts1.equals(accounts)) {
                kq = true;
            }
        }
        return kq;
    }

    public static void updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static boolean saveCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CourseDAO.isExisted(course)) return false;
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

    public static void deleteCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (course != null) {
                session.remove(course);
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

    public static Course findHPbyName(String maHK) {
        Course course = new Course();
        List<Course> list = getAllHocPhanByTenMonHienTai(maHK);
        for (Course c : list) {
            if (c.get_monHoc().getfTenMh().equals(maHK)) ;
            return c;
        }
        return course;
    }

    public static List<Course> getAllHocPhanByTenMonHienTai(String tenMon) {
        List<Course> courses = getAllCoursesHienTai();
        List<Course> kq = new ArrayList<Course>();
        for (Course course : courses) {
            if (course.get_monHoc().getfTenMh().equals(tenMon)) {
                kq.add(course);
            }
        }
        return kq;
    }

//    public static void main(String[] args) {
//        for (Course course : CourseDAO.getAllCoursesHienTai()) {
//            System.out.println(course.toString());
//        }
//    }
}
