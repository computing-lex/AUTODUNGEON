package AUTODUNGEON.items;

import AUTODUNGEON.Level;
import AUTODUNGEON.entities.Entity;
import AUTODUNGEON.items.effects.*;

public class Item {
    private Effect genericEffect;
    private Level level;
    private int damage;

    public Item() {
        level = new Level();
    }   

    public Item(Effect effect) {
        genericEffect = effect;
        level = new Level();
    }

    public Item(int newLevel) {
        level = new Level(newLevel);
    }
    
    // Get / Set
    public int getDamage() {
        return damage;
    }
    
    protected Level getLevel() {
        return level;
    }
    
    public void use() {
        if (genericEffect != null) {
            genericEffect.activate();
        }
    }

    public void attack(Entity target) {
        target.takeDamage(damage);
        System.out.println("Attacked " + target.getName() + " for " + damage + " damage!");
    }
    
}
