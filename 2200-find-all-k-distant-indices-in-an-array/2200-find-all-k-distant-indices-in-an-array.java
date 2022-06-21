class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List <Integer> id = new ArrayList <> ();
        for(int i=0; i<nums.length; ++i){
            if(nums[i] == key){
                id.add(i);
            }
        }  
        
        List <Integer> res = new ArrayList <> ();
        
        for(int i=0; i<nums.length; ++i)
            for(int j=0; j<id.size(); ++j){
            
                if(Math.abs(i - id.get(j)) <= k){
                    
                    res.add(i);
                    break;
                    
                }
               
        }
        
        return res;
    }
}