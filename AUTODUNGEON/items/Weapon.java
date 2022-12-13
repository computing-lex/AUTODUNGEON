package AUTODUNGEON.items;

public class Weapon extends Item {
    public Weapon() {
        
    }

    public Weapon(int level) {
        setDamage(level + (int) Math.random() * level);
    }

    public void playerWeapon() {
        setDamage(getDamage() + (2 * getLevel().getLevel()));
    }
}