package AUTODUNGEON.entities;

public abstract class Entity {
    private int health;
    private int maxHealth;
    private int defense;

    private int[] location;

    public void heal(int healthMod) {
        health += healthMod;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void takeDamage(int damage) {
        health = (health + defense) - damage;
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
}
