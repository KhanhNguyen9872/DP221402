package buoi5.MVC_CommandProcessor.command_processor;

import buoi5.MVC_CommandProcessor.CalculatorModel;

public abstract class Command {
    protected double num1, num2;
    protected CalculatorModel calculatorModelRemote;
    public abstract void execute();
}
