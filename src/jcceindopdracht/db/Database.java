package jcceindopdracht.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jcceindopracht.models.Persoon;

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
	
	public List<Persoon> executeQuery(String query)
	{
		List<Persoon> personen = new ArrayList<>();
		open();
		try
		{
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(query);
			while (results.next())
			{
				String naam = results.getString("Naam");
				String Ouder1 = results.getString("Ouder1");
				String Ouder2 = results.getString("Ouder2");
				
				Persoon persoon = null;
				for(Persoon p : personen)
				{
					if(p.getNaam().equals(naam))
					{
						persoon = p;
						break;
					}
				}
				if(persoon == null)
				{
					persoon = new Persoon(naam);
					personen.add(persoon);
				}			
				
				if(Ouder1 != null)
				{
					for (Persoon ouder : personen) 
					{
						if(ouder.getNaam().equals(Ouder1))
						{
							persoon.setOuder1(ouder);
							break;
						}
					}
					
					if(persoon.getOuder1() == null)
					{
						Persoon ouder1 = new Persoon(Ouder1);
						persoon.setOuder1(ouder1);
						personen.add(ouder1);
					}
				}
				
				if(Ouder2 != null)
				{
					for (Persoon ouder : personen) 
					{
						if(ouder.getNaam().equals(Ouder2))
						{
							persoon.setOuder2(ouder);
							break;
						}
					}
					
					if(persoon.getOuder2() == null)
					{
						Persoon ouder2 = new Persoon(Ouder2);
						persoon.setOuder2(ouder2);
						personen.add(ouder2);
					}
				}
			}
		} catch (SQLException ex)
		{
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		} finally
		{
				close();
		}
		
		return personen;
	}
}
