package th.co.geniustree.intern.infixsuffix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author pramoth
 */
public class InfixToSuffixConverter {

    public String[] chageToPostfix(String[] infixTokens) {
        List<String> postfixToken = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();
        for (String token : infixTokens) {
            if (Character.isLetterOrDigit(token.charAt(0))) {
                postfixToken.add(token);
            } else if (token.equals(")")) {
                popUntilLeftOperand(postfixToken, operatorStack);
            } else if (token.equals("(")) {
                operatorStack.add(token);
            } else {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(") && !precedanceHigherThan(token, operatorStack.peek())) {
                    postfixToken.add(operatorStack.pop());
                }
                operatorStack.add(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixToken.add(operatorStack.pop());
        }
        return postfixToken.toArray(String[]::new);
    }

    private void popUntilLeftOperand(List<String> postfixToken, Stack<String> operatorStack) {
        while (true) {
            String pop = operatorStack.pop();
            if (pop.equals("(")) {
                break;
            }
            postfixToken.add(pop);
        }
    }

    private boolean precedanceHigherThan(String token, String peek) {
        return getPreedence(token) > getPreedence(peek);
    }

    private int getPreedence(String token) {
        if (token.contains("+") || token.contains("-")) {
            return 1;
        }
        if (token.contains("*") || token.contains("/")) {
            return 2;
        }
        return 0;
    }
}
