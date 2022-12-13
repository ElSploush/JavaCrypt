// Imports
import java.awt.event.*;

import javax.swing.JOptionPane;

public class HealButtonListener implements ActionListener
{
	// Establish instance variables
	private JavaCrypt game; // HealButtonListener has-a JavaCrypt
	
	// Constructor(s)
	public HealButtonListener(JavaCrypt givenGame) // Create listener with a HealButton and JavaCrypt
    {
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	public void actionPerformed(ActionEvent e) // Update text field and determine if game is over
    {
		// Determine if player has health potions to use
		if (game.isHealthPotion())
		{
			// Perform heal method
			game.heal(); 
		}
		else
		{
			// Display message for no health potions
			JOptionPane.showMessageDialog(null, "You have no health potions to use. \nDefeat enemies to receive more potions."); 
		}
    }
}
