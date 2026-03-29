package exceptions;

/**
 * Exception for incorrectly entered data.
 */

public class IncorrectInputException extends Exception{
    /**
     * Constructs an {@code IncorrectInputException} with the given message.
     *
     * @param message description of the error
     */
    public IncorrectInputException(String message) {
        super(message);
    }
}
