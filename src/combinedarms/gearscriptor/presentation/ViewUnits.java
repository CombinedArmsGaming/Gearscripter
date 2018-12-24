package combinedarms.gearscriptor.presentation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;

public class ViewUnits 
{
	@FXML
	private TabPane tabPane;
	@FXML
	private TextArea SelectedUnitsTextView;
	
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
			Button tab_button = new Button("Add Unit");
			tab_button.setOnAction(e -> {
				SelectedUnitsTextView.setEditable(true);
				SelectedUnitsTextView.setText(SelectedUnitsTextView.getText() + name + "\n");
				SelectedUnitsTextView.setEditable(false);
	        });
			
			//Make new flowpane to add both objects to the tab
			FlowPane pane = new FlowPane();
			pane.getChildren().addAll(textArea, tab_button);
			tab.setContent(pane);
			
			tabPane.getTabs().add(tab);
	    }
		
		stmt.close();
        c.close();
		tabPane.getSelectionModel().selectFirst();
	}
}
