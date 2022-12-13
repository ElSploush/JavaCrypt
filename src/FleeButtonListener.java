// Imports
import java.awt.event.*;
import java.util.Random;

public class FleeButtonListener implements ActionListener
{
	// Establish instance variables
	private JavaCrypt game; // FleeButtonListener has-a JavaCrypt
	Random random = new Random(); // Create random object for number generation
	
	// Constructor(s)
	public FleeButtonListener(JavaCrypt givenGame) // Create listener with a FleeButton and JavaCrypt
    {
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
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