package AUTODUNGEON.items.effects;

import AUTODUNGEON.Level;
import AUTODUNGEON.entities.Entity;

/** A modifier which takes effect on a target upon activation. */
public class Effect {
    private int healthMod;
    private int defenseMod;
    private int damageMod;
    private Level level;

    private Entity target;

    public Effect() {
        level = new Level();

        setFromLevel();
    }

    public Effect(int newLevel) {
        level = new Level(newLevel);

        setFromLevel();
    }

    /** Activate the effect. */
    public void activate() {

    }

    protected void setFromLevel() {
        healthMod = (int) Math.floor(level.health() / 2);
        defenseMod = level.defense();
        damageMod = level.damage();
    }

    // Get / Set

    protected void setDamageMod(int newDamageMod) {
        damageMod = newDamageMod;
    }

    public int getDamageMod() {
        return damageMod;
    }

    protected void setDefenseMod(int newDefenseMod) {
        defenseMod = newDefenseMod;
    }

    public int getDefenseMod() {
        return defenseMod;
    }

    protected void healthMod(int newHealthMod) {
        healthMod = newHealthMod;
    }

    public int getHealthMod() {
        return healthMod;
    }

    public void target(Entity newTarget) {
        target = newTarget;
    }

    public Entity getTarget() {
        return target;
    }
}
