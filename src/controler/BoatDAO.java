/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import UI.ProprietaireTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Boat;
import modele.BoatType;
import modele.User;

/**
 *
 * @author cerbere
 */
public class BoatDAO 
{
    private static Connection        GETCONNEXION = ConnectDB.getConnection();

    public static void insertVoilier(int user, int classUser, String text) throws Exception
    {
            try
            {
                    java.sql.Statement	state	= GETCONNEXION.createStatement();
                    String		query	= "INSERT INTO `boat` (`user_boat_id`, `boat_user_id`, `user_boat_class`, `user_boat_type_id`, `user_boat_name`) VALUES (NULL, ?, ?, 1, ?);";
                    PreparedStatement	prepare	= GETCONNEXION.prepareStatement(query);
                    prepare.setInt(1, user);
                    prepare.setInt(2, classUser);
                    prepare.setString(3, text);
                    int	rs                      = prepare.executeUpdate();

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


    
    public List<Boat> findAllBoat()
    {
        Connection connection = controler.ConnectDB.getConnection();
        List <Boat> boats = new ArrayList<>();
        
        try
        {
            Statement   state   = connection.createStatement();
            String      sql     = "SELECT user_boat_name, boat_type_name, user_name, user_surname  FROM boat INNER JOIN boat_type ON boat.user_boat_type_id = boat_type.boat_type_id INNER JOIN user ON boat.boat_user_id = user.id";
            ResultSet   rs      = state.executeQuery(sql);
            
            while (rs.next())
            {
                String user_boat_name  = rs.getString("user_boat_name");
                String boat_type_name  = rs.getString("boat_type_name");
                String user_name       = rs.getString("user_name");
                String user_surname    = rs.getString("user_surname");
                
                User u = new User(user_name, user_surname);
                BoatType b = new BoatType(boat_type_name);
                Boat boatsAdd = new Boat(boat_type_name, user_boat_name, u, b);
                
                boats.add(boatsAdd);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return boats;
    }
}
