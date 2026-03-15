package exceptions;

/**
 * Exception for incorrectly entered data.
 */

public class IncorrectInputException extends Exception{

    public IncorrectInputException(String message) {
        super(message);
    }
}
