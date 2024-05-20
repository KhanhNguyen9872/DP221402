public class App {
    private int a;
    private int b;

    public App(int a, int b) {
        this.a = a;
        this.b = b;
    };

    public int get() {
        return this.a * this.b;
    };

    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        App sum = new App(a, b);
        
        System.out.println(sum.get());
    };
};
