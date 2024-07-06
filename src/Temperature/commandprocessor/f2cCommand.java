package Temperature.commandprocessor;

import Temperature.TemperatureModel;

public class f2cCommand extends Command {

    public f2cCommand(TemperatureModel temperatureModel, double num) {
        this.temperatureModel = temperatureModel;
        this.num = num;
    }

    @Override
    public void execute() {
        this.temperatureModel.f2c(this.num);
    }
}
