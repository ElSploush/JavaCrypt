import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FleeButton extends ActionButton
{
	// Constructor(s)
	public FleeButton(String givenString) // Create FleeButton with icon
	{
		// Call the super constructor (EmptyButton)
        super(givenString);
        
        setVerticalTextPosition(SwingConstants.BOTTOM); // Set position of title vertically 
		setHorizontalTextPosition(SwingConstants.CENTER); // Set position of title horizontally
		setIcon(new ImageIcon("flee.png")); // Set image icon
		setRolloverIcon(new ImageIcon("flee.gif")); // Set rollover icon
		setRolloverEnabled(true); // Enable icon
	}
}
