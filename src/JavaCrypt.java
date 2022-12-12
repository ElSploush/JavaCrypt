// Imports
import java.util.ArrayList;
import java.util.Arrays;
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
	private final int WINDOW_HEIGHT = 325; // Initialize final window height
	
	// Establish panel variables
	private JPanel playPanel = new JPanel(); // JavaCrypt has-a playPanel (JPanel)
	private InfoSubPanel infoSubPanel; // playPanel has-a infoSubPanel
	private ActionSubPanel actionSubPanel; // playPanel has-an actionSubPanel
	
	// Establish game objects
	private static Player player = new Player(); // JavaCrypt has-a player
	private Enemy enemy = new Enemy(); // JavaCrypy has-an enemy
	
	// Variables for InfoPanel
	private static int currentPlayerHealth; // Value of player health
	private static int currentNumberOfHealthPotions; // Value for number of potions
	private static String currentEnemy; // Type of enemy
	private static int currentEnemyHealth; // Current enemy health
	private static int numberOfEnemiesDefeated; // The number of enemies defeated this game
	private static int highScore; // All time high score
	
	// Variables for enemies
	private static int maxCurrentEnemyAttackDamage; // Maximum attack damage for the current spawned enemy
	private static int minCurrentEnemyAttackDamage; // Minimum attack damage for the current spawned enemy
	
	// Variables for player
	private static int healthPotionHealAmount; // Health potion heal amount
	
	// Objects
	Random random = new Random(); // Create a random object for random number generation

	// Main Method
	public static void main(String[] args) throws IOException
	{
		// Display welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Java Crypt!");
		
		// Display message for game objective and how to play
		JOptionPane.showMessageDialog(null, "HOW TO PLAY:" + 
											"\nThe Java Crypt is a simple dunegeon crawler." +
											"\nInside the dungeon, you will encounter 3 types of enemies." + 
											"\nEach type of enemy has a different amount of health, and deals damage in a different range of values." +
											"\nYou can chose one of three actions: Attack, Heal, or Flee." +
											"\nThe Attack button deals damage to the enemy, whilst the enemy does damage to you." +
											"\nThe Heal button heals the player for the turn, and the enemy deals no damage." +
											"\nThe player can receive more health potions as a drop chance from defeating an enemy." +
											"\nThe Flee button forces an attempt to flee from the current enemy." +
											"\n If the attempt to flee is succesful, the player receives no damage and encounters another enemy elsewhere." +
											"\n If the attempt is unsuccessful, the player receives half damage from the current enemie's attack range." +
											"\n The goal is to defeat as many enemies as possible before dying." +
											"\n\n GOOD LUCK AND HAVE FUN!");
		
		// Create a new instance of the JavaCrypt
		JavaCrypt javaCrypt = new JavaCrypt();
		
		// Load highScore and update text field
		javaCrypt.loadHighScore();
		
		// Instantiate player values
		javaCrypt.setStartingPlayerInfo();
		
		// Spawn initial enemy
		javaCrypt.spawnEnemy();
	}
	
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
	}
	
	// Mutator(s)
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
	
	public void spawnEnemy()
	{
		// Create list of enemy types
		ArrayList<String> enemyTypes = new ArrayList<String> (Arrays.asList("Syntax","Exception","Compile"));  // ArrayList of enemy types
				
		// Create and define an enemy
		currentEnemy = enemyTypes.get(random.nextInt(enemyTypes.size())); // Retrieve random element from ArrayList and assign it to String currentEnemy
				
		// Establish chosen enemy characteristics
		if (currentEnemy.equals("Syntax"))
		{
		// Assign current enemy with Syntax values
		currentEnemyHealth = enemy.getSyntaxHealth(); // If enemy is Syntax, set currentEnemyHealth equal to syntaxEnemyHealth
		maxCurrentEnemyAttackDamage = enemy.getMaxSyntaxAttackDamage(); // If enemy is Syntax, set maxEnemyAttackDamage equal to maxSyntaxAttackDamage
		minCurrentEnemyAttackDamage = enemy.getMinSyntaxAttackDamage(); // If enemy is Syntax, set minEnemyAttackDamage equal to minSyntaxAttackDamage
		}
		else if (currentEnemy.equals("Exception"))
		{
		// Assign current enemy with Exception values	
		currentEnemyHealth = enemy.getExceptionHealth(); // If enemy is Exception, set currentEnemyHealth equal to exceptionEnemyHealth
		maxCurrentEnemyAttackDamage = enemy.getMaxExceptionAttackDamage(); // If enemy is Exception, set maxEnemyAttackDamage equal to maxExceptionAttackDamage
		minCurrentEnemyAttackDamage = enemy.getMinExceptionAttackDamage(); // If enemy is Exception, set minEnemyAttackDamage equal to minExceptionAttackDamage
		}
		else if (currentEnemy.equals("Compile"))
		{
		// Assign current enemy with Compile values
		currentEnemyHealth = enemy.getCompileHealth(); // If enemy is Compile, set currentEnemyHealth equal to compileEnemyHealth
		maxCurrentEnemyAttackDamage = enemy.getMaxCompileAttackDamage(); // If enemy is Compile, set maxEnemyAttackDamage equal to maxCompileAttackDamage
		minCurrentEnemyAttackDamage = enemy.getMinCompileAttackDamage(); // If enemy is Compile, set minEnemyAttackDamage equal to minCompileAttackDamage
		}
				
		// Display message for which enemy has spawned
		JOptionPane.showMessageDialog(null, "A(n) " + currentEnemy + " has spawned!");
		
		// Update text fields on InfoSubPanel
		infoSubPanel.setEnemyTypeTextField(currentEnemy); // Update which enemy spawned
		infoSubPanel.setEnemyHealthTextField(currentEnemyHealth); // Update enemy health
	}
	
	public void attack() // Adjust text fields for attack
	{
		// Retrieve current enemy and player health before attack
		currentEnemyHealth = this.getCurrentEnemyHealth();
		currentPlayerHealth = this.getCurrentPlayerHealth();
				
		// Determine player damage to enemy
		int damageDealtToEnemy = random.nextInt(player.getMinPlayerAttackDamage(), player.getMaxPlayerAttackDamage()+1); // Establish variable for dmg dealt to enemy
																								 // Assign variable to random number between min and max player damage
				
		
		// Determine damage taken by player
		int damageDealtToPlayer = random.nextInt(minCurrentEnemyAttackDamage, maxCurrentEnemyAttackDamage+1); // Establish variable for dmg taken by player
																											  // Assign variable to random number between min and max
			
		// Calculate damage dealt and taken
		currentEnemyHealth -= damageDealtToEnemy; // Subtract damage dealt from enemy health
		currentPlayerHealth -= damageDealtToPlayer; // Subtract damage dealt from player health
		
		// Display damage recap
		JOptionPane.showMessageDialog(null, "The " + currentEnemy + " has attacked you for " + damageDealtToPlayer + ".");
		JOptionPane.showMessageDialog(null, "You have attacked the " + currentEnemy + " for " + damageDealtToEnemy + ".");
		
		// Update text fields
		infoSubPanel.setEnemyHealthTextField(currentEnemyHealth); // Set enemy health text field
		infoSubPanel.setPlayerHealthTextField(currentPlayerHealth); // Set player health text field
	}
	
	public void fleeAttack()
	{
		// Determine damage taken by player
		int damageDealtToPlayer = (random.nextInt(minCurrentEnemyAttackDamage, maxCurrentEnemyAttackDamage+1)/2); // Establish variable for dmg taken by player
																											  	  // Assign variable to random number between min and max enemy damage
																												  // Divide by 2 for flee
		
		// Calculate damage taken during flee
		currentPlayerHealth -= damageDealtToPlayer; // Subtract damage dealt from player health
		
		// Display damage recap
		JOptionPane.showMessageDialog(null, "Your attempt to flee is unsuccesful!");
		JOptionPane.showMessageDialog(null, "The " + currentEnemy + " has attacked you for " + damageDealtToPlayer + " during your attempt to flee.");
		
		// Update text field
		infoSubPanel.setPlayerHealthTextField(currentPlayerHealth); // Set player health text field
	}
	
	public void heal()
	{
		// Add heal amount to currentPlayerHealth
		currentPlayerHealth += healthPotionHealAmount; 
		
		// Reduce number of potions
		currentNumberOfHealthPotions--;
		
		// Display message
		JOptionPane.showMessageDialog(null, "You have healed for " + healthPotionHealAmount + "!");
		
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(currentPlayerHealth); // Set player health text field
		infoSubPanel.setNumberOfHealthPotionsTextField(currentNumberOfHealthPotions); // Set number of health potions text field
	}
	
	public void foundHealthPotion()
	{
		JavaCrypt.getCurrentNumberOfHealthPotions(); // Retrieve the number of current health potions
		currentNumberOfHealthPotions++; // Increment the number of health potions
		
		JOptionPane.showMessageDialog(null, "The " + currentEnemy + " has dropped a health potion!"); // Display for message for health potion drop
		JOptionPane.showMessageDialog(null, "You now have " + currentNumberOfHealthPotions + " potions."); // Display current number of health potions
		
		// Update text field
		infoSubPanel.setNumberOfHealthPotionsTextField(currentNumberOfHealthPotions);
	}
	
	public void gameOver()
	{
		JOptionPane.showMessageDialog(null, "You have been defeated by " + currentEnemy + "!" + "\nGood luck next time!"); // Display game over message
		
		// CLOSE THE PROGRAM
		System.exit(0); // stop program
	}
	
	public void enemyDead() throws IOException
	{
		// Display message
		JOptionPane.showMessageDialog(null, "You have deafeted the " + currentEnemy + "!");
		
		// Increment number of enemies defeated
		numberOfEnemiesDefeated++;
		
		// Determine if high score occurs
		this.isHighScore();
		
		// Update text field
		infoSubPanel.setNumberOfEnemiesDefeatedTextField(numberOfEnemiesDefeated);
	}
	
	public void isHighScore() throws IOException
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
				e.printStackTrace();
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
		}
		catch (FileNotFoundException e)
		{
			// Print error message 
			e.printStackTrace();
		}
		
		// Update text field
		infoSubPanel.setHighScoreTextField(highScore);
	}
	
	public void setStartingPlayerInfo()
	{
		currentPlayerHealth = player.getStartingPlayerHealth(); // Retrieve player starting health
		currentNumberOfHealthPotions = player.getStartingNumberOfHealthPotions(); // Retrieve starting number of health potions
		healthPotionHealAmount = player.getHealthPotionHealAmount(); // Retrieve health potion heal amount
	}
	
	// Accessor(s)
	public boolean isGameOver() //Determine if the game is over
	{
		if (currentPlayerHealth <= 0)
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
		if (currentEnemyHealth <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getCurrentEnemy()
	{
		return currentEnemy;
	}
	
	public int getCurrentEnemyHealth()
	{
		return currentEnemyHealth;
	}
	
	public int getCurrentPlayerHealth()
	{
		return currentPlayerHealth;
	}
	
	public static int getCurrentNumberOfHealthPotions()
	{
		return currentNumberOfHealthPotions;
	}
}	