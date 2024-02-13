class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] pair1, int[] pair2) ->
            pair1[1] - pair2[1]           
        );
        
        int length = 1;
        int end = pairs[0][1];
        
        for(int i = 1; i < pairs.length; i++){
            if(end < pairs[i][0]){
                length++;
                end = pairs[i][1];
            }
        }
        
        return length;
    }
}