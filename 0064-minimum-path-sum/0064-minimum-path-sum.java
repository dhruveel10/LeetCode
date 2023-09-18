

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        // Initialize the first row and first column.
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Fill in the rest of the dp array.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Choose the minimum path sum from the top or left.
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // The value in the bottom-right cell represents the minimum path sum.
        return dp[m - 1][n - 1];
    }
}
