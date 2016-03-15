package jcceindopdracht.db;

import java.sql.*;
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
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
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
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
			return false;
		}	
	}
	
	
}
