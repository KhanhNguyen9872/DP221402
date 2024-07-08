package Temperature;

import Temperature.commandprocessor.CommandProcessor;

public class TemperatureApp {
    public static void main(String[] args) {
        TemperatureModel temperatureModelRemote = new TemperatureModel();
        CommandProcessor commandProcessorRemote = CommandProcessor.makeCommandProcessor();
        TemperatureView temperatureViewRemote = new TemperatureView(temperatureModelRemote);

        MenuController menuControllerRemote = new MenuController(temperatureViewRemote, temperatureModelRemote, commandProcessorRemote);
        EnterController enterControllerRemote = new EnterController(temperatureViewRemote, temperatureModelRemote, commandProcessorRemote);

        temperatureViewRemote.Show();
    }
}
