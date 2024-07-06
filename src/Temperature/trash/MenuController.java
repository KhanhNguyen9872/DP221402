package Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuController implements ActionListener {
    private TemperatureView temperatureViewRemote;
    private TemperatureModel temperatureModelRemote;

    public MenuController(TemperatureView temperatureView, TemperatureModel temperatureModel) {
        this.temperatureViewRemote = temperatureView;
        this.temperatureModelRemote = temperatureModel;
        this.temperatureViewRemote.setMenuController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        double c, f;

        if (cmd.equals("f2c")) {
            f = Double.parseDouble(this.temperatureViewRemote.getjTextFieldInput2Remote().getText());
            this.temperatureViewRemote.setIsC(true);

            temperatureModelRemote.f2c(f);
            
        } else if (cmd.equals("c2f")) {
            c = Double.parseDouble(this.temperatureViewRemote.getjTextFieldInput1Remote().getText());
            this.temperatureViewRemote.setIsC(false);
            
            temperatureModelRemote.c2f(c);
        } else if (cmd.equals("exit")) {
            temperatureModelRemote.exit();
        }
    }
}
