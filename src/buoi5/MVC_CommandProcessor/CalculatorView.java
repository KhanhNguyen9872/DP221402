package buoi5.MVC_CommandProcessor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buoi5.MVC_CommandProcessor.command_processor.*;
import buoi5.MVC_CommandProcessor.observer.Subscriber;

public class CalculatorView extends JFrame implements Subscriber {

    // field
    private String title;
    private JPanel jPanelRemote;
    private JLabel jLabelInput1Remote, jLabelInput2Remote,
            jLabelOutputRemote;
    private JTextField jTextFieldInput1Remote, jTextFieldInput2Remote;
    private JButton addButtonRemote, subButtonRemote, mulButtonRemote, divButtonRemote;
    private CalculatorModel calculatorModelRemote;
    private CalculatorController calculatorControllerRemote = new CalculatorController();
    private MenuController menuControllerRemote = new MenuController();
    private JMenuBar menuBarRemote;
    private CommandProcessor commandProcessorRemote;

    public JTextField getjTextFieldInput1Remote() {
        return jTextFieldInput1Remote;
    }

    public JTextField getjTextFieldInput2Remote() {
        return jTextFieldInput2Remote;
    }

    public JLabel getjLabelOutputRemote() {
        return jLabelOutputRemote;
    }

    public CalculatorController getCalculatorControlRemote() {
        return this.calculatorControllerRemote;
    }

    // function , method
    CalculatorView() {
        calculatorModelRemote = new CalculatorModel();
        calculatorModelRemote.subscriber(this);
        commandProcessorRemote = CommandProcessor.makeCommandProcessor();

        buildMenu();
        buildPanel();
        add(jPanelRemote);
        title = "Frame Viewer";
        setTitle(title);
        setSize(400, 400);
        setJMenuBar(menuBarRemote);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    // public void setCalculatorControlRemote(CalculatorControl calculatorControlRemote) {
    //     this.calculatorControlRemote = calculatorControlRemote;
    //     this.addButtonRemote.
    //     addActionListener(this.calculatorControlRemote);
    // }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        JMenu calMenuRemote = new JMenu("Calculator");
        JMenuItem addItem = new JMenuItem("ADD");
        JMenuItem subItem = new JMenuItem("SUB");
        JMenuItem mulItem = new JMenuItem("MUL");
        JMenuItem divItem = new JMenuItem("DIV");

        addItem.addActionListener(menuControllerRemote);
        subItem.addActionListener(menuControllerRemote);
        mulItem.addActionListener(menuControllerRemote);
        divItem.addActionListener(menuControllerRemote);
        
        calMenuRemote.add(addItem);
        calMenuRemote.add(subItem);
        calMenuRemote.add(mulItem);
        calMenuRemote.add(divItem);

        menuBarRemote.add(calMenuRemote);
    }

    public void buildPanel() {
        jPanelRemote = new JPanel();
        jLabelInput1Remote = new JLabel("input1");
        jPanelRemote.add(jLabelInput1Remote);
        jTextFieldInput1Remote = new JTextField(10);
        jPanelRemote.add(jTextFieldInput1Remote);
        jLabelInput2Remote = new JLabel("input2");
        jTextFieldInput2Remote = new JTextField(10);
        jLabelOutputRemote = new JLabel("Output");
        jPanelRemote.add(jLabelInput2Remote);
        jPanelRemote.add(jTextFieldInput2Remote);
        jPanelRemote.add(jLabelOutputRemote);
        addButtonRemote = new JButton("ADD");
        addButtonRemote.addActionListener(calculatorControllerRemote);// Remote của CalculatorWindow
        jPanelRemote.add(addButtonRemote);
        subButtonRemote = new JButton("SUB");
        subButtonRemote.addActionListener(calculatorControllerRemote);// Remote của CalculatorWindow
        jPanelRemote.add(subButtonRemote);
        mulButtonRemote = new JButton("MUL");
        mulButtonRemote.addActionListener(calculatorControllerRemote);
        jPanelRemote.add(mulButtonRemote);
        divButtonRemote = new JButton("DIV");
        divButtonRemote.addActionListener(calculatorControllerRemote);
        jPanelRemote.add(divButtonRemote);
        //subButtonRemote.addActionListener(this);

        // jPanelRemote.setBackground(Color.BLUE);

    }

    class MenuController implements ActionListener {
        public MenuController() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Command commandRemote = null;
            String cmd = e.getActionCommand();
            double num1 = Double.parseDouble(getjTextFieldInput1Remote().getText());
            double num2 = Double.parseDouble(getjTextFieldInput2Remote().getText());

            if (cmd.equals("ADD")) {
                commandRemote = new AddCommand(calculatorModelRemote, num1, num2);
            } else if (cmd.equals("SUB")) {
                commandRemote = new SubCommand(calculatorModelRemote, num1, num2);
            } else if (cmd.equals("MUL")) {
                commandRemote = new MulCommand(calculatorModelRemote, num1, num2);
            } else if (cmd.equals("DIV")) {
                commandRemote = new DivCommand(calculatorModelRemote, num1, num2);
            }

            commandRemote.execute();
        }
    }


    class CalculatorController implements ActionListener {
        private CalculatorController() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Command commandRemote = null;
            String command = e.getActionCommand();
            double num1 = Double.parseDouble(getjTextFieldInput1Remote().getText());
            double num2 = Double.parseDouble(getjTextFieldInput2Remote().getText());
            
            if (command.equals("ADD")) {
                //message to Model
                // calculatorModelRemote.add(num1, num2);
                commandRemote = new AddCommand(calculatorModelRemote, num1, num2);
            } else if(command.equals("SUB")) {
                commandRemote = new SubCommand(calculatorModelRemote, num1, num2);
                //calculatorModelRemote.sub(num1, num2);
            } else if(command.equals("MUL")) {
                commandRemote = new MulCommand(calculatorModelRemote, num1, num2);
                //calculatorModelRemote.mul(num1, num2);
            } else if(command.equals("DIV")) {
                commandRemote = new DivCommand(calculatorModelRemote, num1, num2);
                //calculatorModelRemote.div(num1, num2);
            }

            commandRemote.execute();
            // double result = calculatorModelRemote.getResult();
            // getjLabelOutputRemote().setText("" + result);
        }
    }
    
    @Override
    public void update() {
        jLabelOutputRemote.setText("" + calculatorModelRemote.getResult());
    }
}