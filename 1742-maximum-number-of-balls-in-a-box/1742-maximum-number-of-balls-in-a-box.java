class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        //Since the range is 1 ~ 100_000, the biggest possible non-empty box number 
        //is 9 + 9 + 9 + 9 + 9 = 45, which corresponds to ball 99999
        int[] count=new int[46];
        int max=0;
        for(int i=lowLimit;i<=highLimit;i++){
            int n=i,sum=0;
            while(n>0){
                sum += n%10;
                n=n/10;
            }
            max=Math.max(max, ++count[sum]);
        }
        return max;

    }
}