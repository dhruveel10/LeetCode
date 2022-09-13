class Solution {
    public static int numberOfBeams(String[] bank) {
        int sum = 0;
        int prev = 0;
        
        for(String s:bank){
            int count = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1')
                    count++;
            }

            if(count > 0){
                sum += prev * count;
                prev = count;
            }
        }
        return sum;
    }
}