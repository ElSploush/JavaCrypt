// Imports
import javax.swing.*;

@SuppressWarnings("serial")
public class ActionButton extends JButton
{
	// Establish instance variables
	private String string;
	
	// Constructor(s)
	public ActionButton(String givenString) // Create ActionButton with icon
    {
        string = givenString; // Set the default icon
        this.setText(string); // Set this ActionButton icon
    }
}
