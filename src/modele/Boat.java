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
public class Boat
{
    private int user_boat_id, boat_user_id, user_boat_class, user_boat_type_id;
    private String user_boat_name, boat_type_name, user_name;
    User u = new User();
    BoatType b = new BoatType();
 

    public Boat(String boat_type_name, String user_boat_name, User u, BoatType b) {
        super();
        this.boat_type_name = boat_type_name;
        this.user_boat_name = user_boat_name;
        this.u = u;
        this.b = b;
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
        final Boat other = (Boat) obj;
        if (this.user_boat_id != other.user_boat_id) {
            return false;
        }
        return true;
    }

    public int getUser_boat_id() {
        return user_boat_id;
    }

    public void setUser_boat_id(int user_boat_id) {
        this.user_boat_id = user_boat_id;
    }

    public int getBoat_user_id() {
        return boat_user_id;
    }

    public void setBoat_user_id(int boat_user_id) {
        this.boat_user_id = boat_user_id;
    }

    public int getUser_boat_class() {
        return user_boat_class;
    }

    public void setUser_boat_class(int user_boat_class) {
        this.user_boat_class = user_boat_class;
    }

    public int getUser_boat_type_id() {
        return user_boat_type_id;
    }

    public void setUser_boat_type_id(int user_boat_type_id) {
        this.user_boat_type_id = user_boat_type_id;
    }

    public String getUser_boat_name() {
        return user_boat_name;
    }

    public void setUser_boat_name(String user_boat_name) {
        this.user_boat_name = user_boat_name;
    }

    public String getUser_name() {
        return this.u.getUser_name();
    }

    public String getBoat_type_name() {
        return b.getBoat_type_name();
    }

    public String getUser_surname() {
        return this.u.getUser_surname();
    }


}
