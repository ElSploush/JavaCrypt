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
    public InfoSubPanel() // No-arg constructor
    {
    	// Set the panel layout
        setLayout(new GridLayout(2,3));
        
        // Change panel dimension
        setPreferredSize(new Dimension(600,75));
        
        // Player Health
        playerHealthLabel = new JLabel("Player Health:"); // Create label
        add(playerHealthLabel); // Add to panel
        add(playerHealthTextField = new JTextField(1)); // Create text field, add to panel
        
        // Enemy Type
        enemyTypeLabel = new JLabel("Enemy Type:"); 
        add(enemyTypeLabel); // Create label, add to panel
        add(enemyTypeTextField = new JTextField(1)); // Create text field, add to panel
        
        // Number of Enemies Defeated
        numberOfEnemiesDefeatedLabel = new JLabel("Enemies Slain:"); // Create label
        add(numberOfEnemiesDefeatedLabel); // Add to panel
        add(numberOfEnemiesDefeatedTextField = new JTextField(1)); // Create text field, add to panel
        numberOfEnemiesDefeatedTextField.setText("0"); // Initialize text field with starting number of defeated enemies
        
        // Health Potions
        numberOfHealthPotionsLabel = new JLabel("Health Potions:"); // Create label
        add(numberOfHealthPotionsLabel); // Add to panel
        add(numberOfHealthPotionsTextField = new JTextField(1)); // Create text field, add to panel
        
        // Enemy Health
        enemyHealthLabel = new JLabel("Enemy Health:"); // Create label
        add(enemyHealthLabel); // Add to panel
        add(enemyHealthTextField = new JTextField(1)); // Create text field, add to panel
        
        // Highscore
        highScoreLabel = new JLabel("High Score:"); // Create label
        add(highScoreLabel); // Add to panel
        add(highScoreTextField = new JTextField(1)); // Create text field, add to panel
    }
    
    // Mutator(s)
    public void setPlayerHealthTextField(int playerHealth) // Set the playerHealthTextField
    {
    	playerHealthTextField.setText(Integer.toString(playerHealth)); // Convert to string
    }
    
    public void setNumberOfHealthPotionsTextField(int numberOfHealthPotions) // Set the numberOfHealthPotionsTextField
    {
    	numberOfHealthPotionsTextField.setText(Integer.toString(numberOfHealthPotions)); // Convert to string
    }
    
    public void setEnemyTypeTextField(String currentEnemy) // Set the enemyTypeTextField
    {
    	enemyTypeTextField.setText(currentEnemy);
    }
    
    public void setEnemyHealthTextField(int currentEnemyHealth) // Set the enemyHealthTextField
    {
    	enemyHealthTextField.setText(Integer.toString(currentEnemyHealth)); // Convert to string
    }
    
    public void setNumberOfEnemiesDefeatedTextField(int numberOfEnemiesDefeated) // Set the numberOfEnemiesDefeatedTextField
    {
    	numberOfEnemiesDefeatedTextField.setText(Integer.toString(numberOfEnemiesDefeated)); // Convert to string
    }
    
    public void setHighScoreTextField(int highScore) // Set the highscoreTextField
    {
    	highScoreTextField.setText(Integer.toString(highScore)); // Convert to string
    }
}