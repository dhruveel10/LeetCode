class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] ans = new char[word1.length() + word2.length()];
        int s1 = 0, s2 = 0, index = 0;

        while(s1 < word1.length() && s2 < word2.length()){
            ans[index] = word1.charAt(s1);
            index++;
            s1++;
            ans[index] = word2.charAt(s2);
            index++; 
            s2++;
        }

        while(s1 < word1.length()){
            ans[index++] = word1.charAt(s1++);
        }

        while(s2 < word2.length()){
            ans[index++] = word2.charAt(s2++);
        }

        return String.valueOf(ans);   
    }
}