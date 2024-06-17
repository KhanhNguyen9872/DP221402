package buoi5.MVC_CommandProcessor.command_processor;

import buoi5.MVC_CommandProcessor.CalculatorModel;

public class AddCommand extends Command {

    public AddCommand(CalculatorModel calculatorModelRemote, double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.calculatorModelRemote = calculatorModelRemote;
    }

    @Override
    public void execute() {
        calculatorModelRemote.add(this.num1, this.num2);
    }
}
