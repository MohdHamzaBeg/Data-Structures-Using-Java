import java.util.Scanner;

class dllNode {
    int data;
    dllNode prev;
    dllNode next;

    public dllNode(int value) {
        this.data = value;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Scanner sc = new Scanner(System.in);
    dllNode ptr = null;

    public dllNode create(dllNode h) {
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        while (n > 0) {
            int num = sc.nextInt();
            dllNode temp = new dllNode(num);
            if (h == null) {
                h = temp;
            } else {
                ptr = h;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                temp.prev = ptr;
                ptr.next = temp;
            }
            n--;
        }
        return h;
    }

    public void display(dllNode h) {
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

    public void displaybackward(dllNode h) {
        if (h == null) {
            System.out.println("List is empty");
        } else {
            ptr = h;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            while (ptr.prev != null) {
                System.out.println(ptr.data);
                ptr = ptr.prev;
            }
            System.out.println(ptr.data);
        }
    }

    public int displayLargest(dllNode h) {
        ptr = h;
        int val = h.data;
        while (ptr.next!=null) {
            if(ptr.data>=val){
                val = ptr.data;
            }
            ptr = ptr.next;
        }
        if (val>=  ptr.data) {
            return val;   
        }
        else{
            return ptr.data;
        }
    }
}