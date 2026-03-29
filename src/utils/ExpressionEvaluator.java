package utils;

import exceptions.IncorrectExpressionException;
import java.util.ArrayList;
import java.util.List;

/**
 * Evaluates a mathematical expression string and returns the result.
 * Supports +, -, *, /, ^ with correct operator precedence.
 */

public class ExpressionEvaluator {

    /** Token list produced by the tokenizer. */
    private List<String> tokens;

    /** Current position in the token list. */
    private int position;

    /**
     * Evaluates the given expression and returns the result.
     *
     * @param expression the math expression string
     * @return the numeric result
     * @throws IncorrectExpressionException if the expression is invalid
     */
    public double evaluate(String expression) throws IncorrectExpressionException {
        this.tokens = tokenize(expression);
        this.position = 0;
        return evaluateAddSub(); // the result is stored here since + & - have the lowest precedence
    }

    /**
     * Tokenizes the expression into numbers and operators.
     *
     * @param expression the expression string
     * @return list of tokens
     */
    private List<String> tokenize(String expression) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            //skipping whitespace characters
            if (Character.isWhitespace(ch)) {
                i++;
                continue;
            }

            // if current character is a digit, read the full number
            if (Character.isDigit(ch)) {
                StringBuilder numberBuilder  = new StringBuilder();

                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numberBuilder.append(expression.charAt(i++));
                }

                // reading the decimal numbers
                if (i < expression.length() && expression.charAt(i) == '.') {
                    numberBuilder.append(expression.charAt(i++));
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        numberBuilder.append(expression.charAt(i++));
                    }
                }
                result.add(numberBuilder.toString());
                continue;
            }

            //operations
            if ("+-*/^".indexOf(ch) >= 0) {
                result.add(String.valueOf(ch));
                i++;
                continue;
            }

            i++;
        }
        return result;
    }

    /**
     * Evaluates addition(+) and subtraction(-) expressions.
     *
     * @return the result
     * @throws IncorrectExpressionException on error
     */
    private double evaluateAddSub() throws IncorrectExpressionException {
        // get the left side first
        double left = evaluateMultiDiv();

        // keep reading + and - operators
        while (position < tokens.size()) {
            String op = tokens.get(position);

            if (op.equals("+") || op.equals("-")) {
                position++;
                double right = evaluateMultiDiv();

                if (op.equals("+")) {
                    left = left + right;
                } else {
                    left = left - right;
                }
            } else {
                // not a + or -, stop
                break;
            }
        }

        return left;
    }

    /**
     * Evaluates multiplication(*) and division(/) expressions.
     *
     * @return the result
     * @throws IncorrectExpressionException on division by zero or error
     */
    private double evaluateMultiDiv() throws IncorrectExpressionException {
        // get the left side first
        double left = evaluatePower();

        // keep reading * and / operators
        while (position < tokens.size()) {
            String op = tokens.get(position);

            if (op.equals("*") || op.equals("/")) {
                position++;
                double right = evaluatePower();

                if (op.equals("/")) {
                    // division by zero check
                    if (right == 0) {
                        throw new IncorrectExpressionException("Division by zero");
                    }
                    left = left / right;
                } else {
                    left = left * right;
                }
            } else {
                // not a * or /, stop
                break;
            }
        }

        return left;
    }

    /**
     * Evaluates a power(^) expression.
     *
     * @return the result
     * @throws IncorrectExpressionException on error
     */
    private double evaluatePower() throws IncorrectExpressionException {
        // get base number
        double base = number();

        // if next token is ^, read the exponent and calculate
        if (position < tokens.size() && tokens.get(position).equals("^")) {
            position++;
            double exponent = number();
            return Math.pow(base, exponent);
        }

        // no ^ found, return the base
        return base;
    }

    /**
     * Returns the numeric value of the current token.
     *
     * @return the numeric value
     * @throws IncorrectExpressionException if no valid number is found
     */
    private double number() throws IncorrectExpressionException {
        if (position >= tokens.size()) {
            throw new IncorrectExpressionException("Unexpected end of expression");
        }
        try {
            return Double.parseDouble(tokens.get(position++));
        } catch (NumberFormatException e) {
            throw new IncorrectExpressionException("Expected a number but got: " + tokens.get(position - 1));
        }
    }
}
