//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends


class Solution
{
    // Function to sort an array using the quick sort algorithm
    static void quickSort(int arr[], int l, int h) {
        if (l < h) {
            int j = partition(arr, l, h); // Get partition index
            quickSort(arr, l, j - 1); // Sort elements before partition
            quickSort(arr, j + 1, h); // Sort elements after partition
        }
    }
    
    // Partition function
    static int partition(int arr[], int l, int h) {
        // Choose pivot as the first element in the subarray
        int pivot = arr[l];
        int i = l; // Left pointer
        int j = h; // Right pointer
    
        while (i < j) {
            // Find element larger than the pivot from the left side
            while (i < j && arr[i] <= pivot) {
                i++;
            }
    
            // Find element smaller than the pivot from the right side
            while (i <= j && arr[j] > pivot) {
                j--;
            }
    
            // Swap elements found by i and j
            if (i < j) {
                swap(arr, i, j);
            }
        }
    
        // Swap pivot with element at position j (final position of the pivot)
        swap(arr, l, j);
    
        return j; // Return the partition index
    }
    
    // Helper function to swap two elements in the array
    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


}
