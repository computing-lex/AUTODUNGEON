package AUTODUNGEON.entities;

import AUTODUNGEON.Level;
import AUTODUNGEON.items.Weapon;

public abstract class Entity {
    private String name;
    private int health;
    private int maxHealth;
    private int defense;

    private Weapon weapon;
    private Level level;
    private Entity target;

    private int[] location;

    public Entity() {
        level = new Level();
        name = "Empty Name";

        weapon = new Weapon();
        setValues();
    }

    public void takeTurn() {
        
    }

    public void heal(int healthMod) {
        health += healthMod;
        if (health > maxHealth) {
            health = maxHealth;
            System.out.println(name + " healed to full health!");
        } else {
            System.out.println(name + " healed for " + healthMod + " points.");
        }
    }
    
    public void takeDamage(int damage) {
        health = (health + defense) - damage;
    }

    public void attack() {
        weapon.attack(target);
    }

    protected void setLevel(int newLevel) {
        level = new Level(newLevel);
    }

    public int getLevel() {
        return level.getLevel();
    }

    public void levelUp() {
        level.levelUp();
        
        int newHealth = level.health();
        int newDef = level.defense();

        maxHealth = (newHealth > maxHealth) ? newHealth : maxHealth + 1;
        
        defense = (newDef > defense) ? newDef : defense + 1;
    }

    public void setValues() {
        maxHealth = level.health();
        health = maxHealth;

        defense = level.defense();
    }

    public void setTarget(Entity newTarget) {
        target = newTarget;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setLocation(int[] newLocation) {
        location = newLocation;
    }

    public int[] getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
