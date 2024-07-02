package Temperature;

public class TemperatureApp {
    public static void main(String[] args) {
        TemperatureModel temperatureModelRemote = new TemperatureModel();
        TemperatureView temperatureViewRemote = new TemperatureView(temperatureModelRemote);

        MenuController menuControllerRemote = new MenuController(temperatureViewRemote, temperatureModelRemote);
        EnterController enterControllerRemote = new EnterController(temperatureViewRemote, temperatureModelRemote); 

        temperatureViewRemote.Show();
    }
}
