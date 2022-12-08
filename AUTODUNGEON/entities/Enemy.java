package AUTODUNGEON.entities;

import AUTODUNGEON.rooms.Room;

public class Enemy extends Entity {
    
    public Enemy() {

    }

    public Enemy(int startLevel) {
        setLevel(startLevel);

        setValues();
    }

    @Override
    public void takeTurn(Room currentRoom) {
        
    }
}
