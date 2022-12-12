// Imports
import java.awt.event.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class FleeButtonListener implements ActionListener
{
	// Establish instance variables
	private FleeButton fleeButton; // FleeButtonListener has-a fleeButton
	private JavaCrypt game; // FleeButtonListener has-a JavaCrypt
	Random random = new Random(); // Create random object for number generation
	
	// Establish flee variables
	private static int fleeRollChance; // Percentage chance to flee
	private static int successfulFleeChance; // Percentage required to successfully flee
	
	// Establish enemy variables
	private static String currentEnemy; // Current enemy name
	
	// Constructor(s)
	public FleeButtonListener(FleeButton givenFleeButton, JavaCrypt givenGame) // Create listener with a FleeButton and JavaCrypt
    {
        fleeButton = givenFleeButton; // Set the FleeButton
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	public void actionPerformed(ActionEvent e) // Update text field and determine if game is over
    {
		// Retrieve flee success percentage
		successfulFleeChance = Player.getSuccessfulFleeChance();
				
		// Calculate flee roll
		fleeRollChance = random.nextInt(0,101); // Generate a random number between 0 and 100 (incl.) for percentage chance to flee
		
		if (fleeRollChance <= successfulFleeChance) // Conditional for if the player rolls a number less than or equal to 30
		{
			// Retrieve currentEnemy
			currentEnemy = game.getCurrentEnemy();
			
			JOptionPane.showMessageDialog(null, "You flee from the " + currentEnemy + " succesfully!"); // Display message for player running away
			JOptionPane.showMessageDialog(null, "You encounter a new enemy elsewhere."); // Display message for player starting combat with new enemy
			
			// Spawn new enemy
			game.spawnEnemy();
		}
		else
		{
			game.fleeAttack(); // Attack the player during flee
		}
    }
}