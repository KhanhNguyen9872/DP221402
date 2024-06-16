package buoi2.dependency;

public class A {
    // field

    // function, method => behavior
    A() { // function (đây không phải là hành vi của đối tượng)
        // this.bRemote = new B();
    }

    A(B bRemote) { // bRemote -> local variable
        bRemote.methodB();
    }

    void methodA() { // method (có thể gửi message tới đối tượng)
        B bRemote = new B();
        bRemote.methodB();
    }

    void setBRemote(B bRemote) {
        bRemote.methodB();
    }
}
