class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
            //we are using this instead of a[1] - b[1] to protect overflow condition
        
        int c=1;
        int l=points[0][1];
        
        for(int i=1; i<points.length; i++){
            if(points[i][0] > l){
                c++;
                l = points[i][1];
            }
        }
        
        return c;
    }
}