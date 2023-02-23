package sem_04_hw.warriors;

import sem_04_hw.shields.Shield;
import sem_04_hw.weapons.Weapon;

import java.util.Random;

public abstract class Warrior<W extends Weapon, S extends Shield> {
    private String name;

    private int health;

    public Warrior(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public abstract W getWeapon();

    public abstract S getShield();

    public abstract boolean hasShield();

    public void makeDamage(Warrior warrior) {
        Random random = new Random();
        int isFootmanDamagesArcher = (this instanceof Footman && warrior instanceof Archer
                ? random.nextInt(0, 2) : 1);
        int damage = random.nextInt(getWeapon().getDamage()) * isFootmanDamagesArcher;
        warrior.getDamage(damage);
    }

    public void getDamage(int damage) {
        int shieldDefence = 0;
        if (hasShield()) {
            Random random = new Random();
            shieldDefence = (int) (random.nextInt(getShield().getDefence()) * getShield().getAbsorbation());
        }
        health -= Math.max(0, damage - shieldDefence);
    }

    @Override
    public String toString() {
        return String.format(" %s. Здоровье: %d.", name, health);
    }
}
