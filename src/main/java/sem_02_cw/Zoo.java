package sem_02_cw;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();

    private Radio radio = new Radio();

    public List<Animal> addAnimals(List<Animal> animals) {
        this.animals.addAll(animals);
        return this.animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Speakable> getSpeakables() {
        List<Speakable> speakables = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Speakable) {
                speakables.add((Speakable) animal);
            }
        }
        speakables.add(radio);
        return speakables;
    }

    public List<Runable> getRunables() {
        List<Runable> runables = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Runable) {
                runables.add((Runable) animal);
            }
        }
        return runables;
    }

    public List<Flyable> getFlyables() {
        List<Flyable> flyables = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal instanceof Flyable) {
                flyables.add((Flyable) animal);
            }
        }
        return flyables;
    }

    public Runable getChampionOfRun() {
        List<Runable> runables = getRunables();
        Runable champion = runables.get(0);
        for (Runable animal: runables) {
            if (animal.speedOfRun() > champion.speedOfRun()) {
                champion = animal;
            }
        }
        return champion;
    }

    public Flyable getChampionOfFly() {
        List<Flyable> flyables = getFlyables();
        Flyable champion = flyables.get(0);
        for (Flyable animal: flyables) {
            if (animal.speedOfFly() > champion.speedOfFly()) {
                champion = animal;
            }
        }
        return champion;
    }
}
