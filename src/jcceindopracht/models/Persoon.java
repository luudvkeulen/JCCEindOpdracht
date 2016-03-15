package jcceindopracht.models;

import java.util.Date;
public class Persoon
{
	private String naam;
	private Date geboorteDatum;
	private String gender;

	public String getNaam()
	{
		return naam;
	}

	public Date getGeboorteDatum()
	{
		return geboorteDatum;
	}

	public String getGender()
	{
		return gender;
	}	

	public Persoon(String naam, Date geboorteDatum, String gender)
	{
		this.naam = naam;
		this.geboorteDatum = geboorteDatum;
		this.gender = gender;
	}
}
