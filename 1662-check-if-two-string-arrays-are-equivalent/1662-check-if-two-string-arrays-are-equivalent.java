class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = "", str2 = "";
        
        for(String s: word1)
            str1 += s;
        
        //System.out.println(str1);
        
        for(String s: word2)
            str2 += s;
        
        //System.out.println(str1);
        
        if(str1.equals(str2))
            return true;
        else
            return false;
    }
}