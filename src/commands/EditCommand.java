package commands;


import exceptions.IncorrectInputException;
import models.Cell;
import models.Spreadsheet;
import services.CellParser;
import services.SpreadsheetService;
import utils.Printer;

import java.util.Arrays;

/**
 * Edits the value of a cell in the spreadsheet.
 */

public class EditCommand extends Command{

    private final SpreadsheetService service = new SpreadsheetService();

    /**
     * Constructs an {@code EditCommand} with the given spreadsheet.
     *
     * @param spreadsheet the spreadsheet to edit
     */
    public EditCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    /**
     * Executes the edit command.
     * Parses the new value and updates the cell if valid.
     *
     * @param args the command arguments: edit {@code <row> <col> <value>}
     */
    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        if (getSpreadsheet().getFilePath() == null) {
            sb.append("No file is currently open.");
            Printer.print(sb.toString());
            return;
        }

        if (args.length < 4) {
            sb.append("Usage: edit <row> <col> <value>");
            Printer.print(sb.toString());
            //if they are less than 4 then something is not right,
            // edit-1, <row> -2, <col>-3 , <value>-4
            return;
        }
        try {
            int row = Integer.parseInt(args[1]);
            int col = Integer.parseInt(args[2]);
            String rawValue = String.join(" ", Arrays.copyOfRange(args, 3, args.length));

            Cell newCell = CellParser.parse(rawValue, row, col);
            service.edit(getSpreadsheet(), row, col, newCell);
            sb.append("Cell R").append(row).append("C").append(col).append(" updated successfully.");
            printer.print(sb.toString());
        } catch (NumberFormatException e) {
            sb.append("Row and column must be valid integers.");
            printer.print(sb.toString());
        } catch (IncorrectInputException e) {
            printer.print(e.getMessage());
        }
    }
}
