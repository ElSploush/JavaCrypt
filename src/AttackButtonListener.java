// Imports
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class AttackButtonListener implements ActionListener
{
	// Establish objects
	private ActionButton attackButton; // AttackButtonListener has-a AttackButton
	private JavaCrypt game; // AttackButtonListener has-a JavaCrypt
	private Enemy enemy = new Enemy(); // AttackButtonListener has-a enemy
	Random random = new Random(); // Create random object for random number generation
	
	// Constructor(s)
	public AttackButtonListener(AttackButton givenAttackButton, JavaCrypt givenGame) // Create listener with an AttackButton and JavaCrypt
    {
        attackButton = givenAttackButton; // Set the ActionButton
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	public void actionPerformed(ActionEvent e)
    {
		// Perform attack method
		game.attack();
		
		// Determine if the player died
		if (game.isGameOver()) // Determine if player health is less than 0
		{
			game.gameOver(); // Display game over message
		}
		else if (game.isEnemyDead())
		{
			try
			{
				game.enemyDead();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Display enemy dead message
			
			// Determine if enemy drops health potion
			if(random.nextInt(101) <  enemy.getHealthPotionDropChance())
			{
				game.foundHealthPotion();
			}
			
			// Spawn new enemy
			game.spawnEnemy(); 
		}
    }
}
