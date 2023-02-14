package sem_02_cw;

public class Butterfly extends Herbivores implements Flyable {
    public Butterfly(String name) {
        super(name);
    }

    @Override
    public int speedOfFly() {
        return 18;
    }

    @Override
    public String toString() {
        return String.format("I am butterfly. %s I fly with speed %d.", super.toString(), speedOfFly());
    }
}
