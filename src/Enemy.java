public class Enemy
{	
	// Establish Enemy attributes
	private static int syntaxEnemyHealth = 60; // Starting value of a Syntax enemy health
	private static int exceptionEnemyHealth = 50; // Starting value of an Exception enemy health
	private static int compileEnemyHealth = 40; // Starting value of a Compile enemy health
	private static int maxSyntaxAttackDamage = 20; // Maximum attack damage for a Syntax enemy
	private static int minSyntaxAttackDamage = 10; // Minimum attack damage for a Syntax enemy
	private static int maxExceptionAttackDamage = 30; // Maximum attack damage for an Exception enemy
	private static int minExceptionAttackDamage = 20; // Minimum attack damage for an Exception enemy
	private static int maxCompileAttackDamage = 40; // Maximum attack damage for a Compile enemy
	private static int minCompileAttackDamage = 30; // Minimum attack damage for a Compile enemy
	private static final int healthPotionDropChance = 40; // Amount of heal per health potion
	
	// Accessor(s)
	public int getSyntaxHealth()
	{
		return syntaxEnemyHealth;
	}
	
	public int getMaxSyntaxAttackDamage()
	{
		return maxSyntaxAttackDamage;
	}
	
	public int getMinSyntaxAttackDamage()
	{
		return minSyntaxAttackDamage;
	}
	
	public int getExceptionHealth()
	{
		return exceptionEnemyHealth;
	}
	
	public int getMaxExceptionAttackDamage()
	{
		return maxExceptionAttackDamage;
	}
	
	public int getMinExceptionAttackDamage()
	{
		return minExceptionAttackDamage;
	}
	
	public int getCompileHealth()
	{
		return compileEnemyHealth;
	}
	
	public int getMaxCompileAttackDamage()
	{
		return maxCompileAttackDamage;
	}
	
	public int getMinCompileAttackDamage()
	{
		return minCompileAttackDamage;
	}
	
	public int getHealthPotionDropChance()
	{
		return healthPotionDropChance;
	}
}