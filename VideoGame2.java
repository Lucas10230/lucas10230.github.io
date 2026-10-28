// Represents a video game character with a name, level, and health.
class VideoGame2 {
    // Character details that each VideoGame object keeps track of.
    private String name;
    private int level;
    private int health;

    // Sets the starting name, level, and health for a character.
    public VideoGame2(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    // Updates the character's name.
    public void setName(String name) {
        this.name = name;
    }

    // Updates the character's level.
    public void setLevel(int level) {
        this.level = level;
    }

    // Updates health without allowing it to fall below zero.
    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    // Increases the character's level by one.
    public void levelUp() {
        level++;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    // Reduces health by the damage amount and reports the result.
    public void takeDamage(int damage) {
        if (damage < 0) {
            System.out.println("Damage cannot be negative.");
            return;
        }

        health = Math.max(0, health - damage);
        if (health == 0) {
            System.out.println(name + " is out of health!");
        } else {
            System.out.println(name + " has " + health + " health remaining.");
        }
    }

    // Prints the character's current details.
    public void displayInfo() {
        System.out.println(name + " is at level " + level + " with " + health + " health.");
    }
}

class Main {
    public static void main(String[] args) {
        // Create three separate character objects.
        VideoGame2 hero = new VideoGame2("Hero", 1, 100);
        VideoGame2 wizard = new VideoGame2("Wizard", 2, 80);
        VideoGame2 knight = new VideoGame2("Knight", 3, 120);

        // Change some of each character's starting attributes.
        hero.setName("Avery");
        hero.setHealth(90);
        wizard.setLevel(4);
        knight.setHealth(150);

        // Demonstrate character actions.
        hero.levelUp();
        wizard.takeDamage(25);
        knight.takeDamage(40);

        // Display the final information for all three characters.
        System.out.println("\nFinal character information:");
        hero.displayInfo();
        wizard.displayInfo();
        knight.displayInfo();
    }
}
