import java.util.ArrayList;

public class basicLevel1 {
    public static int romanToInt(String s) {
        s = s + " ";
        char arr[] = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 'I') {
                if (arr[i + 1] == 'V' || arr[i + 1] == 'X') {
                    sum = sum - 1;
                } else {
                    sum = sum + 1;
                }
            } else if (arr[i] == 'V') {
                sum = sum + 5;
            } else if (arr[i] == 'X') {
                if (arr[i + 1] == 'L' || arr[i + 1] == 'C') {
                    sum = sum - 10;
                } else {
                    sum = sum + 10;
                }
            } else if (arr[i] == 'L') {
                sum = sum + 50;
            } else if (arr[i] == 'C') {
                if (arr[i + 1] == 'D' || arr[i + 1] == 'M') {
                    sum = sum - 100;
                } else {
                    sum = sum + 100;
                }
            } else if (arr[i] == 'D') {
                sum = sum + 500;
            } else if (arr[i] == 'M') {
                sum = sum + 1000;
            } else {
                System.out.println("Wrong input");
                return 0;
            }
        }
        return sum;
    }

    public static int[] runningSum(int[] nums) {
        int arr[] = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        return arr;
    }

    public static int pivotIndex(int[] nums) {
        int leftsum[] = new int[nums.length];
        int rightsum[] = new int[nums.length];
        // leftsum[0] = 0;
        // rightsum[nums.length-1] = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + nums[j];
            }
            leftsum[i] = sum;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = nums.length - 1; j > i; j--) {
                sum = sum + nums[j];
            }
            rightsum[i] = sum;
        }
        for (int i = 0; i < leftsum.length; i++) {
            for (int j = 0; j < rightsum.length; j++) {
                // System.out.println(leftsum[i]+" - "+rightsum[j]);
                if (leftsum[i] == rightsum[j] && i == j) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isIsomorphic(String s, String t) {
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        char c1, c2;
        boolean result = false;
        for (int i = 0; i < ch1.length; i++) {
            c1 = ch1[i];
            c2 = ch2[i];
            for (int j = 0; j < ch2.length; j++) {
                if(ch1[j]==c1){
                    if(ch2[j]==c2){
                    result = true;
                    }
                    else{
                        return false;
                    }
                }
                else if(ch2[j]==c2&&ch1[j]!=c1){
                    return false;
                }
            }
        }
        return result;
    }

    public static boolean isSubsequence(String s, String t) {
        ArrayList<Character> t1 = new ArrayList<Character>();
        ArrayList<Character> visited = new ArrayList<Character>();
        String newt = "";
        for (int i = 0; i < t.length(); i++) {
            t1.add(t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t1.size(); j++) {
                System.out.println(j);
                if(visited.contains(t1.get(j))){
                    continue;
                }
                else{
                    if(s.charAt(i)==t1.get(j)){
                        newt = newt+t1.get(j);
                        t1.remove(j);
                        j--;
                        break;
                    }
                    else{
                        t1.remove(j);
                        j--;
                    }
                }
            }
        }
        System.out.println(newt);
        if(s.equals(newt))
        return true;
        else
        return false;
    }

    public static int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, profit = 0;
        ArrayList<Integer> profits = new ArrayList<Integer>();
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
                //System.out.println(min);
                for (int j = i+1; j < prices.length; j++) {
                    System.out.println(j);
                    if(prices[j]>=max&&prices[j]>min){
                        max = prices[j];
                        System.out.println(max);
                        profit = max - min;
                        profits.add(profit);
                    }
                }
            }
        }
        profits.sort(null);
        System.out.println(profits);
        if(profits.isEmpty()||profits.get(profits.size()-1)<0)
        return 0;
        else
        return profits.get(profits.size()-1);
    }

    public static void main(String[] args) {
        // Question 1:-
        // String s = "DCXLIX";
        // System.out.println(romanToInt(s));

        // Question 2:-
        /**
         * int arr[] = {1,2,3,4};
         * arr = runningSum(arr);
         * for (int i = 0; i < arr.length; i++) {
         * System.out.println(arr[i]);
         * }
         */

        // Question 3:-
        // int arr[] = {2,1,-1};
        // System.out.println(pivotIndex(arr));

        // Question 4:-
        //System.out.println(isIsomorphic("paper", "title"));
        
        // Question 5:-
        //System.out.println(isSubsequence("abc", "ahbgdc"));

        // Question 6:- Best time to buy or sell stock
        int arr[] = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
}
