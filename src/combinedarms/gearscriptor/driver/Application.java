package combinedarms.gearscriptor.driver;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Application extends javafx.application.Application 
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//get the FXML file for this page 
		Parent root = FXMLLoader.load(getClass().getResource("../presentation/LoginScreen.fxml"));
        //Set Title
        stage.setTitle("CombinedArms GearScripter");
        //Create new scene
        stage.setScene(new Scene(root));
        //Screen is not resizable
      	stage.setResizable(false);
        stage.show();
	}
}
