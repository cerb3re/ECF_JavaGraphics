
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.User;

/**
 *
 * @author cerbere
 */
public class UserDAO 
{
    public static void insertUser(String user_name, String user_surname, int user_phone, String user_email, int age) throws Exception
    {
        try
        {
                java.sql.Statement	state	= ConnectDB.getConnection().createStatement();
                String		query	= "INSERT INTO `user` (`id`, `user_name`, `user_surname`, `user_phone`, `user_email`, `age`) VALUES (NULL, ?, ?, ?, ?, ?);";
                PreparedStatement	prepare	= ConnectDB.getConnection().prepareStatement(query);
                prepare.setString(1, user_name);
                prepare.setString(2, user_surname);
                prepare.setInt(3, user_phone);
                prepare.setString(4, user_email);
                prepare.setInt(5, age);

                int	rs              = prepare.executeUpdate();

                System.out.print("\n");

                prepare.close();
                state.close();

                if (rs > 0)
                        System.out.println("Donnée correctement inserée.");
                else
                        System.out.println("Problème d'insertion.");
        }
        catch(SQLException e)
        {
                e.printStackTrace();
            }
    }
       
    public List<User> findAll()
    {
        Connection connection = controler.ConnectDB.getConnection();
        List <User> user = new ArrayList<>();
        
        try
        {
            Statement   state   = connection.createStatement();
            String      sql     = "SELECT * FROM user";
            ResultSet   rs      = state.executeQuery(sql);
            
            while (rs.next())
            {
                int    id            = rs.getInt("id");
                String user_name     = rs.getString("user_name");
                String user_surname  = rs.getString("user_surname");
                int    user_phone    = rs.getInt("user_phone");
                String email         = rs.getString("user_email");
                int age              = rs.getInt("age");
                
                User userAdd = new User(id, user_name, user_surname, user_phone, email, age);
                user.add(userAdd);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return user;
    }
}
