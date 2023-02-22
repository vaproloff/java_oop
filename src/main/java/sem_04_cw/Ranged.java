package sem_04_cw;

public class Ranged implements Weapon {
    private String weaponName;
    private int damage;
    private int range;

    public Ranged(String weaponName, int damage, int range) {
        this.weaponName = weaponName;
        this.damage = damage;
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Ranged{" +
                "weaponName='" + weaponName + '\'' +
                ", damage=" + damage +
                ", range=" + range +
                '}';
    }
}
