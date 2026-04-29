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
        if (value.matches("[+-]?\\d+")) {
            return Long.parseLong(value);
        }
        if (value.matches("[+-]?\\d+\\.\\d+")) {
            return Double.parseDouble(value);
        }
        return 0;
    }

    @Override
    public String getRawValue() {
        return "\"" + value.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
