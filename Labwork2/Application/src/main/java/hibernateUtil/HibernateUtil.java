package hibernateUtil;

import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
         sessionFactory = new org.hibernate
                .cfg
                .Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
