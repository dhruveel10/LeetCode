class Solution {
        public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int col = mat[0].length;
        int m=0, n=0;
        int ans[][] = new int[r][c];
        if(r*c != rows*col)
            return mat;
        
            for(int i=0; i<rows; i++){
                for(int j=0; j<col; j++){
                    ans[m][n] = mat[i][j];
                    n++;  // we always fill columns first in any matrix. So we will here fill col till its max cap
                    if(n==c){
                        n=0;    // once col 1 is full, we go to next row and also col reset col to 0
                        m++;
                    }    
                }
            }
            return ans;
    }
}