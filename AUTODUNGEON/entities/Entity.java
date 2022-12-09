package AUTODUNGEON.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import AUTODUNGEON.Level;
import AUTODUNGEON.items.Weapon;
import AUTODUNGEON.rooms.Room;

public abstract class Entity {
    private String name;
    private int health;
    private int maxHealth;
    private int defense;

    private Weapon weapon;
    private Level level;
    private Entity target;
    private Scanner in;

    private int[] location;

    public Entity() {
        level = new Level();
        name = generateName();

        weapon = new Weapon();
        setValues();
    }

    private String generateName() {
        File names = new File("names.dat");
        String name = "Default";
        
        try {
            LinkedList<String> lines = new LinkedList<String>();
            in = new Scanner(names);

            while(in.hasNextLine()) {
                lines.add(in.nextLine());
            }

            name = lines.get((int) Math.floor(Math.random() * lines.size()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        

        return name;
    }

    public void takeTurn(Room currentRoom) {
        
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

    protected void setMaxHealth(int newHealth) {
        maxHealth = newHealth;
        health = maxHealth;
    }

    public boolean isDead() {
        boolean isDead = false;
        
        if (health <= 0) {
            isDead = true;
        }

        return isDead;
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

    public Weapon getWeapon() {
        return weapon;
    }
    
    protected void setName(String newName) {
        name = newName;
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
