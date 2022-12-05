package AUTODUNGEON.entities;

import java.util.Scanner;
import AUTODUNGEON.rooms.Room;

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

    public int move(Room currentRoom) {
        Scanner in = new Scanner(System.in);
        int move = 0;

        System.out.println("Pick a door to enter: ");
        currentRoom.printDoorStates();

        move = in.nextInt();
        
        while (!currentRoom.checkDoor(move)) {
            System.out.println("Please pick a different door: ");
            move = in.nextInt();
        }
        
        in.close();

        return move;
    }
}
