package sem_06_cw.SolidLsp1.lsp;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public void setSideA(int sideA) {
        super.setSideA(sideA);
    }

    @Override
    public void setSideB(int sideB) {
        super.setSideB(sideB);
    }

    @Override
    public int getArea() {
        return (int) Math.pow(getSideA(), 2);
    }
}
