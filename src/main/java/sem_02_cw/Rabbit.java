package sem_02_cw;

public class Rabbit extends Herbivores implements Runable {
    public Rabbit(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am rabbit. %s I run with speed %d.", super.toString(), speedOfRun());
    }

    @Override
    public int speedOfRun() {
        return 22;
    }
}
