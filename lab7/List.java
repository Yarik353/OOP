package lab7;

import lab6.Plane;

public class List {
    private LinkedList head;
    public List(){
        head=null;
    }
    private boolean isEmpty(){
        return head==null;
    }
    public void add ( Plane data){
        LinkedList temp = new LinkedList(data);
        temp.next = head;
        head = temp;
    }
    public Plane next(){
        LinkedList temp = head;
        return temp.next.data;
    }
    public void remove(Plane key){
        LinkedList cur = head;
        LinkedList prev = head;
        if (isEmpty()){
            System.out.println("List is empty");
            return;
        }
        else{
            prev = cur;
            cur = cur.next;
        }
        if(cur == head){
            head = head.next;
        }
        else{
            prev.next = cur.next;
        }
    }
    public boolean contains(Plane key){
        LinkedList temp = head;
        while(temp != null){
        if(temp.data == key){
            return true;
        }
        temp = temp.next;
        }
        return false;
    }
    public  void print(){
        LinkedList temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp= temp.next;
        }
    }
}
