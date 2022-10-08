class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        //System.out.println(s);
        
        String[] s_string = s.split(" ");
        String ans = s_string[s_string.length-1];
        //System.out.println(ans);

        return ans.length();    
    }
}