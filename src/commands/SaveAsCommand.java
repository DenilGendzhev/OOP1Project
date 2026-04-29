package commands;


import io.FileWriter;
import models.Spreadsheet;

import java.io.IOException;

/**
 * *Class for the save-as command.
 */

public class SaveAsCommand extends Command{
    private final FileWriter fileWriter = new FileWriter();

    /**
     * Constructs a {@code SaveAsCommand} with the given spreadsheet.
     *
     * @param spreadsheet the spreadsheet to save
     */
    public SaveAsCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    /**
     * Executes the save as command.
     * Saves the spreadsheet to a new file and updates the current file path.
     *
     * @param args the command arguments, where {@code args[2]} is the new file path
     */
    @Override
    public void execute(String[] args) {
        if (getSpreadsheet().getFilePath() == null) {
            System.out.println("No file is currently open.");
            return;
        }
        if (args.length < 3) {
            System.out.println("Usage: save as <path>");
            return;
        }
        String newFilePath = args[2];
        try {
            fileWriter.write(getSpreadsheet(), newFilePath);
            getSpreadsheet().setFilePath(newFilePath);
            System.out.println("Successfully saved as: " + newFilePath);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
