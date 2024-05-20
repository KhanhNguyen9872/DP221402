package oop;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculatorRemote = new Calculator(2, 2);
        System.out.println(calculatorRemote.multiply());
    };
}
