import java.util.ArrayList;
import java.util.Scanner;

public class questionsonstack {
    public static final Stack st = new Stack();
    Scanner sc = new Scanner(System.in);

    public Node prblm1(Node t) {
        System.out.println("Enter the string to reverse it");
        String str = sc.nextLine();
        char chs[] = str.toCharArray();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            // t = st.push(t, chs[i]);
        }
        return t;
    }

    private Node prblm2(Node t) {
        int c = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> brr = new ArrayList<Integer>();
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) > arr.get(i)) {
                    // t = st.push(t, arr.get(j));
                    c++;
                    break;
                }
            }
        }
        return t;
    }

    private boolean prblm3(Node t) {
        System.out.println("Enter a string containing only parenthesis");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '}' || str.charAt(i) == '(' || str.charAt(i) == ')' ||
                    str.charAt(i) == '[' || str.charAt(i) == ']') {
                t = st.push(t, str.charAt(i));
            } else {
                System.out.println("Wrong Input\n Re-start the program and provide a valid input");
                System.exit(0);
            }
        }

        return false;
    }

    private Node prblm4(Node t) {
        System.out.println("Enter an infix expression to change it into postfix through stack");
        String str = sc.nextLine();
        ArrayList<Character> arr = new ArrayList<>();
        ArrayList<Character> brr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            arr.add(str.charAt(i));
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == '(' || arr.get(i) == '!' || arr.get(i) == '^' || arr.get(i) == '+'
                    || arr.get(i) == '-' || arr.get(i) == '*' ||
                    arr.get(i) == '%' || arr.get(i) == '/') {
                        if (t.data=='+'||t.data=='-'&&arr.get(i)== '!' || arr.get(i) == '^' ||arr.get(i) == '*' || arr.get(i) == '%' ||
                         arr.get(i) == '/') {
                            brr.add(t.data);
                            t = st.push(t, arr.get(i));
                        }
                    }
                else if(arr.get(i)==')'){
                    st.pop(t);
                    brr.add(t.data);
                } else {
                brr.add(arr.get(i));
            }
        }
        for (int i = 0; i < brr.size(); i++) {
            System.out.print(brr.get(i));
        }
        return t;
    }

    public static void main(String[] args) {
        questionsonstack qs = new questionsonstack();
        Node top = null;

        // 1. Reversing a string
        // top = qs.prblm1(top);
        // st.peek(top);

        // 2. Finding the next greater element in an array
        // top = qs.prblm2(top);
        // st.peek(top);

        // 3. Valid parenthesis
        // boolean d = qs.prblm3(top);

        // 4. Implementing the theory questions
        top = qs.prblm4(top);
        st.peek(top);

    }
}
