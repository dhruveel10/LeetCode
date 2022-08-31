class Solution {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        char[] c = boxes.toCharArray();
        
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<i+n; j++){
                int temp = (i+j)%n;

                if(c[temp] == '1'){
                    sum = sum + Math.abs((temp - i)) ;
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}