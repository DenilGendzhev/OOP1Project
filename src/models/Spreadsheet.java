package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for the spreadsheet
 */

public class Spreadsheet {

    private List<List<Cell>> table;

    /** The path of the currently open file, or {@code null} if no file is open. */
    private String filePath;

    /**
     * Returns the path of the currently open file.
     *
     * @return the file path, or {@code null} if no file is open
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the path of the currently open file.
     *
     * @param filePath the file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Constructs an empty {@code Spreadsheet} with no rows or columns.
     */
    public Spreadsheet() {
        table = new ArrayList<>();
    }

    /**
     * Adds a row to the spreadsheet.
     */
    public void addRow(List<Cell> row) {
        table.add(row);
    }

    /**
     * Clears all rows from the spreadsheet.
     */
    public void clear() {
        table.clear();
        filePath=null;
    }

    /**
     * Returns the full table as a list of rows.
     *
     * @return the table
     */
    public List<List<Cell>> getTable() {
        return table;
    }

    /**
     * Returns the cell at the given 1-based row and column.
     * Returns an {@link EmptyCell} if the coordinates are out of bounds.
     *
     * @param row 1-based row index
     * @param col 1-based column index
     * @return the cell at the given position
     */
    public Cell getCell(int row, int col) {
        if (row < 1 || row > table.size()) {
            return new EmptyCell();
        }
        List<Cell> rowList = table.get(row - 1);
        if (col < 1 || col > rowList.size()) {
            return new EmptyCell();
        }
        return rowList.get(col - 1);
    }
}
