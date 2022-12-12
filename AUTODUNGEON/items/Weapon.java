package AUTODUNGEON.items;

public class Weapon extends Item {
    public Weapon() {
        
    }

    public void playerWeapon() {
        setDamage(getDamage() + (2 * getLevel().getLevel()));
    }
}