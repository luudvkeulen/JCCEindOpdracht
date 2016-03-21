package jcceindopdracht.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database
{
	private final String url = "jdbc:mysql://athena01.fhict.local";   //database specific url.
	private final String user = "dbi318583";
	private final String password = "vdJUmMmQxC";
	
	private Connection connection;
	
	public boolean open()
	{
            try
            {
                    connection = DriverManager.getConnection(url, user, password);
                    return true;
            } catch (SQLException e)
            {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    return false;
            }
	}
	
	public boolean close()
	{
            try
            {
                    connection.close();
                    return true;
            } catch (SQLException e)
            {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    return false;
            }	
	}

	public int executeNonQuery(String query)
	{
            open();
            try
            {
                    Statement statement = connection.createStatement();	
                    return statement.executeUpdate(query);
            } catch (SQLException ex)
            {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    return 0;
            } finally
            {
                    close();
            }
	}
	
	public ResultSet executeQuery(String query)
	{
            open();
            try
            {
                    Statement statement = connection.createStatement();		
                    return statement.executeQuery(query);
            } catch (SQLException ex)
            {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
            } finally
            {
                    close();
            }
	}
}
