package jcceindopdracht;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
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
	
	@FXML
	private ListView<Persoon> listOuders;
	
	@FXML
	private ListView<Persoon> listVoorOuders;
	
	private final Alert alert = new Alert(Alert.AlertType.WARNING, "Vul alle velden in");
	private final Alert alert2 = new Alert(Alert.AlertType.WARNING, "Selecteer eerst een persoon");
	private final Alert alert3 = new Alert(Alert.AlertType.INFORMATION, "Opgeslagen");
	private final Alert alert4 = new Alert(Alert.AlertType.INFORMATION, "Opgehaald");
	
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		AddSelectionEventHandler();
		setCellFactory();
		UpdateList();
	}

	@FXML
	private void btnAddPerson(ActionEvent event)
	{
            if(txtName.getText().trim().length() == 0) 
            {
                alert.show();
                return;
            }
		administratie.voegPersonenToe(new Persoon(txtName.getText()));
		UpdateList();
	}

	@FXML
	private void btnAddPersonWithParents(ActionEvent event)
	{
            if(txtParent2.getText().trim().length() == 0 || txtParent1.getText().trim().length() == 0 || txtName.getText().trim().length() == 0) 
            {
                alert.show();
                return;
            }
		
		Persoon ouder1 = new Persoon(txtParent1.getText());
		Persoon ouder2 = new Persoon(txtParent2.getText());	
		Persoon persoon = new Persoon(txtName.getText(), ouder1, ouder2);
			
		administratie.voegPersonenToe(ouder1);
		administratie.voegPersonenToe(ouder2);
		administratie.voegPersonenToe(persoon);
		UpdateList();
	}
	
	@FXML
	private void onIndexChanged(Persoon selectedPersoon)
	{
		System.out.println(selectedPersoon.getNaam());
		List<Persoon> ouders = selectedPersoon.getOuders();
		if(ouders.size() > 0)
		{
			listOuders.setItems(FXCollections.observableList(ouders));
		} else {
			listOuders.setItems(null);
		}
		
		List<Persoon> results = new ArrayList<>();
		selectedPersoon.getVoorOuders(results, true);
		if(results.size() > 0)
		{
			listVoorOuders.setItems(FXCollections.observableList(results));
		} else {
			listVoorOuders.setItems(null);
		}
	}
	
	private void UpdateList()
	{
		listPersonen.setItems(FXCollections.observableList(administratie.getAllPersonen()));
	}
	
	private void setCellFactory()
	{
		listPersonen.setCellFactory((ListView<Persoon> param) ->
		{
			final ListCell<Persoon> cell = new ListCell<Persoon>() {
				@Override
				public void updateItem(Persoon item, boolean empty) {
					super.updateItem(item, empty);
					if (item != null) {
						setText(item.getNaam());
					}
				}
			};
			return cell;
		});
		
		listOuders.setCellFactory((ListView<Persoon> param) ->
		{
			final ListCell<Persoon> cell = new ListCell<Persoon>() {
				@Override
				public void updateItem(Persoon item, boolean empty) {
					super.updateItem(item, empty);
					if (item != null) {
						setText(item.getNaam());
					}
				}
			};
			return cell;
		});
		
		listVoorOuders.setCellFactory((ListView<Persoon> param) ->
		{
			final ListCell<Persoon> cell = new ListCell<Persoon>() {
				@Override
				public void updateItem(Persoon item, boolean empty) {
					super.updateItem(item, empty);
					if (item != null) {
						setText(item.getNaam());
					}
				}
			};
			return cell;
		});
	}
	
	private void AddSelectionEventHandler()
	{
		listPersonen.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Persoon> observable, Persoon oldValue, Persoon newValue) ->
		{
			if(newValue != null)
			{
				onIndexChanged(newValue);	
			}			
		});
	}
	
	@FXML
	private void btnAanpassen(ActionEvent event)
	{
		if(listPersonen.getSelectionModel().selectedItemProperty().get() == null) 
		{
			alert2.show();
			return;
		}
		
		if(txtParent2.getText().trim().length() == 0 || txtParent1.getText().trim().length() == 0 || txtName.getText().trim().length() == 0) 
		{
			alert.show();
			return;
		}
		
		Persoon persoon = listPersonen.getSelectionModel().getSelectedItem();
		Persoon ouder1 = new Persoon(txtParent1.getText());
		Persoon ouder2 = new Persoon(txtParent2.getText());
		persoon.setOuder1(ouder1);
		persoon.setOuder2(ouder2);
		administratie.voegPersonenToe(ouder1);
		administratie.voegPersonenToe(ouder2);
		UpdateList();
	}
	
	@FXML
	private void sendToDatabase()
	{
		administratie.SendToDatabase();
		alert3.show();
		
	}
	
	@FXML
	private void getFromDatabase()
	{
		administratie.FillFromDatabase();
		UpdateList();
		alert4.show();
	}
}
