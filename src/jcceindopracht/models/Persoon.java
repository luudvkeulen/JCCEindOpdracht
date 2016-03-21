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
    
    // Constructor
    public Persoon(String naam, Persoon ouder1, Persoon ouder2)
    {
        this.naam = naam;
        this.ouder1 = ouder2;
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
}
