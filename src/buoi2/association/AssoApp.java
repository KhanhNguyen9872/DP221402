package buoi2.association;

public class AssoApp {
    public static void main(String[] args) {
        // B bRemote = new B();
        A aRemote = new A();
        // aRemote.methodA();

        B bRemote1 = new B();
        aRemote.setBRemote(bRemote1);
        aRemote.methodA();
    }
}
