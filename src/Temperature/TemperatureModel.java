package Temperature;

import Temperature.observer.Publisher;

public class TemperatureModel extends Publisher {
    private double result;

    public void c2f(double c){
        double f = (c * 9/5) + 32;
        this.result = f;
        changeState();
    }

    public void f2c(double f){
        double c = ((f - 32) *5)/9;
        this.result = c;
        changeState();
    }

    public double getResult(){
        return result;
    }

    public void exit(){
        System.exit(0);
    }

    public void changeState() {
        notifySubscribers();
    }
}