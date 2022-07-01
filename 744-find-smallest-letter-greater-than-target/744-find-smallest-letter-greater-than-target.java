class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(int i=0; i<letters.length; i++)
            if(letters[i]-'a' > target-'a')
                return letters[i];
        if(target-'a' >= letters[letters.length-1]-'a')
            return letters[0];
        
        return 'a';    
    }
}