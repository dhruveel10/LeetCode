class Solution {
    public String freqAlphabets(String s) {
        StringBuilder output = new StringBuilder(); //used stringbuiled append b/c it's optimized
        
        for(int i = s.length()-1; i >= 0; i--){ 
            if(s.charAt(i) == '#'){
                output.append((char)('a' + (s.charAt(i-1) -'0' ) + 10*(s.charAt(i-2)-'0') -1) ); 
//using ascii, add 'a' to start from the alphabet, subtract '0' b/c currently the digits in the String s are chars
                
                i -= 2; //have skip 2 characters , b/c we already checked it in the above line
            } 
            else 
                output.append((char)('a' + (s.charAt(i) - '0') -1));
        }
        output.reverse(); 
        
        return output.toString();    
    }
}