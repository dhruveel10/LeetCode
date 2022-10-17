class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //TOO SLOW. TIMEOUT 
/*        List<Integer> ans = new ArrayList<>();
        int n = p.length();
        
        char[] c2 = p.toCharArray();
        Arrays.sort(c2);
        String s2 = new String(c2);
                
        
        for(int i = 0; i<=s.length()-n; i++){
            String temp = s.substring(i,n+i);
            char[] c1 = temp.toCharArray();
            
            Arrays.sort(c1);
            
            String s1 = new String(c1);
            
            if(s1.equals(s2))
                ans.add(i);       
        }
        return ans;
*/    
        
        List<Integer> result = new ArrayList();
        
        if(s.length() == 0 || s == null) return result;
        
        int[] char_counts = new int [26];

        for (char c : p.toCharArray()) 
        char_counts[c-'a']++;

        int left = 0;
        int right = 0;
        int count = p.length();
        
        while (right < s.length()) {
            if (char_counts[s.charAt(right++)-'a'] -- >= 1) 
                count--;

            if (count == 0) 
                result.add(left);

            if (right - left == p.length() && char_counts[s.charAt(left++)-'a']++ >= 0)
                count++;
        }
        return result;
    } 
}