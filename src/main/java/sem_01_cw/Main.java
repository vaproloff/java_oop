package sem_01_cw;

public class Main {
    public static void main(String[] args) {

        VendingMachine store = new VendingMachine();

        store.addProduct(new Product("Lays", 123.45))
                .addProduct(new Product("Fanta", 56.79))
                .addProduct(new Product("Bounty", 27.79))
                .addProduct(new Product("Sprite", 85.79))
                .addProduct(new CursedProduct("Snickers", 85.79, 7))
                .addProduct(new Beer("Kozel", 66.66))
                .addProduct(new Beer("Stella Artois", 100.10, 4.9));

        System.out.println(store);

        System.out.println("Searching...");
        System.out.println(store.findProduct("Lays"));

        System.out.println("Покупаем Lays:");
        store.buy("Lays", 123.45);
        System.out.println(store);
        System.out.println("Покупаем Что-то:");
        store.buy("Что-то", 123.45);
        System.out.println("Покупаем пиво:");
        store.buy("Kozel", 66.66);
        System.out.println(store);
    }
}
