class Solution {
    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char currentCharacter = s.charAt(i);
            if(map.containsKey(currentCharacter)){
                //currentCharacter is an opening bracket
                stack.push(map.get(currentCharacter));
            }else if(stack.size()>0 && stack.peek() == currentCharacter){
                //currentCharacter is a closing bracket and currentCharacter
                // match with top of the stack
                stack.pop();
            }else{
                //currentCharacter is a closing bracket and currentCharacter
                // not match with top of the stack
                return false;
            }
        
        }

        return stack.isEmpty()? true: false;
    }
}


// Approach1: Use Stack
// Complexity
// Time complexity: O(n) - Balanced Paranthesis