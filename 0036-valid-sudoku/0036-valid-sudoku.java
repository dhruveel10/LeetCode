class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>(); // instead of using Integer, we use String for a particular reason
            
        for(int i=0; i<9; i++){
           for(int j=0; j<9; j++){
               char curr_val = board[i][j];
                if(curr_val != '.'){
// Add method can also be used like this to check for Duplicates. 
//Since by adding "Foun..." we create each seperate entry and we can check for each row and this is why we used String
                    if(!seen.add(curr_val + "Found in row" + i) || !seen.add(curr_val + "Found in col" + j) ||
                    !seen.add(curr_val + "Found in subbox" + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        
        return true;                       
    }
}