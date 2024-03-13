class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int[][] dp= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]= 0;
            }
        }
        
        int ans= 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans= Math.max(ans, solve(mat,i,j,m,n,dp));
            }
        }
        
        return ans;
    }
    
    public int solve(int[][] grid, int i, int j, int m, int n, int[][] dp){
        if(i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        
        int f1=1, f2=1, f3=1, f4=1;
        
        if( i<m-1 && grid[i+1][j]>grid[i][j]){
            f1= 1+solve(grid,i+1,j,m,n,dp);
        }
        if(i>0 && grid[i-1][j]>grid[i][j]){
            f2=  1+solve(grid,i-1,j,m,n,dp);
        }
        if(j<n-1 && grid[i][j+1]>grid[i][j]){
            f3= 1+solve(grid,i,j+1,m,n,dp);
        }
        if(j>0 && grid[i][j-1]>grid[i][j]){
            f4= 1+solve(grid,i,j-1,m,n,dp);
        }
        
        return dp[i][j]= Math.max(Math.max(f1,f2), Math.max(f3,f4));
    }
}