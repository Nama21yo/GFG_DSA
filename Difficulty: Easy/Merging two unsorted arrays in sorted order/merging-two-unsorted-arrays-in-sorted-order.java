//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public void sortedMerge(int[] nums1, int[] nums2, int[] res) {
        int m = nums1.length; // Length of nums1
        int n = nums2.length; // Length of nums2
        int left = m - 1; // Start from the last element of nums1
        int right = 0;    // Start from the first element of nums2
        
        // Step 1: Swap larger elements in nums1 with smaller elements in nums2
        while(left >= 0 && right < n) {
            if(nums1[left] > nums2[right]) {
                // Swap nums1[left] and nums2[right]
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break; // Break the loop if nums1[left] <= nums2[right]
            }
        }
        
        // Step 2: Sort both arrays after swapping
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // Step 3: Merge nums1 and nums2 into res in sorted order
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1 if any
        while (i < m) {
            res[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2 if any
        while (j < n) {
            res[k++] = nums2[j++];
        }
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] arr1Str = line.split(" ");
            int[] arr1 = new int[arr1Str.length];
            for (int i = 0; i < arr1Str.length; i++) {
                arr1[i] = Integer.parseInt(arr1Str[i]);
            }

            line = sc.nextLine();
            String[] arr2Str = line.split(" ");
            int[] arr2 = new int[arr2Str.length];
            for (int i = 0; i < arr2Str.length; i++) {
                arr2[i] = Integer.parseInt(arr2Str[i]);
            }

            int n = arr1.length;
            int m = arr2.length;
            int[] res = new int[n + m]; // Initialize res array of size n + m

            Solution ob = new Solution();
            ob.sortedMerge(arr1, arr2, res);
            for (int i = 0; i < n + m; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends