/**
 * Represents an ActionButton for the ActionSubPanel
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class HealButton extends ActionButton
{
	// Constructor(s)
	/**
	 * Create an ActionButton with a String, and set it's design
	 * @param givenString
	 */
	public HealButton(String givenString) // Create HealButton with icon
	{
		// Call the super constructor (EmptyButton)
        super(givenString);

        setVerticalTextPosition(SwingConstants.BOTTOM); // Set position of title vertically 
		setHorizontalTextPosition(SwingConstants.CENTER); // Set position of title horizontally
		setIcon(new ImageIcon("heal.png")); // Set image icon
		setRolloverIcon(new ImageIcon("heal.gif")); // Set rollover icon
		setRolloverEnabled(true); // Enable icon
	}
}
