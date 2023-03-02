package sem_07_cw.decorator;

// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
public class Main {
    public static void main(String[] args) {
        Logable logger = new Logger();
        ICalculableFactory calculableFactory = new CalcDecFactory(logger);
        ViewCalculator view = new ViewCalculator(calculableFactory);
        view.run();
    }
}
