package sem_04_cw;

import java.util.Random;

public abstract class Warrior <W extends Weapon> {
    private String name;
    private int health;

    protected W weapon;

    protected Warrior(String name, int health, W weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", weapon=" + weapon +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public W getWeapon() {
        return weapon;
    }

    public void setWeapon(W weapon) {
        this.weapon = weapon;
    }

    public boolean hit(Warrior warrior) {
        int damage = damageFork();
        return !warrior.reduceHealth(damage);
    }

    public int damageFork() {
        Random random = new Random();
        return random.nextInt(weapon.damage());
    }

    public boolean reduceHealth(int damage) {
        health -= damage;
        return health > 0;
    }
}
