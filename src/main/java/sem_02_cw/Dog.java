package sem_02_cw;

public class Dog extends Predator implements Speakable, Runable, Swimmable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am dog. %s I run with speed %d.", super.toString(), speedOfRun());
    }

    @Override
    public String say() {
        return "Woof";
    }

    @Override
    public int speedOfRun() {
        return 20;
    }

    @Override
    public int speedOfSwim() {
        return 3;
    }
}
