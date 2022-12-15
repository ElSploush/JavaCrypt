/**
 * Represents an JPanel object for the game
 * @author Brandon Ware
 * @version 2.5
 * @since 1.0
 * @reference Gaddis, T. (2015). Starting Out With Java Myprogramming Lab
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley.
 * McFayden, R. (2015). Java with BlueJ Part I.
 */

// Imports
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class InfoSubPanel extends JPanel
{	
    // Player variables
    private JLabel playerHealthLabel; // Label for player health
    private JTextField playerHealthTextField; // Text field for player health
    private JLabel numberOfHealthPotionsLabel; // Label for number of health potions
    private JTextField numberOfHealthPotionsTextField; // Text field for number of health potions
    
    // Enemy variables
    private JLabel enemyTypeLabel; // Label for enemy type
    private JTextField enemyTypeTextField; // Text field for enemy type
    private JLabel enemyHealthLabel; // Label for enemy health
    private JTextField enemyHealthTextField; // Text field for enemy health
    
    
    // Score variables
    private JLabel numberOfEnemiesDefeatedLabel; // Label for number of enemies defeated
    private JTextField numberOfEnemiesDefeatedTextField; // Text field for number of enemies defeated
    private JLabel highScoreLabel; // Label for highscore
    private JTextField highScoreTextField; // Text field for highscore
    
    // Constructor(s)
    /**
     * Creates an InfoSubPanel with JLabels and JTextFields
     */
    public InfoSubPanel() // No-arg constructor
    {
    	// Set the panel layout
        setLayout(new GridLayout(2,3));
        
        // Change panel dimension
        setPreferredSize(new Dimension(600,75));
        
        // Player Health
        playerHealthLabel = new JLabel("Player Health:"); // Create label
        add(playerHealthLabel); // Add to panel
        playerHealthTextField = new JTextField();
        add(playerHealthTextField); // Create text field, add to panel
        playerHealthTextField.setEditable(false); // Make the text field not editable
        
        // Enemy Type
        enemyTypeLabel = new JLabel("Enemy Type:"); 
        add(enemyTypeLabel); // Create label, add to panel
        enemyTypeTextField = new JTextField();
        add(enemyTypeTextField); // Create text field, add to panel
        enemyTypeTextField.setEditable(false); // Make the text field not editable
        
        // Number of Enemies Defeated
        numberOfEnemiesDefeatedLabel = new JLabel("Enemies Slain:"); // Create label
        add(numberOfEnemiesDefeatedLabel); // Add to panel
        numberOfEnemiesDefeatedTextField = new JTextField();
        add(numberOfEnemiesDefeatedTextField); // Create text field, add to panel
        numberOfEnemiesDefeatedTextField.setText("0"); // Initialize text field with starting number of defeated enemies
        numberOfEnemiesDefeatedTextField.setEditable(false); // Make the text field not editable
        
        // Health Potions
        numberOfHealthPotionsLabel = new JLabel("Health Potions:"); // Create label
        add(numberOfHealthPotionsLabel); // Add to panel
        numberOfHealthPotionsTextField = new JTextField();
        add(numberOfHealthPotionsTextField); // Create text field, add to panel
        numberOfHealthPotionsTextField.setEditable(false); // Make the text field not editable
        
        // Enemy Health
        enemyHealthLabel = new JLabel("Enemy Health:"); // Create label
        add(enemyHealthLabel); // Add to panel
        enemyHealthTextField = new JTextField();
        add(enemyHealthTextField); // Create text field, add to panel
        enemyHealthTextField.setEditable(false); // Make the text field not editable
        
        // Highscore
        highScoreLabel = new JLabel("High Score:"); // Create label
        add(highScoreLabel); // Add to panel
        highScoreTextField = new JTextField();
        add(highScoreTextField); // Create text field, add to panel
        highScoreTextField.setEditable(false); // Make the text field not editable
    }
    
    // Mutator(s)
    /**
     * Set text field to a player's health
     * @param playerHealth
     */
    public void setPlayerHealthTextField(int playerHealth) // Set the playerHealthTextField
    {
    	playerHealthTextField.setText(Integer.toString(playerHealth)); // Convert to string
    }
    
    /**
     * Set text field to a player's number of health potions
     * @param numberOfHealthPotions
     */
    public void setNumberOfHealthPotionsTextField(int numberOfHealthPotions) // Set the numberOfHealthPotionsTextField
    {
    	numberOfHealthPotionsTextField.setText(Integer.toString(numberOfHealthPotions)); // Convert to string
    }
    
    /**
     * Set text field to an enemy's name(type)
     * @param currentEnemy
     */
    public void setEnemyTypeTextField(String currentEnemy) // Set the enemyTypeTextField
    {
    	enemyTypeTextField.setText(currentEnemy);
    }
    
    /**
     * Set text field to an enemy's health
     * @param currentEnemyHealth
     */
    public void setEnemyHealthTextField(int currentEnemyHealth) // Set the enemyHealthTextField
    {
    	enemyHealthTextField.setText(Integer.toString(currentEnemyHealth)); // Convert to string
    }
    
    /**
     * Set text field to the current number of enemies defeated
     * @param numberOfEnemiesDefeated
     */
    public void setNumberOfEnemiesDefeatedTextField(int numberOfEnemiesDefeated) // Set the numberOfEnemiesDefeatedTextField
    {
    	numberOfEnemiesDefeatedTextField.setText(Integer.toString(numberOfEnemiesDefeated)); // Convert to string
    }
    
    /**
     * Set high score text field with the high score
     * @param highScore
     */
    public void setHighScoreTextField(int highScore) // Set the highscoreTextField
    {
    	highScoreTextField.setText(Integer.toString(highScore)); // Convert to string
    }
}