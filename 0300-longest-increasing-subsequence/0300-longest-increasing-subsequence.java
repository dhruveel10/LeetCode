class Solution {
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int[][] dp=new int[n+1][n+1];
        
        for(int i = 0; i<=n; i++)
            dp[n][i] = 0;
        
        for(int i=n-1; i>= 0; i--){
            for(int prev=i-1; prev >= -1; prev--){
                int notPick = dp[i+1][prev+1];
                int pick = -1;
                if(prev == -1 || a[i]>a[prev])
                    pick = 1 + dp[i+1][i+1];
                dp[i][prev+1] = Math.max(pick,notPick);
            }
        }
        return dp[0][0];
    } 
}