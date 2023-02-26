package sem_05_calc;

import sem_05_calc.controllers.CalcController;
import sem_05_calc.models.Logger;
import sem_05_calc.views.ViewCalc;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = new Logger("src/main/java/sem_05_calc/calclog.txt");
        CalcController calc = new CalcController(logger);
        ViewCalc view = new ViewCalc(calc);
        logger.addToLog("Calc started");
        view.run();
        logger.addToLog("Calc stopped");
    }
}
