class Solution {
    public int findLucky(int[] arr) {
        int currenLucky = 0, maxLucky = 0;
        int[] freq = new int[501];

        for(int i=0; i<arr.length; i++)
            freq[arr[i]]++;

        for(int i=0; i<freq.length; i++){
            if(freq[i] == i){
                currenLucky = i;
                maxLucky = Math.max(currenLucky, maxLucky);
            }
            
        }

        if(maxLucky > 0)
            return maxLucky;
        else return -1;    
    }
}