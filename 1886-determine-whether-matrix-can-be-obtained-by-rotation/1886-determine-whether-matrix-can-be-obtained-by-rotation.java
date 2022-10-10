class Solution {
    public static boolean findRotation(int[][] mat, int[][] target) {
    int n = mat.length;
        boolean []res = new boolean[4];
        Arrays.fill(res, true);
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] !=target[i][j]) res[0] = false; // 0
                if(mat[i][j] != target[n-j-1][i]) res[1] = false; // 90
                if(mat[i][j] != target[n-i-1][n-j-1]) res[2] = false; // 180
                if(mat[i][j] != target[j][n-i-1]) res[3] = false; // 270
            }
        }
        return res[0] || res[1] || res[2] || res[3];
        
/*        for(int i=0; i<4; i++){
            if(Arrays.deepEquals(mat, target))
                return true;
                
            System.out.println(i);
            rotateMatrix(mat);
        }
        return false;
    }

    private static int[][] rotateMatrix(int[][] mat) {
        int n = mat.length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                int temp = mat[i][j]; 
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int k = 0; k<n/2; k++){
                int temp = mat[i][k]; 
                mat[i][k] = mat[i][n-1-k];
                mat[i][n-1-k] = temp;
            }

        }
        return mat;
    }
*/
    }
}