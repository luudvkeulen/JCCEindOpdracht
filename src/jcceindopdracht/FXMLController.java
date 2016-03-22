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
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.ListView;
import jcceindopracht.models.Administratie;
import jcceindopracht.models.Persoon;

public class FXMLController implements Initializable
{
	private final Administratie administratie = new Administratie();
	
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtParent1;
	
	@FXML
	private TextField txtParent2;
	
	@FXML
	private ListView<Persoon> listPersonen;
	
	private final ObservableList<Persoon> personen = FXCollections.observableArrayList(administratie.getAllPersonen());
	
	private final Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in");
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		listPersonen.setItems(personen);
		//UpdateList();
	}

	@FXML
	private void btnAddPerson(ActionEvent event)
	{
            if(txtName.getText().trim().length() == 0) 
            {
                alert.show();
                return;
            }
		administratie.voegPersonenToe(new Persoon("Pieter"));
		//UpdateList();
		
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
	
	private void UpdateList()
	{
		listPersonen.setItems(FXCollections.observableList(administratie.getAllPersonen()));
	}
}
