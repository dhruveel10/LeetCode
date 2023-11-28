class Solution {
    static boolean isAllStars(String S1, int i) {
        for (int j = 1; j <= i; j++) {
          if (S1.charAt(j - 1) != '*')
            return false;
        }
        return true;
      }
    
    public boolean isMatch(String S1, String S2) {
        String temp = S1;
        S1 = S2;
        S2 = temp;
        
        int n = S1.length();
        int m = S2.length();

        // Create a 2D array to store the matching results
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Initialize the first row and column based on wildcard '*' in S1
        for (int j = 1; j <= m; j++) {
          dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
          dp[i][0] = isAllStars(S1, i);
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
              dp[i][j] = dp[i - 1][j - 1]; // Characters match or '?' is encountered.
            } 
              
            else if (S1.charAt(i - 1) == '*') {              
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches one or more characters.
            }
          }
        }

        return dp[n][m]; 
    }
}