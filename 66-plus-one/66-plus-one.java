class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
            int[] ans = new int[n+1];
            for(int i=n-1; i>-1; i--)
            {
                if(digits[i]<9) {
                    digits[i] += 1;
                    return digits;
                }
                else digits[i]=0;
            }
            ans[0] = 1;
        return ans;    
    }
}