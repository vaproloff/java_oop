package sem_06_cw.SolidLsp2.lsp;

public class Order extends OrderAbstract {
    public Order(int qnt, int price) {
        super(qnt, price);
    }

    public int getAmount() {
        return qnt * price;
    }
}
