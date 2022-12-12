public class Player
{
	// Establish Player variables
	private static int startingPlayerHealth = 100; // Starting value of player health
	private static final int maxPlayerAttackDamage = 40; // Maximum amount of player attack damage
	private static final int minPlayerAttackDamage = 25; // Minimum amount of player attack damage
	private static int startingNumberOfHealthPotions = 3; // Starting number of health potions
	private static final int healthPotionHealAmount = 35; // Amount of heal per health potion
	private static final int successfulFleeChance = 30; // Successful chance for player to flee
	
	// Accessor(s)
	public int getStartingPlayerHealth()
	{
		return startingPlayerHealth;
	}
	
	public int getMaxPlayerAttackDamage()
	{
		return maxPlayerAttackDamage;
	}
	
	public int getMinPlayerAttackDamage()
	{
		return minPlayerAttackDamage;
	}
	
	public int getStartingNumberOfHealthPotions()
	{
		return startingNumberOfHealthPotions;
	}
	
	public int getHealthPotionHealAmount()
	{
		return healthPotionHealAmount;
	}
	
	public int getSuccessfulFleeChance()
	{
		return successfulFleeChance;
	}
}
