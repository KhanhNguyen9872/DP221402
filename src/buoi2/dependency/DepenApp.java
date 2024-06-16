package buoi2.dependency;

public class DepenApp {
    public static void main(String[] args) {
        // A aRemote = new A();
        // aRemote.methodA();

        B bRemote = new B();
        A aRemote = new A(bRemote);
        // aRemote.methodA();
    }
}
