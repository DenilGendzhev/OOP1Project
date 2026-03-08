package models;

/**
 * Cell that stores an integer value.
 */

public class IntegerCell extends Cell{

    private int value;

    public IntegerCell(int value) {
        this.value = value;
    }

    @Override
    public String getDisplayValue(Spreadsheet sheet) {
        return String.valueOf(value);
    }

    @Override
    public double getNumericValue(Spreadsheet sheet) {
        return value;
    }
}
