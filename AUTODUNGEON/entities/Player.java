package AUTODUNGEON.entities;

import java.util.Scanner;

public class Player extends Entity {
    public Player() {
        System.out.println("Starting at 5, 5.");
        setLocation(new int[] {5, 5});
    }

    public int autoMove() {
        int move = 0;

        move = (int) Math.floor(Math.random() * 4);

        return move;
    }

    public int move() {
        Scanner in = new Scanner(System.in);
        int move = 0;

        System.out.println("Pick a door to enter: ");
        System.out.print("0: North\n1: East\n2: South\n3: West\n");
        
        move = in.nextInt();

        return move;
    }
}
