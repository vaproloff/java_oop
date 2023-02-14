package sem_02_cw;

public class Duck extends Herbivores implements Speakable, Runable, Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am duck. %s I run with speed %d and fly with speed %d.",
                super.toString(), speedOfRun(), speedOfFly());
    }

    @Override
    public String say() {
        return "Quack";
    }

    @Override
    public int speedOfRun() {
        return 7;
    }

    @Override
    public int speedOfFly() {
        return 30;
    }

    @Override
    public int speedOfSwim() {
        return 8;
    }
}
