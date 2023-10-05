class Solution {
    public String largestNumber(int[] nums) {
        String ans = "";
        
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                StringBuilder a = new StringBuilder();
                a.append(nums[i]);
                a.append(nums[j]);
                StringBuilder b = new StringBuilder();
                b.append(nums[j]);
                b.append(nums[i]);
                
                // System.out.println(a);
                // System.out.println(b);
                // System.out.println(a.compareTo(b));
                    
                if(a.compareTo(b) < 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }      
            }
        }
        
        int temp = 0;
        for(int i: nums){
            temp += i;
            ans += String.valueOf(i);
        }
        
        if(temp == 0)
            return "0";
        
        return ans;
    }
}