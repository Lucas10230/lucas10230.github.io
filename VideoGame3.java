// Represents a video game character with a name, level, and health.
public class VideoGame3 {
    private String name;
    private int level;
    private int health;

    public VideoGame3(String name, int level, int health) {
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
}

// A character that uses mana to cast spells.
class Mage extends VideoGame3 {
    private int mana;

    public Mage(String name, int level, int health, int mana) {
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
class Warrior extends VideoGame3 {
    private int armor;

    public Warrior(String name, int level, int health, int armor) {
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

// Demo entry point, named separately to avoid colliding with VideoGame2.java's Main.
class VideoGame3Demo {
    public static void main(String[] args) {
        VideoGame3 hero = new VideoGame3("Hero", 1, 100);
        Mage wizard = new Mage("Wizard", 2, 80, 50);
        Warrior knight = new Warrior("Knight", 3, 120, 10);

        System.out.println("Starting information:");
        hero.displayInfo();
        wizard.displayInfo();
        knight.displayInfo();

        hero.setName("Avery");
        hero.levelUp();
        wizard.setLevel(4);
        wizard.castSpell("Fireball", 30);
        wizard.castSpell("Lightning", 30);
        wizard.restoreMana(20);
        knight.upgradeArmor(5);
        knight.takeDamage(40);
        hero.takeDamage(40);

        System.out.println("\nFinal character information:");
        hero.displayInfo();
        wizard.displayInfo();
        knight.displayInfo();
    }
}
