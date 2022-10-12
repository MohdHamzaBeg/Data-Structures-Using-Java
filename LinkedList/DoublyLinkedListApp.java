import java.util.Scanner;

public class DoublyLinkedListApp {
    public static final DoublyLinkedList dll = new DoublyLinkedList();
    
    public static void main(String[] args) {
        dllNode head = null;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter 1 to make a new linked list");
            System.out.println("Enter 2 to display the linked list");
            System.out.println("Enter 3 to display the list backward");
            System.out.println("Enter 4 to display the largest element in the list");
            System.out.println("Enter 6 exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    head = dll.create(head);
                    break;
                case 2:
                    dll.display(head);
                    break;
                case 3:
                    dll.displaybackward(head);
                    break;
                case 4:
                    System.out.println(dll.displayLargest(head));
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
