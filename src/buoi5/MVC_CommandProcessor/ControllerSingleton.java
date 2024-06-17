package buoi5.MVC_CommandProcessor;

public class ControllerSingleton {
    private static ControllerSingleton controller = null;

    private ControllerSingleton() {

    }

    public static ControllerSingleton makeController() {
        if (controller == null) {
            controller = new ControllerSingleton();
        }

        return controller;
    }
}
