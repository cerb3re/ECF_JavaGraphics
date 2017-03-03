/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.ClassUser;
import modele.Serie;

/**
 *
 * @author cerbere
 */
public class ClassUserDAO 
{
    public List<ClassUser> findBySerie(int class_serie_id)
    {
        Serie serie = null;
        List <ClassUser> lstSerie = new ArrayList<ClassUser>();
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try
        {
            stm = connection.prepareStatement("SELECT * FROM class INNER JOIN serie ON class.class_serie_id = ? AND class.class_serie_id = serie.serie_id");
            stm.setInt(1, class_serie_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                ClassUser c   = new ClassUser(rs.getInt("class_id"), rs.getString("class_name"));
                lstSerie.add(c);
                System.out.println(lstSerie);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        
        return lstSerie;
    }
}
