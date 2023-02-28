package sem_06_cw.SolidSrp2;

import sem_06_cw.SolidSrp2.srp.models.Order;
import sem_06_cw.SolidSrp2.srp.models.Persister;
import sem_06_cw.SolidSrp2.srp.models.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите заказ:");
        View consoleInput = new View();
        Order order = consoleInput.inputFromConsole();
        Persister saver = new Persister("src/main/java/sem_06_cw/SolidSrp2/order.json");
        saver.saveToJson(order);
    }
}
