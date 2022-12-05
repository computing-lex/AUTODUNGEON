package AUTODUNGEON.items;

public class Chest {
    private Item[] loot;

    public Chest() {
        generateLoot();
    }

    private void generateLoot() {
        
    }

    public Item[] getLoot() {
        return loot;
    }

}