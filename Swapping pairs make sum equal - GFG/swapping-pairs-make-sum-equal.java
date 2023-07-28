//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution {
    long findSwapValues(long A[], int n, long B[], int m) { 
        long sumA = 0, sumB = 0;
        HashSet<Long> setB = new HashSet<>();
        
        for (long num : A) {
            sumA += num;
        }
        for (long num : B) {
            sumB += num;
            setB.add(num);
        }
        
        long diff = sumA - sumB;
        if (diff % 2 != 0) {
            // If difference is odd, cannot make sums equal by swapping
            return -1L;
        }
        
        long target = diff / 2;
        for (long num : A) {
            if (setB.contains(num - target)) {
                // Found a pair that can be swapped to make sums equal
                return 1L;
            }
        }
        
        // No such pair found, sums cannot be made equal by swapping
        return -1L;
    }
}




//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends