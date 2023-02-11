package sem_01_cw;

public class Main {
    public static void main(String[] args) {

        VendingMachine store = new VendingMachine();

        store.addProduct(new Product("Lays", 123.45))
                .addProduct(new Product("Fanta", 56.79))
                .addProduct(new CursedProduct("Snickers", 85.79, 7))
                .addProduct(new Beer("Kozel", 66.66))
                .addProduct(new Beer("Stella Artois", 100.10, 4.9))
                .addProduct(new Milk("Parmalat", 89.90, 4.9))
                .addProduct(new Water("Bonaqua", 34.50, 500))
                .addProduct(new Water("Evian", 66.00, 300, false));

        System.out.println(store);

        System.out.println("\nИщем Lays..");
        System.out.println(store.findProduct("Lays"));
        System.out.println("\nПокупаем Lays..");
        store.buy("Lays", 123.45);
        System.out.println("\nПокупаем Что-то..");
        store.buy("Что-то", 123.45);
        System.out.println("\nПокупаем пиво..");
        store.buy("Kozel", 66.66);
        System.out.println("\nПокупаем Evian..");
        store.buy("evian", 66.00);
        System.out.println("\nПокупаем Parmalat..");
        store.buy("Parmalat", 100.00);

        System.out.println(store);
    }
}
