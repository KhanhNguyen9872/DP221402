package Temperature.commandprocessor;

import Temperature.TemperatureModel;

public abstract class Command {
    protected double num;
    protected TemperatureModel temperatureModel;
    public abstract void execute();
}
