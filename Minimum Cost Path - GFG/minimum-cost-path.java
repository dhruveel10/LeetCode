//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class tuple { 
    int first, second, third; 
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int[] source = {0,0};
        int[] destination = {n-1,n-1};
        
        
        if(source[0] == destination[0] && 
           source[1] == destination[1]) return 0;
           
        PriorityQueue<tuple> q = new PriorityQueue<tuple>((x,y) -> (x.first - y.first));
        
        int[][] dist = new int[n][n]; 
        for(int i = 0;i<n;i++) {
            for(int j =0;j<n;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0] = grid[0][0]; 
        q.add(new tuple(grid[0][0], source[0], source[1]));
        
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            tuple it = q.peek(); 
            //System.out.println(it.first);
            q.remove(); 
            int dis = it.first; 
            int r = it.second; 
            int c = it.third; 
            
            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for(int i = 0;i<4;i++) {
                int newr = r + dr[i]; 
                int newc = c + dc[i]; 
                
                // Checking the validity of the cell and updating if dist is shorter.
                if(newr >= 0 && newr < n && newc >= 0 && newc < n && dis + grid[newr][newc] < dist[newr][newc]) {
                    dist[newr][newc] = grid[newr][newc] + dis; 

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if(newr == destination[0] && newc == destination[1]) 
                        return dis + grid[newr][newc]; 
                        
                    q.add(new tuple(grid[newr][newc]+dis, newr, newc)); 
                }
            }
        }
        
        return -1;
    }
}