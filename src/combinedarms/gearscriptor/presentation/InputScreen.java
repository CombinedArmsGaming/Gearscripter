package combinedarms.gearscriptor.presentation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class InputScreen 
{
	@FXML
	private Button buttonMain;
	@FXML
	private TextArea submitCodeTextField;
	@FXML
	private TextArea outputTextField;
	@FXML
	private TextField unitRoleBox;
	
	public void buttonMainClicked()
	{
		if(unitRoleBox.getText().equals("")) 
		{
			popUpErrorBox("Please enter a unit role.");
		}
		else if(submitCodeTextField.getText().equals("")) 
		{
			popUpErrorBox("No code detected. Please enter arsenal code.");
		}
		
		//TODO - Check if code is valid
		else 
		{
			//add to log - we should move this sort of thing to it's own method in the future
			//the output box is not editable, so we need to make it so first
			outputTextField.setEditable(true);
			outputTextField.setText(outputTextField.getText() + "Added unit " + unitRoleBox.getText() +".\n");
			outputTextField.setEditable(false);
		}
		
		//TODO - Pass arsenal code and unit role/name to relevant methods to parse them
	}
	
	//Error box, takes a string as argument and then displays it on screen 
	private void popUpErrorBox(String error)
	{
		Alert alert = new Alert(AlertType.ERROR, error, ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(InputScreen.class.getResourceAsStream("../resources/caLogo.png")));
	    alert.showAndWait();
	}
	
	//Clears the log box
	public void clearOutputBox()
	{
		outputTextField.setEditable(true);
		outputTextField.setText("");
		outputTextField.setEditable(false);
	}
	
	
	public void viewSubmittedUnits(ActionEvent event) throws IOException 
	{
		try {
	        ((Node)(event.getSource())).getScene().getWindow().hide();
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("../presentation/fxml/ViewUnits.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setTitle("CombinedArms GearScripter");
	        stage.getIcons().add(new Image(InputScreen.class.getResourceAsStream("../resources/caLogo.png")));
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    } catch (Exception e) { 
	    	System.out.println(e);
	    }
	}
	
	//Return to login screen
	public void logOut(ActionEvent event) throws IOException
	{
		try {		
			((Node)(event.getSource())).getScene().getWindow().hide();
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("../presentation/fxml/LoginScreen.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setTitle("CombinedArms GearScripter");
	        stage.getIcons().add(new Image(InputScreen.class.getResourceAsStream("../resources/caLogo.png")));
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    } catch (Exception e) { 
	    	System.out.println(e);
	    }
	}
	
	//Tooltips
	public void hoverOnOutputBox()
	{
		outputTextField.setTooltip(new Tooltip("General output descriptions of the program will appear here."));
	}
	
	public void hoverOnTextBox() 
	{
		submitCodeTextField.setTooltip(new Tooltip("Enter your ACE or BI arsenal code in this box."));
	}
	
	public void hoverOnRoleBox() 
	{
		unitRoleBox.setTooltip(new Tooltip("Enter the role of this soldier in this box."));
	}
}
