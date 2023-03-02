package sem_07_cw.decorator;

public class CalcDecFactory implements ICalculableFactory {
    private Logable logger;
    public CalcDecFactory(Logable logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(int primaryArg) {
        return new CalcDecorator(new Calculator(primaryArg), logger);
    }
}
