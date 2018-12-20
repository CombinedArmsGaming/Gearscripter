package combinedarms.gearscriptor.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class InputScreen 
{
	@FXML
	private Button buttonMain;
	@FXML
	private TextArea submitCodeTextField;
	@FXML
	private TextField unitRoleBox;
	@FXML
	private Tooltip tooltip;
	
	public void buttonMainClicked(ActionEvent event)
	{
		System.out.println(submitCodeTextField.getText());
		System.out.println(unitRoleBox.getText());
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
