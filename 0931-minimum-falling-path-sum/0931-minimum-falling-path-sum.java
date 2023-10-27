class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int j = 0; j<m; j++)
            dp[0][j] = matrix[0][j];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int up = matrix[i][j] + dp[i-1][j];
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if(j-1 >= 0)
                    left = matrix[i][j] + dp[i-1][j-1];
                if(j+1 < m)
                    right = matrix[i][j] + dp[i-1][j+1];
                
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }
        
        int min = dp[n-1][0];
        
        for(int j = 1; j<m; j++)
            min = Math.min(dp[n-1][j], min);
        
        return min;
    }
}