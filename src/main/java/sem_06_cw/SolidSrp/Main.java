package sem_06_cw.SolidSrp;

import sem_06_cw.SolidSrp.srp.SquareCalc;
import sem_06_cw.SolidSrp.srp.SquareView;

public class Main {
    public static void main(String[] args) {
        SquareCalc squareCalc = new SquareCalc(5);
        SquareView squareView = new SquareView();
        squareView.draw(squareCalc.getSide() * 2);
    }
}
