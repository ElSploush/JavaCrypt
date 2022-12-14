/**
 * Represents a JButton for the ActionSubPanel
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import javax.swing.*;

@SuppressWarnings("serial")
public class ActionButton extends JButton
{
	// Establish instance variables
	private String string;
	
	// Constructor(s)
	/**
	 * Create an action button with a String
	 * @param givenString
	 */
	public ActionButton(String givenString) // Create ActionButton with icon
    {
        string = givenString; // Set the default icon
        this.setText(string); // Set this ActionButton icon
    }
}
