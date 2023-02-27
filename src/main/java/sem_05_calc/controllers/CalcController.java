package sem_05_calc.controllers;

import sem_05_calc.models.Complex;
import sem_05_calc.models.Logger;
import sem_05_calc.models.Rational;

import java.io.IOException;

public class CalcController {
    private Logger logger;

    public CalcController(Logger logger) {
        this.logger = logger;
    }

    public Complex calcComplex(String num1, String num2, String operator) throws IOException {
        Complex complexNum1 = new Complex(num1);
        Complex complexNum2 = new Complex(num2);
        Complex result = switch (operator) {
            case "+" -> complexNum1.sum(complexNum2);
            case "-" -> complexNum1.subtract(complexNum2);
            case "*" -> complexNum1.multiply(complexNum2);
            case "/" -> complexNum1.divide(complexNum2);
            default -> null;
        };
        this.logger.addToLog(String.format("%s %s %s = %s", num1, operator, num2, result));
        return result;
    }

    public Rational calcRational(String num1, String num2, String operator) throws IOException {
        Rational rationalNum1 = new Rational(num1);
        Rational rationalNum2 = new Rational(num2);
        Rational result = switch (operator) {
            case "+" -> rationalNum1.sum(rationalNum2);
            case "-" -> rationalNum1.subtract(rationalNum2);
            case "*" -> rationalNum1.multiply(rationalNum2);
            case "/" -> rationalNum1.divide(rationalNum2);
            default -> null;
        };
        this.logger.addToLog(String.format("%s %s %s = %s", num1, operator, num2, result));
        return result;
    }
}
