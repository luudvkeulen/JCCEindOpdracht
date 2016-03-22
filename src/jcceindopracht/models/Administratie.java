package jcceindopracht.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jcceindopdracht.db.Database;

public class Administratie
{
    // Fields
    private List<Persoon> personen = new ArrayList<>();
	private final Database database = new Database();
    
    // Methods
    public void voegPersonenToe(Persoon persoon)
    {
        personen.add(persoon);
    }
    
    public List<Persoon> getAllPersonen()
    {
        return Collections.unmodifiableList(personen);
    }
	
	public void SendToDatabase()
	{
		for (Persoon persoon : personen)
		{
			String sql = "INSERT IGNORE INTO dbi318583.persoon (Naam) VALUES (" + "'" + persoon.getNaam() + "'" + ")";
			database.executeNonQuery(sql);
		}
		
		for(Persoon persoon : personen)
		{
			String sql;
			if(persoon.getOuder1() != null && persoon.getOuder2() != null)
			{
				sql = "UPDATE dbi318583.persoon SET Ouder1='" +  persoon.getOuder1().getNaam() + "' ,Ouder2='" + persoon.getOuder2().getNaam() + "' WHERE Naam='" + persoon.getNaam() + "'";
				database.executeNonQuery(sql);
			} else if (persoon.getOuder1() != null)
			{
				sql = "UPDATE dbi318583.persoon SET Ouder1='" +  persoon.getOuder1().getNaam() + "' WHERE Naam='" + persoon.getNaam() + "'";
				database.executeNonQuery(sql);
			} else if (persoon.getOuder2() != null)
			{
				sql = "UPDATE dbi318583.persoon SET Ouder2='" +  persoon.getOuder2().getNaam() + "' WHERE Naam='" + persoon.getNaam() + "'";
				database.executeNonQuery(sql);
			}
		}
	}
	
	public void FillFromDatabase() throws SQLException
	{
		String sql = "SELECT Naam,Ouder1,Ouder2 FROM dbi318583.persoon";
		List<Persoon> result = database.executeQuery(sql);
		personen.addAll(result);
	}
}
