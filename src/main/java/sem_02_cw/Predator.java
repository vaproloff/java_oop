package sem_02_cw;

public abstract class Predator extends Animal {
    public Predator(String name) {
        super(name);
    }

    @Override
    public String eat() {
        return "I eat meat.";
    }
}
