package combinedarms.gearscriptor.presentation;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginScreen 
{
	public void login(ActionEvent event) throws IOException 
	{  
		//TODO add login stuff properly
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setLocation(getClass().getResource("../presentation/InputScreen.fxml"));
	        Scene scene = new Scene(fxmlLoader.load());
	        Stage stage = new Stage();
	        stage.setTitle("New Window");
	        stage.setScene(scene);
	        stage.show();
	        ((Node)(event.getSource())).getScene().getWindow().hide();
	    } catch (IOException e) { }
	}
}
