package dao;

import hibernate.Course;
import hibernate.Semester;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

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

    public static void main(String[] args) {
        for (Course course : CourseDAO.getAllCoursesHienTai()) {
            System.out.println(course.toString());
        }
    }
}
