//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    // Function to return a list containing the DFS traversal of the graph.
    public int numIslands(char[][] grid) {
        //boolean array to keep track of visited vertices
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    bfs(i, j, vis, grid);
                }
            
        
        return count;
    }
    
    
    void bfs(int i, int j, int[][] vis, char[][] grid){
        vis[i][j] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty()){
            int[] temp = q.peek();
            int row = temp[0];
            int col = temp[1];
            q.remove();
            
            //traversing the neighbours to check if land or water
            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                            vis[nrow][ncol] = 1;
                            q.add(new int[] {nrow, ncol});
                                    
                    }
                }
            }
        } 
    }
}