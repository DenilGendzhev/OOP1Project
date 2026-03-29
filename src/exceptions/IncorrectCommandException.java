package exceptions;

/**
 * Exception for incorrectly entered command.
 */

public class IncorrectCommandException extends Exception{
    /**
     * Constructs an {@code IncorrectCommandException} with the given message.
     *
     * @param message description of the error
     */
    public IncorrectCommandException(String message) {
        super(message);
    }
}
