#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

/*
AUTO-DUNGEON!

code by tanzytechgem
    created 2/22/22
    last modified 2/24/22

MAIN:

STRUCTS:
    Weapon
        Weapon.weaponName = char[30]
        Weapon.plusDamage = int
        Weapon.durability = int
    Character
        Player.name = char[30]
        Player.health = int, default 25
        Player.armor = int
        Player.damage = int
        Player.weapon = struct
    Room
        roomSize = int
        roomDescription = char[250]
        roomTitle = char[50]
        maxEnemies = int
        spawnChance = double
        enemyChance = double

FUNCTIONS:



*/

struct Weapon {
    char weaponName[30];
    int plusDamage;
    int durability;
};

struct Character {
    char name[30];
    int health;
    int armor;
    int damage;
    struct Weapon sword;
    bool isHostlie;
};

struct Room {
    int roomSize;
    int doorCount;
    char roomDescription[250];
    char roomTitle[50];
    int maxEnemies;
    double spawnChance;
    double enemyChance;
};

void listStats(struct Character player);

int main(void)
{
    struct Weapon trainSword = {"Training Sword", 1, 50};
    struct Character p1 = {"", 25, 0, 1, trainSword, false};


    printf("What is your name?\n");
    scanf("%s", p1.name);

    listStats(p1);


    return 0;
}

void roomMaker(struct Room newRoom)
{
    FILE *fp;
    int menuChoice = 0;
    int menuChoice2 = 0;

    // Open file to apphend
    fp = fopen("roomList.txt", "a");

    do {
        printf("Welcome to the Room Generator.\n\nPlease select from the menu below.\n");
        printf("1: Room Title\n2: Room Description\n3: Room Settings");
        scanf("%d", &menuChoice);

        switch (menuChoice)
        {
            case 1:
                // Room Title
                printf("\n\nPlease enter the title of your room.\n");
                scanf("%s", newRoom.roomTitle);
                break;
            case 2:
                // Room Description
                printf("\n\nPlease enter the description of your room.\nThe text must be 250 characters or less.");
                scanf("%s", newRoom.roomDescription);
                break;
            case 3:
                // Room Settings
                do
                {
                    printf("\n\nWelcome to room options. Please select from the menu below.");
                    printf("\n1: Room Size\n2: Door Count\n3: Max Enemies\n4: Spawn Chance\n5: Enemy Spawn Chance\n6: Return to main menu");

                    switch (menuChoice2)
                    {
                    case 1:
                        // Room Size
                    case 2:
                        // Door Count
                    case 3:
                        // Max Enemies
                    case 4:
                        // Spawn Chance
                    case 5:
                        // Enemy Spawn Chance
                    case 6:
                        // main menu
                    default:
                        break;
                    }

                } while (menuChoice2 != 6);
                break;
            default:
                break;
        }
    } while (menuChoice != 0);

    do {
        printf("\n\nAre you sure you want to commit this room?\n1: Review\n2: Confirm\n3: Cancel (DELETES ALL INFORMATION ENTERED)\n");
        scanf("%d", &menuChoice);

        switch (menuChoice)
        {
        case 1:
            // List room information
        case 2:
            // Write to file
        case 3:
            // Quit the function
        }
    } while (menuChoice != 3);
}

void listStats(struct Character player)
{
    printf("\nYour stats are currently:\n");
    printf("Name: %s\nHealth: %d\nArmor: %d\nWeapon: %s\n  Total Damage: %d\n", player.name, player.health, player.armor, player.sword.weaponName, (player.damage + player.sword.plusDamage));

}
