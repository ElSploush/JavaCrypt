import java.util.Random;

import javax.swing.JOptionPane;

public class Enemy
{	
	// Objects
	Random random = new Random(); // Create a random object for random number generation
	private Player player; // Enemy has-a player
	private InfoSubPanel infoSubPanel = new InfoSubPanel(); // Enemy has-a infoSubPanel
	
	// Establish finals
	private final int HEALTH_POTION_DROP_CHANCE = 40; // Amount of heal per health potion
	
	// Establish instance variables
	private String enemy; // Enemy name
	private int health; //Enemy health
	private int maxAttackDamage; // Max enemy attack damage
	private int minAttackDamage; // Min attack damage
	private int damageDealt; // Damage dealt
	
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
	
	public void fleeAttack()
	{
		// Determine damage dealt to player
		int damageDealt = random.nextInt(random.nextInt(minAttackDamage, maxAttackDamage+1)/2); // Establish variable for dmg taken by player
																		  // Assign variable to random number between min and max
			
		// Deal damage to player
		int playerHealth = player.getHealth();
		playerHealth -= damageDealt;
			
		// Display damage recap
		JOptionPane.showMessageDialog(null, "Your attempt to flee is unsuccesful!");
		JOptionPane.showMessageDialog(null, "The " + enemy + " has attacked you for " + damageDealt + " during your attempt to flee.");
				
		// Update text field
		infoSubPanel.setPlayerHealthTextField(playerHealth); // Set player health text field
	}
	
	public void isHealthPotionDropped()
	{
		if (random.nextInt(101) <  HEALTH_POTION_DROP_CHANCE)
		{
			player.foundHealthPotion();
		}
	}
	
	// Accessor(s)
	public int damageDealt()
	{
		// Determine damage dealt by enemy
		int damageDealt = random.nextInt(minAttackDamage, maxAttackDamage+1); // Establish variable for dmg dealt to enemy
																			  // Assign variable to random number between min and max player damage
		
		return damageDealt;
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