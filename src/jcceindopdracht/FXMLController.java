package jcceindopdracht;

import javafx.scene.input.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
<<<<<<< HEAD
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable
{
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtParent1;
	
	@FXML
	private TextField txtParent2;
	
	private Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in");
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		
	}

	@FXML
	private void btnAddPerson(ActionEvent event)
	{
		if(txtName.getText().trim().length() == 0) 
		{
			alert.show();
			return;
		}
		System.out.println(txtName.getText());
	}

	@FXML
	private void btnAddPersonWithParents(ActionEvent event)
	{
		if(txtParent2.getText().trim().length() == 0 || txtParent1.getText().trim().length() == 0 || txtName.getText().trim().length() == 0) 
		{
			alert.show();
			return;
		}
		System.out.println(txtParent1.getText());
		System.out.println(txtParent2.getText());
	}
=======
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
>>>>>>> origin/master
}
