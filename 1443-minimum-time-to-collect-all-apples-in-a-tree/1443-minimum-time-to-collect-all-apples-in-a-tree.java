class Solution {
    
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>(0));
        
        boolean[] visited = new boolean[n];
        
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        return dfs(adj, visited, hasApple, 0);
    }
    
    private int dfs(List<List<Integer>> adj, boolean[] visited, List<Boolean> hasApple, int index){
        int appleCollectiontime = 0;
        visited[index] = true;
        
        for(int i : adj.get(index))
            if(!visited[i])
                appleCollectiontime += dfs(adj, visited, hasApple, i);
        
        if(index == 0)
            return appleCollectiontime;
        
        if(hasApple.get(index) || appleCollectiontime > 0)
            appleCollectiontime += 2;
        
        return appleCollectiontime;
    }
}