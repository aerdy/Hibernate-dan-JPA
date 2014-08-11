/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate2.entitas;

/**
 *
 * @author aerdy
 */
public class Person {
     private int id;
    private String nama;
    private String telepon;
    private String alamat;

    public Person() {
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
