package buoi4.ECB;

public class WindowApp {
    public static void main(String[] args) {
        CalculatorEntity calculatorEntityRemote = new CalculatorEntity();

        CalculatorBoundary calculatorBoundaryRemote = new CalculatorBoundary();

        // calculatorBoundaryRemote.
        // setCalculatorControlRemote(calculatorControlRemote);
        calculatorBoundaryRemote.getCalculatorControlRemote().setCalculatorEntityRemote(calculatorEntityRemote);
    }

}