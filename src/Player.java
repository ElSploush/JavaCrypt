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
	public Player(int health, int numberOfHealthPotions)
	{
		// Set current player health and number of potions
		this.health = health;
		this.numberOfHealthPotions = numberOfHealthPotions;
	}
	
	// Mutator(s)
	public void receiveAttack(Enemy givenEnemy)
	{
		enemyDamage = givenEnemy.damageDealt(); // Set the enemy damage
		
		health -= enemyDamage; // Subtract damage dealt by enemy from enemy health
	}
	
	public void receiveFleeAttack(Enemy givenEnemy)
	{
		enemyFleeDamage = givenEnemy.fleeDamageDealt(); // Call the enemy from the game
		
		health -= enemyFleeDamage; // Subtract damage dealt by enemy from enemy health
	}
	
	public void foundHealthPotion()
	{
		numberOfHealthPotions++; // Increment the number of health potions
		
		// Display message
		JOptionPane.showMessageDialog(null, "A health potion dropped!"); // Display for message for health potion drop
		JOptionPane.showMessageDialog(null, "You now have " + numberOfHealthPotions + " potions."); // Display current number of health potions
	}
	
	public void useHealthPotion()
	{
		numberOfHealthPotions--; // Decrement number of health potions
		
		health += HEALTH_POTION_HEAL_AMOUNT; // Heal the player
	}
	
	// Accessor(s)
	public int damageDealt()
	{
		// Determine damage dealt by player
		int damageDealt = random.nextInt(MIN_ATTACK_DAMAGE, MAX_ATTACK_DAMAGE+1); // Establish variable for dmg dealt to enemy
																			  	  // Assign variable to random number between min and max player damage
		
		return damageDealt;
	}
	
	public int getEnemyDamage()
	{
		return enemyDamage;
	}
	
	public int getEnemyFleeDamage()
	{
		return enemyFleeDamage;
	}
	
	public int getHealth()
	{
		return health; 
	}
	
	public int getSuccessfulFleeChance()
	{
		return SUCCESSFUL_FLEE_CHANCE;
	}
	
	public int getNumberOfHealthPotions()
	{
		return numberOfHealthPotions;
	}
	
	public int getHealthPotionHealAmount()
	{
		return HEALTH_POTION_HEAL_AMOUNT;
	}
}
