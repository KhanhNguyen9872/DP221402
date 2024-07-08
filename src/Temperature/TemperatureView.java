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

import Temperature.commandprocessor.*;
import Temperature.observer.Subscriber;

public class TemperatureView extends JFrame implements Subscriber {
    private String title;
    private JLabel jLabelInput1Remote, jLabelInput2Remote;
    private JTextField jTextFieldInput1Remote, jTextFieldInput2Remote;
    private JPanel jPanelRemote;
    private JMenuBar menuBarRemote;
    private JMenuItem f2c, c2f, exit;
    private TemperatureModel temperatureModelRemote;
    private CommandProcessor commandProcessorRemote;
    private MenuController menuControllerRemote;
    private EnterController enterControllerRemote;
    private boolean isC = false;

    TemperatureView(TemperatureModel temperatureModel, CommandProcessor commandProcessor) {
        commandProcessorRemote = commandProcessor;
        temperatureModelRemote = temperatureModel;
        temperatureModelRemote.subscriber(this);

        buildMenu();
        buildPanel();
        add(jPanelRemote);
        title = "Temperature Converter";
        setTitle(title);
        setSize(400, 400);
        setJMenuBar(menuBarRemote);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setMenuController();
        setEnterController();
    }

    public void Show() {
        setVisible(true);
    }

    public void Hide() {
        setVisible(false);
    }

    public void setIsC(boolean isC) {
        this.isC = isC;
    }

    // public void setMenuController(MenuController menuController) {
    //     f2c.addActionListener(menuController);
    //     c2f.addActionListener(menuController);
    //     exit.addActionListener(menuController);
    // }

    public void setMenuController() {
        menuControllerRemote = new MenuController();
        f2c.addActionListener(menuControllerRemote);
        c2f.addActionListener(menuControllerRemote);
        exit.addActionListener(menuControllerRemote);
    }

    // public void setEnterController(EnterController enterController) {
    //     jTextFieldInput1Remote.addActionListener(enterController);
    //     jTextFieldInput2Remote.addActionListener(enterController);
    // }

    public void setEnterController() {
        enterControllerRemote = new EnterController();
        jTextFieldInput1Remote.addActionListener(enterControllerRemote);
        jTextFieldInput2Remote.addActionListener(enterControllerRemote);
    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        JMenu commandJMenu = new JMenu("Commands");
        f2c = new JMenuItem("f2c");
        c2f = new JMenuItem("c2f");
        exit = new JMenuItem("exit");
        
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

    class MenuController implements ActionListener {    
        public MenuController() {
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            double c, f;
    
            if (cmd.equals("f2c")) {
                f = Double.parseDouble(getjTextFieldInput2Remote().getText());
                setIsC(true);
    
                temperatureModelRemote.f2c(f);
                
            } else if (cmd.equals("c2f")) {
                c = Double.parseDouble(getjTextFieldInput1Remote().getText());
                setIsC(false);
                
                temperatureModelRemote.c2f(c);
            } else if (cmd.equals("exit")) {
                temperatureModelRemote.exit();
            }
        }
    }

    class EnterController implements ActionListener {
        public EnterController() {

        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = "";
            String num = e.getActionCommand();
            if (num.equals(getjTextFieldInput2Remote().getText())) {
                cmd = "f2c";
            } else if (num.equals(getjTextFieldInput1Remote().getText())) {
                cmd = "c2f";
            }
            double c, f;
    
            if (cmd.equals("f2c")) {
                f = Double.parseDouble(num);
                setIsC(true);
    
                temperatureModelRemote.f2c(f);
                
            } else if (cmd.equals("c2f")) {
                c = Double.parseDouble(num);
                setIsC(false);
                
                temperatureModelRemote.c2f(c);
            } else if (cmd.equals("exit")) {
                temperatureModelRemote.exit();
            }
        }
    }
}
