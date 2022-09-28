class Solution {
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        if(n==1)
            return mat[0][0];

        if(n==2){
            return mat[0][1] + mat[0][0] + mat[1][0] + mat[1][1];
        }

        if(n%2 != 0){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j)
                        sum += mat[i][j] + mat[i][n-1-i];;
                }
            }
            return sum-mat[n/2][n/2];
        }

        if(n%2 == 0){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j)
                        sum += mat[i][j] + mat[i][n-1-i];
                }
            }
            return sum;
        }

        return 0;
    }
}