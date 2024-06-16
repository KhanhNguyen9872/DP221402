package buoi4;

public class CalculatorModel {
    private double result; 

    public void add (double a, double b) {
        this.result = a + b;
    }

    public void sub(double a, double b) {
        this.result = a - b;
    }

    public void mul(double a, double b) {
        this.result = a * b;
    }

    public void div(double a, double b) {
        this.result = a / b;
    }

    public double getResult() {
        return this.result;
    }
}
