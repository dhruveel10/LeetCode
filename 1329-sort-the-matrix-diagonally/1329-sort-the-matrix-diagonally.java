class Solution {
    public static int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        //for row 0
        for(int j=0; j<m; j++){
            sort(mat, 0, j, m, n);
        }
        
        //for col 0
        for(int i=1; i<n; i++){
            sort(mat, i, 0, m, n);
        }
        return mat;
    }

    public static void sort(int[][] mat, int row, int col, int m, int n){
        int r = row, c = col;
        //List<Integer> values = new ArrayList<>(); extra space and slowers the process so we will counting sort
        //because we know the limit is 100 so we can use counting sort.

        int[] values = new int[101];
        while(r<n && c<m){
            //values.add(mat[r][c]);    needed for list solution
            values[mat[r][c]]++;
            r++;
            c++;
        }

        r=row;
        c=col;

        for(int i=1; i<101; i++){
            if(values[i] > 0){
                int count = values[i];
                while(count --> 0){
                    mat[r][c] = i;
                    r++;
                    c++;
                }
            }
        }

        //everything below is for List solution
        // int index = 0;
        // while(r<n && c<m){
        //     mat[r][c] = values.get(index);
        //     r++;
        //     c++;
        //     index++;
        // }
    }
}