package sem_04_hw.shields;

public abstract class Shield {
    private int defence;

    private double absorbation;

    public Shield(int defence, double absorbation) {
        this.defence = defence;
        this.absorbation = absorbation;
    }

    public int getDefence() {
        return defence;
    }

    public double getAbsorbation() {
        return absorbation;
    }

    @Override
    public String toString() {
        return String.format(" щит: %d.", defence);
    }
}
