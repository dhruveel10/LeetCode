class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;
        Map <Integer, Integer> times = new HashMap<>();

        for(int i = 0; i<manager.length; i++)
            result = Math.max(result, dfs(i,manager,informTime,times));

        return result;
    }

    private static int dfs(int i, int[] manager, int[] informTime, Map<Integer, Integer> times) {
        if(manager[i] == -1)
            return 0;
        
        if(times.containsKey(i))
            return times.get(i);
        
        times.put(i, informTime[manager[i]] + dfs(manager[i], manager, informTime, times));
        
        return times.get(i);
    }
}