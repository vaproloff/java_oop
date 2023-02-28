package sem_06_cw.SolidSrp2.srp.models;

public class View {
    public Order inputFromConsole() {
        String clientName = Utils.prompt("Client name: ");
        String product = Utils.prompt("Product: ");
        int qnt = Integer.parseInt(Utils.prompt("Quantity: "));
        int price = Integer.parseInt(Utils.prompt("Price: "));

        return new Order(clientName, product, qnt, price);
    }
}
