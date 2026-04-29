package services;

import models.Cell;
import models.Spreadsheet;

import java.util.List;

public class TableFormatter {
    /**
     * Calculates the maximum width of each column in the spreadsheet.
     *
     * @param spreadsheet the spreadsheet to calculate column widths for
     * @return an array of column widths
     */
    public static int[] getColumnWidths(Spreadsheet spreadsheet) {
        List<List<Cell>> table = spreadsheet.getTable();
        int colCount = 0;

        for (List<Cell> row : table) {
            if (row.size() > colCount) {
                colCount = row.size();
            }
        }

        int[] widths = new int[colCount];

        for (List<Cell> row : table) {
            for (int col = 0; col < row.size(); col++) {
                int width = row.get(col).getDisplayValue(spreadsheet).length();
                if (width > widths[col]) {
                    widths[col] = width;
                }
            }
        }
        return widths;
    }

    /**
     * Pads a string on the right with spaces to reach the desired width.
     *
     * @param value the string to pad
     * @param width the desired width
     * @return the padded string
     */
    public static String padRight(String value, int width) {
        StringBuilder sb = new StringBuilder(value);
        while (sb.length() < width) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
