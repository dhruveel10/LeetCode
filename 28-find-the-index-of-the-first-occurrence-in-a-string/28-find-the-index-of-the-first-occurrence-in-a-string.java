class Solution {
    public int strStr(String haystack, String needle) {
            for(int i=0; i<=haystack.length()-needle.length(); i++){
            int j = i + needle.length();
            String sub = haystack.substring(i, j);
            if(sub.compareTo(needle) == 0)
                return i;
        }

        return -1;    
    }
}