package models;

/**
 * Cell that stores a floating point value.
 */

public class DoubleCell extends Cell{

    private double value;

    public DoubleCell(double value) {
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

    @Override
    public String getRawValue() {
        return String.valueOf(value);
    }
}
