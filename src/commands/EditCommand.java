package commands;


import exceptions.IncorrectInputException;
import models.Cell;
import models.Spreadsheet;
import services.CellParser;
import services.SpreadsheetService;

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
        if (getSpreadsheet().getFilePath() == null) {
            System.out.println("No file is currently open.");
            return;
        }

        if (args.length < 4) {
            System.out.println("Usage: edit <row> <col> <value>");
            //if they are less than 4 then something is not right,
            // edit-1, <row> -2, <col>-3 , <value>-4
            return;
        }
        try {
            int row = Integer.parseInt(args[1]);
            int col = Integer.parseInt(args[2]);
            String rawValue = args[3];

            Cell newCell = CellParser.parse(rawValue, row, col);
            service.edit(getSpreadsheet(), row, col, newCell);
            System.out.println("Cell R" + row + "C" + col + " updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Row and column must be valid integers.");
        } catch (IncorrectInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
