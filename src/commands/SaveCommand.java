package commands;


import models.Spreadsheet;

/**
 * *Class for the save command.
 */

public class SaveCommand extends Command{

    public SaveCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {

        System.out.println("Saving file...");
        System.exit(0);
    }

}
