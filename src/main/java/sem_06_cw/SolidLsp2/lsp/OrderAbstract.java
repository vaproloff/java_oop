package sem_06_cw.SolidLsp2.lsp;

public abstract class OrderAbstract implements Orderable {
    protected int price;
    protected int qnt;

    public OrderAbstract(int qnt, int price) {
        this.price = price;
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        return String.format("Количество = %d, Цена = %d", qnt, price);
    }
}
