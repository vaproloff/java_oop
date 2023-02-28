package sem_06_cw.SolidSrp2.srp.models;

import java.util.Scanner;

public class Utils {
    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
