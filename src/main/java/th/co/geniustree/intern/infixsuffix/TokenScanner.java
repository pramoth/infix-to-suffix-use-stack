package th.co.geniustree.intern.infixsuffix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pramoth
 */
public class TokenScanner {

    public String[] createTokensArray(String infixExpression) {
        //replace all whitespace
        infixExpression = infixExpression.replaceAll("\\s+", "");
        List<StringBuilder> tokens = new ArrayList<>();
        char[] charArrays = infixExpression.toCharArray();
        char previous = 0;
        for (char c : charArrays) {
            if (Character.isDigit(c)) {
                if (Character.isDigit(previous)) {
                    tokens.get(tokens.size() - 1).append(c);
                } else {
                    StringBuilder str = new StringBuilder();
                    str.append(c);
                    tokens.add(str);
                }
            } else {
                StringBuilder str = new StringBuilder();
                str.append(c);
                tokens.add(str);
            }
            previous = c;
        }
        return tokens.stream().map(e -> e.toString()).toArray(String[]::new);
    }

    private int fetchMoreDigitIfAny(String infixExpression, int charactorIndex, StringBuilder token) {
        while (true) {
            if ((charactorIndex + 1) < infixExpression.length()) {
                charactorIndex = charactorIndex + 1;
                char c = infixExpression.charAt(charactorIndex);
                if (Character.isDigit(c)) {
                    token.append(c);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return charactorIndex;
    }
}
