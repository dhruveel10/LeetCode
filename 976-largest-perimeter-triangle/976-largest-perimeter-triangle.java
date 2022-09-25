class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; i--){
            int j=i-1, k=i-2;
            if(nums[i]+nums[j]>nums[k] && nums[k]+nums[j]>nums[i] && nums[k]+nums[i]>nums[j])
                return nums[i]+nums[j]+nums[k];
        }
        
        return 0;   
    }
}