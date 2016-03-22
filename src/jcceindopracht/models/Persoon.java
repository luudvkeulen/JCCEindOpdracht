package jcceindopracht.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Persoon
{
    // Fields
    private String naam;
    private Persoon ouder1;
private Persoon ouder2;	

public void setOuder1(Persoon ouder1)
{
	this.ouder1 = ouder1;
}

public void setOuder2(Persoon ouder2)
{
	this.ouder2 = ouder2;
}
    
    
    // Constructor
    public Persoon(String naam, Persoon ouder1, Persoon ouder2)
    {
        this.naam = naam;
        this.ouder1 = ouder1;
	this.ouder2 = ouder2;
    }
    
    public Persoon(String naam, Persoon ouder1)
    {
        this.naam = naam;
        this.ouder1 = ouder1;
    }

    public Persoon(String naam)
    {
        this.naam = naam;
    }
    
    // Methods
    public String getNaam()
    {
        return naam;
    }
    
    public Persoon getOuder1()
    {
        return ouder1;
    }
    
    public Persoon getOuder2()
    {
        return ouder2;
    }
	
	public List<Persoon> getOuders()
	{
		List<Persoon> personen = new ArrayList<>();
		if(ouder1 != null)
		{
			personen.add(ouder1);
		}
		if(ouder2 != null)
		{
			personen.add(ouder2);
		}
		
		return personen;
	}
}
