package commands;


import models.Spreadsheet;

/**
 * *Class for the save-as command.
 */

public class SaveAsCommand extends Command{

    public SaveAsCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Saving file...");
    }
}
