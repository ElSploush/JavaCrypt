import java.util.Random;

import javax.swing.JOptionPane;

public class Player
{	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
	private Enemy enemy; // Player has-a enemy
	private InfoSubPanel infoSubPanel = new InfoSubPanel(); // Player has-a infoSubPanel
		
	// Establish Player variables
	private final int MAX_ATTACK_DAMAGE = 40; // Maximum amount of player attack damage
	private final int MIN_ATTACK_DAMAGE = 25; // Minimum amount of player attack damage
	private final int HEALTH_POTION_HEAL_AMOUNT = 35; // Amount of heal per health potion
	private final int SUCCESSFUL_FLEE_CHANCE = 30; // Successful chance for player to flee
	
	// Establish instance variables
	private int health; // Player health
	private int numberOfHealthPotions; // Number of health potions
	private int damageDealt; // Damage dealt
	
	// Contructor(s)
	public Player(int health, int numberOfHealthPotions)
	{
		// Set current player health and number of potions
		this.health = health;
		this.numberOfHealthPotions = numberOfHealthPotions;
		
		// Update text fields
		infoSubPanel.setPlayerHealthTextField(health); // Set enemy health text field
		infoSubPanel.setNumberOfHealthPotionsTextField(numberOfHealthPotions); // Set player health text field
	}
	
	// Mutator(s)
	public void foundHealthPotion()
	{
		numberOfHealthPotions++; // Increment the number of health potions
		
		// Display message
		JOptionPane.showMessageDialog(null, "A health potion dropped!"); // Display for message for health potion drop
		JOptionPane.showMessageDialog(null, "You now have " + numberOfHealthPotions + " potions."); // Display current number of health potions
				
		// Update text field
		infoSubPanel.setNumberOfHealthPotionsTextField(numberOfHealthPotions);
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
	
	public int getHealth()
	{
		return health; 
	}
	
	public int getSuccessfulFleeChance()
	{
		return SUCCESSFUL_FLEE_CHANCE;
	}
	
	public int getMaxAttackDamage()
	{
		return MAX_ATTACK_DAMAGE;
	}
	
	public int getMinAttackDamage()
	{
		return MIN_ATTACK_DAMAGE;
	}
	
	public int getNumberOfHealthPotions()
	{
		return numberOfHealthPotions;
	}
	
	public int getHealthPotionHealAmount()
	{
		return HEALTH_POTION_HEAL_AMOUNT;
	}
	
	public int getDamageDealt()
	{
		return damageDealt;
	}
}
