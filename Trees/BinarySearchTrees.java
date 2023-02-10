package Trees;

import java.util.ArrayList;

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTrees {
    public static BSTNode build(int num, BSTNode root) {
        if (root == null) {
            root = new BSTNode(num);
            return root;
        }
        if (num < root.data) {
            root.left = build(num, root.left);
        } else {
            root.right = build(num, root.right);
        }
        return root;
    }

    static int numberofpaths = 0;
    public static void inorder(BSTNode root) {
        if (root == null) {
            return;
        }
        if(root.left==null&&root.right==null)
        numberofpaths++;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static int c = 0;
    static BSTNode preroot;

    private static int search(BSTNode root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.data > val) {
            search(root.left, val);
        } else if (root.data < val) {
            search(root.right, val);
        } else if (root.data == val) {
            c++;
        } else {
            System.out.println("Value not found");
        }
        return c;
    }

    private static void delete(BSTNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.data > val) {
            preroot = root;
            c = 1;
            delete(root.left, val);
        } else if (root.data < val) {
            preroot = root;
            c = 2;
            delete(root.right, val);
        } else if (root.data == val) {
            if (c == 1) {
                preroot.left = root.right;
            } else {
                preroot.right = root.right;
            }
        }
    }

    static int f = 0;

    public static void printer(BSTNode root, int ll, int ul) {
        if (root == null) {
            return;
        }
        printer(root.left, ll, ul);
        if (root.data >= ll && root.data <= ul) {
            System.out.println(root.data);
        }
        printer(root.right, ll, ul);
    }
    private static void printinrange(BSTNode root, int ll, int ul) {
        if (search(root, ll) == 1)
            f++;
        else
            System.out.println("Lower Limit not found");
        if (search(root, ul) == 2)
            f++;
        else
            System.out.println("Upper Limit not found");
        if (f == 2) {
            printer(root, ll, ul);
        }

    }
    static int i = -1;
    private static void roottoleaf(BSTNode root, ArrayList<Integer> arr) {
        i++;
        if (root == null) {
            i--;
            return;
        }
        arr.add(i,root.data);
        if(root.left==null&&root.right==null){
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j)+" -> ");
            }
            System.out.println();
        }
        
        roottoleaf(root.left,arr);
        roottoleaf(root.right,arr);
        arr.remove(i);
        i--;
        
    }

    public static void main(String[] args) {
        // Building the tree
        BSTNode root = null;
        int arr[] = { 15, 11, 19, 9, 14, 16, 21};
        for (int i = 0; i < arr.length; i++) {
            root = build(arr[i], root);
        }
        //Calculating number of paths from the root node to every leaf node
        //inorder(root);
        //System.out.println(numberofpaths);
         
         //Searching Algorithm
         /* if(search(root, 6)==1)
         System.out.println("value found");
         else
         System.out.println("Value not found");
         */ 

        // Deleting a node:-
        /*
         * preroot = root;
         * delete(root, 22);
         * inorder(root);
         */

        // Printing the elements which lie between the two values
        //printinrange(root, 4, 8);

        // Saving different paths from root to leaf
        ArrayList<Integer> al = new ArrayList<>();
        roottoleaf(root, al);
    }

}
