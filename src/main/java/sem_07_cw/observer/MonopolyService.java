package sem_07_cw.observer;

public class MonopolyService implements Observer {
    private int minSalary;

    public MonopolyService(int minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        System.out.println("Монопольная служба рассматривает компанию " + nameCompany);
        if (minSalary > salary) {
            System.out.printf("У компании %s большие проблемы!%n", nameCompany);
        }
    }
}
