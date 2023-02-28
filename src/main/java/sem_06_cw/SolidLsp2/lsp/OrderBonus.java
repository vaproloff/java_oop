package sem_06_cw.SolidLsp2.lsp;

public class OrderBonus extends OrderAbstract {
    public OrderBonus(int qnt, int price) {
        super(qnt, price);
    }

    @Override
    public int getAmount() {
        return qnt * price / 2;
    }
}
