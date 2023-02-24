package sem_04_hw.shields;

public class HeavyShield extends Shield {
    public HeavyShield(int defence) {
        super(defence, 0.75);
    }

    @Override
    public String toString() {
        return String.format("Тяжёлый%s", super.toString());
    }
}
