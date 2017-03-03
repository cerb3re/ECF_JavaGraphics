package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Serie;

/**
 *
 * @author cerbere
 */
public class SerieDAO 
{

    static Serie findBy(int personId) 
    {
        Serie serie = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try
        {
            stm = connection.prepareStatement("SELECT * FROM serie inner join class WHERE ? = class.class_serie_id");
            stm.setInt(1, personId);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
            {
                serie        = new Serie(rs.getInt("serie_id"), rs.getString("serie_name"));
           
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        
        return serie;
    }
 public  List<Serie> findAll()
    {
        Connection          connection  = ConnectDB.getConnection();
        List<Serie>         serie       = new ArrayList<>();
        PreparedStatement   stm;
        
        try
        {
            stm = connection.prepareStatement("SELECT * FROM serie");
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next())
            {
                String serieName    = rs.getString("serie_name");
                int serieId      = rs.getInt("serie_id");
                
                Serie s = new Serie(serieId, serieName);
                serie.add(s);
            }
            rs.close();
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
        return serie;
    }
}
