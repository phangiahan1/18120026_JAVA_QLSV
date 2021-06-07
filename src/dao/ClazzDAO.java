package dao;

import hibernate.Clazz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
        } catch (HibernateException e) {
            System.err.println(e);
        } finally {
            session.close();
        }
        return clazzes;
    }

    public static int TongNamLopHoc(Clazz clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int kq = 0;
        return kq;
    }

}
