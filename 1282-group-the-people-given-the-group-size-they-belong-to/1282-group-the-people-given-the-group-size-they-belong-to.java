//https://youtu.be/xZsmqXdPaIc

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        //[3,3,3,3,3,1,3] - groupSizes
        //[0,1,2,3,4,5,6] - people/indexes
        //Map<group size, people with that size> so for map<3, [0,1,2,3,4,6]> and map<1,5>

        for(int i=0; i<groupSizes.length; i++){
            int person = i; //person = index
            int groupSize = groupSizes[i];

            List<Integer> group = map.getOrDefault(groupSize, new ArrayList<>());
            group.add(person);
            map.put(groupSize, group);

            if(group.size() == groupSize){
                ans.add(group);
                map.remove(groupSize);
            }
        }

        return ans;    
    }
}