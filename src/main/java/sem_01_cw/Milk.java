package sem_01_cw;

public class Milk extends Product{
    private double fat;

    public Milk(String name, double cost, double fat) {
        super(name, cost);
        this.fat = fat;
    }

    @Override
    public String toString() {
        return String.format("%s - %.1f жирн.", super.toString(), fat);
    }
}
