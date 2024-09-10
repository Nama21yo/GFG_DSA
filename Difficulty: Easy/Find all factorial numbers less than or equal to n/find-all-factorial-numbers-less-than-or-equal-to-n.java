//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        ArrayList<Long> list =new ArrayList<>();
        recursive(1,1,list,n);
        return list;
    }
    static void recursive(long temp, long fact, ArrayList<Long> list, long n){
        if(fact>n)
            return;
        fact*=temp;//fact=fact*temp
        if(fact<=n)
            list.add(fact);
        temp++;
        recursive(temp,fact,list,n);
    }

    
}