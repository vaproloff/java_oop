package sem_07_cw.decorator;

public class CalcDecorator implements Calculable {
    private Calculable calc;
    private Logable log;
    public CalcDecorator(Calculable calc, Logable log) {
        this.calc = calc;
        this.log = log;
    }

    @Override
    public Calculable sum(int arg) {
        log.log("Перед вызовом метода SUM");
        Calculable calcSum = calc.sum(arg);
        log.log("После вызова метода SUM");
        return calcSum;
    }

    @Override
    public Calculable multi(int arg) {
        log.log("Перед вызовом метода MULTI");
        Calculable calcMult = calc.multi(arg);
        log.log("После вызова метода MULTI");
        return calcMult;
    }

    @Override
    public int getResult() {
        log.log("Перед получением результата");
        int calcResult = calc.getResult();
        log.log("После получения результата");
        return calcResult;
    }
}
