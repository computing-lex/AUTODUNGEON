package AUTODUNGEON;

public class Level {
    private int level;
    
    private int[] healthRange;
    private int[] defenseRange;
    private int[] damageRange;
    
    public Level() {
        level = 1;
        setRanges();
    }

    public Level(int startingLevel) {
        level = startingLevel;
        setRanges();
    }

    public void levelUp() {
        level++;
        setRanges();
    }

    // Set ranges
    private void setRanges() {
        setHealthRange();
        setDefenseRange();
        setDamageRange();
    }

    /** Generate possible range of health values. */
    private void setHealthRange() {
        int base = level * 10;

        healthRange = new int[2];
        healthRange[0] = base - (int) Math.ceil(Math.random() * (level));
        healthRange[1] = base + (int) Math.ceil(Math.random() * (level));
    }

    /** Generate possible range of defense values. */
    private void setDefenseRange() {
        int base = level;

        defenseRange = new int[2];
        defenseRange[0] = base - (int) Math.floor(Math.random() * Math.floor(level / 2));
        defenseRange[1] = base + (int) Math.floor(Math.random() * Math.floor(level / 2));

        if (defenseRange[0] < 0 || defenseRange[1] < 0) {

        }
    }

    /** Generate possible range of damage values. */
    private void setDamageRange() {
        int base = level;

        damageRange = new int[2];
        damageRange[0] = base - (int) Math.ceil(Math.random() * Math.ceil(level / 2));
        damageRange[1] = base + (int) Math.ceil(Math.random() * Math.ceil(level / 2));
    }

    // Set values from ranges
    public int health() {
        return randomInRange(healthRange);
    }

    public int defense() {
        return randomInRange(defenseRange);
    }

    public int damage() {
        return randomInRange(damageRange);
    }

    private int randomInRange(int[] range) {
        int rand = (int) Math.floor(Math.random() * (range[1] - range[0])) + range[0];

        return rand;
    }

    public int getLevel() {
        return level;
    }
}
