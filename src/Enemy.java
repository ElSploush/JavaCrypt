/**
 * Represents an enemy for the game
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

public class Enemy
{	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
	
	// Establish finals
	private final int HEALTH_POTION_DROP_CHANCE = 40; // Amount of heal per health potion
	
	// Establish instance variables
	private String enemy; // Enemy name
	private int health; //Enemy health
	private int maxAttackDamage; // Max enemy attack damage
	private int minAttackDamage; // Min attack damage
	private int playerDamage; // Damage dealt by player
	
	// Contstructor(s)
	/**
	 * Creates an enemy
	 * @param enemy
	 * @param health
	 * @param maxAttackDamage
	 * @param minAttackDamage
	 */
	public Enemy(String enemy, int health, int maxAttackDamage, int minAttackDamage)
	{
		this.enemy = enemy;
		this.health = health;
		this.maxAttackDamage = maxAttackDamage;
		this.minAttackDamage = minAttackDamage;
		
		// Display message for which enemy has spawned
		JOptionPane.showMessageDialog(null, "A(n) " + enemy + " has spawned!");
	}
	
	// Mutator(s)
	/**
	 * Receive an attack from a player, and determine an enemy's health after
	 * @param givenPlayer
	 */
	public void receiveAttack(Player givenPlayer)
	{
		playerDamage = givenPlayer.damageDealt(); // Set the player damage
		
		health -= playerDamage; // Subtract damage dealt by player from enemy health
	}
	
	// Accessor(s)
	/**
	 * Retrieve damage dealt by an enemy on a player
	 * @return int damage dealt by enemy
	 */
	public int damageDealt()
	{
		// Determine damage dealt by enemy
		int damageDealt = random.nextInt(minAttackDamage, maxAttackDamage+1); // Establish variable for dmg dealt to enemy
																			  // Assign variable to random number between min and max player damage
		
		return damageDealt;
	}
	
	/**
	 * Retrieve damage dealt by an enemy on a player during flee attempt
	 * @return int damage dealt by enemy when a player flees
	 */
	public int fleeDamageDealt()
	{
		// Determine damage dealt by enemy
		int damageDealt = random.nextInt(getMinAttackDamage(), getMaxAttackDamage()+1)/2; // Establish variable for dmg dealt to player
																			  					// Assign variable to random number between min and max player damage
		
		return damageDealt;
	}
	
	/**
	 * Retrieve damage dealt by a player on an enemy
	 * @return int damage dealt by player on an enemy
	 */
	public int getPlayerDamage()
	{
		return playerDamage;
	}
	
	/**
	 * Retrieve enemy name
	 * @return String name of enemy
	 */
	public String getEnemy()
	{
		return enemy;
	}
	
	/**
	 * Retrieve an enemy's health
	 * @return int enemy health
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * Retrieve an enemy's max attack damage
	 * @return int enemy max attack damage
	 */
	public int getMaxAttackDamage()
	{
		return maxAttackDamage;
	}
	
	/**
	 * Retrieve an enemy's min attack damage
	 * @return int enemy min attack damage
	 */
	public int getMinAttackDamage()
	{
		return minAttackDamage;
	}
	
	/**
	 * Retrieve an enemy's chance (percentage) to drop a health potion
	 * @return int percentage chance to drop a health potion
	 */
	public int getHealthPotionDropChance()
	{
		return HEALTH_POTION_DROP_CHANCE;
	}
}