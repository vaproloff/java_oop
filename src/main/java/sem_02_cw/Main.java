package sem_02_cw;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.addAnimals(List.of(new Cat("Garfield"),
                new Dog("Charlie"),
                new Cow("Milka"),
                new Rabbit("Whistler"),
                new Duck("Donald"),
                new Butterfly("Molly")));

        for (Speakable animal: zoo.getSpeakables()) {
            System.out.println(animal.say());
        }

        System.out.println("--------");
        for (Runable animal: zoo.getRunables()) {
            System.out.println(animal);
        }

        System.out.println("--------");
        for (Flyable animal: zoo.getFlyables()) {
            System.out.println(animal);
        }

        System.out.println("--------");
        System.out.println(zoo.getChampionOfRun());

        System.out.println("--------");
        System.out.println(zoo.getChampionOfFly());
    }
}
