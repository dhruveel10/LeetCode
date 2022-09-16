class Solution {
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, HashSet<Integer>>map = new HashMap();

        for(int[] log:logs){
            //log[][] so id will have log[0][] and time - log[][1]
            int id = log[0];    
            int time = log[1];

            if(!map.containsKey(id))
                map.put(id, new HashSet<>());

            map.get(id).add(time);
        }

        for(int id: map.keySet()){
            int UAM = map.get(id).size();
            ans[UAM - 1] ++;
        }

        return ans;
    }

}