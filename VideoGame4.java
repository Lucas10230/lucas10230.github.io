import java.util.ArrayList;
import java.util.Collections;

// Represents a video game character.
// This class implements Comparable so objects can be sorted with Collections.sort().
public class VideoGame4 implements Comparable<VideoGame4> {
    private String name;
    private int level;
    private int health;

    // Constructor initializes the character's name, level, and health.
    public VideoGame4(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = Math.max(0, health);
    }

    // Returns the character's name.
    public String getName() {
        return name;
    }

    // Updates the character's level.
    public void setLevel(int level) {
        this.level = level;
    }

    // Updates the character's health and keeps it from going below zero.
    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    // Increases the character's level by 1.
    public void levelUp() {
        level++;
        System.out.println(name + " leveled up to level " + level + "!");
    }

    // Reduces health by the amount of damage.
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

    // Prints the character's current stats.
    public void displayInfo() {
        System.out.println(name + " is at level " + level + " with " + health + " health.");
    }

    // compareTo decides how objects are ordered.
    // This version sorts by level first, then by name.
    @Override
    public int compareTo(VideoGame4 other) {
        int result = Integer.compare(this.level, other.level);
        if (result != 0) {
            return result;
        }
        return this.name.compareTo(other.name);
    }

    // toString makes the object easier to print.
    @Override
    public String toString() {
        return name + " (level " + level + ", health " + health + ")";
    }

    // Demo creates a list of 10 characters, prints them, sorts them,
    // and prints the sorted list again.
    public static void main(String[] args) {
        ArrayList<VideoGame4> characters = new ArrayList<>();

        characters.add(new VideoGame4("Hero", 5, 100));
        characters.add(new VideoGame4("Wizard", 8, 80));
        characters.add(new VideoGame4("Knight", 12, 120));
        characters.add(new VideoGame4("Merlin", 15, 70));
        characters.add(new VideoGame4("Brute", 3, 150));
        characters.add(new VideoGame4("Scout", 7, 60));
        characters.add(new VideoGame4("Apprentice", 2, 40));
        characters.add(new VideoGame4("Guardian", 10, 140));
        characters.add(new VideoGame4("Rogue", 8, 75));
        characters.add(new VideoGame4("Sage", 11, 65));

        System.out.println("Before sorting:");
        for (VideoGame4 character : characters) {
            System.out.println(character);
        }

        // Collections.sort uses the compareTo method to order the list.
        Collections.sort(characters);

        System.out.println("\nAfter sorting by level:");
        for (VideoGame4 character : characters) {
            System.out.println(character);
        }
    }
}
