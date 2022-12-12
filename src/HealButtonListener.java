// Imports
import java.awt.event.*;

import javax.swing.JOptionPane;

public class HealButtonListener implements ActionListener
{
	// Establish instance variables
	private HealButton healButton; // HealButtonListener has-a healButton
	private JavaCrypt game; // HealButtonListener has-a JavaCrypt
	
	// Establish player variables
	private int currentNumberOfHealthPotions; // Starting number of health potions
	
	// Constructor(s)
	public HealButtonListener(HealButton givenHealButton, JavaCrypt givenGame) // Create listener with a HealButton and JavaCrypt
    {
        healButton = givenHealButton; // Set the HealButton
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	public void actionPerformed(ActionEvent e) // Update text field and determine if game is over
    {
		currentNumberOfHealthPotions = game.getCurrentNumberOfHealthPotions(); // Retrieve current number of health potions
		
		// Determine if player has health potions to use
		if (currentNumberOfHealthPotions > 0)
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
