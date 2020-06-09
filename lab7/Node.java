package lab7;

import lab6.Plane;

public class Node{
    public Plane data;
    public Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Plane getData() {
        return data;
    }

    public void setData(Plane data) {
        this.data = data;
    }
}
