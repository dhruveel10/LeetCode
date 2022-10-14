class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;        
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            boolean bool = false;

            for(int left = i+1; left<n; left++){
                if(bool == true)
                    break;
                if(bool == false && nums[left] > nums[i]){
                    ans[i] = nums[left];
                    bool = true;
                }
            }
            if(bool == false){
                for(int right = 0; right<=i; right++){
                    if(bool == true)
                        break;
                    
                    if(right == i)
                        ans[i] = -1;
            
                    if(bool == false && nums[right] > nums[i]){
                        ans[i] = nums[right];
                        bool = true;
                    }
                }
            } 
            
        }
        return ans; 
    }
}