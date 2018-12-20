package combinedarms.gearscriptor.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ViewUnits 
{
	//TODO load only the units from the database
	//This is currently proof of concept
	@FXML
	TabPane tabPane;
	
	// City list fetched from server
	private String[] cityList = {"Moscow", "Stambul", "New York", "Bishkek"};
	public void testButtonPush()
	{
		// Add only tabs dynamically but not their content
		for (String city : cityList) {
		    tabPane.getTabs().add(new Tab(city));
		}
		tabPane.getSelectionModel().selectFirst();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
