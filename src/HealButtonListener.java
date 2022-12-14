/**
 * Implements an ActionListener for a HealButton
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import java.awt.event.*;

import javax.swing.JOptionPane;

public class HealButtonListener implements ActionListener
{
	// Establish instance variables
	private JavaCrypt game; // HealButtonListener has-a JavaCrypt
	
	// Constructor(s)
	/**
	 * Create an ActionListener with a game
	 * @param givenGame
	 */
	public HealButtonListener(JavaCrypt givenGame) // Create listener with a HealButton and JavaCrypt
    {
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	/**
	 * Determine if a player can heal, perform a heal, or display message if unable
	 */
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
