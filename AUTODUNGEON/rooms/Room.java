package AUTODUNGEON.rooms;

import AUTODUNGEON.entities.Enemy;
import AUTODUNGEON.items.Chest;
import AUTODUNGEON.items.Item;

public class Room {
    /*
     * The dungeon is a 2 by 2 grid.
     * A room can have up to 4 doors, each
     * connecting to the corresponding
     * cardinal direction.
     */
    /** Cardinal directions: {N, E, S, W} */
    private boolean[] doorStates;
    private int doorCount;
    
    private int enemyCount;
    private Enemy[] enemies;
    
    private Chest loot;

    public Room() {
        generateRoom();
    }

    public void generateRoom() {
        setDoors(4);
        
        doorStates = new boolean[] {true, true, true, true};
        enemyCount = 2;

        enemies = new Enemy[enemyCount];
        for (int i = 0; i < enemyCount; i++) {
            enemies[i] = new Enemy();
        }

        loot = new Chest();

    }

    private void setDoors(int newDoorCount) {
        if (newDoorCount <= 4) {
            doorCount = newDoorCount;
        } else {
            doorCount = 1;
        }
    }

    public int getDoorCount() {
        return doorCount;
    }

    public Item[] loot() {
        return loot.getLoot();
    }

    /** Cardinal directions based on index: {N, E, S, W} */
    public boolean checkDoor(int door) {
        boolean state = false;
        if (door >= 0 || door < doorStates.length) {
            state = doorStates[door];
        }

        return state;
    }
}