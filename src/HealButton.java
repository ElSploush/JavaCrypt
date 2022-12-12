import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class HealButton extends ActionButton
{
	// Constructor(s)
	public HealButton(String givenString) // Create HealButton with icon
	{
		// Call the super constructor (EmptyButton)
        super(givenString);
<<<<<<< HEAD
        
=======
>>>>>>> refs/remotes/origin/main
        setVerticalTextPosition(SwingConstants.BOTTOM); // Set position of title vertically 
		setHorizontalTextPosition(SwingConstants.CENTER); // Set position of title horizontally
		setIcon(new ImageIcon("heal.png")); // Set image icon
		setRolloverIcon(new ImageIcon("heal.gif")); // Set rollover icon
		setRolloverEnabled(true); // Enable icon
	}
}
