package sem_05_calc.views;

import sem_05_calc.controllers.CalcController;

import java.io.IOException;
import java.util.Scanner;

public class ViewCalc {

    private CalcController calc;
    private Validator validator = new Validator();

    public ViewCalc(CalcController calc) {
        this.calc = calc;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("С какими числами будем работать?");
                String command = prompt("1 - Комплексные, 2 - Рациональные (0 - выход): ");
                switch (command) {
                    case "1" -> caseComplex();
                    case "2" -> caseRational();
                    case "0" -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.printf("Произошла ошибка: %s\n", e.getMessage());
            }
        }
    }

    private void caseComplex() throws IOException {
        String num1 = getComplexNum();
        String operator = getOperator();
        String num2 = getComplexNum();
        System.out.printf("%s %s %s = %s%n", num1, operator, num2, calc.calcComplex(num1, num2, operator));
    }

    private void caseRational() throws IOException {
        String num1 = getRationalNum();
        String operator = getOperator();
        String num2 = getRationalNum();
        System.out.printf("%s %s %s = %s%n", num1, operator, num2, calc.calcRational(num1, num2, operator));
    }

    private String getOperator() {
        String operator = "";
        while (!validator.validateOperator(operator)) {
            operator = prompt("Введите арифметический оператор: ");
            if (!validator.validateOperator(operator)) {
                System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
        return operator;
    }

    private String getComplexNum() {
        String num = "";
        while (!validator.validateComplex(num)) {
            num = prompt("Введите комплексное число в формате a + bi: ");
            if (!validator.validateComplex(num)) {
                System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
        return num;
    }

    private String getRationalNum() {
        String num = "";
        while (!validator.validateRational(num)) {
            num = prompt("Введите рациональное число в формате a/b: ");
            if (!validator.validateRational(num)) {
                System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
        return num;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
