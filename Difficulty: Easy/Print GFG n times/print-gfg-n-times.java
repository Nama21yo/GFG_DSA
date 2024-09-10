//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printGfg(n);
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    void printGfg(int N) {
        print(1,N,"GFG");
    }
    private void print(int i, int N, String s) {
        if(i > N) return;
        else {
            System.out.printf("%S ",s);
            print(i + 1,N,s);
        }
    }
}