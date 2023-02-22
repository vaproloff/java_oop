package sem_04_cw;

public class Melee implements Weapon{

    private String weaponName;

    private int damage;

    public Melee(String weaponName, int damage) {
        this.weaponName = weaponName;
        this.damage = damage;
    }

    @Override
    public int damage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Melee{" +
                "weaponName='" + weaponName + '\'' +
                ", damage=" + damage +
                '}';
    }
}
