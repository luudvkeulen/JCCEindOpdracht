package jcceindopracht.models;

import java.util.ArrayList;
import java.util.Date;
public class Persoon
{
	private String naam;
	private Gezin gezin;

	public Gezin getGezin()
	{
		return gezin;
	}

	public String getNaam()
	{
		return naam;
	}	

	public Persoon(String naam, Gezin gezin)
	{
		this.naam = naam;
		this.gezin = gezin;
	}
	
	public Persoon(String naam)
	{
		this.naam = naam;
	}
}
