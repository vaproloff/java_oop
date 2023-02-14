package sem_02_cw;

public abstract class Herbivores extends Animal {
    public Herbivores(String name) {
        super(name);
    }

    @Override
    public String eat() {
        return "I eat herbs.";
    }
}
