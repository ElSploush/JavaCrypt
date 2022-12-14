/**
 * Represents an ActionListener for a FleeButton
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import java.awt.event.*;
import java.util.Random;

public class FleeButtonListener implements ActionListener
{
	// Establish instance variables
	private JavaCrypt game; // FleeButtonListener has-a JavaCrypt
	Random random = new Random(); // Create random object for number generation
	
	// Constructor(s)
	/**
	 * Create an ActionListener with a game
	 * @param givenGame
	 */
	public FleeButtonListener(JavaCrypt givenGame) // Create listener with a FleeButton and JavaCrypt
    {
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	/**
	 * Determine if a player can flee,  perform a flee, or perform a flee attack
	 */
	public void actionPerformed(ActionEvent e) // Update text field and determine if game is over
    {		
		if (game.isFleeSuccessful()) // Conditional for if the player rolls a number less than or equal to 30
		{
			// Display flee message
			game.flee();
		}
		else
		{
			game.fleeAttack(); // Attack the player during flee
		}
    }
}