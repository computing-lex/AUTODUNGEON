#include "autodungeon.h"

/*
AUTO-DUNGEON!

code by tanzytechgem
    created 2/22/22
    last modified 2/24/22
*/


int main(void)
{
    struct Weapon trainSword = {"Training Sword", 1, 50};
    struct Character p1 = {"", 25, 0, 1, trainSword, false};


    printf("What is your name?\n");
    scanf("%s", p1.name);

    listStats(p1);


    return 0;
}

void listStats(struct Character player)
{
    printf("\nYour stats are currently:\n");
    printf("Name: %s\nHealth: %d\nArmor: %d\nWeapon: %s\n  Total Damage: %d\n", player.name, player.health, player.armor, player.sword.weaponName, (player.damage + player.sword.plusDamage));

}
