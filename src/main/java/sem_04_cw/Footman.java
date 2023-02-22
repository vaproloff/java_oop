package sem_04_cw;

public class Footman extends Warrior {

    public Footman(String name, int health, Weapon weapon) {
        super(name, health, weapon);
    }

    @Override
    public String toString() {
        return "Footman " +
                super.toString();
    }
}
