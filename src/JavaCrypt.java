// Imports
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.TitledBorder;

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
	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
	
	// Constructor(s)
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
		player = new Player(100, 3);
		
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(player.getHealth()); // Set enemy health text field
		infoSubPanel.setNumberOfHealthPotionsTextField(player.getNumberOfHealthPotions()); // Set player health text field
		
		// Spawn an enemy
		spawnEnemy(); 
	}
	
	// Mutator(s)
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
	
	public void createPlayPanel()
	{
		// Establish local variables
		infoSubPanel = new InfoSubPanel(); // playPanel has-a InfoSubPanel
		actionSubPanel = new ActionSubPanel(this); // playPanel has-a ActionSubPanel
		
		// Set the layout of the playPanel
		playPanel.setLayout(new BorderLayout());
		
		// Add playPanel components and designate location
		add(infoSubPanel, BorderLayout.NORTH);
		playPanel.add(actionSubPanel, BorderLayout.SOUTH);
		
		// Create TitledBorder objects for playPanel and infoPanel, then format
		TitledBorder aboveTopBorderPlayPanel = BorderFactory.createTitledBorder("Actions");
		aboveTopBorderPlayPanel.setTitlePosition(TitledBorder.ABOVE_TOP);
		TitledBorder aboveTopBorderInfoSubPanel = BorderFactory.createTitledBorder("Game Info");
		aboveTopBorderInfoSubPanel.setTitlePosition(TitledBorder.ABOVE_TOP);
		
		// Set infoSubPanel and actionSubPanel to the aboveTopBorder
		playPanel.setBorder(aboveTopBorderPlayPanel);
		infoSubPanel.setBorder(aboveTopBorderInfoSubPanel); 
	}
	
	public void attackPhase()
	{
		// Retrieve values
		int damageDealtByEnemy = enemy.damageDealt();
		int damageDealtByPlayer = player.damageDealt();
		int playerHealth = player.getHealth();
		int enemyHealth = enemy.getHealth();
		
		// Display message
		JOptionPane.showMessageDialog(null, "The " + enemy.getEnemy() + " attacks for " + damageDealtByEnemy + "!");
		JOptionPane.showMessageDialog(null, "You have attacked the " + enemy.getEnemy() + " for " + damageDealtByPlayer + "!");
		
		// Calculate
		playerHealth -= damageDealtByEnemy;
		enemyHealth -= damageDealtByPlayer;
		
		// Update panels
		infoSubPanel.setPlayerHealthTextField(playerHealth);
		infoSubPanel.setEnemyHealthTextField(enemyHealth);
	}
	
	public void heal()
	{
		player.useHealthPotion(); // Use a health potion on the player
		
		// Display message
		JOptionPane.showMessageDialog(null, "You have healed for " + player.getHealthPotionHealAmount() + "!");
				
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(player.getHealth()); // Set player health text field
		infoSubPanel.setNumberOfHealthPotionsTextField(player.getNumberOfHealthPotions()); // Set number of health potions text field
	}
	
	public void dropHealthPotion()
	{
		if (random.nextInt(101) < enemy.getHealthPotionDropChance())
		{
		player.foundHealthPotion();
		}
	}
	
	public void gameOver()
	{
		JOptionPane.showMessageDialog(null, "You have been defeated by " + enemy.getEnemy() + "!" + "\nGood luck next time!"); // Display game over message
		
		// CLOSE THE PROGRAM
		System.exit(0); // stop program
	}
	
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
	
	public void isHighScore()
	{
		if (numberOfEnemiesDefeated > highScore)
		{
			// Write to file
			try
			{
			BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt")); // Create BufferedWriter object
			writer.write(Integer.toString(numberOfEnemiesDefeated)); // Write numberOfEnemiesDefeated to highscore.txt
			writer.close(); // Close the writer
			
			} catch (IOException e)
			{
				// Print error message
				JOptionPane.showMessageDialog(null, "Error writing to file \'highscore.txt\'");
			}	
		}
	}
	
	public void loadHighScore() throws IOException
	{
		// Read from file
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
			
			String lineRead = reader.readLine(); // Create local string for the line read and assign it to return from readLine
			highScore = Integer.parseInt(lineRead); // Convert the lineRead string to an int
			reader.close(); // Close the reader
		}
		catch (FileNotFoundException e)
		{
			// Print error message 
			JOptionPane.showMessageDialog(null, "Error reading file \'highscore.txt\'. The program will close.");
			System.exit(0);
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(null, "Conversion error from \'highscore.txt\'. The program will close.");
			System.exit(0);
		}
		
		// Update text field
		infoSubPanel.setHighScoreTextField(highScore);
	}
	
	// Accessor(s)
	public boolean isGameOver() //Determine if the game is over
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
	
	public boolean isEnemyDead() //Determine if the enemy is dead
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
	
	public boolean isHealthPotion() //Determine if the game is over
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
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Enemy getEnemy()
	{
		return enemy;
	}
}	