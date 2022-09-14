class Solution {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int i=0;
        for(int j=0; j<n; j++){
            if(nums[j] > 0){
                ans[i] = nums[j];
                i +=2;
            }
        }

        i=1;
        for(int j=0; j<n; j++){
            if(nums[j] < 0){
                ans[i] = nums[j];
                i +=2;
            }
        }

        return ans;
    }
}