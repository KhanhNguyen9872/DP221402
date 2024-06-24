package Temperature;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import Temperature.observer.Subscriber;

public class TemperatureView extends JFrame implements Subscriber {
    private String title;
    private JLabel jLabelInput1Remote, jLabelInput2Remote;
    private JTextField jTextFieldInput1Remote, jTextFieldInput2Remote;
    private JPanel jPanelRemote;
    private JMenuBar menuBarRemote;
    private MenuController menuControllerRemote = new MenuController();
    private TemperatureModel temperatureModelRemote;
    private boolean isC = false;

    TemperatureView() {
        temperatureModelRemote = new TemperatureModel();
        temperatureModelRemote.subscriber(this);

        buildMenu();
        buildPanel();
        add(jPanelRemote);
        title = "Temprature Converter";
        setTitle(title);
        setSize(400, 400);
        setJMenuBar(menuBarRemote);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        JMenu commandJMenu = new JMenu("Commands");
        JMenuItem f2c = new JMenuItem("f2c");
        JMenuItem c2f = new JMenuItem("c2f");
        JMenuItem exit = new JMenuItem("exit");

        f2c.addActionListener(menuControllerRemote);
        c2f.addActionListener(menuControllerRemote);
        exit.addActionListener(menuControllerRemote);
        
        commandJMenu.add(f2c);
        commandJMenu.add(c2f);
        commandJMenu.add(exit);

        menuBarRemote.add(commandJMenu);
    }

    public void buildPanel() {
        jPanelRemote = new JPanel();
        jLabelInput1Remote = new JLabel("Celsius");
        jPanelRemote.add(jLabelInput1Remote);
        jTextFieldInput1Remote = new JTextField(10);
        jPanelRemote.add(jTextFieldInput1Remote);
        jLabelInput2Remote = new JLabel("Fahrenheit");
        jTextFieldInput2Remote = new JTextField(10);
        jPanelRemote.add(jLabelInput2Remote);
        jPanelRemote.add(jTextFieldInput2Remote);

    }

    public JTextField getjTextFieldInput1Remote() {
        return jTextFieldInput1Remote;
    }

    public JTextField getjTextFieldInput2Remote() {
        return jTextFieldInput2Remote;
    }

    class MenuController implements ActionListener {
        public MenuController() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            double c, f;

            if (cmd.equals("f2c")) {
                f = Double.parseDouble(getjTextFieldInput2Remote().getText());
                isC = true;

                temperatureModelRemote.f2c(f);
                
            } else if (cmd.equals("c2f")) {
                c = Double.parseDouble(getjTextFieldInput1Remote().getText());
                isC = false;
                
                temperatureModelRemote.c2f(c);
            } else if (cmd.equals("exit")) {
                temperatureModelRemote.exit();
            }
        }
    }

    @Override
    public void update() {
        double result = temperatureModelRemote.getResult();
        DecimalFormat df = new DecimalFormat("#.###");
        String s = df.format(result);
        if (isC) {
            jTextFieldInput1Remote.setText(s);
        } else {
            jTextFieldInput2Remote.setText(s);
        }
    }
}
