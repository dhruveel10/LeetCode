class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c: expression.toCharArray()) {
            // Dont pass Open Bracket and comma to stack. 
            if(c == '(' || c == ',') {
                continue;
            } 
            // If Closing Bracket Evaluate Stack till latest operator
            if(c == ')') {
                // True and False variables to Know truth Value
                boolean True = false, False = false;
                // Get Truth Values till latest operator
                while(stack.peek() == 't' || stack.peek() == 'f') {
                    if(stack.pop() == 't') {
                        True = true;
                    } else {
                        False = true;
                    }
                }
                char operator = stack.pop(), result;
                if(operator == '&') {
                    // One false in AND operation is always false
                    result = False ? 'f' : 't';
                } else if(operator == '|') {
                    // One true in OR operation is always true
                    result = True ? 't' : 'f';
                } else {
                    // Simple Negation
                    result = True ? 'f' : 't';
                }
                // Push Back the result of evaluation
                stack.push(result);
                continue;
            }
            stack.push(c);
        }
        return stack.pop() == 't' ? true : false;
    }
}