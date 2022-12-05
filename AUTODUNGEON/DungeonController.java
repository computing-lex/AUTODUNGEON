package AUTODUNGEON;

import java.util.LinkedList;
import AUTODUNGEON.entities.Player;
import AUTODUNGEON.rooms.*;

public class DungeonController {

    private LinkedList<LinkedList<Room>> rooms;
    private Player player;

    public DungeonController() {
        player = new Player();
        generateRooms();
        buildRoom(player.getLocation());
    }

    public void update() {
        for (int i = 0; i < 50; i++) {
            movePlayer();
        }
    }

    public void movePlayer() {

        int playerChoice = player.move();

        setPosition(getRoomPosition(playerChoice));
        System.out.println("Moved to: " + player.getLocation()[0] + ", " + player.getLocation()[1] + " through the " + rooms.get(0).get(0).doorToString(playerChoice) + " door.");
    }

    private int[] getRoomPosition(int doorIndex) {
        int[] newPosition = player.getLocation();

        buildRoom(newPosition);
        
        if (rooms.get(player.getLocation()[0]).get(player.getLocation()[1]).checkDoor(doorIndex)) {
            switch (doorIndex) {
            case 0:
                if (newPosition[1] - 1 >= 0) {
                    newPosition[1]--;
                } else {
                    newPosition[1] = 0;
                }
                break;
            case 1:
                newPosition[0]++;
                break;
            case 2:
                newPosition[1]++;
                break;
            case 3:
                if (newPosition[0]-- >= 0) {
                    newPosition[0]--;
                } else {
                    newPosition[0] = 0;
                }
                break;
            default:
                break;
            }
        }
        
        return newPosition;
    }

    private void generateRooms() {
        rooms = new LinkedList<LinkedList<Room>>();
        rooms.add(0, new LinkedList<Room>());
        
        rooms.get(0).add(new Room());
    }

    private void buildRoom(int[] location) {
        if (rooms.size() - 1 < location[0]) {
            for (int i = rooms.size() - 1; i < location[0]; i++) {
                rooms.add(new LinkedList<Room>());
            }
        }

        if (rooms.get(location[0]).size() - 1 < location[1]) {
            for (int i = rooms.get(location[0]).size() - 1; i < location[1]; i++) {
                rooms.get(location[0]).add(new Room());
            }
        }
    }

    private void setPosition(int[] location) {

        if (rooms.size() > location[0]) {
            if (rooms.get(location[0]).size() > location[1]) {
                player.setLocation(location);
            }
        } else if (location[0] >= 0 && location[1] >= 0) {
            buildRoom(location);
            player.setLocation(location);
        }
    }
}
