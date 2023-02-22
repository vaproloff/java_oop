package sem_04_cw;

public class Archer extends Warrior<Ranged> {

    public int range() {
        return weapon.getRange();
    }
    public Archer(String name, int health, Ranged rangedWeapon) {
        super(name, health, rangedWeapon);
    }

    @Override
    public String toString() {
        return "Archer " +
                super.toString();
    }
}
