import java.util.Scanner;
class Node {
    int data;
    Node next;

    public Node(int value) {
        this.data = value;
        this.next = next;
    }
}


interface SLLinterface {
    Node create(Node h);
    void display(Node h);
    Node insert(Node h);
    void delete(Node h);
}

public class SingleLinkedList implements SLLinterface {
    Node ptr;
    Scanner sc = new Scanner(System.in);

    public Node create(Node h) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to store");
        int n = sc.nextInt();

        while (n > 0) {
            int num = sc.nextInt();
            Node temp = new Node(num);
            if (h == null) {
                h = temp;
            } else {
                ptr = h;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
            }
            n--;
        }
        return h;
    }

    public void display(Node h) {
        if (h == null) {
            System.out.println("List is empty");
        } else {
            ptr = h;
            while (ptr.next != null) {
                System.out.println(ptr.data);
                ptr = ptr.next;
            }
            System.out.println(ptr.data);
        }
    }

    public Node insert(Node h) {
        System.out.println("Enter the position number to insert the element");
        int n = sc.nextInt();
        if (h == null) {
            System.out.println("List is empty");
        } else if (n == 1) {
            System.out.println("Enter the element");
            int num = sc.nextInt();
            Node temp = new Node(num);
            temp.next = h;
            h = temp;
            System.out.println("Element inserted");
        } else {
            ptr = h;
            for (int i = 0; i < n - 2; i++) {
                ptr = ptr.next;
            }
            System.out.println("Enter the element");
            int num = sc.nextInt();
            Node temp = new Node(num);
            temp.next = ptr.next;
            ptr.next = temp;
            System.out.println("Element inserted");
        }
        return h;
    }

    public void delete(Node h) {
        Node preptr = null;
        System.out.println("Enter the position number to delete the element");
        int n = sc.nextInt();
        if (h == null) {
            System.out.println("List is empty");
        } else if (n == 1) {
            ptr = h;
            h = h.next;
            // free(ptr);
            System.out.println("Element deleted");
        } else {

            ptr = h;
            for (int i = 0; i <= n - 2; i++) {
                preptr = ptr;
                ptr = ptr.next;
            }
            preptr.next = ptr.next;
            // free(ptr);
            System.out.println("Element deleted");
        }
    }
}
