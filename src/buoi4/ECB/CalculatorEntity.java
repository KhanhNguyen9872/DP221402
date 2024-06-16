package buoi4.ECB;

public class CalculatorEntity {
    private double result;

    CalculatorEntity() {

    }

    public void add(double a, double b) {
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
