//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // Amazon Question
        int left = 0;
        int right = 0;
        HashMap<Integer,Integer> Basket = new HashMap<>();
        int maxLen = 0;
        
        while (right < arr.length) {
            // Add the fruit to the basket and increment its count
            Basket.put(arr[right], Basket.getOrDefault(arr[right], 0) + 1);
    
            // Shrink the window if there are more than 2 types of fruits
            while (Basket.size() > 2) {
                Basket.put(arr[left], Basket.get(arr[left]) - 1);
                if (Basket.get(arr[left]) == 0) {
                    Basket.remove(arr[left]);
                }
                left++;
            }
    
            // Calculate the maximum length of the valid window
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}