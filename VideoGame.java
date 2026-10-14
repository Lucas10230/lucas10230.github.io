// Represents a simple video game character with a name, level, and health.
public class VideoGame {
    // Stores the player's/game character's name.
    private String name;
    // Tracks the character's current health points.
    private int health;
    // Keeps track of the player's current level.
    private int level;

    // Constructor used to create a new game object with initial values.
    public VideoGame(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    // Reduces the health by the given damage amount.
    public void takeDamage(int damage) {
        health -= damage; // Subtract damage from current health.
        if (health <= 0) {
            health = 0; // Prevent negative health values.
            System.out.println("Game Over!");
        } else {
            System.out.println("Remaining Health: " + health);
        }
    }

    // Prints the current game info to the console.
    public void displayInfo() {
        System.out.println(name + " is at level " + level + " with " + health + " health.");
    }

   
    public static void main(String[] args) {
        VideoGame game = new VideoGame("Adventure Quest", 5, 100);
        game.displayInfo();
        game.takeDamage(30);
        game.takeDamage(80);
        game.displayInfo();
    }
}