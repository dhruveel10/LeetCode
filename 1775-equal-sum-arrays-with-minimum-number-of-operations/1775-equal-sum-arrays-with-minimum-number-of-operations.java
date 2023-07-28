class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int mSum = 0, nSum = 0;
        for (int num1 : nums1)
            mSum += num1;
        for (int num2 : nums2)
            nSum += num2;

        int diff = mSum - nSum;
        if (diff == 0)
            return 0;

        if (diff > 0)
            return getMinOps(nums1, nums2, diff);
        else
            return getMinOps(nums2, nums1, -diff);
    }

    private int getMinOps(int[] nums1, int[] nums2, int diff) {
        int[] count = new int[6];
        for (int num1 : nums1)
            count[num1-1]++;
        for (int num2 : nums2)
            count[6-num2]++;

        int minOps = 0;
        for (int i=5; i>0; i--) {
            if (diff <= 0) break;
            if (diff != 0) {
                if (count[i] != 0) {
                    int tempMinOps = Math.min(count[i], diff/i + ((diff%i != 0) ? 1 : 0));
                    diff -= i * tempMinOps;
                    minOps += tempMinOps;
                }
            }
        }
        if (diff > 0)
            minOps = -1;
        return minOps;
    }
}