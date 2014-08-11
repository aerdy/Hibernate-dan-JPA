/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate2.entitas;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author aerdy
 */
public class HibernateUtil {
      private static final SessionFactory sessionFactory;
    private static final PersonDAO personDao;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            personDao = new PersonDAOImpl(sessionFactory);
        } catch (Throwable e) {
            System.err.println("Inisialisasi sessionFactory gagal "+e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static PersonDAO getPersonDao() {
        return personDao;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
