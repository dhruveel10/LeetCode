class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashMap = new HashSet<>();        
        
        for(int i=0; i<nums.length; i++){
            if(hashMap.contains(nums[i])){
                return true;
            }
            else{
                hashMap.add(nums[i]);
            }
        }
        return false;
    }
}