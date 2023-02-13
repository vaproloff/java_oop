package sem_02_cw;

public class Cow extends Herbivores implements Runable {
    public Cow(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am cow. %s I run with speed %d.", super.toString(), speedOfRun());
    }

    @Override
    public String say() {
        return "Moo";
    }

    @Override
    public int speedOfRun() {
        return 5;
    }
}
