package commands;

import models.Spreadsheet;
import utils.Printer;

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
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        if (getSpreadsheet().getFilePath()==null){
            sb.append("No file is currently open.");
            printer.print(sb.toString());
            return;
        }
        getSpreadsheet().clear();
        sb.append("File closed successfully.");
        printer.print(sb.toString());
    }
}
