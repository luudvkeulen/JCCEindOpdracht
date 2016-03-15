package jcceindopdracht.db;

import java.sql.*;

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
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public void closeConnection() throws SQLException
	{
		connection.close();
	}
}
