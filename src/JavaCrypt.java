/**
 * Represents a JFrame object for the game
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class JavaCrypt extends JFrame
{
	// Establish window variables
	private final int WINDOW_WIDTH = 700; // Initialize final window width
	private final int WINDOW_HEIGHT = 400; // Initialize final window height
	
	// Establish panel variables
	private JPanel playPanel = new JPanel(); // JavaCrypt has-a playPanel (JPanel)
	private InfoSubPanel infoSubPanel; // playPanel has-a infoSubPanel
	private ActionSubPanel actionSubPanel; // playPanel has-an actionSubPanel
	
	// Establish game objects
	private Player player; // JavaCrypt has-a player
	private Enemy enemy; // JavaCrypy has-an enemy
	
	// Variables for InfoPanel
	private static int numberOfEnemiesDefeated; // The number of enemies defeated this game
	private static int highScore; // All time high score
	
	// Establish Starting player attributes
	private final int STARTING_PLAYER_HEALTH = 100; // Starting player health
	private final int STARTING_NUMBER_OF_HEALTH_POTIONS = 3; // Starting number of player health potions
	
	// Establish Enemy attributes
	private final int SYNTAX_ENEMY_HEALTH = 60; // Starting value of a Syntax enemy health
	private final int EXCEPTION_ENEMY_HEALTH = 50; // Starting value of an Exception enemy health
	private final int COMPILE_ENEMY_HEALTH = 40; // Starting value of a Compile enemy health
	private final int MAX_SYNTAX_ATTACK_DAMAGE = 20; // Maximum attack damage for a Syntax enemy
	private final int MIN_SYNTAX_ATTACK_DAMAGE = 10; // Minimum attack damage for a Syntax enemy
	private final int MAX_EXCEPTION_ATTACK_DAMAGE = 30; // Maximum attack damage for an Exception enemy
	private final int MIN_EXCEPTION_ATTACK_DAMAGE = 20; // Minimum attack damage for an Exception enemy
	private final int MAX_COMPILE_ATTACK_DAMAGE = 40; // Maximum attack damage for a Compile enemy
	private final int MIN_COMPILE_ATTACK_DAMAGE = 30; // Minimum attack damage for a Compile enemy
	
	// Establish flee variables
	private static int fleeRoll; // Percentage chance to flee
	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
	
	// Constructor(s)
	/**
	 * Creates a JavaCrypt game
	 */
	public JavaCrypt() // No-arg constructor
	{	
		// Set window features
		setTitle("Java Crypt!"); // Set the window title
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT); // Set the window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Add a close button to the window
		setLayout(new FlowLayout()); // Set the layout of panels
		
		createPlayPanel(); // Create play panel
		add(playPanel); // Add play panel
		
		// Display the window
		setLocationRelativeTo(null);
		setVisible(true);
		
		// Create a player
		player = new Player(STARTING_PLAYER_HEALTH, STARTING_NUMBER_OF_HEALTH_POTIONS);
		
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(player.getHealth()); // Set enemy health text field
		infoSubPanel.setNumberOfHealthPotionsTextField(player.getNumberOfHealthPotions()); // Set player health text field
		
		// Spawn an enemy
		spawnEnemy(); 
	}
	
	// Mutator(s)
	/**
	 * Creates an enemy object and chooses it's attributes
	 */
	public void spawnEnemy()
	{
		int enemyChoice = random.nextInt(3); // Generate a random number
		
		// Establish chosen enemy characteristics
		if (enemyChoice == 0)
		{
			// Assign current enemy with Syntax values
			enemy = new Enemy("Syntax", SYNTAX_ENEMY_HEALTH, MAX_SYNTAX_ATTACK_DAMAGE, MIN_SYNTAX_ATTACK_DAMAGE); 
		}
		else if (enemyChoice == 1)
		{
			// Assign current enemy with Syntax values
			enemy = new Enemy("Exception", EXCEPTION_ENEMY_HEALTH, MAX_EXCEPTION_ATTACK_DAMAGE, MIN_EXCEPTION_ATTACK_DAMAGE);
		}
		else if (enemyChoice == 2)
		{
			// Assign current enemy with Syntax values
			enemy = new Enemy("Compile", COMPILE_ENEMY_HEALTH, MAX_COMPILE_ATTACK_DAMAGE, MIN_COMPILE_ATTACK_DAMAGE);
		}
		
		// Update text fields on InfoSubPanel
		infoSubPanel.setEnemyTypeTextField(enemy.getEnemy()); // Update which enemy spawned
		infoSubPanel.setEnemyHealthTextField(enemy.getHealth()); // Update enemy health
	}
	
	/**
	 * Assigns the playPanel characteristics
	 */
	public void createPlayPanel()
	{
		// Establish local variables
		infoSubPanel = new InfoSubPanel(); // playPanel has-a InfoSubPanel
		actionSubPanel = new ActionSubPanel(this); // playPanel has-a ActionSubPanel
		
		// Set the layout of the playPanel
		playPanel.setLayout(new BorderLayout());
		
		// Add playPanel components and designate location
		add(infoSubPanel, BorderLayout.NORTH);
		add(actionSubPanel, BorderLayout.SOUTH);
		
		// Create TitledBorder objects for playPanel and infoPanel, then format
		TitledBorder aboveTopBorderActionSubPanel = BorderFactory.createTitledBorder("Actions");
		aboveTopBorderActionSubPanel.setTitlePosition(TitledBorder.ABOVE_TOP);
		TitledBorder aboveTopBorderInfoSubPanel = BorderFactory.createTitledBorder("Game Info");
		aboveTopBorderInfoSubPanel.setTitlePosition(TitledBorder.ABOVE_TOP);
		
		// Set infoSubPanel and actionSubPanel to the aboveTopBorder
		actionSubPanel.setBorder(aboveTopBorderActionSubPanel);
		infoSubPanel.setBorder(aboveTopBorderInfoSubPanel); 
	}
	
	/**
	 * Determines damage received by a player and enemy, displays message, and sets corresponding text fields
	 */
	public void attackPhase()
	{
		enemy.receiveAttack(player); // Receive attack on enemy
		player.receiveAttack(enemy); // Receive attack on player
		
		// Display messages
		JOptionPane.showMessageDialog(null, "The " + enemy.getEnemy() + " attacks you for " + player.getEnemyDamage() + "!");
		JOptionPane.showMessageDialog(null, "You attack the " + enemy.getEnemy() + " for " + enemy.getPlayerDamage() + "!");
		
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(player.getHealth()); // Set player health text field
		infoSubPanel.setEnemyHealthTextField(enemy.getHealth()); // Set enemy health text field
		
	}
	
	/**
	 * Determines damage received by a player during a flee attempt, displays message, and updates corresponding text field 
	 */
	public void fleeAttack()
	{
		player.receiveFleeAttack(enemy); // Receive flee attack on player
		
		// Display message
		JOptionPane.showMessageDialog(null, "Your attempt to flee was unsuccesful!");
		JOptionPane.showMessageDialog(null, "The " + enemy.getEnemy() + " has attacked you for " + player.getEnemyFleeDamage() + " during your attempt to flee.");
		
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(player.getHealth()); // Set player health text field
	}
	
	/**
	 * Uses a health potion on a player, displays message, and updates corresponding text field
	 */
	public void heal()
	{
		player.useHealthPotion(); // Use a health potion on the player
		
		// Display message
		JOptionPane.showMessageDialog(null, "You have healed for " + player.getHealthPotionHealAmount() + "!");
				
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(player.getHealth()); // Set player health text field
		infoSubPanel.setNumberOfHealthPotionsTextField(player.getNumberOfHealthPotions()); // Set number of health potions text field
	}
	
	/**
	 * Determines if a health potion drops, a player finds it, and updates corresponding text field
	 */
	public void dropHealthPotion()
	{
		if (random.nextInt(101) < enemy.getHealthPotionDropChance())
		{
		player.foundHealthPotion();
		
		// Update text panel
		infoSubPanel.setNumberOfHealthPotionsTextField(player.getNumberOfHealthPotions());
		}
	}
	
	/**
	 * Displays a message for the game ending, and closes the program
	 */
	public void gameOver()
	{
		JOptionPane.showMessageDialog(null, "You have been defeated by " + enemy.getEnemy() + "!" + "\nGood luck next time!"); // Display game over message
		
		// CLOSE THE PROGRAM
		System.exit(0); // stop program
	}
	
	/**
	 * Displays a message for an enemy being defeated, increases the number of enemies defeated, determines if it sets a high score, and updates the corresponding text field
	 */
	public void enemyDead()
	{
		// Display message
		JOptionPane.showMessageDialog(null, "You have deafeted the " + enemy.getEnemy() + "!");
		
		// Increment number of enemies defeated
		numberOfEnemiesDefeated++;
		
		// Determine if high score occurs
		this.isHighScore();
		
		// Update text field
		infoSubPanel.setNumberOfEnemiesDefeatedTextField(numberOfEnemiesDefeated);
	}
	
	/**
	 * Displays a message for a player fleeing, spawns a new enemy
	 */
	public void flee()
	{
		// Display message
		JOptionPane.showMessageDialog(null, "You flee from the " + enemy.getEnemy() + " succesfully!"); // Display message for player running away
		JOptionPane.showMessageDialog(null, "You encounter a new enemy elsewhere."); // Display message for player starting combat with new enemy
		
		// Spawn new enemy
		this.spawnEnemy();
	}
	
	/**
	 * Determines if high score occurs, and writes the high score to a file if it does occur
	 * Catches IOException if the file for a high score does not exist, and displays message for the error
	 */
	public void isHighScore()
	{
		if (numberOfEnemiesDefeated > highScore)
		{
			// Write to file
			try
			{
			PrintWriter writer = new PrintWriter(new FileWriter("highscore.txt")); // Create BufferedWriter object
			writer.println(numberOfEnemiesDefeated); // Write numberOfEnemiesDefeated to highscore.txt
			writer.close(); // Close the writer
			
			} catch (IOException e)
			{
				// Display error message
				JOptionPane.showMessageDialog(null, "Error writing to file \'highscore.txt\'");
			}	
		}
	}
	
	/**
	 * Loads high score from a file, displays message if an error occurs, and updates corresponding text field
	 * @throws IOException
	 */
	public void loadHighScore() throws IOException
	{
		// Read from file
		try
		{
			Scanner scanner = new Scanner(new File("highscore.txt"));
			
			String lineRead = scanner.nextLine(); // Create local string for the line read and assign it to return from readLine
			highScore = Integer.parseInt(lineRead); // Convert the lineRead string to an int
			scanner.close(); // Close the reader
		}
		catch (FileNotFoundException e)
		{
			// Display error message
			JOptionPane.showMessageDialog(null, "Error reading file \'highscore.txt\'. The program will close.");
			System.exit(0);
		}
		catch (NumberFormatException nfe)
		{
			// Display error message
			JOptionPane.showMessageDialog(null, "Conversion error from \'highscore.txt\'. The program will close.");
			System.exit(0);
		}
		
		// Update text field
		infoSubPanel.setHighScoreTextField(highScore);
	}
	
	/**
	 * Determines if a game is over
	 * @return boolean true if a game is over, false if a game is not over
	 */
	// Accessor(s)
	public boolean isGameOver()
	{
		if (player.getHealth() <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Determines if a enemy is dead
	 * @return boolean true if a enemy is dead, false if not dead
	 */
	public boolean isEnemyDead()
	{
		if (enemy.getHealth() <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Determines if a potion is available for use by a player
	 * @return boolean true if a potion can be used, false if a potion cannot be used
	 */
	public boolean isHealthPotion()
	{
		if (player.getNumberOfHealthPotions() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Determines if a flee attempt is successful
	 * @return true if flee attempt is successful, false if unsuccessful
	 */
	public boolean isFleeSuccessful() // Determine if the flee is successful
	{
		// Calculate flee roll
		fleeRoll = random.nextInt(101); // Generate a random number between 0 and 100 (incl.) for percentage chance to flee
		
		if (fleeRoll <= player.getSuccessfulFleeChance())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}	