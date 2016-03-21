/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcceindopracht.models;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Maxime
 */
public class Administratie
{
    // Fields
    private List<Persoon> personen = new ArrayList<>();
    
    // Methods
    public void voegPersonenToe(Persoon persoon)
    {
        personen.add(persoon);
    }
    
    public void personenTestData()
    {
        voegPersonenToe(new Persoon("Sven", new Persoon("Rick"), new Persoon("Marlie")));
        voegPersonenToe(new Persoon("Robbert", new Persoon("Peter")));
        voegPersonenToe(new Persoon("Bonnie", new Persoon("Mandy")));
        voegPersonenToe(new Persoon("Richard", new Persoon("Luud", new Persoon("Maxime"))));
    }
    
    public List<Persoon> getAllPersonen()
    {
        return Collections.unmodifiableList(personen);
    }
}
