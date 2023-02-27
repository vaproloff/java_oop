package sem_05_calc.views;

import java.util.regex.Pattern;

public class Validator {
    private Pattern patternComplex = Pattern.compile("(-?\\d+(?:\\.\\d+)?\\s?[+\\-]\\s?\\d+(?:\\.\\d+)?i)" +
            "|(-?\\d+(?:\\.\\d+)?i?)");
    private Pattern patternRational = Pattern.compile("-?[1-9]\\d*(?:/[1-9]\\d*)?");
    private Pattern patternOperator = Pattern.compile("[+\\-*/]");

    public boolean validateComplex(String complexNum) {
        return patternComplex.matcher(complexNum).matches();
    }

    public boolean validateRational(String rationalNum) {
        return patternRational.matcher(rationalNum).matches();
    }

    public boolean validateOperator(String operator) {
        return patternOperator.matcher(operator).matches();
    }
}
