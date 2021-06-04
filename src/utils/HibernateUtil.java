package utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
//    private static Connection connection = null;
//
//    private static Connection buildConnection() {
//        Properties prop = new Properties();
//        InputStream inputFile = null;
//        try {
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsv";
//            String username = prop.getProperty("root");
//            String pass = prop.getProperty("1234");
//            // Connection c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSV", "sa", "Long123ohio");
//            Connection c = DriverManager.getConnection(url, username, pass);
//            return c;
//        }
//        catch (Throwable ex) {
//            // System.err.println("Initial Connection failed." + ex);
//            System.err.println("Lỗi ở hàm buildConnection file HibernateUtil");
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
private static SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration();
            config.configure();

            sessionFactory = config.buildSessionFactory();
        } catch (HibernateException e) {
            throw e;
        }
    }

    //
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
//    public static Connection getConnection() {
//        if (connection == null) {
//            connection = buildConnection();
//        }
//        return connection;
//    }

}
