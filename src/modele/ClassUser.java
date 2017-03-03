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
public class ClassUser 
{
    private int class_id, class_serie_id;
    private String class_name;
    private Serie s = new Serie();

    public ClassUser() {}
    
    public ClassUser(String class_name)
    {
        this.class_name = class_name;
    }
    
    public ClassUser(int class_id, int class_serie_id, String class_name) {
        this.class_id = class_id;
        this.class_serie_id = class_serie_id;
        this.class_name = class_name;
    }

    public ClassUser(int class_id, int class_serie_id, String class_name, Serie s) {
        this.class_id = class_id;
        this.class_serie_id = class_serie_id;
        this.class_name = class_name;
        this.s = s;
    }

    public ClassUser(int class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getClass_serie_id() {
        return class_serie_id;
    }

    public void setClass_serie_id(int class_serie_id) {
        this.class_serie_id = class_serie_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final ClassUser other = (ClassUser) obj;
        if (this.class_id != other.class_id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return class_name;
    }
}
