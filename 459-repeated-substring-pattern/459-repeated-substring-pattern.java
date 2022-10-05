class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = s.length()/2; i>0; i--){
            if(len%i == 0){
                int m = len/i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                for(int j = 0; j<m; j++)
                    sb.append(sub);
                
                if(sb.toString().equals(s))
                    return true; 
            }
        }

        return false;    
    }
}