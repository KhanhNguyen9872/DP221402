package buoi4.MVC_Bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatorModel {
    private double result;
    private PropertyChangeSupport pcs;

    CalculatorModel() {
        pcs = new PropertyChangeSupport(this);
    }

    public void add(double a, double b) {
        this.result = a + b;
        changeState();
    }

    public void sub(double a, double b) {
        this.result = a - b;
        changeState();
    }

    public void mul(double a, double b) {
        this.result = a * b;
        changeState();
    }

    public void div(double a, double b) {
        this.result = a / b;
        changeState();
    }

    public void subscriber(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void unsubscriber(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void changeState() {
        pcs.firePropertyChange(null, null, this.result);
    }
}
