package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for the spreadsheet
 */

public class Spreadsheet {

    private List<List<Cell>> table;

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
    }

    public List<List<Cell>> getTable() {
        return table;
    }
}
