package sem_06_cw.SolidSrp.srp;

public class SquareView {
    public void draw(int side) {
        for (int i = 0; i < side; i++) {
            System.out.print("* ");
        }
        System.out.println();
        for (int i = 0; i < side - 2; i++) {
            System.out.print("* ");
            for (int j = 1; j < side - 1; j++) {
                System.out.print("  ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < side; i++) {
            System.out.print("* ");
        }
    }
}
