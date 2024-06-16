package buoi4.MVC;

import buoi4.MVC.observer.Publisher;

public class CalculatorModel extends Publisher {
    private double result;

    CalculatorModel() {

    }

    public void add(double a, double b) {
        this.result = a + b;
        changeState();
    }

    public void sub(double a, double b) {
        this.result = a - b;
        changeState();
    }

    public void mul(double a, double b) {
        this.result = a * b;
        changeState();
    }

    public void div(double a, double b) {
        this.result = a / b;
        changeState();
    }

    public double getResult() {
        return this.result;
    }

    public void changeState() {
        notifySubscribers();
    }
}
