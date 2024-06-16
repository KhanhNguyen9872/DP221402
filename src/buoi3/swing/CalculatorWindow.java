package buoi3.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorWindow extends JFrame implements ActionListener {
    private String title;
    private JPanel jPanelRemote;
    private JLabel jLabelInput1Remote, jLabelInput2Remote, jLabelOutputRemote;
    private JTextField jTextFieldInput1Remote, jTextFieldInput2Remote;
    private JButton addButtonRemote, subButtonRemote, mulButtonRemote, divButtonRemote;

    CalculatorWindow() {
        buildPanel();
        add(jPanelRemote);
        title = "Frame Viewer";
        setTitle(title);
        setSize(420, 400);
        setVisible(true);
    }

    public void buildPanel() {
        jPanelRemote = new JPanel();

        jLabelInput1Remote = new JLabel("input1");
        jLabelInput2Remote = new JLabel("input2");
        jLabelOutputRemote = new JLabel("output");
        
        jTextFieldInput1Remote = new JTextField(10);
        jTextFieldInput2Remote = new JTextField(10);

        addButtonRemote = new JButton("ADD");
        mulButtonRemote = new JButton("MUL");
        subButtonRemote = new JButton("SUB");
        divButtonRemote = new JButton("DIV");

        addButtonRemote.addActionListener(this);
        mulButtonRemote.addActionListener(this);
        subButtonRemote.addActionListener(this);
        divButtonRemote.addActionListener(this);

        jPanelRemote.add(jLabelInput1Remote);
        jPanelRemote.add(jTextFieldInput1Remote);

        jPanelRemote.add(jLabelInput2Remote);
        jPanelRemote.add(jTextFieldInput2Remote);

        jPanelRemote.add(jLabelOutputRemote);

        jPanelRemote.add(addButtonRemote);
        jPanelRemote.add(mulButtonRemote);
        jPanelRemote.add(subButtonRemote);
        jPanelRemote.add(divButtonRemote);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        double num1 = Double.parseDouble(jTextFieldInput1Remote.getText());
        double num2 = Double.parseDouble(jTextFieldInput2Remote.getText());
        double result = 0;

        if (cmd.equals("ADD")) {
            result = num1 + num2;
        } else if (cmd.equals("SUB")) {
            result = num1 - num2;
        } else if (cmd.equals("MUL")) {
            result = num1 * num2;
        } else if (cmd.equals("DIV")) {
            result = num1 / num2;
        };
        
        jLabelOutputRemote.setText("output " + result);
    };
};
