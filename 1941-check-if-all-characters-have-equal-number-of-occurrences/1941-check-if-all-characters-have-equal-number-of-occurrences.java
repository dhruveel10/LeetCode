class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        
		// we get the frequency of the first letter in the string (or any letter in the string, it doesn't matter)
        int prev = freq[s.charAt(0) - 'a'];
        
		// Compare non-zero frequencies to the frequency of the first letter
        for(int num: freq){
		    if(num != 0 && num != prev){
                return false;
            }
        }
        
		return true;    
    }
}