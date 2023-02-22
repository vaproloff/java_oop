package sem_04_cw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team <T extends Warrior> implements Iterable<T> {
    private List<T> warriors = new ArrayList<>();

    public void addWarrior(T warrior) {
        warriors.add(warrior);
    }

    @Override
    public Iterator<T> iterator() {
        return warriors.iterator();
    }

    public int getTeamHealth() {
        int teamHealth = 0;
        for (T warrior: warriors) {
            teamHealth += warrior.getHealth();
        }
        return teamHealth;
    }

    public int getMaxRange() {
        int maxRange = 0;
        for (T warrior: warriors) {
            if (warrior instanceof Archer) {
                Archer archer = (Archer) warrior;
                if (maxRange < archer.range()) {
                    maxRange = archer.range();
                }
            }
        }
        return maxRange;
    }

    public int getSumDamage() {
        int sumDamage = 0;
        for (T warrior: warriors) {
            sumDamage += warrior.getWeapon().damage();
        }
        return sumDamage;
    }
}
