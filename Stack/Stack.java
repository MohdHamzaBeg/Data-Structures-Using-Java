import java.util.Scanner;
class Node {
    char data;
    Node next;

    public Node(char value) {
        this.data = value;
        this.next = next;
    }
}


interface StackInterface {
    Node push(Node t, char val);
    void peek(Node t);
    int pop(Node t);
    // // void delete(Node h);
}

public class Stack implements StackInterface{
    Node ptr;
    int c=0;
    Scanner sc = new Scanner(System.in);

    public Node push(Node t, char val) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the element");
            Node temp = new Node(val);
            if (t == null) {
                t = temp;
            } else {
                temp.next = t;
                t = temp;
            }
        return t;
    }

    
    public void peek(Node t) {
        if (t == null) {
            System.out.println("Stack underflow");
        } else {
            ptr = t;
            while (ptr.next != null) {
                System.out.print(ptr.data);
                ptr = ptr.next;
            }
            System.out.print(ptr.data);
        }
    }


    public int pop(Node t) {
        int val = t.data;
        t = t.next;
        return val;
    }
}