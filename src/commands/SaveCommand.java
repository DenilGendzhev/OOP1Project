package commands;


import io.FileWriter;
import models.Spreadsheet;
import utils.Printer;

import java.io.IOException;

/**
 * *Class for the save command.
 */

public class SaveCommand extends Command{

    private final FileWriter fileWriter = new FileWriter();

    /**
     * Constructs a {@code SaveCommand} with the given spreadsheet.
     *
     * @param spreadsheet the spreadsheet to save
     */

    public SaveCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    /**
     * Executes the save command.
     * Saves the spreadsheet to the currently open file path.
     *
     * @param args the command arguments (none required here)
     */
    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        if (getSpreadsheet().getFilePath() == null) {
            sb.append("No file is currently open.");
            printer.print(sb.toString());
            return;
        }
        try {
            fileWriter.write(getSpreadsheet(), getSpreadsheet().getFilePath());
            sb.append("Successfully saved: " + getSpreadsheet().getFilePath());
            printer.print(sb.toString());
        } catch (IOException e) {
            sb.append("Error saving file: ").append(e.getMessage());
            printer.print(sb.toString());
        }
    }
}
