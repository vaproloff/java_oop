package sem_06_cw.SolidIsp.isp;

public class TerminalPaymentService implements WebMoneyPayable, CreditCardPayable {

    @Override
    public void payWebMoney(int amount) {
        System.out.printf("Terminal pay by web money %d\n", amount);
    }

    @Override
    public void payCreditCard(int amount) {
        System.out.printf("Terminal pay by credit card %d\n", amount);
    }
}
