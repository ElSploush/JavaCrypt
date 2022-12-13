// Imports
import java.awt.event.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class FleeButtonListener implements ActionListener
{
	// Establish instance variables
	private FleeButton fleeButton; // FleeButtonListener has-a fleeButton
	private JavaCrypt game; // FleeButtonListener has-a JavaCrypt
	private Player player; // FleeButtonListener has-a Player
	private Enemy enemy; //FleeButtonListener has-a Enemy
	Random random = new Random(); // Create random object for number generation
	
	// Establish flee variables
	private static int fleeRoll; // Percentage chance to flee
	
	// Constructor(s)
	public FleeButtonListener(FleeButton givenFleeButton, JavaCrypt givenGame) // Create listener with a FleeButton and JavaCrypt
    {
        fleeButton = givenFleeButton; // Set the FleeButton
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	public void actionPerformed(ActionEvent e) // Update text field and determine if game is over
    {		
		// Calculate flee roll
		fleeRoll = random.nextInt(101); // Generate a random number between 0 and 100 (incl.) for percentage chance to flee
		
		if (fleeRoll <= player.getSuccessfulFleeChance()) // Conditional for if the player rolls a number less than or equal to 30
		{
			// Display flee message
			JOptionPane.showMessageDialog(null, "You flee from the " + enemy.getEnemy() + " succesfully!"); // Display message for player running away
			JOptionPane.showMessageDialog(null, "You encounter a new enemy elsewhere."); // Display message for player starting combat with new enemy
			
			// Spawn new enemy
			game.spawnEnemy(); 
		}
		else
		{
			enemy.fleeAttack(); // Attack the player during flee
		}
    }
}