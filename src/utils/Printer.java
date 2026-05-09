package utils;

/**
 * Utility class for printing messages to the console.
 * Avoiding System.out.println-s in other parts of the code
 */
public class Printer {

    /**
     * Prints a message to the console.
     *
     * @param message the message to print
     */
    public static void print(String message){
        System.out.println(message);
    }
}
