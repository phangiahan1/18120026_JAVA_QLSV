package dao;

import hibernate.AccountsStu;
import hibernate.Course;
import hibernate.Semester;
import hibernate.StudentDkhp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class SinhVienHocPhanDAO {
    public static List<StudentDkhp> getAll() {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<StudentDkhp> studentDkhpList = null;
        Semester semester = SemesterDAO.findHocKiHienTai();
        try {
            final String hql = "select acc from StudentDkhp acc, Course c where c.fMaHk = :ma and acc.fMaCourse = c.fMaHp";
            Query query = session.createQuery(hql);
            query.setParameter("ma", semester.getfMaHk());
            studentDkhpList = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return studentDkhpList;
    }

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

    public static List<StudentDkhp> getAllSvdaHPdaDkHt(int maHp) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<StudentDkhp> studentDkhpList = null;
        List<AccountsStu> accountsStus = null;
        try {
            final String hql = "select acc from StudentDkhp acc where acc.fMaCourse = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", maHp);
            studentDkhpList = query.list();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return studentDkhpList;
    }

    public static List<AccountsStu> getAllSvdaHPdaDkHtTheoTen(String tenMon) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<StudentDkhp> studentDkhpList = null;
        List<Course> courses = CourseDAO.getAllHocPhanByTenMonHienTai(tenMon);
        List<AccountsStu> accountsStus = new ArrayList<AccountsStu>();
        try {
            for (Course course : courses) {
                for (StudentDkhp studentDkhp : getAllSvdaHPdaDkHt(course.getfMaHp())) {
                    accountsStus.add(ClassStudentDAO.getAccByName(studentDkhp.getfMaTK()));
                }
            }
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return accountsStus;
    }

    public static Course findSV_TenMonHoc(int maSv, String tenMH) {
        Course kq = new Course();
        List<Course> list = SinhVienHocPhanDAO.getAllCoursesHienTaiDaDk(maSv);
        for (Course l : list) {
            if (CourseDAO.findHPbyName(tenMH).equals(l)) {
                return l;
            }
        }
        return kq;
    }

    public static StudentDkhp findSv_MaHP(int naSV, int maHP) {
        StudentDkhp studentDkhp = new StudentDkhp();
        List<StudentDkhp> list = getAllSvdaHPdaDkHt(maHP);
        for (StudentDkhp l : list) {
            if (l.getfMaTK() == naSV) {
                return l;
            }
        }
        return studentDkhp;
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

    public static StudentDkhp getHp_svDk(int maSv, int maHp) {
        //open session
        Session session = HibernateUtil.getSessionFactory().openSession();
        StudentDkhp studentDkhpList = new StudentDkhp();
        try {
            final String hql = "select acc from StudentDkhp acc where acc.fMaTK = :ma and acc.fMaCourse = :mahp";
            Query query = session.createQuery(hql);
            query.setParameter("ma", maSv);
            query.setParameter("mahp", maHp);
            studentDkhpList = (StudentDkhp) query.uniqueResult();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return studentDkhpList;
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
                    if (d.getfMaCourse() == c.getfMaHp()) {
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
                    if (d.getfMaCourse() == c.getfMaHp()) {
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

    public static boolean kiemTraTrungGio(StudentDkhp accounts) {
        boolean kq = false;
        List<Course> list = SinhVienHocPhanDAO.getAllCoursesHienTaiDaDk(accounts.getfMaTK());
        for (Course accounts1 : list) {
            if (accounts1.getfThuHoc().equals(CourseDAO.get(accounts.getfMaCourse()).getfThuHoc())) {
                if (accounts1.getfCaHoc().equals(CourseDAO.get(accounts.getfMaCourse()).getfCaHoc())) {
                    kq = true;

//                    System.out.println(CourseDAO.get(accounts.getfMaCourse()).getfMaHp());
//                    System.out.println(CourseDAO.get(accounts.getfMaCourse()).getfThuHoc());
//                    System.out.println(CourseDAO.get(accounts.getfMaCourse()).getfCaHoc());
//
//                    System.out.println(accounts1.getfMaHp());
//                    System.out.println(accounts1.getfThuHoc());
//                    System.out.println(accounts1.getfCaHoc());
                }
            }
        }
        return kq;
    }

    public static boolean kiemTraTrungTen(StudentDkhp accounts) {
        boolean kq = false;
        List<Course> list2 = CourseDAO.getAllCoursesHienTai();
        List<Course> list3 = CourseDAO.getAllCourses();
        List<StudentDkhp> list1 = SinhVienHocPhanDAO.getAllHp_SVdaDk(accounts.getfMaTK());
        List<Course> list = SinhVienHocPhanDAO.getAllCoursesHienTaiDaDk(accounts.getfMaTK());
        for (Course accounts1 : list) {
            if (accounts1.get_monHoc().getfTenMh().equals(CourseDAO.get(accounts.getfMaCourse()).get_monHoc().getfTenMh())) {
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

    public static void delete(StudentDkhp studentDkhp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //Remove a persistent object
            if (studentDkhp != null) {
                session.remove(studentDkhp);
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

    public static void main(String[] args) {
        List<StudentDkhp> list = getAll();
        if (list.size() == 0) {
            System.out.println("Không có");
        } else {
            for (StudentDkhp studentDkhp : list) {
                System.out.println(studentDkhp.toString());
            }
            System.out.println(list.size());
        }
    }
}
