package pl.sda;

public class Node {
    private Node next;
    private Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public Node setValue(Object value) {
        this.value = value;
        return this;
    }
}
