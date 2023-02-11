package sem_01_cw;

public class Beer extends Product{

    private double alcohol;

    public Beer(String name, double cost) {
        super(name, cost);
    }

    public Beer(String name, double cost, double alcohol) {
        super(name, cost);
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return String.format("%s - %.1f алк.", super.toString(), alcohol);
    }
}
