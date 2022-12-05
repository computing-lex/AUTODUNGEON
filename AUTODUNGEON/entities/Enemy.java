package AUTODUNGEON.entities;

public class Enemy extends Entity {
    
    public Enemy() {

    }

    public Enemy(int startLevel) {
        setLevel(startLevel);

        setValues();
    }

    @Override
    public void takeTurn() {
        
    }
}
