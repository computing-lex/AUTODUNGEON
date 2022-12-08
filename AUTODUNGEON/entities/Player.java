package AUTODUNGEON.entities;

import java.util.Scanner;
import AUTODUNGEON.rooms.Room;

public class Player extends Entity {
    private Scanner in;

    public Player() {
        in = new Scanner(System.in);
        System.out.println("Starting at 5, 5.");
        setLocation(new int[] {5, 5});
    }

    public int playerMenu() {
        int playerChoice = 0;

        System.out.println("Make your decision...");
        System.out.println("");

        return playerChoice;
    }

    public int autoMove() {
        int move = 0;

        move = (int) Math.floor(Math.random() * 4);

        return move;
    }

    public int move(Room currentRoom) {
        int move = 0;

        System.out.println("Pick a door to enter: ");
        currentRoom.printDoorStates();

        move = in.nextInt();
        
        while (!currentRoom.checkDoor(move)) {
            System.out.println("Please pick a different door: ");
            move = in.nextInt();
        }
        
        return move;
    }

    public void closeScanner() {
        in.close();
    }
}
