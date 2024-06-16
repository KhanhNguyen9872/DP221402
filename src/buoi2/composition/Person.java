package buoi2.composition;

public class Person {
    private Head headRemote;

    Person() {
        headRemote = new Head();
    }

    public void control() {
        headRemote.see();        
    }
}

