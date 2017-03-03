/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author cerbere
 */
public class User 
{
    private int     id, age, user_phone;
    private String  user_name, user_surname, user_email, user_boat_name, boat_type_name;

    public User(String user_name, String user_surname) {
        this.user_name = user_name;
        this.user_surname = user_surname;
    }

    public User(String user_name, String user_surname, int user_phone, String user_email, int age) {
        this.user_name = user_name;
        this.user_surname  = user_surname;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.age = age;
    }

    public User() {
        
    }

    public User(String user_boat_name, String boat_type_name, String user_name, String user_surname) {
        this.user_boat_name = user_boat_name;
        this.boat_type_name = boat_type_name;
        this.user_name      = user_name;
        this.user_surname  = user_surname;
    }

    public User(int id, String user_name, String user_surname, int user_phone, String user_email, int age) {
        this.id = id;
        this.user_name = user_name;
        this.user_surname  = user_surname;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.age = age;    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(int user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    
    @Override
    public String toString()
    {
        return user_surname + " " + user_name;
    }

    public Object getCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
