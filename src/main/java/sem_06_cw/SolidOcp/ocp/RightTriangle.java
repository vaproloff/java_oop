package sem_06_cw.SolidOcp.ocp;

public class RightTriangle implements Shape {
    private int katet1;
    private int katet2;
    private double gipotenuza;

    public RightTriangle(int katet1, int katet2) {
        this.katet1 = katet1;
        this.katet2 = katet2;
        this.gipotenuza = Math.sqrt(Math.pow(katet1, 2) + Math.pow(katet2, 2));
    }

    public double getArea() {
        return katet1 * katet2 / 2.0;
    }
}
