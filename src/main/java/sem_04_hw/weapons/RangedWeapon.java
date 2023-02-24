package sem_04_hw.weapons;

public class RangedWeapon extends Weapon {
    private int range;
    public RangedWeapon(String name, int damage, int range) {
        super(name, damage);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    @Override
    public String toString() {
        return String.format("%s Дальность: %d.", super.toString(), range);
    }
}
