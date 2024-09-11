//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // size of array
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int P = Integer.parseInt(br.readLine().trim());
            // calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P);

            // printing array elements
            for (int i = 0; i < N; i++) System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // Create a hashmap to store the frequency of each element
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count the occurrences of each element in the array
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1 && arr[i] <= N) {  // Only consider elements within the range 1 to N
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            }
        }

        // Update the original array with the frequency of elements from 1 to N
        for (int i = 0; i < N; i++) {
            arr[i] = countMap.getOrDefault(i + 1, 0);  // Set 0 for elements that do not appear
        }
    }
}
