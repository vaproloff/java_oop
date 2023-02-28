package sem_06_cw.SolidDip.dip;

import java.util.List;

public class DisplayReport implements Output {
    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output ti display");
        for (ReportItem item : items) {
            System.out.format("display %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
