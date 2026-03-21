package exceptions;

/**
 * Exception for when the file can`t be opened.
 */

public class OpenFileException extends Exception{

    public OpenFileException(String message) {
        super(message);
    }
}
