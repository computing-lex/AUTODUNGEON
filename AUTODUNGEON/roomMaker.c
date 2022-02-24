#include "autodungeon.h"

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
        default:
            break;
        }
    } while (menuChoice != 3);
}
