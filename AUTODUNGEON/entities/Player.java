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

        System.out.println("\nMake your decision...");
        System.out.println("1: Move\n2: Quit");

        playerChoice = in.nextInt();

        while (playerChoice < 1 || playerChoice > 2) {
            System.out.println("Invalid choice. Please try again. ");
            System.out.println("Make your decision...");
            System.out.println("1: Move\n2: Quit");
            playerChoice = in.nextInt();
        }

        return playerChoice;
    }

    @Override
    public void takeTurn(Room currentRoom) {
        System.out.println("It is your turn to fight!\nThere are " + currentRoom.getEnemyCount() + " enemies in the room!");

        for (int i = 0; i < currentRoom.getEnemies().length; i++) {
            if (currentRoom.getEnemies()[i].getHealth() > 0) {
                System.out.println(i + ": " + currentRoom.getEnemies()[i].getName());
            }
        }
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
