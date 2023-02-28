package sem_06_cw.SolidIsp;

import sem_06_cw.SolidIsp.isp.InternetPaymentService;
import sem_06_cw.SolidIsp.isp.TerminalPaymentService;

public class Main {
    public static void main(String[] args) {
        InternetPaymentService internetService = new InternetPaymentService();
        internetService.payWebMoney(10);
        internetService.payCreditCard(20);
        internetService.payPhoneNumber(30);

        TerminalPaymentService terminalService = new TerminalPaymentService();
        terminalService.payWebMoney(40);
        terminalService.payCreditCard(50);
    }
}
