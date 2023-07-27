class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        
        Collections.sort(list, (a,b) ->{
             return map.get(b) - map.get(a);
        });
        
        int result[] = new int[k];
        int index = 0;
        
        for(int num:list){
            if(k == 0){
                return result;
            }
            if(index < k)
                result[index++] = num;
        }
        
        return result;
    }
}