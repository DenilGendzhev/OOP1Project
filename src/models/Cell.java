package models;

/**
 * Base abstract class for all cell types that inherit it.
 */

public abstract class Cell {

    public abstract String getDisplayValue(Spreadsheet table);

    public abstract double getNumericValue(Spreadsheet table);

    public abstract String getRawValue();

}
