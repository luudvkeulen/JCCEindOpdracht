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
	
	public Connection getConnection()
	{
		try
		{
			connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e)
		{
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}
	
	public boolean closeConnection()
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
		try
		{
			Statement statement = connection.createStatement();	
			return statement.executeUpdate(query);
		} catch (SQLException ex)
		{
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}
	}
	
	public ResultSet executeQuery(String query)
	{
		try
		{
			Statement statement = connection.createStatement();		
			return statement.executeQuery(query);
		} catch (SQLException ex)
		{
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
}
