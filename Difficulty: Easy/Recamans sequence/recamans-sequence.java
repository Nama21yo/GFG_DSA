//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    // Iterative method to generate the Recaman sequence
    static ArrayList<Integer> recamanSequence(int n) {
        // Using long to handle large numbers, and then convert to integer
        ArrayList<Long> longSequence = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();
        
        // Start with the first element as 0
        long prev = 0;
        longSequence.add(prev);
        set.add(prev);

        for (int i = 1; i < n; i++) {
            long next = prev - i; // Recaman formula: a(n) = a(n-1) - n

            // If the next value is positive and not in the sequence, use it
            if (next > 0 && !set.contains(next)) {
                longSequence.add(next);
                set.add(next);
            } else {
                // Otherwise, use the alternative: a(n) = a(n-1) + n
                next = prev + i;
                longSequence.add(next);
                set.add(next);
            }
            prev = next; // Update previous value
        }

        // Convert the long sequence back to integers
        ArrayList<Integer> intSequence = new ArrayList<>();
        for (long num : longSequence) {
            intSequence.add((int) num); // Convert long to int
        }

        return intSequence;
    }
    
}