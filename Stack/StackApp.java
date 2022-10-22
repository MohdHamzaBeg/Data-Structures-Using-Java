import java.util.Scanner;

public class StackApp {
    public static void main(String[] args) {
        Node top = null;
        int c = 1,n=0;
        Scanner sc = new Scanner(System.in);
        var stack = new Stack();
        do {
            System.out.println("Enter 1 to push to the stack");
            System.out.println("Enter 2 to peek the stack");
            System.out.println("Enter 3 to pop from the stack");
            //System.out.println("Enter 4 to delete an element in the linked list");
            System.out.println("Enter 6 exit");
            int ch = sc.nextInt();
            switch (ch) {
                // case 1:
                //     if(top==null){
                //     System.out.println("Enter the number of elements");
                //     n = sc.nextInt();
                //     }
                //     if(c<=n){
                //     top = stack.push(top);
                //     c++;
                //     }
                //     else{
                //         System.out.println("Stack Overflow");
                //     }
                //     break;
                case 2:
                    stack.peek(top);
                    break;
                case 3:
                System.out.println("Value which has been deleted= "+stack.pop(top));
                break;
                // case 4:
                // llo.delete(head);
                // break;
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
