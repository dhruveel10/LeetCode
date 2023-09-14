class tuple { 
    int first, second, third; 
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[] source = {0, 0};
        int[] destination = {n-1, n-1};
        
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }
        
        if(source[0] == destination[0] && source[1] == destination[1])
            return 1;
        
        Queue<tuple> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                dist[i][j] = (int)(1e9);
        
        dist[source[0]][source[1]] = 0;
        q.add(new tuple(0, source[0], source[1]));
        
        int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        while(!q.isEmpty()){
            tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int r = it.second;
            int c = it.third;
            
            for(int i = 0; i<8; i++){
                int newr = r + dr[i];
                int newc = c + dc[i];
                
                if(newr >= 0 && newr < n && newc >= 0 && newc < n 
                && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis; 

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if(newr == destination[0] && newc == destination[1])
                        return dis + 2; 
                    
                    
                    q.add(new tuple(1+dis, newr, newc)); 
                }
            }
        }
        
        return -1;
    }
}