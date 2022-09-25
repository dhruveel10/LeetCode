class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE, index = -1;
        for(int i=0; i<points.length; i++){
            if (x==points[i][0] ||  y==points[i][1]){
                int temp = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if(temp < ans){
                    ans = temp;
                    index = i;
                }
            }
        }
        
        return index;  
    }
}