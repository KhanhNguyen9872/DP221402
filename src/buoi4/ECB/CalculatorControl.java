package buoi4.ECB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorControl implements ActionListener {
    private CalculatorBoundary calculatorBoundaryRemote;
    private CalculatorEntity calculatorEntityRemote;

    
    public CalculatorControl(CalculatorBoundary calculatorBoundaryRemote, CalculatorEntity calculatorEntityRemote) {
        this.calculatorBoundaryRemote = calculatorBoundaryRemote;
        this.calculatorEntityRemote = calculatorEntityRemote;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        double num1 = Double.parseDouble
        (calculatorBoundaryRemote.getjTextFieldInput1Remote().getText());
        double num2 = Double.parseDouble
        (calculatorBoundaryRemote.getjTextFieldInput2Remote().getText());
        
        if (command.equals("ADD")) {
            //message to Model
            calculatorEntityRemote.add(num1, num2);
            double result = calculatorEntityRemote.getResult();

            calculatorBoundaryRemote.getjLabelOutputRemote().setText("" + result);

        }else if(command.equals("SUB")){
            calculatorEntityRemote.sub(num1, num2);
            double result = calculatorEntityRemote.getResult();

            calculatorBoundaryRemote.getjLabelOutputRemote().setText("" + result);


        }

    }

}