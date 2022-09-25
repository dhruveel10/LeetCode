class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(n != 1){
            int digit = n;
            int sum = 0;
            while(digit != 0){
                sum += (digit%10) * (digit%10);
                digit /= 10;
            }
            if(seen.contains(sum))
                return false;

            seen.add(sum);
            n = sum;
        }

        return true;    
    }
}