package sem_02_cw;

public class Penguin extends Predator implements Runable, Swimmable {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am penguin. %s I run with speed %d and swim with speed %d.",
                super.toString(), speedOfRun(), speedOfSwim());
    }

    @Override
    public int speedOfRun() {
        return 10;
    }

    @Override
    public int speedOfSwim() {
        return 30;
    }
}
