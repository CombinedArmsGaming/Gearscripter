package combinedarms.gearscriptor.presentation;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewUnits 
{
	@FXML
	private TabPane tabPane;
	@FXML
	private TextArea SelectedUnitsTextView;
	
	private ArrayList<String> unitList = new ArrayList<String>();
	
	
	public void refreshUnitsViewTab() throws SQLException
	{
		//Clear all current tabs
		tabPane.getTabs().clear();
		
		//Get connection to Database
		Connection c = combinedarms.gearscriptor.driver.Application.dbConnect();
		Statement stmt = c.createStatement();
		
		String sql = "SELECT * FROM UNITS";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
	    {
			//Pull data from this row in the database
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			String madeby = rs.getString("MADEBY");
			String primary = rs.getString("PRIMARYWEAPON");
			String secondary = rs.getString("SECONDARYWEAPON");
			String arsenalCode = rs.getString("ARSENALCODE");
			
			//Make new tab
			Tab tab = new Tab();
			//Set the name
			tab.setText(name);
		
			//Create and populate the Textarea
			TextArea textArea = new TextArea();
			textArea.setText("Name : " + name + "\n" +
			"Made by: " + madeby + "\n" +
			"Primary: " + primary + "\n" +
			"Secondary: " + secondary + "\n");
			textArea.setEditable(false);
			
			//Create the button and link
			Button tabButton = new Button("Add Unit");
			tabButton.setOnAction(e -> {
				addUnittoListButton(name);
	        });
			
			
			//Copy arsenal code to clipboard
			Button copyToClipboardButton = new Button("Copy arsenal code");
			copyToClipboardButton.setOnAction(e -> {
				StringSelection stringSelection = new StringSelection(arsenalCode);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			});
			
			
			//Make new flowpane to add both objects to the tab
			FlowPane pane = new FlowPane();
			pane.getChildren().addAll(textArea, tabButton, copyToClipboardButton);
			tab.setContent(pane);
			
			tabPane.getTabs().add(tab);
	    }
		
		stmt.close();
        c.close();
		tabPane.getSelectionModel().selectFirst();
	}
	
	
	private void addUnittoListButton(String name) 
	{
		//TODO - swap the name out for the units unique identifier  
		if(unitList.contains(name)) 
		{
			popUpErrorBox("This unit has already been added to the list.");
		}
		else 
		{
			SelectedUnitsTextView.setEditable(true);
			SelectedUnitsTextView.setText(SelectedUnitsTextView.getText() + name + "\n");
			SelectedUnitsTextView.setEditable(false);
			unitList.add(name);
		}
	}
	
	
	//Error box, takes a string as argument and then displays it on screen 
	private void popUpErrorBox(String error)
	{
		Alert alert = new Alert(AlertType.ERROR, error, ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(InputScreen.class.getResourceAsStream("../resources/caLogo.png")));
		alert.showAndWait();
	}
}
