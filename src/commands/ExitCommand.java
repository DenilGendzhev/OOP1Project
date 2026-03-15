package commands;


import models.Spreadsheet;

/**
 * *Class for the exiting command.
 */

public class ExitCommand extends Command{

    public ExitCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {

        System.out.println("Exiting program...");
        System.exit(0);
    }
}
