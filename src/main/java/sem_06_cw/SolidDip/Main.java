package sem_06_cw.SolidDip;

import sem_06_cw.SolidDip.dip.DisplayReport;
import sem_06_cw.SolidDip.dip.Output;
import sem_06_cw.SolidDip.dip.PrintReport;
import sem_06_cw.SolidDip.dip.Report;

public class Main {
    public static void main(String[] args) {
        Report report = new Report();
        report.calculate();

        Output printReport = new PrintReport();
        Output displayReport = new DisplayReport();
        report.output(printReport);
        report.output(displayReport);
    }
}
