//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public int print2largest(List<Integer> arr) {
        if (arr == null || arr.size() < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max1) {
                max2 = max1;
                max1 = arr.get(i);
            } else if (arr.get(i) > max2 && arr.get(i) != max1) {
                max2 = arr.get(i);
            }
        }

        if (max2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second largest element in the array.");
        }

        return max2;
    }
}
