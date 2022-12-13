// Imports
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class AttackButtonListener implements ActionListener
{
	// Establish objects
	private AttackButton attackButton; // AttackButtonListener has-a AttackButton
	private JavaCrypt game; // AttackButtonListener has-a JavaCrypt
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
		// Perform attack methods
		game.attackPhase();
		
		// Determine if the player died
		if (game.isGameOver()) // Determine if player health is less than 0
		{
			game.gameOver(); // Display game over message
		}
		else if (game.isEnemyDead())
		{
			
			game.enemyDead(); // Display enemy dead message
			
			// Determine if health potion drops
			game.dropHealthPotion(); 
			
			// Spawn new enemy
			game.spawnEnemy();
		}
    }
}
