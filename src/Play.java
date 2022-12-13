import java.io.IOException;

import javax.swing.JOptionPane;

public class Play
{
	// Main Method
	public static void main(String[] args) throws IOException
	{
		// Display welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Java Crypt!");
			
		// Display message for game objective and how to play
		JOptionPane.showMessageDialog(null, "The Java Crypt is a simple dungeon crawler." +
											"\n\nHOW TO PLAY:" + 
											"\n\n-Inside the dungeon, you will encounter 3 types of enemies." + 
											"\n-Each type of enemy has a different amount of health, and deals damage in a different range of values." +
											"\n-You can chose one of three actions: Attack, Heal, or Flee." +
											"\n-The Attack button deals damage to the enemy, whilst the enemy does damage to you." +
											"\n-The Heal button heals the player for the turn, and the enemy deals no damage." +
											"\n-The player can receive more health potions as a drop chance from defeating an enemy." +
											"\n-The Flee button forces an attempt to flee from the current enemy." +
											"\n-If the attempt to flee is succesful, the player receives no damage and encounters another enemy elsewhere." +
											"\n-If the attempt is unsuccessful, the player receives half damage from the current enemie's attack range." +
											"\n-The goal is to defeat as many enemies as possible before dying." +
											"\n\n GOOD LUCK AND HAVE FUN!");
			
		// Create a new instance of the JavaCrypt
		JavaCrypt javaCrypt = new JavaCrypt();
				
		// Load highScore and update text field
		javaCrypt.loadHighScore();
	}
}
