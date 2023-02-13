package sem_02_cw;

public abstract class Herbivores extends Animal {
    public Herbivores(String name) {
        super(name);
    }

    @Override
    public String feed() {
        return "Eat herbs";
    }
}
