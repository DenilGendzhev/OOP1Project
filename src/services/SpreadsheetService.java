package services;

import models.Cell;
import models.Spreadsheet;

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
        for (var row : spreadsheet.getTable()) {

            for (Cell cell : row) {
                System.out.print(cell.getDisplayValue(spreadsheet) + " | ");
            }

            System.out.println();
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
        spreadsheet.getTable().get(row - 1).set(col - 1, cell);
    }
}
