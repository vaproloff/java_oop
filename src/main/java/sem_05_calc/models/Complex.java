package sem_05_calc.models;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(String inputNum) {
        inputNum = inputNum.replaceAll(" ", "");
        boolean firstNegative = inputNum.charAt(0) == '-';
        boolean secondNegative = inputNum.substring(1).contains("-");

        String[] complexArr = inputNum.split("[+-]");
        if (complexArr[0].isBlank()) {
            complexArr[0] = complexArr[1];
            complexArr[1] = complexArr[2];
        }

        this.real = 0;
        this.imaginary = 0;
        if (complexArr[0].contains("i"))
            this.imaginary = Double.parseDouble((firstNegative ? "-" : "+")
                    + complexArr[0].substring(0, complexArr[0].length() - 1));
        else
            this.real = Double.parseDouble((firstNegative ? "-" : "+")
                    + complexArr[0]);

        if (complexArr.length > 1) {
            if (complexArr[1].contains("i"))
                this.imaginary = Double.parseDouble((secondNegative ? "-" : "+")
                        + complexArr[1].substring(0, complexArr[1].length() - 1));
            else
                this.real = Double.parseDouble((secondNegative ? "-" : "+")
                        + complexArr[1]);
        }
    }

    public Complex sum(Complex num) {
        return new Complex(real + num.real, imaginary + num.imaginary);
    }

    public Complex subtract(Complex num) {
        return new Complex(real - num.real, imaginary - num.imaginary);
    }

    public Complex multiply(Complex num) {
        double newReal = real * num.real - imaginary * num.imaginary;
        double newImaginary = real * num.imaginary + imaginary * num.real;
        return new Complex(newReal, newImaginary);
    }

    public Complex divide(Complex num) {
        double newReal = (real * num.real + imaginary * num.imaginary) /
                (num.real * num.real + num.imaginary + num.imaginary);
        double newImaginary = (imaginary * num.real - real * num.imaginary) /
                (num.real * num.real + num.imaginary + num.imaginary);
        return new Complex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (real != 0) {
            output.append(String.format("%.2f", real));
        }
        if (imaginary != 0) {
            output.append(imaginary > 0 ? "+" : "-")
                    .append(Math.abs(imaginary) == 1 ? "" : String.format("%.2f", Math.abs(imaginary)))
                    .append("i");
        }
        return output.toString();
    }
}
