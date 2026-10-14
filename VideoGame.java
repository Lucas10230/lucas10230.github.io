public class VideoGame {
    private String name;
    private int health;
    private int level;
    
    public VideoGame(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            System.out.println("Game Over!");
        } else {
            System.out.println("Remaining Health: " + health);
        }
    }
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

 
