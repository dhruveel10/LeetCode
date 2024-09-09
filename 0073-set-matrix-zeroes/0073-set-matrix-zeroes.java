class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++)
                if(matrix[i][j] == 0){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    temp.add(t);
                }
        
        int[] rows = new int[temp.size()];
        int[] col = new int[temp.size()];
        
        for(int i = 0; i<temp.size(); i++){
            ArrayList<Integer> t= temp.get(i);
            rows[i] = t.get(0);
            col[i] = t.get(1);
        }
        
        for(int i: rows){
            for(int j=0; j<m; j++)
                matrix[i][j] = 0;
        }
        
        for(int i=0; i<n; i++){
            for(int j:col)
                matrix[i][j] = 0;
        }
                
    }
}
