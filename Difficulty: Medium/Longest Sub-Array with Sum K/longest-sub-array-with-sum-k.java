//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function for finding the length of the longest subarray with sum equal to k
    public static int lenOfLongSubarr(int[] A, int N, int k) {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i];

            // If the current sum is equal to k, update maxLen
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // Calculate the remaining sum needed to get k
            int rem = sum - k;

            // Check if the remaining sum is in the map
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Add the current sum to the map if it's not already there
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
