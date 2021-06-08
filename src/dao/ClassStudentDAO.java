package dao;

import hibernate.Clazz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

public class ClassStudentDAO {
    public static int TongHS1lop(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int kq = 0;
        try {
            final String hql = "select count(*) from AccountsStu gd where gd.fMaLop = " + clazz.getfMaLh();
            //final String hql = "select count(gd.fTaiKhoan) from AccountsStu gd";
            Query query = session.createQuery(hql);
//            for(Iterator it=query.iterate();it.hasNext();)
//            {
//                long row = 0;
//                row = (Long) it.next();
//                System.out.print("Count: " + row);
//            }
            kq = query.uniqueResult().hashCode();

        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

    public static int TongHS1lopNu(Clazz clazz) {
        int kq = 0;
        kq = ClassStudentDAO.TongHS1lop(clazz) - ClassStudentDAO.TongHS1lopNam(clazz);
        return kq;
    }

    public static int TongHS1lopNam(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int kq = 0;
        try {
            //final String hql = "select count(gd.fTaiKhoan) from AccountsStu gd where gd.fMaLop = "+ clazz.getfMaLh() +" and gd.fGioiTinh = \"Nam\"";
            final String hql = "select count(gd.fTaiKhoan) from AccountsStu gd where gd.fMaLop = " + clazz.getfMaLh() + " and gd.fGioiTinh = :gioiTinh";
            Query query = session.createQuery(hql);
            query.setParameter("gioiTinh", "Nam");
            kq = query.uniqueResult().hashCode();
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return kq;
    }

//    public static void main(String[] args) {
//        List<Clazz> clazzes = ClazzDAO.getAllClass();
//        for (Clazz clazz : clazzes){
//            System.out.println(ClassStudentDAO.TongHS1lopNu(clazz));
//        }
//    }
}
