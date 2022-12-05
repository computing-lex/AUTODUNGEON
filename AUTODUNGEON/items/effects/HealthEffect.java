package AUTODUNGEON.items.effects;

public class HealthEffect extends Effect {
    public HealthEffect(int newHealthMod) {
        healthMod(newHealthMod);
    }

    @Override
    public void activate() {
        getTarget().heal(getHealthMod());
    }
}