class Solution {
    
    public boolean dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visit, 
                    boolean[] dfsVisit, Queue<Integer> q){
        visit[curr] = true;
        dfsVisit[curr] = true;
        
        for(Integer v : adj.get(curr)){
            if(!visit[v]){
                if(dfs(v, adj, visit, dfsVisit, q)) return true;
            }
            else if(dfsVisit[v]) return true;
        }
        
        q.add(curr);
        dfsVisit[curr] = false;
        return false;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList());
        for(int[] e : prerequisites) adj.get(e[0]).add(e[1]);
        
        boolean[] visit = new boolean[numCourses];
        boolean[] dfsVisit = new boolean[numCourses];
        Queue<Integer> q = new LinkedList();
        
        for(int i=0;i<numCourses;i++){
            if(!visit[i]){
                if(dfs(i, adj, visit, dfsVisit, q)) return new int[0];
            }
        }
        
        int[] res = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()) res[i++] = q.remove();
        return res;
    }
}