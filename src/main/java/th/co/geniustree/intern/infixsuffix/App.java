package th.co.geniustree.intern.infixsuffix;

import java.util.Arrays;

/**
 *
 * @author pramoth
 */
public class App {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("use: java th.co.geniustree.intern.infixsuffix.App \"(10-2/(4+5)*6)\" ");
        }
        // Compile the infix to postfix
        String[] postfixTokens = compileInfixExpression(args);
        
        System.out.println();

        // Use the stack machine to execute postfix
        TheStackMachine stackMachine = new TheStackMachine();
        int execute = stackMachine.execute(postfixTokens);
        System.out.println("======================= result =======================");
        System.out.println(execute);
        System.out.println("======================= result =======================");
    }

    private static String[] compileInfixExpression(String[] args) {
        System.out.println("======================================================");
        String infixExpression = args[0];
        System.out.println("infix expression string = " + infixExpression);

        // Before compile we must scan for each token into array.
        TokenScanner tokenScanner = new TokenScanner();
        String[] tokens = tokenScanner.createTokensArray(infixExpression);
        System.out.println("infix expression tokens:" + Arrays.toString(tokens));

        // convert infix array to posyfix array
        InfixToSuffixConverter infixToSuffixConverter = new InfixToSuffixConverter();
        String[] postfixTokens = infixToSuffixConverter.chageToPostfix(tokens);
        System.out.println("postfix expression tokens:" + Arrays.toString(postfixTokens));
        System.out.println("======================================================");
        return postfixTokens;
    }

}
