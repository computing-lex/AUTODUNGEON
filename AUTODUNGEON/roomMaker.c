#include "autodungeon.h"

void roomMaker(struct Room newRoom)
{
    // FILE *fp;
    int menuChoice = 0;
    int menuChoice2 = 0;

    // Open file to apphend
    // fp = fopen("roomList.txt", "a");

    do {
        clearscr();
        printf("Welcome to the Room Generator.\n\nPlease select from the menu below.\n");
        printf("1: Room Title\n2: Room Description\n3: Room Settings\n4: Review Room X\n5: Save or Quit\n");
        scanf("%d", &menuChoice);

        switch (menuChoice)
        {
            case 1:
                // Room Title
                printf("\n\nPlease enter the title of your room.\n");
                scanf("%s", newRoom.roomTitle);
                loadBuff(1);
                break;
            case 2:
                // Room Description
                printf("\n\nPlease enter the description of your room.\nThe text must be 250 characters or less.");
                scanf("%s", newRoom.roomDescription);
                loadBuff(1);
                break;
            case 3:
                // Room Settings
                do
                {
                    clearscr();
                    printf("Welcome to room options. Please select from the menu below.");
                    printf("\n1: Room Size\n2: Door Count\n3: Max Enemies\n4: Spawn Chance\n5: Enemy Spawn Chance\n6: Return to main menu\n");
                    scanf("%d", &menuChoice2);

                    switch (menuChoice2)
                    {
                    case 1:
                        // Room Size
                        printf("\nHow large is your room? (Must be a whole number between 2-100 units\n)");
                        scanf("%d", &newRoom.roomSize);

                        while (newRoom.roomSize < 2 || newRoom.roomSize > 100) {
                            printf("\nPlease try again. Room must be a whole number between 2 and 100.\n");
                            scanf("%d", &newRoom.roomSize);
                        }
                        loadBuff(1);
                        break;
                    case 2:
                        // Door Count
                        printf("\nHow many doors does your room have? (Must be a whole number between 1 and 10\n)");
                        scanf("%d", &newRoom.doorCount);

                        while (newRoom.doorCount < 1 || newRoom.doorCount > 10) {
                            printf("\nPlease try again. Room must be a whole number between 1 and 10.\n");
                            scanf("%d", &newRoom.doorCount);
                        }
                        loadBuff(1);
                        break;
                    case 3:
                        // Max Enemies
                        printf("\nHow many enemies can spawn in the room? (Must be a whole number between 0 and 100\n)");
                        scanf("%d", &newRoom.maxEnemies);

                        while (newRoom.maxEnemies < 0 || newRoom.maxEnemies > 100) {
                            printf("\nPlease try again. Count must be a whole number between 0 and 100.\n");
                            scanf("%d", &newRoom.maxEnemies);
                        }
                        loadBuff(1);
                        break;
                    case 4:
                        // Spawn Chance
                        printf("How likely is it for this room to appear?\nPlease enter a number between 0 and 1.\n");
                        scanf("%lf", &newRoom.spawnChance);

                        while (newRoom.spawnChance < 0 || newRoom.spawnChance > 1) {
                            printf("\nPlease try again. It must be a number between 0 and 1.\n");
                            scanf("lf", &newRoom.spawnChance);
                        }
                        loadBuff(1);
                        break;
                    case 5:
                        // Enemy Spawn Chance
                        printf("How likely is it for an enemy to spawn on any given turn?\nPlease enter a number between 0 and 1.\n");
                        scanf("%lf", &newRoom.enemyChance);

                        while (newRoom.enemyChance < 0 || newRoom.enemyChance > 1) {
                            printf("\nPlease try again. It must be a number between 0 and 1.\n");
                            scanf("lf", &newRoom.enemyChance);
                        }
                        loadBuff(1);
                        break;
                    case 6:
                        // main menu
                        printf("\n\nReturning to main menu...\n\n");
                        loadBuff(0);
                        break;
                    default:
                        break;
                    }

                } while (menuChoice2 != 6);
                // Break from case 3 of main menu
                break;
            case 4:
                // Review Room
            case 5:
                // Quit
                printf("Continuing to quit menu...");
                loadBuff(0);
                break;
            default:
                break;
        }
    } while (menuChoice != 5);

    do {
        clearscr();
        printf("Are you sure you want to commit this room?\n1: Review X\n2: Confirm X\n3: Cancel (DELETES ALL INFORMATION ENTERED)\n");
        scanf("%d", &menuChoice);

        switch (menuChoice)
        {
        case 1:
            // List room information
        case 2:
            // Write to file
        case 3:
            // Quit the function
            printf("\n\nQuitting...");
            loadBuff(0);
            break;
        default:
            break;
        }
    } while (menuChoice != 3);
}
