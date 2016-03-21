package jcceindopdracht;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import jcceindopracht.models.Persoon;

public class FXMLController implements Initializable
{
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtParent1;
	
	@FXML
	private TextField txtParent2;
	
	@FXML
	private ListView<Persoon> listPersonen;
	
	private ObservableList<Persoon> personen;
	
	private final Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in");
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		listPersonen = new ListView();
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
}
