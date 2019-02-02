package combinedarms.gearscriptor.presentation;

import java.io.IOException;

import combinedarms.gearscriptor.driver.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginScreen 
{
	public void login(ActionEvent event) throws IOException 
	{  
		//TODO add login stuff properly
	}
	
	public void continueWithoutLogin(ActionEvent event) throws IOException 
	{
		try {
			((Node)(event.getSource())).getScene().getWindow().hide();
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("../presentation/fxml/InputScreen.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setTitle("CombinedArms GearScripter");
	        stage.getIcons().add(new Image(Application.class.getResourceAsStream("../resources/caLogo.png")));
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    } catch (IOException e) { }
	}
}
