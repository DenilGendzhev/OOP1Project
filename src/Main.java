import commands.CommandProcessor;
import models.Spreadsheet;
import java.util.Scanner;

/**
 * Entry point for the spreadsheet application.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Spreadsheet app");
        Spreadsheet spreadsheet = new Spreadsheet();
        CommandProcessor processor = new CommandProcessor(spreadsheet);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Spreadsheet Application. Type 'help' for a list of commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            processor.process(input);
        }
    }
}
