package Temperature.commandprocessor;

import Temperature.TemperatureModel;

public class exitCommand extends Command {
    public exitCommand(TemperatureModel temperatureModel) {
        this.temperatureModel = temperatureModel;
    }

    @Override
    public void execute() {
        this.temperatureModel.exit();
    }

}
