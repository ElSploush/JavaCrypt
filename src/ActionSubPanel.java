// Import required classes
import javax.swing.*;
import java.awt.*;

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
		buttonArray[0].setVerticalTextPosition(SwingConstants.BOTTOM); // Set position of title vertically 
		buttonArray[0].setHorizontalTextPosition(SwingConstants.CENTER); // Set position of title horizontally
		buttonArray[0].setIcon(new ImageIcon("attackicon.png")); // Set image icon
		buttonArray[0].setRolloverIcon(new ImageIcon("attackicon.gif")); // Set rollover icon
		buttonArray[0].setRolloverEnabled(true); // Enable icon
		AttackButtonListener attackButtonListener = new AttackButtonListener((AttackButton) buttonArray[0], game);
		buttonArray[0].addActionListener(attackButtonListener);
		
		// Create HealButton and HealButtonListener Objects and register action listener
		buttonArray[1] = new HealButton("Heal"); 
		buttonArray[1].setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonArray[1].setHorizontalTextPosition(SwingConstants.CENTER);
		buttonArray[1].setIcon(new ImageIcon("healicon.png"));
		buttonArray[1].setRolloverIcon(new ImageIcon("healicon.gif")); // Set rollover icon
		buttonArray[1].setRolloverEnabled(true); // Enable icon
		HealButtonListener healButtonListener = new HealButtonListener((HealButton) buttonArray[1], game);
		buttonArray[1].addActionListener(healButtonListener);
		
		// Create FleeButton and FleeButtonListener Objects and register action listener
		buttonArray[2] = new FleeButton("Flee"); 
		buttonArray[2].setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonArray[2].setHorizontalTextPosition(SwingConstants.CENTER);
		buttonArray[2].setIcon(new ImageIcon("fleeicon.png"));
		buttonArray[2].setRolloverIcon(new ImageIcon("fleeicon.gif")); // Set rollover icon
		buttonArray[2].setRolloverEnabled(true); // Enable icon
		FleeButtonListener fleeButtonListener = new FleeButtonListener((FleeButton) buttonArray[2], game);
		buttonArray[2].addActionListener(fleeButtonListener);
		
		// Add buttonArray to the action panel
		for (int index = 0; index < NUMBER_OF_ACTIONS; index++)
		{
			add(buttonArray[index]);
		}
	}	
}
