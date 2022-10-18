//https://leetcode.com/problems/smallest-range-ii/discuss/1396697/JAVA-SOLUTION-or-Fast-or-GREEDY-or
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        Arrays.sort(nums);  // Sort the array
        
        int n = nums.length;
        int ans = nums[n-1] - nums[0];  // Assume min diff to be as of now because of sorting
        int min = nums[0] + k;    // Assume min to be 0th index element
        int max = nums[n-1] - k;  // Assume max to be N-1th index element 
        
        for(int i = 0; i < n-1; i++) {          
			// Travel and find Max and Min in ith and i+1th indexes
            int mx = Math.max(max, nums[i] + k);       // Just maximize the ith index element 
		    int mi = Math.min(min, nums[i+1] - k);     // Just minimize the i+1th index element
            ans = Math.min(ans, mx - mi);   // just compare mx - mi with previous answer 
        }
        return ans;
    }
}