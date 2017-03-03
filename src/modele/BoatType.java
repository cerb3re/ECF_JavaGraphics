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
public class BoatType 
{
    private int     boat_type_id;
    private String  boat_type_name;

    public BoatType(String boat_type_name) {
       this.boat_type_name = boat_type_name;
    }

    BoatType() {
        
    }

    public int getBoat_type_id() {
        return boat_type_id;
    }

    public void setBoat_type_id(int boat_type_id) {
        this.boat_type_id = boat_type_id;
    }

    public String getBoat_type_name() {
        return boat_type_name;
    }

    public void setBoat_type_name(String boat_type_name) {
        this.boat_type_name = boat_type_name;
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
        final BoatType other = (BoatType) obj;
        if (this.boat_type_id != other.boat_type_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return boat_type_name;
    }
}
