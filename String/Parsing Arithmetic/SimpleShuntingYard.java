import java.util.*;

public class SimpleShuntingYard {
    public static String shuntingYard(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        Map<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);

        for (char token : infix.toCharArray()) {
            if (Character.isDigit(token)) {
                postfix.append(token);
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop '('
            } else if (precedence.containsKey(token)) {
                while (!operatorStack.isEmpty()
                       && precedence.containsKey(operatorStack.peek())
                       && precedence.get(operatorStack.peek()) >= precedence.get(token)) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "3 + 4 * (2 - 1)";
        String postfix = shuntingYard(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix); // Output: 3421-*+
    }
}

/*
The Shunting Yard algorithm is a method for parsing mathematical expressions specified in infix notation. Infix notation is the common way of representing mathematical expressions, where operators are placed between operands. The Shunting Yard algorithm converts infix expressions into postfix notation, also known as Reverse Polish Notation (RPN), which is easier to evaluate using a stack-based approach.

Here's the theory behind the Shunting Yard algorithm:

1. Create two stacks: one for operators (`operatorStack`) and another for output (`outputQueue`).
2. Read each token (operand or operator) from left to right in the infix expression.
3. If the token is an operand, add it to the `outputQueue`.
4. If the token is an operator:
   a. While there are operators in the `operatorStack` with higher precedence or equal precedence and left-associativity, pop them from the stack and add to the `outputQueue`.
   b. Push the current operator onto the `operatorStack`.
5. If the token is an open parenthesis '(', push it onto the `operatorStack`.
6. If the token is a close parenthesis ')':
   a. Pop operators from the `operatorStack` and add them to the `outputQueue` until an open parenthesis '(' is encountered on the stack.
   b. Pop and discard the open parenthesis from the `operatorStack`.
7. After processing all tokens, pop any remaining operators from the `operatorStack` and add them to the `outputQueue`.

The postfix expression in the `outputQueue` can then be evaluated using a stack-based approach.

Here's a simple Java implementation of the Shunting Yard algorithm:

```java

This implementation provides a basic understanding of the Shunting Yard algorithm. Keep in mind that this example doesn't handle all possible cases, such as unary minus and functions. In a real-world scenario, you may need to enhance the algorithm to handle more complex expressions.

*/