package jcceindopdracht;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import jcceindopdracht.db.Database;

public class FXMLController implements Initializable
{      
    private Database db = new Database();
    private String query;
    @FXML private Button btnGegevensOphalen;
    @FXML private Label lblGegevensVerstuurd;
    
    @FXML 
    private void handleClickGegevens(ActionEvent event)
    {        
        lblGegevensVerstuurd.setText("TESTING!!!");
        System.out.println("Knop is gedrukt");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
