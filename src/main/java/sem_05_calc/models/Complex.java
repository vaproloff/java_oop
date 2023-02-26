package sem_05_calc.models;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
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
            if (imaginary > 0) {
                output.append("+");
            }
            output.append(String.format("%.2f", imaginary)).append("i");
        }
        return output.toString();
    }
}
