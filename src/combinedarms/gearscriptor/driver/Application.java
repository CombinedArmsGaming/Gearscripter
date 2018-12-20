package combinedarms.gearscriptor.driver;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Application extends javafx.application.Application 
{
	Label lb_text;
	Button btn_click;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//get the FXML file for this page 
		Parent root = FXMLLoader.load(getClass().getResource("../presentation/InputScreen.fxml"));
        //Set Title
        stage.setTitle("CombinedArms GearScriptor");
        //Create new scene
        stage.setScene(new Scene(root));
        //Screen is not resizable
      	stage.setResizable(false);
        stage.show();
	}
}
