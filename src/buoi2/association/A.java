package buoi2.association;

public class A {
    // field
    private B bRemote;

    // function, method => behavior
    A() { // function (đây không phải là hành vi của đối tượng)
        // this.bRemote = new B();
    }

    A(B bRemote) { // bRemote -> local variable
        this.bRemote /* -> instance variable */ = bRemote;
    }

    void methodA() { // method (có thể gửi message tới đối tượng)
        this.bRemote.methodB();
    }

    void setBRemote(B bRemote) {
        this.bRemote = bRemote;
    }
}
