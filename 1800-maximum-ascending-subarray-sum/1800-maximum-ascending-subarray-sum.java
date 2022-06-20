class Solution {
    public int maxAscendingSum(int[] nums) {
        int currentSum=0, maxSum=0;
        
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i] > nums[i-1]){
                currentSum = Math.max(currentSum, currentSum + nums[i]);        
                maxSum = Math.max(currentSum, maxSum);
            }
            else{
                currentSum=nums[i];
            }
        }
        return maxSum;
    }
}