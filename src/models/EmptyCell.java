package models;

/**
 * Represents an empty cell.
 */

public class EmptyCell extends Cell{

    @Override
    public String getDisplayValue(Spreadsheet sheet) {
        return "";
    }

    @Override
    public double getNumericValue(Spreadsheet sheet) {
        return 0;
    }

}
