// Import required classes
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ActionSubPanel extends JPanel
{
	// Establish objects
	private JavaCrypt game; // ActionSubPanel has-a game
	
	// Reference variables for GameInfoPanel
	private final int NUMBER_OF_ACTIONS = 3; // Number of possible actions
	
	// Create array of buttons
	private ActionButton[] buttonArray = new ActionButton[NUMBER_OF_ACTIONS]; // Has-an array of ActionButtons
	
	// Constructor(s)
	public ActionSubPanel(JavaCrypt givenGame) // Create ActionSubPanel with a game
	{
		// Set the game
		game = givenGame;
		
		// Set panel layout
		setLayout(new GridLayout(1,3));
		
		// Change panel dimension
        setPreferredSize(new Dimension(650,250));
		
		// Create AttackButton and AtttackButtonListener Objects and register action listener
		buttonArray[0] = new AttackButton("Attack"); // Set title of button
		AttackButtonListener attackButtonListener = new AttackButtonListener(game);
		buttonArray[0].addActionListener(attackButtonListener);
		
		// Create HealButton and HealButtonListener Objects and register action listener
		buttonArray[1] = new HealButton("Heal"); 
		HealButtonListener healButtonListener = new HealButtonListener(game);
		buttonArray[1].addActionListener(healButtonListener);
		
		// Create FleeButton and FleeButtonListener Objects and register action listener
		buttonArray[2] = new FleeButton("Flee"); 
		FleeButtonListener fleeButtonListener = new FleeButtonListener(game);
		buttonArray[2].addActionListener(fleeButtonListener);
		
		// Add buttonArray to the action panel
		for (int index = 0; index < NUMBER_OF_ACTIONS; index++)
		{
			add(buttonArray[index]);
		}
	}	
}
