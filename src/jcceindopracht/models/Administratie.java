package jcceindopracht.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Administratie
{
    // Fields
    private List<Persoon> personen = new ArrayList<>();
    
    // Methods
    public void voegPersonenToe(Persoon persoon)
    {
        personen.add(persoon);
    }
    
    public List<Persoon> getAllPersonen()
    {
        return Collections.unmodifiableList(personen);
    }
}
