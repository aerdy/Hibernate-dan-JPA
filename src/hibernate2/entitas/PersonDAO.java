/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate2.entitas;

import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author aerdy
 */
public interface PersonDAO {
      public void insert(Person person) throws HibernateException;

    public void update(Person person) throws HibernateException;

    public void delete(Person person) throws HibernateException;

    List <Person> SelectAll() throws HibernateException;

    List<Person> GetByName(String nama) throws HibernateException;
}
