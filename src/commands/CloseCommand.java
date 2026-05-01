package commands;

import models.Spreadsheet;

/**
 * *Class for closing the currently opened file and clears the spreadsheet.
 */

public class CloseCommand extends Command{

    /**
     * Constructs a {@code CloseCommand} with the given spreadsheet.
     *
     * @param spreadsheet the spreadsheet to close
     */
    public CloseCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    /**
     * Executes the close command.
     * Clears all data and resets the file path.
     *
     * @param args he command arguments (none required here)
     */
    @Override
    public void execute(String[] args) {
        if (getSpreadsheet().getFilePath()==null){
            System.out.println("No file is currently open.");
            return;
        }
        getSpreadsheet().clear();
        System.out.println("File closed successfully.");
    }
}
