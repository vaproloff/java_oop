package sem_04_cw;

public class Main {
    public static void main(String[] args) {
        Team<Footman> squadFoot = new Team<>();
        squadFoot.addWarrior(new Footman("Joe", 55, new Melee("Sword", 20)));
        squadFoot.addWarrior(new Footman("Mel", 55, new Melee("Spear", 15)));
        squadFoot.addWarrior(new Footman("John", 55, new Melee("Axe", 18)));

        for (Footman footWarrior: squadFoot) {
            System.out.println(footWarrior);
        }

        System.out.println(squadFoot.getTeamHealth());
        System.out.println(squadFoot.getMaxRange());
        System.out.println(squadFoot.getSumDamage());

        Team<Warrior> squadBase = new Team<>();
        squadBase.addWarrior(new Footman("Klack", 30, new Melee("Sword", 25)));
        squadBase.addWarrior(new Archer("Johnatan", 40, new Ranged("Crossbow", 25, 15)));
        squadBase.addWarrior(new Archer("Mike", 45, new Ranged("Bow", 16, 10)));

        for (Warrior warrior: squadBase) {
            System.out.println(warrior);
        }

        System.out.println(squadBase.getTeamHealth());
        System.out.println(squadBase.getMaxRange());
        System.out.println(squadBase.getSumDamage());

        Footman footman1 = new Footman("Vasya", 45, new Melee("Knife", 10));
        Footman footman2 = new Footman("Petya", 55, new Melee("Fork", 8));
        while (footman1.getHealth() > 0 && footman2.getHealth() > 0) {
            footman1.hit(footman2);
            System.out.println(footman2);
            footman2.hit(footman1);
            System.out.println(footman1);
        }
        if (footman1.getHealth() > 0) {
            System.out.println("Победил " + footman1.getName());
        } else {
            System.out.println("Победил " + footman2.getName());
        }
    }
}
