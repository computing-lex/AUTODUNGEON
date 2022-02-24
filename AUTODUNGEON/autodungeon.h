#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
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

void roomMaker(struct Room newRoom);
void listStats(struct Character player);
void clearscr(void);
void loadBuff(int confirm);

#endif // AUTODUNGEON_H_INCLUDED
