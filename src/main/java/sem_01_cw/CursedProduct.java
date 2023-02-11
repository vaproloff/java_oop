package sem_01_cw;

public class CursedProduct extends Product{
    private int longevity;
    public CursedProduct(String name, double cost, int longevity) {
        super(name, cost);
        this.longevity = longevity;
    }

    @Override
    public String toString() {
        return String.format("%s - %d дней годности", super.toString(), longevity);
    }
}
