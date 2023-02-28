package sem_06_cw.SolidLsp2.lsp;

public class FactoryOrder {
    public Orderable create(int qnt, int price, boolean isBonus) {
        if (isBonus) {
            return new OrderBonus(qnt, price);
        }
        return new Order(qnt, price);
    }
}
