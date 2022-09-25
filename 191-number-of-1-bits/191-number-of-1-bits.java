public class Solution {
    // you need to treat n as an unsigned value
    //https://leetcode.com/problems/number-of-1-bits/discuss/1519675/JAVA-C%2B%2B-%3A-Simple-or-Optimised-or-Faster-than-100-or-Detailed-Explanation
    public static int hammingWeight(int n) {
        int count = 0;
        
        while(n!=0){
            n &= (n-1);
            count++;
        }

        return count;
    }
}