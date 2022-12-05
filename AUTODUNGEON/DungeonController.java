package AUTODUNGEON;

import java.util.ArrayList;
import AUTODUNGEON.entities.Player;
import AUTODUNGEON.rooms.*;

public class DungeonController {

    private ArrayList<ArrayList<Room>> rooms;
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
        setPosition(getRoomPosition(player.move()));
        System.out.println("Moved to: " + player.getLocation()[0] + ", " + player.getLocation()[1]);
    }

    private int[] getRoomPosition(int doorIndex) {
        int[] newPosition = player.getLocation();

        if (rooms.get(player.getLocation()[0]).get(player.getLocation()[1]).checkDoor(doorIndex)) {
            switch (doorIndex) {
            case 0:
                if (newPosition[1] - 1 > 0) {
                    newPosition[1] = newPosition[1] - 1;
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
                if (newPosition[0]-- > 0) {
                    newPosition[0]--;
                } else {
                    newPosition[0] = 0;
                }
            default:
                break;
            }
        }
        
        return newPosition;
    }

    private void generateRooms() {
        rooms = new ArrayList<ArrayList<Room>>();
        rooms.add(0, new ArrayList<Room>());
        
        rooms.get(0).add(new Room());
    }

    private void buildRoom(int[] location) {
        if (rooms.get(location[0]) == null) {
            rooms.add(location[0], new ArrayList<Room>());
        }

        if (rooms.get(location[0]).get(location[1]) == null) {
            rooms.get(location[0]).add(location[1], new Room());
        }
    }

    private void setPosition(int[] location) {
        if (rooms.get(location[0]).get(location[1]) != null) {
            player.setLocation(location);
        } else if (location[0] > 0 && location[1] > 0) {
            buildRoom(location);
            player.setLocation(location);
        }
    }
}
