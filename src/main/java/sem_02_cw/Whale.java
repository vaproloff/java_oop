package sem_02_cw;

public class Whale extends Predator implements Swimmable {
    public Whale(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am whale. %s I swim with speed %d.",
                super.toString(), speedOfSwim());
    }

    @Override
    public int speedOfSwim() {
        return 35;
    }
}
