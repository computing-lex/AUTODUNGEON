package AUTODUNGEON.items;

import AUTODUNGEON.items.effects.Effect;
import AUTODUNGEON.items.effects.HealthEffect;

public class Chest {
    private Item loot;

    public Chest() {
        generateLoot();
    }

    private void generateLoot() {
        double lootChance = Math.random();

        if (lootChance <= 0.5) {
            loot = new Weapon();
        } else  {
            Effect heal = new HealthEffect(10);
            loot = new Item(heal);
        }
    }

    public Item getLoot() {
        return loot;
    }

}