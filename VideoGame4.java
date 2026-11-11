import java.util.ArrayList;
import java.util.Collections;

// Represents a video game character with a name, level, and health.
// Implements Comparable so characters can be sorted by level.
public class VideoGame4 implements Comparable<VideoGame4> {
    private String name;
    private int level;
    private int health;

    public VideoGame4(String name, int level, int health) {
        this.name = name;
        this.level = level;
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public void levelUp() {
        level++;
        System.out.println(name + " leveled up to level " + level + "!");
    }

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

    public void displayInfo() {
        System.out.println(name + " is at level " + level + " with " + health + " health.");
    }

    // Required by Comparable: characters are ordered by level, lowest first.
    // If two characters have the same level, they are ordered by name.
    @Override
    public int compareTo(VideoGame4 other) {
        int result = Integer.compare(this.level, other.level);
        if (result != 0) {
            return result;
        }
        return this.name.compareTo(other.name);
    }

    // Controls how a character looks when printed.
    @Override
    public String toString() {
        return name + " (level " + level + ", health " + health + ")";
    }
}

// A character that uses mana to cast spells.
class VideoGame4Mage extends VideoGame4 {
    private int mana;

    public VideoGame4Mage(String name, int level, int health, int mana) {
        super(name, level, health);
        this.mana = Math.max(0, mana);
    }

    public void castSpell(String spell, int cost) {
        if (cost < 0) {
            System.out.println("Spell cost cannot be negative.");
        } else if (cost > mana) {
            System.out.println(getName() + " does not have enough mana for " + spell + ".");
        } else {
            mana -= cost;
            System.out.println(getName() + " casts " + spell + "! Mana left: " + mana);
        }
    }

    public void restoreMana(int amount) {
        if (amount < 0) {
            System.out.println("Mana restoration cannot be negative.");
            return;
        }

        mana += amount;
        System.out.println(getName() + " restored " + amount + " mana.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Mana: " + mana);
    }
}

// A character with armor that blocks part of the damage.
class VideoGame4Warrior extends VideoGame4 {
    private int armor;

    public VideoGame4Warrior(String name, int level, int health, int armor) {
        super(name, level, health);
        this.armor = Math.max(0, armor);
    }

    public void upgradeArmor(int amount) {
        if (amount < 0) {
            System.out.println("Armor upgrade cannot be negative.");
            return;
        }

        armor += amount;
        System.out.println(getName() + "'s armor is now " + armor + ".");
    }

    @Override
    public void takeDamage(int damage) {
        if (damage < 0) {
            super.takeDamage(damage);
            return;
        }

        int reduced = Math.max(0, damage - armor);
        System.out.println("Armor blocked " + (damage - reduced) + " damage.");
        super.takeDamage(reduced);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Armor: " + armor);
    }
}

// Creates 10 characters, prints them, sorts them, and prints them again.
class VideoGame4Demo {
    public static void main(String[] args) {
        // The list holds VideoGame4, Mage, and Warrior objects together.
        ArrayList<VideoGame4> characters = new ArrayList<>();
        characters.add(new VideoGame4("Hero", 5, 100));
        characters.add(new VideoGame4Mage("Wizard", 8, 80, 50));
        characters.add(new VideoGame4Warrior("Knight", 12, 120, 10));
        characters.add(new VideoGame4Mage("Merlin", 15, 70, 90));
        characters.add(new VideoGame4Warrior("Brute", 3, 150, 5));
        characters.add(new VideoGame4("Scout", 7, 60));
        characters.add(new VideoGame4Mage("Apprentice", 2, 40, 20));
        characters.add(new VideoGame4Warrior("Guardian", 10, 140, 20));
        characters.add(new VideoGame4("Rogue", 8, 75));
        characters.add(new VideoGame4Mage("Sage", 11, 65, 70));

        System.out.println("Before sorting:");
        for (VideoGame4 c : characters) {
            System.out.println(c);
        }

        // Collections.sort uses our compareTo method.
        Collections.sort(characters);

        System.out.println("\nAfter sorting by level:");
        for (VideoGame4 c : characters) {
            System.out.println(c);
        }
    }
}
