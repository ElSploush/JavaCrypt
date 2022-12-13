import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AttackButton extends ActionButton
{
	// Constructor(s)
	public AttackButton(String string) // Create AttackButton with icon
    {
		// Call the super constructor (EmptyButton)
        super(string);
        
		setVerticalTextPosition(SwingConstants.BOTTOM); // Set position of title vertically 
		setHorizontalTextPosition(SwingConstants.CENTER); // Set position of title horizontally
		setIcon(new ImageIcon("attack.png")); // Set image icon
		setRolloverIcon(new ImageIcon("attack.gif")); // Set rollover icon
		setRolloverEnabled(true); // Enable icon
    }
}