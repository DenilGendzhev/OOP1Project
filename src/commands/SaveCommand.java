package commands;


import io.FileWriter;
import models.Spreadsheet;

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
        if (getSpreadsheet().getFilePath() == null) {
            System.out.println("No file is currently open.");
            return;
        }
        try {
            fileWriter.write(getSpreadsheet(), getSpreadsheet().getFilePath());
            System.out.println("Successfully saved: " + getSpreadsheet().getFilePath());
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
