//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        selectionSort(arr,i);
        for (i = 0;i<arr.length-1;i++) {
            System.out.print(arr[i] + " ");
        }
        return arr.length-2;
        
        
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    for(int i = 0;i<n;i++) {
	        int min = i;
	        for(int j = i;j<n;j++) {
	            if(arr[j]<arr[min]) {
	                min = j;
	            }
	        }
	       // swap
	       int temp = arr[min];
	       arr[min] = arr[i];
	       arr[i] = temp;
	       
	    }
	}
}