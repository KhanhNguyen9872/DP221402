package Temperature;

import Temperature.commandprocessor.CommandProcessor;

public class TemperatureApp {
    public static void main(String[] args) {
        TemperatureModel temperatureModelRemote = new TemperatureModel();
        CommandProcessor commandProcessor = CommandProcessor.makeCommandProcessor();
        TemperatureView temperatureViewRemote = new TemperatureView(temperatureModelRemote, commandProcessor);

        temperatureViewRemote.Show();
    }
}
