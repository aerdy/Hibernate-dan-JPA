/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate2.entitas;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aerdy
 */
public class PersonController {
   Person person = new Person();
    PersonDAO personDAO = HibernateUtil.getPersonDao();
    String header[] = {"Id", "Nama", "Telepon", "Alamat"};

    public void insert(String nama, String telepon, String alamat){
        person.setNama(nama);
        person.setTelepon(telepon);
        person.setAlamat(alamat);
        personDAO.insert(person);
    }

    public void update(String id, String nama, String telepon, String alamat){
        person.setId(Integer.parseInt(id));
        person.setNama(nama);
        person.setTelepon(telepon);
        person.setAlamat(alamat);
        personDAO.update(person);
    }

    public void delete(String id, String nama, String telepon, String alamat){
        person.setId(Integer.parseInt(id));
        person.setNama(nama);
        person.setTelepon(telepon);
        person.setAlamat(alamat);
        personDAO.delete(person);
    }

    public void SelectAll(JTable table){
        List<Person> list = personDAO.SelectAll();
        Object data[][] = new Object[list.size()][4];
        int i = 0;
        for(Person manusia : list){
            data[i][0] = manusia.getId();
            data[i][1] = manusia.getNama();
            data[i][2] = manusia.getTelepon();
            data[i][3] = manusia.getAlamat();
            ++i;
        }
        table.setModel(new DefaultTableModel(data, header));
    }

    public void GetByName(String nama, JTable table){
        List<Person> list = personDAO.GetByName(nama);
        Object data[][] = new Object[list.size()][4];
        int i = 0;
        for(Person manusia : list){
            data[i][0] = manusia.getId();
            data[i][1] = manusia.getNama();
            data[i][2] = manusia.getTelepon();
            data[i][3] = manusia.getAlamat();
            ++i;
        }
        table.setModel(new DefaultTableModel(data, header));
    }  
}
