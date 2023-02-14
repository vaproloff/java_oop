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
                new Butterfly("Molly"),
                new Penguin("Lolo"),
                new Whale("Kiddy")));

        System.out.println("Those can speak:");
        for (Speakable animal: zoo.getSpeakables()) {
            System.out.println(animal.say());
        }

        System.out.println("--------");
        System.out.println("Animals who can run:");
        for (Runable animal: zoo.getRunables()) {
            System.out.println(animal);
        }

        System.out.println("--------");
        System.out.println("Animals who can fly:");
        for (Flyable animal: zoo.getFlyables()) {
            System.out.println(animal);
        }

        System.out.println("--------");
        System.out.println("Animals who can swim:");
        for (Swimmable animal: zoo.getSwimmables()) {
            System.out.println(animal);
        }

        System.out.println("--------");
        System.out.println("Champion of running:");
        System.out.println(zoo.getChampionOfRun());

        System.out.println("--------");
        System.out.println("Champion of flying:");
        System.out.println(zoo.getChampionOfFly());

        System.out.println("--------");
        System.out.println("Champion of swimming:");
        System.out.println(zoo.getChampionOfSwim());
    }
}
