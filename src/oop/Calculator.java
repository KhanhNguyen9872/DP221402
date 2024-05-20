package oop;

public class Calculator {
    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    };

    public int multiply() {
        return this.a * this.b;
    };
};
