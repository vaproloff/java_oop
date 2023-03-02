package sem_07_cw.decorator;

public class Logger implements Logable {
    @Override
    public void log(String logOutput) {
        System.out.println(logOutput);
    }
}
