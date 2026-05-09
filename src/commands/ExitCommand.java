package commands;


import models.Spreadsheet;
import utils.Printer;

/**
 * *Class for the exiting command.
 */

public class ExitCommand extends Command{

    public ExitCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        sb.append("Exiting program...");
        printer.print(sb.toString());
        System.exit(0);
    }
}
