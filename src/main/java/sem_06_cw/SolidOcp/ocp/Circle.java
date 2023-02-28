package sem_06_cw.SolidOcp.ocp;

public class Circle implements Shape {
    private int radius;

    double pi = Math.PI;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return pi * Math.pow(radius, 2);
    }
}
