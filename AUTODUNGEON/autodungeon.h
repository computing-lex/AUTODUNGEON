#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

#ifndef AUTODUNGEON_H_INCLUDED
#define AUTODUNGEON_H_INCLUDED

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

// Generates a new room based on user imput
void roomMaker(struct Room newRoom);

// Lists the information about a given room
void roomDescriber(struct Room thisRoom);

// Exports a room to the given file. 
void roomExport(struct Room saveRoom, FILE *roomPoint, char[32] fileName)

// Lists the player's current stats
void listStats(struct Character player);

// Clears the command window
void clearscr(void);

// Pauses for 1 second to allow user to get feedback
void loadBuff(int confirm);

#endif // AUTODUNGEON_H_INCLUDED
