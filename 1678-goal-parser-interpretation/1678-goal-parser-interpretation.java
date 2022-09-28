class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<command.length(); i++){
            if(command.charAt(i) == 'G')
                ans.append("G");

            if(i < command.length() - 1 && command.charAt(i) == '(' && command.charAt(i+1) == ')')
                ans.append("o");
            
            if(i < command.length() - 1 && command.charAt(i) == '(' && command.charAt(i+1) != ')')
                ans.append("al");
            
        }

        return ans.toString();    
    }
}