class Solution {
    public boolean canPartition(int[] arr) {
        int k = 0;
        for(int i:arr)
            k += i;
        
        if(k%2 != 0)
            return false;
        
        int n = arr.length;
        
        k = k/2;
            
        boolean dp[][] = new boolean[n][k + 1];
        
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];
                
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                
                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];
    }
}