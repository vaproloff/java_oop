package sem_04_hw;

import sem_04_hw.shields.HeavyShield;
import sem_04_hw.shields.LightShield;
import sem_04_hw.warriors.Archer;
import sem_04_hw.warriors.Footman;
import sem_04_hw.warriors.Warrior;
import sem_04_hw.weapons.MeleeWeapon;
import sem_04_hw.weapons.RangedWeapon;

public class Main {
    public static void main(String[] args) {
        Team<Footman> footSquad = new Team<>("Пехота");
        footSquad.addWarrior(new Footman("Jack", 55,
                new MeleeWeapon("Old axe", 18)));
        footSquad.addWarrior(new Footman("Mike", 60,
                new MeleeWeapon("Kitchen knife", 9),
                new LightShield(10)));
        footSquad.addWarrior(new Footman("Max", 45,
                new MeleeWeapon("Father's sword", 32),
                new HeavyShield(12)));
        System.out.println(footSquad);

        Team<Archer> archerSquad = new Team<>("Лучники");
        archerSquad.addWarrior(new Archer("Bill", 45,
                new RangedWeapon("Wooden bow", 10, 25),
                new LightShield(9)));
        archerSquad.addWarrior(new Archer("Robin", 40,
                new RangedWeapon("Crossbow", 25, 35)));
        archerSquad.addWarrior(new Archer("John", 50,
                new RangedWeapon("Long bow", 12, 20),
                new LightShield(7)));
        System.out.println(archerSquad);

        Team<Warrior> mixedSquad = new Team<>("Разношёрстные");
        mixedSquad.addWarrior(new Footman("Brad", 60,
                new MeleeWeapon("Steel axe", 30),
                new HeavyShield(15)));
        mixedSquad.addWarrior(new Archer("Harry", 40,
                new RangedWeapon("Short bow", 12, 25)));
        mixedSquad.addWarrior(new Archer("Jim", 30,
                new RangedWeapon("Sport bow", 15, 45),
                new LightShield(10)));
        System.out.println(mixedSquad);

//        makeBattle(footSquad, archerSquad);
//        makeBattle(footSquad, mixedSquad);
        makeBattle(archerSquad, mixedSquad);
    }

    private static void makeBattle(Team team1, Team team2) {
        boolean firstTeamGo = false;
        while (team1.isAlive() && team2.isAlive()) {
            if (firstTeamGo) {
                team1.getRandomAliveWarrior().makeDamage(team2.getRandomAliveWarrior());
            } else {
                team2.getRandomAliveWarrior().makeDamage(team1.getRandomAliveWarrior());
            }
//            System.out.println("Команда 1: " + team1.getTeamHealth());
//            System.out.println("Команда 2: " + team2.getTeamHealth());
            firstTeamGo = !firstTeamGo;
        }
        System.out.printf("Команда %s победила\n", team1.isAlive() ? team1.getName(): team2.getName());
    }
}
