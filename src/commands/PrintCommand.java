package commands;


import models.Spreadsheet;

/**
 * *Class for the closing command.
 */

public class PrintCommand extends Command{

    public PrintCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {

        System.out.println("Printing spreadsheet...");
        System.exit(0);
    }
}
