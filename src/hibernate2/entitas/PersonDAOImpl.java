/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate2.entitas;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aerdy
 */
public class PersonDAOImpl implements PersonDAO{
     Session session;
    SessionFactory factory;
    Criteria criteria;

    public PersonDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public void insert(Person person) throws HibernateException {
        session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            System.out.println("Sukses kang!!!");
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally{
            session.close();
            factory.close();
        }
    }

    public void update(Person person) throws HibernateException {
        session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
            System.out.println("Sukses kang!!");
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    public void delete(Person person) throws HibernateException {
        session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    public List<Person> SelectAll() throws HibernateException {
        session = factory.openSession();
        try {
            criteria = session.createCriteria(Person.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
        return criteria.list();
    }

    public List<Person> GetByName(String nama) throws HibernateException {
        session = factory.openSession();
        try {
            criteria = session.createCriteria(Person.class).add(Restrictions.like("nama", nama, MatchMode.ANYWHERE));
            System.out.println("Sukses kang!!");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return criteria.list();
    }
}
