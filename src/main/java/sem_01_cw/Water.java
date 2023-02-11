package sem_01_cw;

public class Water extends Product{
    private boolean isStill = true;

    private int volume;

    public Water(String name, double cost, int volume) {
        super(name, cost);
        this.volume = volume;
    }

    public Water(String name, double cost, int volume, boolean isStill) {
        this(name, cost, volume);
        this.isStill = isStill;
    }

    @Override
    public String toString() {
        String isStill = this.isStill ? "негаз." : "газ.";
        return String.format("%s - %d мл - %s", super.toString(), volume, isStill);
    }
}
