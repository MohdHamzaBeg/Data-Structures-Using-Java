import java.util.Scanner;

// Explaination- In C, we use pointers to get the address of a node. But here, the work of & operator is replaced by the object of the
// class Node (which will have only a data and address like we used structure in C) which will act as a node and the value of next will
// store the object of the next Node class to link with that node.

public class SingleLinkedListApp {
    public static void main(String[] args) {
        Node head = null;
        Scanner sc = new Scanner(System.in);
        var llo = new SingleLinkedList();
        do {
            System.out.println("Enter 1 to make a new linked list");
            System.out.println("Enter 2 to display the linked list");
            System.out.println("Enter 3 to insert an element in the linked list");
            System.out.println("Enter 4 to delete an element in the linked list");
            System.out.println("Enter 6 exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    head = llo.create(head);
                    break;
                case 2:
                    llo.display(head);
                    break;
                case 3:
                    head = llo.insert(head);
                    break;
                case 4:
                    llo.delete(head);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }
        } while (true);
    }
}