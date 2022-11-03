/*My logic: Count array on both the Strings
Then one for loop in which you compare if(ransomNote[i] count != magazine[i]) return false
Algo is not efficient because Ill be using 3 for loops tho O(n)
*/

//Optimized Algo
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) 
            return false;
        
        int[] counter = new int[26];
        
        for (char c : magazine.toCharArray())
                counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (counter[c-'a'] == 0) return false;
                counter[c-'a']--;
        }
        return true;
    }
}