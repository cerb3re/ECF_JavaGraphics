package	controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB 
{
    final	static	String	URL 		= "jdbc:mysql://localhost/final_ecf?noAccessToProcedureBodies=true";
    final 	static	String	IDBDD		= "root";
    final	static	String	PASSBDD		= "poubelle";

	/* PARAMETRES DE CONNECTION A LA BDD */
	private static	Connection connect 	= null;

	public static Connection getConnection()
	{
		if (connect == null)
		{

            try 
            {
                try 
                {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.println("Connection en cours...");
                } 
                catch (InstantiationException ex) 
                {
                    Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IllegalAccessException ex) 
                {
                    Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
            catch (ClassNotFoundException ex) 
            {
            	Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }

            try 
            {
            	connect = DriverManager.getConnection(URL, IDBDD, PASSBDD);
            	System.out.println("Connection établie.");
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

        return connect;
	}
}
