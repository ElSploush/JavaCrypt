/**
 * Represents a JPanel for the game
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ActionSubPanel extends JPanel
{
	// Reference variables for GameInfoPanel
	private final int NUMBER_OF_ACTIONS = 3; // Number of possible actions
	
	// Create array of buttons
	private ActionButton[] buttonArray = new ActionButton[NUMBER_OF_ACTIONS]; // Has-an array of ActionButtons
	
	// Constructor(s)
	/**
	 * Create an ActionSubPanel with JButtons and ActionListeners
	 * @param givenGame
	 */
	public ActionSubPanel(JavaCrypt givenGame) // Create ActionSubPanel with a game
	{
		// Set panel layout
		setLayout(new GridLayout(1,3));
		
		// Change panel dimension
        setPreferredSize(new Dimension(650,250));
		
		// Create AttackButton and AtttackButtonListener Objects and register action listener
		buttonArray[0] = new AttackButton("Attack"); // Set title of button
		AttackButtonListener attackButtonListener = new AttackButtonListener(givenGame);
		buttonArray[0].addActionListener(attackButtonListener);
		
		// Create HealButton and HealButtonListener Objects and register action listener
		buttonArray[1] = new HealButton("Heal"); 
		HealButtonListener healButtonListener = new HealButtonListener(givenGame);
		buttonArray[1].addActionListener(healButtonListener);
		
		// Create FleeButton and FleeButtonListener Objects and register action listener
		buttonArray[2] = new FleeButton("Flee"); 
		FleeButtonListener fleeButtonListener = new FleeButtonListener(givenGame);
		buttonArray[2].addActionListener(fleeButtonListener);
		
		// Add buttonArray to the action panel
		for (int index = 0; index < NUMBER_OF_ACTIONS; index++)
		{
			add(buttonArray[index]);
		}
	}	
}
