package Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Temperature.commandprocessor.*;

class EnterController implements ActionListener {
    private TemperatureView temperatureViewRemote;
    private TemperatureModel temperatureModelRemote;
    private CommandProcessor commandProcessorRemote;

    public EnterController(TemperatureView temperatureView, TemperatureModel temperatureModel, CommandProcessor commandProcessor) {
        this.temperatureViewRemote = temperatureView;
        this.temperatureModelRemote = temperatureModel;
        this.commandProcessorRemote = commandProcessor;
        this.temperatureViewRemote.setEnterController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command command = null;
        String cmd = "";
        String num = e.getActionCommand();
        if (num.equals(this.temperatureViewRemote.getjTextFieldInput2Remote().getText())) {
            cmd = "f2c";
        } else if (num.equals(this.temperatureViewRemote.getjTextFieldInput1Remote().getText())) {
            cmd = "c2f";
        }
        double c, f;

        if (cmd.equals("f2c")) {
            f = Double.parseDouble(num);
            temperatureViewRemote.setIsC(true);

            command = new f2cCommand(temperatureModelRemote, f);
        } else if (cmd.equals("c2f")) {
            c = Double.parseDouble(num);
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