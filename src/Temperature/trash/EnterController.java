package Temperature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EnterController implements ActionListener {
    private TemperatureView temperatureViewRemote;
    private TemperatureModel temperatureModelRemote;

    public EnterController(TemperatureView temperatureView, TemperatureModel temperatureModel) {
        this.temperatureViewRemote = temperatureView;
        this.temperatureModelRemote = temperatureModel;
        this.temperatureViewRemote.setEnterController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            this.temperatureViewRemote.setIsC(true);

            temperatureModelRemote.f2c(f);
            
        } else if (cmd.equals("c2f")) {
            c = Double.parseDouble(num);
            this.temperatureViewRemote.setIsC(false);
            
            temperatureModelRemote.c2f(c);
        } else if (cmd.equals("exit")) {
            temperatureModelRemote.exit();
        }
    }
}