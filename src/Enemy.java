import java.util.Random;

import javax.swing.JOptionPane;

public class Enemy
{	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
	private Player player; // Enemy has-a player
	
	// Establish finals
	private final int HEALTH_POTION_DROP_CHANCE = 40; // Amount of heal per health potion
	
	// Establish instance variables
	private String enemy; // Enemy name
	private int health; //Enemy health
	private int maxAttackDamage; // Max enemy attack damage
	private int minAttackDamage; // Min attack damage
	private int playerDamage; // Damage dealt by player
	
	// Contstructor(s)
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
	public void receiveAttack(Player givenPlayer)
	{
		player = givenPlayer; // Set the player
		
		playerDamage = player.damageDealt(); // Set the player damage
		
		health -= playerDamage; // Subtract damage dealt by player from enemy health
	}
	
	// Accessor(s)
	public int damageDealt()
	{
		// Determine damage dealt by enemy
		int damageDealt = random.nextInt(minAttackDamage, maxAttackDamage+1); // Establish variable for dmg dealt to enemy
																			  // Assign variable to random number between min and max player damage
		
		return damageDealt;
	}
	
	public int fleeDamageDealt()
	{
		// Determine damage dealt by enemy
		int damageDealt = random.nextInt(getMinAttackDamage(), getMaxAttackDamage()+1)/2; // Establish variable for dmg dealt to player
																			  					// Assign variable to random number between min and max player damage
		
		return damageDealt;
	}
	
	public int getPlayerDamage()
	{
		return playerDamage;
	}
	
	public String getEnemy()
	{
		return enemy;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getMaxAttackDamage()
	{
		return maxAttackDamage;
	}
	
	public int getMinAttackDamage()
	{
		return minAttackDamage;
	}
	
	public int getHealthPotionDropChance()
	{
		return HEALTH_POTION_DROP_CHANCE;
	}
}