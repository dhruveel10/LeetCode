class Solution {
    public int maxCoins(int[] nums) {
        int[] newCuts = new int[nums.length + 2];
        newCuts[0] = 1;
        newCuts[newCuts.length - 1] = 1;
        System.arraycopy(nums, 0, newCuts, 1, nums.length);
        
        int n = nums.length;
        
        int[][] dp = new int[n + 2][n + 2];

        // Iterate from the end to the beginning
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;
                
                // Iterate through possible indices to split the array
                for (int ind = i; ind <= j; ind++) {
                    int cost = newCuts[i-1] * newCuts[ind] * newCuts[j + 1] +
                               dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}