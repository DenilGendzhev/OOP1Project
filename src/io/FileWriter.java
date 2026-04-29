package io;

import models.Cell;
import models.Spreadsheet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes the contents of a {@link Spreadsheet} to a CSV file.
 */
public class FileWriter {

    /**
     * Saves the given spreadsheet to the specified file path.
     *
     * @param spreadsheet the spreadsheet to save
     * @param filePath    the destination file path
     * @throws IOException if the file cannot be written
     */
    public void write(Spreadsheet spreadsheet, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            for (List<Cell> row : spreadsheet.getTable()) {
                StringBuilder line = new StringBuilder();

                for (int i = 0; i < row.size(); i++) {
                    if (i > 0) {
                        line.append(", ");
                    }
                    line.append(row.get(i).getRawValue());
                }

                writer.write(line.toString());
                writer.newLine();
            }
        }
    }
}
