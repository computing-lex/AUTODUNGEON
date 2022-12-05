package AUTODUNGEON.entities;

public class Player extends Entity {
    public Player() {
        setLocation(new int[] {5, 5});
    }

    public int move() {
        int move = 0;

        move = (int) Math.floor(Math.random() * 4);

        return move;
    }
}
