package exceptions;

/**
 * Exception for incorrectly entered data.
 */

public class IncorrectExpressionException extends Exception{
    /**
     * Constructs an {@code IncorrectExpressionException} with the given message.
     *
     * @param message description of the error
     */
    public IncorrectExpressionException(String message) {
        super(message);
    }
}
