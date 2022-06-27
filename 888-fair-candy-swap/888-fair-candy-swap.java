class Solution {
    // https://leetcode.com/problems/fair-candy-swap/discuss/687223/java-Solution-Hash-set-with-explanantion
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();

        for(int i:aliceSizes){
            sumA = sumA + i;
            set.add(i);
        }

        for(int i:bobSizes)
            sumB = sumB + i;

        for(int j:bobSizes){
            int temp = (sumA - sumB + 2*j)/2;
            if(set.contains(temp)){
                ans[0] = temp;
                ans[1] = j;
                return ans;
            }
        }
        
        return ans;           
    }
}