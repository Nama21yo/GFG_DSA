//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            
            // If the sum is zero, the subarray from 0 to i has sum 0
            if (sum == 0) {
                maxLen = i + 1;  // Update maxLen as this subarray starts from index 0
            }

            // If this sum has been seen before
            if (preSumMap.containsKey(sum)) {
                // Calculate the length of the subarray with sum 0
                int len = i - preSumMap.get(sum);
                maxLen = Math.max(maxLen, len);  // Update the maximum length
            } else {
                // If the sum hasn't been seen before, store the index
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}