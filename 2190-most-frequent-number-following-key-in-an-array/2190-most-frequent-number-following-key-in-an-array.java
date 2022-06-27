class Solution {
    public int mostFrequent(int[] nums, int key) {
        int ans = 0;
        int[] freq = new int[1001];

        for(int i=0; i<nums.length-1; i++)
            if(nums[i] == key)
                freq[nums[i+1]]++;

        for(int i=1; i<freq.length; i++){
            if(freq[i] > freq[ans])
                ans = i;
        }
    
        return ans;    
    }
}