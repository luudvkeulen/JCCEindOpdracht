package jcceindopdracht;

import javafx.scene.input.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
}
