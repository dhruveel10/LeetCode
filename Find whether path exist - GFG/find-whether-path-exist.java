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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
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
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int[] source = new int[2];
        int[] destination = new int[2];
        
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    source[0] = i;
                    source[1] = j;
                }
                
                if(grid[i][j] == 2){
                    destination[0] = i;
                    destination[1] = j;
                }
                    
            }
            

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<tuple> q = new LinkedList<>();  
        int m = grid[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0. 
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[source[0]][source[1]] = 0; 
        q.add(new tuple(0, source[0], source[1])); 

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have 
        // in a direction.
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
 
        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(!q.isEmpty()) {
            tuple it = q.peek(); 
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
                if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                 && dis + 1 < dist[newr][newc] &&(grid[newr][newc] == 3 || grid[newr][newc] == 2)) {
                    dist[newr][newc] = 1 + dis; 

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if(newr == destination[0] && 
                       newc == destination[1]) return true; 
                    q.add(new tuple(1+dis, newr, newc)); 
                }
            }
        }
        // If no path is found from source to destination.
        return false;
    }
}