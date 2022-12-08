package AUTODUNGEON.entities;

import AUTODUNGEON.rooms.Room;

public class Enemy extends Entity {
    
    public Enemy(Entity target) {
        setTarget(target);
    }

    public Enemy(Entity target, int startLevel) {
        setLevel(startLevel);
        setTarget(target);
        setValues();
    }

    @Override
    public void takeTurn(Room currentRoom) {
        attack();
    }
}
