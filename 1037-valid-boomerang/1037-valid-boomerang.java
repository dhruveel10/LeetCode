class Solution {
    public boolean isBoomerang(int[][] points) {
                int x1 = points[0][0], x2 = points[1][0], x3 = points[2][0];
        int y1 = points[0][1], y2 = points[1][1], y3 = points[2][1];

        // if(((y2-y1)/(x2-x1)) == ((y3-y2)/(x3-x2)))   
        //     return false;

        // above method will may give divide by 0 error so
         if(((y2-y1)*(x3-x2)) == ((y3-y2)*(x2-x1)))
             return false;

        return true;
    
    }
}