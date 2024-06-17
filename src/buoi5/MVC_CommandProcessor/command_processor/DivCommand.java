package buoi5.MVC_CommandProcessor.command_processor;

import buoi5.MVC_CommandProcessor.CalculatorModel;

public class DivCommand extends Command {
    
    public DivCommand(CalculatorModel calculatorModelRemote, double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.calculatorModelRemote = calculatorModelRemote;
    }

    @Override
    public void execute() {
        calculatorModelRemote.div(this.num1, this.num2);
    }
}
