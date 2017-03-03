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
public class Serie 
{
    private int serie_id;
    private String serie_name;

    public Serie(String serieName) {
        this.serie_name = serieName;
    }
    
    public Serie(int serie_id, String serie_name)
    {
        this.serie_id = serie_id;
        this.serie_name = serie_name;
    }

    Serie() {
       
    }

    public int getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(int serie_id) {
        this.serie_id = serie_id;
    }

    public String getSerie_name() {
        return serie_name;
    }

    public void setSerie_name(String serie_name) {
        this.serie_name = serie_name;
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
        final Serie other = (Serie) obj;
        if (this.serie_id != other.serie_id) {
            return false;
        }
        return true;
    }

    public String getCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public String toString() {
        return serie_name;
    }
    
} 
