//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return -1; // handle edge cases
    
        HashMap<Character, Integer> countChar = new HashMap<>();
        int left = 0, maxLen = -1;
    
        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the map
            countChar.put(s.charAt(right), countChar.getOrDefault(s.charAt(right), 0) + 1);
    
            // Shrink the window if there are more than `k` distinct characters
            while (countChar.size() > k) {
                countChar.put(s.charAt(left), countChar.get(s.charAt(left)) - 1);
                if (countChar.get(s.charAt(left)) == 0) {
                    countChar.remove(s.charAt(left));
                }
                left++;
            }
    
            // Update maxLen only if we have exactly `k` distinct characters
            if (countChar.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
    
        return maxLen; // Return -1 if no valid substring is found
    }

}