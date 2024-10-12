//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        char[] word = arr.toCharArray();
        // [e,d,f,a,b]
        // [4,3,5,0,1]
        int n = word.length;
        int max_char = 0;
        for(int i = 0; i < n; ++i) {
            max_char = Math.max(max_char,(int)word[i] - 'a');
        }
        // Produce the Count Array
        int[] count = new int[max_char + 1];
        
        for(int i = 0; i < n; ++i) {
            count[word[i] - 'a']++;
        }
        // Produce the Prefix Sum
        for(int i = 1; i < count.length; ++i) {
            count[i] = count[i] + count[i - 1];
        }
        // Go in reverse and insert it in new outputArray
        // This is because to make it stable
        char[] output = new char[n];
        for(int i = n - 1; i >= 0; i--) {
            output[count[word[i] - 'a'] - 1] = word[i];
            count[word[i] - 'a']--;
        }
        
        return new String(output);
    }
}