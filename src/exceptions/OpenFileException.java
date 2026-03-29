package exceptions;

/**
 * Exception for when the file can`t be opened.
 */

public class OpenFileException extends Exception{
    /**
     * Constructs an {@code OpenFileException} with the given message.
     *
     * @param message description of the error
     */
    public OpenFileException(String message) {
        super(message);
    }
}
