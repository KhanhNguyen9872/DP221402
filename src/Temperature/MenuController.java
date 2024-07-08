package Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Temperature.commandprocessor.*;

class MenuController implements ActionListener {
    private TemperatureView temperatureViewRemote;
    private TemperatureModel temperatureModelRemote;
    private CommandProcessor commandProcessorRemote;

    public MenuController(TemperatureView temperatureView, TemperatureModel temperatureModel, CommandProcessor commandProcessor) {
        this.temperatureViewRemote = temperatureView;
        this.temperatureModelRemote = temperatureModel;
        this.commandProcessorRemote = commandProcessor;
        this.temperatureViewRemote.setMenuController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command command = null;
        String cmd = e.getActionCommand();
        double c, f;

        if (cmd.equals("f2c")) {
            f = Double.parseDouble(temperatureViewRemote.getjTextFieldInput2Remote().getText());
            temperatureViewRemote.setIsC(true);

            command = new f2cCommand(temperatureModelRemote, f);
        } else if (cmd.equals("c2f")) {
            c = Double.parseDouble(temperatureViewRemote.getjTextFieldInput1Remote().getText());
            temperatureViewRemote.setIsC(false);
            
            command = new c2fCommand(temperatureModelRemote, c);
        } else if (cmd.equals("exit")) {
            command = new exitCommand(temperatureModelRemote);
        }

        if (command != null) {
            commandProcessorRemote.execute(command);
        }
    }
}
