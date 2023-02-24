package sem_04_hw;

import sem_04_hw.warriors.Archer;
import sem_04_hw.warriors.Warrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Team <W extends Warrior> implements Iterable<W> {
    private String name;
    private List<W> warriors = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addWarrior(W warrior) {
        warriors.add(warrior);
    }

    public String getName() {
        return name;
    }

    public int getTeamHealth() {
        int teamHealth = 0;
        for (W warrior: warriors) {
            teamHealth += Math.max(0, warrior.getHealth());
        }
        return teamHealth;
    }

    public int getMaxRange() {
        int maxRange = 0;
        for (W warrior: warriors) {
            if (warrior instanceof Archer archer) {
                if (maxRange < archer.getWeaponRange()) {
                    maxRange = archer.getWeaponRange();
                }
            }
        }
        return maxRange;
    }

    public int getSumDamage() {
        int sumDamage = 0;
        for (W warrior: warriors) {
            sumDamage += warrior.getWeapon().getDamage();
        }
        return sumDamage;
    }

    public int getMinShield() {
        int minShield = Integer.MAX_VALUE;
        for (W warrior: warriors) {
            if (warrior.hasShield()) {
                minShield = Math.min(minShield, warrior.getShield().getDefence());
            }
        }
        return minShield;
    }

    public boolean isAlive() {
        for (W warrior: warriors) {
            if (warrior.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    public W getRandomAliveWarrior() {
        Random random = new Random();
        W warrior = warriors.get(random.nextInt(warriors.size()));
        while (warrior.getHealth() <= 0) {
            warrior = warriors.get(random.nextInt(warriors.size()));
        }
        return warrior;
    }

    @Override
    public Iterator<W> iterator() {
        return warriors.iterator();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("---Команда %s---\n", name));
        for (W warrior: warriors) {
            output.append(warrior).append("\n");
        }
        output.append("- Здоровье команды: ").append(getTeamHealth()).append("\n")
                .append("- Максимальная дальность: ").append(getMaxRange()).append("\n")
                .append("- Общий урон: ").append(getSumDamage()).append("\n")
                .append("- Самый слабый щит: ").append(getMinShield()).append("\n")
                .append("---");
        return output.toString();
    }
}
