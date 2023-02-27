package sem_05_calc.models;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduceFraction();
    }

    public Rational(String inputNum) {
        String[] rationalArr = inputNum.split("/");
        this.numerator = Integer.parseInt(rationalArr[0].replaceAll(" ", ""));
        if (rationalArr.length > 1) {
            this.denominator = Integer.parseInt(rationalArr[1].replaceAll(" ", ""));
        } else {
            this.denominator = 1;
        }
        reduceFraction();
    }

    private void reduceFraction() {
        int nod = findNod(Math.abs(numerator), denominator);
        numerator /= nod;
        denominator /= nod;
    }

    private int findNod(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return findNod(num2, num1 % num2);
        }
    }

    public Rational sum(Rational fraction) {
        int newNum = numerator * fraction.denominator + fraction.numerator * denominator;
        int newDenum = denominator * fraction.denominator;
        return new Rational(newNum, newDenum);
    }

    public Rational subtract(Rational fraction) {
        int newNum = numerator * fraction.denominator - fraction.numerator * denominator;
        int newDenom = denominator * fraction.denominator;
        return new Rational(newNum, newDenom);
    }

    public Rational multiply(Rational fraction) {
        int newNum = numerator * fraction.numerator;
        int newDenom = denominator * fraction.denominator;
        return new Rational(newNum, newDenom);
    }

    public Rational divide(Rational fraction) {
        int newNum = numerator * fraction.denominator;
        int newDenom = denominator * fraction.numerator;
        return new Rational(newNum, newDenom);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.format("%d", numerator);
        }
        return String.format("%d/%d", numerator, denominator);
    }
}
