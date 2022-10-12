import java.text.BreakIterator;
import java.util.Scanner;

class questions {
    Node ptr;

    public Node prblm1(Node h) {
        Node preptr = h, temp = null;
        ptr = h.next;
        while (ptr.next != null) {
            temp = ptr.next;
            ptr.next = preptr;
            preptr = ptr;
            ptr = temp;
        }
        ptr.next = preptr;
        h.next = null;
        h = ptr;
        return h;
    }

    public void prblm2(Node h) {
        Node iterator = h;
        int tempval;
        while (iterator.next != null) {
            ptr = h;
            while (ptr.next != null) {
                if (ptr.data > ptr.next.data) {
                    tempval = ptr.next.data;
                    ptr.next.data = ptr.data;
                    System.out.println("Checker");
                    ptr.data = tempval;
                }
                ptr = ptr.next;
            }
            iterator = iterator.next;
        }
    }

    public void pblm3(Node h) {
        Node iterator = h;
        ptr = h;
        int temp = 0;
        while (iterator.next != null) {
            ptr = iterator;
            Node tempval = ptr;
            while (ptr.next != null) {
                if (ptr.data <= tempval.data) {
                    tempval = ptr;

                }
                ptr = ptr.next;
            }
            if (ptr.data <= tempval.data) {
                tempval = ptr;
            }
            temp = iterator.data;
            iterator.data = tempval.data;
            tempval.data = temp;
            iterator = iterator.next;
        }
    }

    public void prblm4(Node h) {
        ptr = h;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        Node iterator = h, pivot;
        pivot = ptr;
        Node templ = pivot, tempr = pivot;
        // while (iterator.next != null) {
        ptr = h;
        while (ptr != pivot) {
            if (ptr.data > pivot.data) {
                tempr.next = ptr;
                tempr = tempr.next;
                // tempr.next = null;
            } else if (ptr.data < pivot.data) {
                Node templ2 = ptr;
                templ2.next = templ;
                templ = templ2;
            } else {
                break;
            }
            ptr = ptr.next;
        }
        System.out.println("Checker");
        // iterator = iterator.next;
        // }
    }

    public void noduplicates(Node h) {
        Node iterator = h;
        Node preptr = h;
        int c = 0;
        try {
            while (iterator.next != null) {
                ptr = iterator.next;
                preptr = iterator;
                while (ptr.next != null) {
                    if (ptr.data == iterator.data) {
                        preptr.next = ptr.next;
                        c++;
                    } else {
                        preptr = preptr.next;
                    }
                    ptr = ptr.next;
                }
                if (iterator.data == ptr.data)
                    preptr.next = null;
                iterator = iterator.next;
            }
        } catch (NullPointerException e) {
            System.out.println("All elements are equal");
        }
        if (c>0) {
            System.out.println(c+ "Duplicate(s) exists");
        } else {
            System.out.println("No Duplicates");
        }
    }

    public void noloops(Node h) {
        Node sptr = h;
        Node fptr = h;
        int c = 0;
        while (sptr.next!=null) {
            if (fptr.data==sptr.data&&sptr!=h&&fptr!=h) {
                sptr.next = null;
                c = 1;
                break;
            }
            if(fptr.next!=null&&fptr.next.next!=null)
            fptr = fptr.next.next;
            sptr = sptr.next;
        }
        if(c==1)
        System.out.println("Loop found");
        else
        System.out.println("Loop not found");
    }
    /** Explicitly added loop to check noloops algorithm
    public void addloop(Node h) {
        ptr = h;
        while (ptr.next!=null) {
            ptr = ptr.next;
        }
        ptr.next = h.next.next.next;
    }*/

    public double prblm5(Node h) {
        ptr = h;
        int n = 1;
        double sum = 0;
        while (ptr.next!=null) {
            ptr = ptr.next;
            n++;
        }
        double arr[] = new double[n];
        ptr = h;
        for (int i = n-1; i >=0; i--) {
            arr[i] = ptr.data*(Math.pow(2,i));
            sum = sum+arr[i];
            ptr = ptr.next;
        }
        return sum;
    }
}

public class QuestionsOnSLL {
    public static final SingleLinkedList sll = new SingleLinkedList();

    public static void main(String[] args) {
        Node head = null;
        questions ques = new questions();
        head = sll.create(head);
        // 1- Reversing the linkedlist

        // head = ques.prblm1(head);
        // System.out.println("Updated head= "+head.data);

        // 2- Bubble sort
        // ques.prblm2(head);
        // sll.display(head);

        // 3- Selection Sort
        // ques.pblm3(head);
        // sll.display(head);

        // 4- Quicksort **Incomplete
        // ques.prblm4(head);
        // sll.display(head);

        // 5- Duplicacy detector and remover
        //ques.noduplicates(head);
        //sll.display(head);

        // 6- Loop detector and remover
        //ques.addloop(head);
        //ques.noloops(head);
        //sll.display(head);

        // 7- Binary to Decimal
        //double c = ques.prblm5(head);
        // System.out.println("Decimal value for the entered binary number is "+c);
    }
}
