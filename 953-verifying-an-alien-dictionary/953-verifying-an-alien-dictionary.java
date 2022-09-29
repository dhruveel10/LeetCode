class Solution {
    public static int[] map = new int[26];
    public static boolean isAlienSorted(String[] words, String order) {
        
        for(int i=0; i<order.length(); i++)
            map[order.charAt(i) - 'a'] = i;
        
        for(int i=1; i<words.length; i++)
            if(compare(words[i-1], words[i]) > 0)   return false;
        
        return true;
    }
    private static int compare(String string, String string2) {
        int i=0, j=0, char_compare_val = 0;

        while(i < string.length() && j < string2.length() && char_compare_val == 0){
            char_compare_val = map[string.charAt(i) - 'a'] - map[string2.charAt(j) - 'a'];
            i++;
            j++;
        }

        if(char_compare_val == 0)
            return string.length() - string2.length();
        else
            return char_compare_val;
    }
}