package th.co.geniustree.intern.infixsuffix;

import java.util.Stack;

/**
 *
 * @author pramoth
 */
public class TheStackMachine {

    public int execute(String[] postfix) {
        Stack<Integer> operandStack = new Stack<>();
        for (String token : postfix) {
            if (isOperator(token)) {
                Integer rightOperand = operandStack.pop();
                Integer leftOperand = operandStack.pop();
                switch (token) {
                    case "+":
                        operandStack.push(leftOperand + rightOperand);
                        break;
                    case "-":
                        operandStack.push(leftOperand - rightOperand);
                        break;
                    case "*":
                        operandStack.push(leftOperand * rightOperand);
                        break;
                    case "/":
                        operandStack.push(leftOperand / rightOperand);
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                operandStack.push(Integer.parseInt(token));
            }
        }
        return operandStack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
