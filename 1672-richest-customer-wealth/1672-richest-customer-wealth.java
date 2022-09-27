class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;

        for(int[] account:accounts){
            int sum = 0;
            for(int i=0; i<account.length; i++){
                sum += account[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;  
    }
}