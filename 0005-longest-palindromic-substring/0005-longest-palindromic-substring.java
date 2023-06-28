class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1)
            return "";
            
        int start = 0, end = 0;
        
        for(int i = 0; i < s.length(); i++){
            int mid1 = expandingFromMiddleElement(s, i, i);
            int mid2 = expandingFromMiddleElement(s, i, i+1);
            
            int mid = Math.max(mid1, mid2);
            
            if(mid > end - start){
                start = i - ((mid - 1)/2);
                end = i + (mid / 2);
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    static int expandingFromMiddleElement(String s, int left, int right){
        if(s == null || left > right)
            return 0;
            
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        
        return right - left - 1;
    } 
}