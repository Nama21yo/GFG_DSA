//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long maxSum = 0;
        long windowSum = 0;
    
        // Find the sum of the first window of size 'K'
        for (int i = 0; i < K; i++) {
            windowSum += Arr.get(i);
        }
        
        // Initialize maxSum with the first window sum
        maxSum = windowSum;
    
        // Slide the window by adding the new element and removing the first element of the previous window
        for (int end = K; end < N; end++) {
            windowSum += Arr.get(end) - Arr.get(end - K);
            maxSum = Math.max(maxSum, windowSum); // Update maxSum if needed
        }
    
        return maxSum;
    }

}
