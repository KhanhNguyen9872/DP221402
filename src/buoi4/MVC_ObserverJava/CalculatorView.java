package buoi4.MVC_ObserverJava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame implements Observer {

    // field
    private String title;
    private JPanel jPanelRemote;
    private JLabel jLabelInput1Remote, jLabelInput2Remote,
            jLabelOutputRemote;
    private JTextField jTextFieldInput1Remote, jTextFieldInput2Remote;
    private JButton addButtonRemote, subButtonRemote, mulButtonRemote, divButtonRemote;
    private CalculatorModel calculatorModelRemote;
    private CalculatorControl calculatorControlRemote = new CalculatorControl();


    public JTextField getjTextFieldInput1Remote() {
        return jTextFieldInput1Remote;
    }

    public JTextField getjTextFieldInput2Remote() {
        return jTextFieldInput2Remote;
    }

    public JLabel getjLabelOutputRemote() {
        return jLabelOutputRemote;
    }

    public CalculatorControl getCalculatorControlRemote() {
        return this.calculatorControlRemote;
    }

    // function , method
    CalculatorView() {
        calculatorModelRemote = new CalculatorModel();
        calculatorModelRemote.addObserver(this);
        buildPanel();
        add(jPanelRemote);
        title = "Frame Viewer";
        setTitle(title);
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    // public void setCalculatorControlRemote(CalculatorControl calculatorControlRemote) {
    //     this.calculatorControlRemote = calculatorControlRemote;
    //     this.addButtonRemote.
    //     addActionListener(this.calculatorControlRemote);
    // }

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
        addButtonRemote.addActionListener(calculatorControlRemote);// Remote của CalculatorWindow
        jPanelRemote.add(addButtonRemote);
        subButtonRemote = new JButton("SUB");
        subButtonRemote.addActionListener(calculatorControlRemote);// Remote của CalculatorWindow
        jPanelRemote.add(subButtonRemote);
        mulButtonRemote = new JButton("MUL");
        mulButtonRemote.addActionListener(calculatorControlRemote);
        jPanelRemote.add(mulButtonRemote);
        divButtonRemote = new JButton("DIV");
        divButtonRemote.addActionListener(calculatorControlRemote);
        jPanelRemote.add(divButtonRemote);
        //subButtonRemote.addActionListener(this);

        // jPanelRemote.setBackground(Color.BLUE);

    }

    class CalculatorControl implements ActionListener {
        public CalculatorControl() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            double num1 = Double.parseDouble(getjTextFieldInput1Remote().getText());
            double num2 = Double.parseDouble(getjTextFieldInput2Remote().getText());
            
            if (command.equals("ADD")) {
                //message to Model
                calculatorModelRemote.add(num1, num2);
            } else if(command.equals("SUB")) {
                calculatorModelRemote.sub(num1, num2);
            } else if(command.equals("MUL")) {
                calculatorModelRemote.mul(num1, num2);
            } else if(command.equals("DIV")) {
                calculatorModelRemote.div(num1, num2);
            }
            // double result = calculatorModelRemote.getResult();
            // getjLabelOutputRemote().setText("" + result);
        }
    }
    
    @Override
    public void update(Observable o, Object arg)  {
        jLabelOutputRemote.setText("" + calculatorModelRemote.getResult());
    }
}