package services;

import models.Cell;
import models.EmptyCell;
import models.Spreadsheet;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles the actions of the spreadsheet
 */

public class SpreadsheetService {

    /**
     * Prints the values of the spreadsheet and divides them with |
     *
     * @param spreadsheet
     */
    public void print(Spreadsheet spreadsheet) {
        int[] widths = TableFormatter.getColumnWidths(spreadsheet);
        for (List<Cell> row : spreadsheet.getTable()) {
            StringBuilder sb = new StringBuilder();
            Printer printer = new Printer();

            for (int col = 0; col < row.size(); col++) {
                String value = row.get(col).getDisplayValue(spreadsheet);
                sb.append(TableFormatter.padRight(value, widths[col]));
                sb.append(" | ");
            }
            printer.print(sb.toString());
        }
    }

    /**
     * Loads data into the spreadsheet, replacing any existing content.
     *
     * @param spreadsheet the spreadsheet to load data into
     * @param data        the parsed rows of cells
     */
    public void loadData(Spreadsheet spreadsheet, List<List<Cell>> data) {
        spreadsheet.clear();
        for (List<Cell> row : data) {
            spreadsheet.addRow(row);
        }
    }

    /**
     * Edits the cell at the given 1-based row and column.
     *
     * @param spreadsheet
     * @param row
     * @param col
     * @param cell
     */
    public void edit(Spreadsheet spreadsheet, int row, int col, Cell cell) {
        // expand rows if needed
        while (spreadsheet.getTable().size() < row) {
            spreadsheet.getTable().add(new ArrayList<>());
        }

        List<Cell> rowList = spreadsheet.getTable().get(row - 1);

        // expand columns in the row if needed
        while (rowList.size() < col) {
            rowList.add(new EmptyCell());
        }
        rowList.set(col - 1, cell);
    }
}
