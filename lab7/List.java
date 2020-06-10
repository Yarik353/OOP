package lab7;

import lab6.Plane;

public class List {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    void addFront(Plane data) {
        Node a = new Node();
        a.data = data;
        if (head == null) {
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    void addBack(Plane data) {
        Node a = new Node();
        a.data = (Plane) data;
        if (tail == null) {
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
        }
    }

    void delEl(Plane data) {
        if (head == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node t = head;
        while (t.next != null) {
            if (t.next.data == data) {
                if (tail == t.next) {
                    tail = t;
                }
                t.next = t.next.next;
                return;
            }
            t = t.next;
        }
    }
}
