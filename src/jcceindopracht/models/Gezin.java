package jcceindopracht.models;
public class Gezin
{
	private Persoon ouder1;
	private Persoon ouder2;

	public Persoon getOuder1()
	{
		return ouder1;
	}

	public Persoon getOuder2()
	{
		return ouder2;
	}
	
	public void addOuders(Persoon ouder1, Persoon ouder2)
	{
		this.ouder1 = ouder1;
		this.ouder2 = ouder2;
	}
}
