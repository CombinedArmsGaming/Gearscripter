package combinedarms.gearscriptor.driver;
import java.sql.*;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Application extends javafx.application.Application 
{
	public static void main(String[] args)
	{
		connectToDb();
		launch(args);
	}

	public static void connectToDb() 
	{
		Connection c = null;
		Statement stmt = null;
	      
		try {
				Class.forName("org.sqlite.JDBC");
	        	c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        	stmt = c.createStatement();
	        	String sql = "CREATE TABLE IF NOT EXISTS UNITS " + 
	        		"(ID INT PRIMARY KEY NOT NULL," +
	        		" NAME							TEXT, " + 
	        		" MADEBY        				TEXT, " + 
	        		" DATECREATED     				TEXT, " + 
	        		" PRIMARYWEAPON 				TEXT, " + 
	        		" PRIMARYWEAPONATTACHMENTS		TEXT, " + 
	        		" SECONDARYWEAPON        		TEXT, " +
	        		" SECONDARYWEAPONATTACHMENTS 	TEXT, " +
	        		" LAUNCHER					 	TEXT, " +
	        		" LAUNCHERATTACHMENTS		 	TEXT, " +
	        		" UNIFORM						TEXT, " +
	        		" VEST						 	TEXT, " +
	        		" BACKPACK					 	TEXT, " +
	        		" HEADGEAR					 	TEXT, " +
	        		" FACEWEAR					 	TEXT, " +
	        		" UNIFORMITEMS					TEXT, " +
	        		" VESTITEMS						TEXT, " +
	        		" BACKPACKITEMS			 		TEXT, " + 
	        		" ARSENALCODE					TEXT)"; 
	        	stmt.executeUpdate(sql);
	        	stmt.close();
	        	c.close();
			} catch (Exception e) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				System.exit(0);
			}
	}
	
	//Returns a db connection
	//TODO - Handle what happens if connection is unsuccessful 
	public static Connection dbConnect() 
	{
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return c;
	}
	@Override
	public void start(Stage stage) throws Exception {
		//get the FXML file for this page 
		Parent root = FXMLLoader.load(getClass().getResource("../presentation/fxml/LoginScreen.fxml"));
        //Set Title
        stage.setTitle("CombinedArms GearScripter");
        //Set the icon
        stage.getIcons().add(new Image(Application.class.getResourceAsStream("../resources/caLogo.png")));
        //Create new scene
        stage.setScene(new Scene(root));
        //Screen is not resizable
      	stage.setResizable(false);
        stage.show();
	}
}