package sem_04_hw.shields;

public class LightShield extends Shield {
    public LightShield(int defence) {
        super(defence, 0.25);
    }

    @Override
    public String toString() {
        return String.format("Легкий%s", super.toString());
    }
}
