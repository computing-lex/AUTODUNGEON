package AUTODUNGEON.entities;

import AUTODUNGEON.rooms.Room;

public class Enemy extends Entity {
    
    public Enemy(Entity target) {
        setTarget(target);
        setMaxHealth(getHealth() / 2);
    }

    public Enemy(Entity target, int startLevel) {
        setLevel(startLevel);
        setTarget(target);
        setValues();
        setMaxHealth(getHealth() / 2);
    }

    @Override
    public void takeTurn(Room currentRoom) {
        attack();
    }
}
