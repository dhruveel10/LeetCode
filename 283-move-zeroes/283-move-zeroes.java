class Solution {
    public void moveZeroes(int[] nums) {
         if (nums == null || nums.length == 0) return;        

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        
        /* TAKES TOO MUCH TIME. PROBABLY BECAUSE OF SWAP FN CALL
        if(nums.length==1)
                return;
                
            int left=0, right=0;
            while(right<nums.length){
                if(nums[right]==0)
                        right++;
                else{
                    swap(nums, left, right);
                    right++;
                    left++;
                }
                
            }
            for(int i=0; i<nums.length; i++)
            System.out.println(nums[i]);       
    }
    
    static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }*/


    }
}    
