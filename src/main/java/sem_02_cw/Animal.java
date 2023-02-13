package sem_02_cw;

public abstract class Animal implements Sayable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String feed();

    @Override
    public String toString() {
        return String.format("My name is %s.", name);
    }
}
