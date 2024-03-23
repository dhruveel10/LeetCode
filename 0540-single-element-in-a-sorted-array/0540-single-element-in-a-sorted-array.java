class Solution {
    int find(int low, int high, int[] nums){

        while( low < high ){
            int mid = (low + high)/2;
            // System.out.println(mid);
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid-1]) return mid;
            
            // if current mid index is even 
            if(mid%2 == 0){
                // required index on right side
                if( nums[mid+1] == nums[mid] ){
                    low = mid + 1;
                }
                // required index on left side
                else if( nums[mid-1] == nums[mid] ){
                    high = mid;
                }
            }
            
            // if current mid index is odd
            else{
                // required index on right side
               if( mid%2==1 && nums[mid-1] == nums[mid] ){
                    low = mid + 1;
                }
                // required index on left side
                else if( mid%2 ==1 && nums[mid+1] == nums[mid] ){
                    high = mid;
                }             
            }
        }
        return -1;

    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];

        else{
            // if the number is at either of the extreme indices
            if(nums[0]!=nums[1]) return nums[0];
            if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

            int low = 0;
            int high = nums.length-1;
            // finding the required index
            int index =  find(low, high, nums);
            return nums[index];
        }
       
    }
}