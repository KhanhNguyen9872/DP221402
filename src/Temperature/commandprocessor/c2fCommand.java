package Temperature.commandprocessor;

import Temperature.TemperatureModel;

public class c2fCommand extends Command {

    public c2fCommand(TemperatureModel temperatureModel, double num) {
        this.temperatureModel = temperatureModel;
        this.num = num;
    }

    @Override
    public void execute() {
        this.temperatureModel.c2f(this.num);
    }
}
