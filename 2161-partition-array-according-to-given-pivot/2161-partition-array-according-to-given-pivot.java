class Solution {
        public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < pivot){
                result[left] = nums[i];
                left++;
            }
            if(nums[nums.length-1-i] > pivot){    //to check from behind
                result[right] = nums[nums.length-1-i];
                right--;
            }
        }

        //the above loop does not place pivot and copies of it. So for that we iterate and fill the empty space
//with pivot element. NOTE we do not change left and right so that continue from where we left above
        while(left<=right){
            result[left] = pivot;
            result[right] = pivot;
            left++;
            right--;
        }

        return result;
    }

}