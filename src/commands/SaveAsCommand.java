package commands;


import io.FileWriter;
import models.Spreadsheet;
import utils.Printer;

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
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        if (getSpreadsheet().getFilePath() == null) {
            sb.append("No file is currently open.");
            printer.print(sb.toString());
            return;
        }
        if (args.length < 3) {
            sb.append("Usage: save as <path>");
            printer.print(sb.toString());
            return;
        }
        String newFilePath = args[2];
        try {
            fileWriter.write(getSpreadsheet(), newFilePath);
            getSpreadsheet().setFilePath(newFilePath);
            sb.append("Successfully saved as: ").append(newFilePath);
            printer.print(sb.toString());
        } catch (IOException e) {
            sb.append("Error saving file: ").append(e.getMessage());
            printer.print(sb.toString());
        }
    }
}
