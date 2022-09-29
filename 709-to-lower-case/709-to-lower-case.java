class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 65 && c <= 90)
                ans.append((char)(c + 32));
            else
                ans.append(c);
            
        }

        return ans.toString();    
    }
}