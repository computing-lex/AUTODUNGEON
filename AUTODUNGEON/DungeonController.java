package AUTODUNGEON;

import java.util.LinkedList;

import AUTODUNGEON.entities.Entity;
import AUTODUNGEON.entities.Player;
import AUTODUNGEON.items.Item;
import AUTODUNGEON.items.Weapon;
import AUTODUNGEON.rooms.*;

public class DungeonController {

    private LinkedList<LinkedList<Room>> rooms;
    private Player player;

    public static void main(String[] args) {
        DungeonController dungeon = new DungeonController();

        dungeon.update();
    }

    public DungeonController() {
        player = new Player();
        generateRooms();
        buildRoom(player.getLocation());
    }

    public void update() {
        int turnCount = 0;

        while (turnCount < 100) {
            buildRoom(player.getLocation());
            
            while (getPlayerRoom().getEnemyCount() > 0 && player.getHealth() > 0) {
                battle();
            }

            if (player.getHealth() <= 0) {
                turnCount = 100;
                System.out.println("You died!");
            } else {
                
                if (getPlayerRoom().loot() instanceof Weapon) {
                    player.setWeapon(getPlayerRoom().loot());
                }

                switch (player.playerMenu()) {
                case 1:
                    movePlayer();
                    break;
                case 2:
                    turnCount = 100;
                    break;
                default:
                    break;
                }

                turnCount++;
            
                if (turnCount % 10 == 0) {
                    player.levelUp();
                }
            }
        }
    }
    
    public void battle() {
        player.printStats();
        player.takeTurn(getPlayerRoom());
        for (Entity e : getPlayerRoom().getEnemies()) {
            if (!e.isDead()) {
                e.takeTurn(getPlayerRoom());
            }
        }
    }

    public void movePlayer() {
        
        int playerChoice = player.move(getPlayerRoom());

        setPosition(getRoomPosition(playerChoice));
        System.out.println("Moved to: " + player.getLocation()[0] + ", " + player.getLocation()[1] + " through the " + rooms.get(0).get(0).doorToString(playerChoice) + " door.");
    }

    private Room getPlayerRoom() {
        return rooms.get(player.getLocation()[0]).get(player.getLocation()[1]);
    }

    private int[] getRoomPosition(int doorIndex) {
        int[] newPosition = player.getLocation();

        buildRoom(newPosition);
        
        if (getPlayerRoom().checkDoor(doorIndex)) {
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
        
        rooms.get(0).add(new Room(player.getLevel()));
    }

    private void buildRoom(int[] location) {
        if (rooms.size() - 1 < location[0]) {
            for (int i = rooms.size() - 1; i < location[0]; i++) {
                rooms.add(new LinkedList<Room>());
            }
        }

        if (rooms.get(location[0]).size() - 1 < location[1]) {
            for (int i = rooms.get(location[0]).size() - 1; i < location[1]; i++) {
                rooms.get(location[0]).add(new Room(player.getLevel()));
            }
        }

        getPlayerRoom().generateEnemies(player);
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
