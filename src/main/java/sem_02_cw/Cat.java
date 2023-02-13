package sem_02_cw;

public class Cat extends Predator implements Runable {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("I am cat. %s I run with speed %d.", super.toString(), speedOfRun());
    }

    @Override
    public String say() {
        return "Meow";
    }

    @Override
    public int speedOfRun() {
        return 15;
    }
}
