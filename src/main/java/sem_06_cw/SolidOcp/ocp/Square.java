package sem_06_cw.SolidOcp.ocp;

public class Square  implements Shape {
    private int side;
    public Square(int side) {
        this.side = side;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }
}
