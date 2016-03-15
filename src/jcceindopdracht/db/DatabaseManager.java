package jcceindopdracht.db;

import java.sql.ResultSet;
public class DatabaseManager
{
	private final Database database = new Database();
	
	public void saveStamboom()
	{
		String query = "insert or update";
		database.executeNonQuery(query);
	}
	
	public void getStamboom()
	{
		String query = "";
		ResultSet result = database.executeQuery(query);
	}
}
