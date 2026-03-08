package models;

/**
 * Cell that stores text.
 */

public class StringCell extends Cell{

    private String value;

    public StringCell(String value) {
        this.value = value;
    }

    @Override
    public String getDisplayValue(Spreadsheet sheet) {
        return value;
    }

    @Override
    public double getNumericValue(Spreadsheet sheet) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
