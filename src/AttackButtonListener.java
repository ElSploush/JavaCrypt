/**
 * Implements an ActionListener for an AttackButton
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import java.awt.event.*;
import java.util.Random;

public class AttackButtonListener implements ActionListener
{
	// Establish objects
	private JavaCrypt game; // AttackButtonListener has-a JavaCrypt
	Random random = new Random(); // Create random object for random number generation
	
	// Constructor(s)
	/**
	 * Create an ActionListener with a game
	 * @param givenGame
	 */
	public AttackButtonListener(JavaCrypt givenGame) // Create listener with an AttackButton and JavaCrypt
    {
        game = givenGame; // Set the game
    }
	
	// Mutator(s)
	/**
	 * Perform an attack phase, determine if the game is over, determine if the enemy is dead, determine if a health potion drops, spawn a new enemy if an enemy is dead
	 */
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
