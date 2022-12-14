/**
 * Represents a player for the game
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */
 
// Imports
import java.util.Random;

import javax.swing.JOptionPane;

public class Player
{	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
		
	// Establish Player variables
	private final int MAX_ATTACK_DAMAGE = 40; // Maximum amount of player attack damage
	private final int MIN_ATTACK_DAMAGE = 25; // Minimum amount of player attack damage
	private final int HEALTH_POTION_HEAL_AMOUNT = 35; // Amount of heal per health potion
	private final int SUCCESSFUL_FLEE_CHANCE = 30; // Successful chance for player to flee
	
	// Establish instance variables
	private int health; // Player health
	private int numberOfHealthPotions; // Number of health potions
	private int enemyDamage; // Damage dealt by enemy
	private int enemyFleeDamage; // Damage dealt by enemy during flee
	
	// Contructor(s)
	/**
	 * Creates a player
	 * @param health
	 * @param numberOfHealthPotions
	 */
	public Player(int health, int numberOfHealthPotions)
	{
		// Set current player health and number of potions
		this.health = health;
		this.numberOfHealthPotions = numberOfHealthPotions;
	}
	
	// Mutator(s)
	/**
	 * Receive an attack from an enemy, and determine a player's health after
	 * @param givenEnemy
	 */
	public void receiveAttack(Enemy givenEnemy)
	{
		enemyDamage = givenEnemy.damageDealt(); // Set the enemy damage
		
		health -= enemyDamage; // Subtract damage dealt by enemy from enemy health
	}
	
	/**
	 * Receive an attack from an enemy while fleeing, and determine a player's health after
	 * @param givenEnemy
	 */
	public void receiveFleeAttack(Enemy givenEnemy)
	{
		enemyFleeDamage = givenEnemy.fleeDamageDealt(); // Call the enemy from the game
		
		health -= enemyFleeDamage; // Subtract damage dealt by enemy from enemy health
	}
	
	/**
	 * Increase number of health potions and display message
	 */
	public void foundHealthPotion()
	{
		numberOfHealthPotions++; // Increment the number of health potions
		
		// Display message
		JOptionPane.showMessageDialog(null, "A health potion dropped!"); // Display for message for health potion drop
		JOptionPane.showMessageDialog(null, "You now have " + numberOfHealthPotions + " potions."); // Display current number of health potions
	}
	
	/**
	 * Reduce number of health potions from player and increase player health by heal amount
	 */
	public void useHealthPotion()
	{
		numberOfHealthPotions--; // Decrement number of health potions
		
		health += HEALTH_POTION_HEAL_AMOUNT; // Heal the player
	}
	
	// Accessor(s)
	/**
	 * Determine damage dealt by player on an enemy
	 * @return int damage dealt by player
	 */
	public int damageDealt()
	{
		// Determine damage dealt by player
		int damageDealt = random.nextInt(MIN_ATTACK_DAMAGE, MAX_ATTACK_DAMAGE+1); // Establish variable for dmg dealt to enemy
																			  	  // Assign variable to random number between min and max player damage
		
		return damageDealt;
	}
	
	/**
	 * Retrieve damage dealt by an enemy on a player
	 * @return int damage dealt by enemy
	 */
	public int getEnemyDamage()
	{
		return enemyDamage;
	}
	
	/**
	 * Retrieve damage dealt by an enemy on a player during a flee attempt
	 * @return int damage dealt by enemy during flee
	 */
	public int getEnemyFleeDamage()
	{
		return enemyFleeDamage;
	}
	
	/**
	 * Retrieve a player's health
	 * @return int player's health
	 */
	public int getHealth()
	{
		return health; 
	}
	
	/**
	 * Retrieve successful flee chance (percentage)
	 * @return int percentage chance to successfully flee
	 */
	public int getSuccessfulFleeChance()
	{
		return SUCCESSFUL_FLEE_CHANCE;
	}
	
	/**
	 * Retrieve number of health potions a player has
	 * @return int number of health potions for a player
	 */
	public int getNumberOfHealthPotions()
	{
		return numberOfHealthPotions;
	}
	
	/**
	 * Retrieve heal amount of a health potion
	 * @return int health potion heal amount
	 */
	public int getHealthPotionHealAmount()
	{
		return HEALTH_POTION_HEAL_AMOUNT;
	}
}
