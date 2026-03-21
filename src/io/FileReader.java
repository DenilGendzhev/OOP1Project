package io;

import exceptions.*;
import models.Cell;
import services.CellParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that reads the contents of a CSV file and parses it into a list of rows 0f {@link Cell} objects.
 */

public class FileReader {

    /**
     * Reads the file at the given path and returns its contents as a list of rows.
     * Outer List represents all the rows in the file, the inner List represents the values in each row.
     *
     * @param filePath the path to the CSV file
     * @return a list of rows, each row being a list of {@link Cell} objects
     * @throws OpenFileException       if the file cannot be opened
     * @throws IncorrectInputException if a cell token cannot be parsed
     */
    public List<List<Cell>> read(String filePath) throws OpenFileException, IncorrectInputException {
        List<List<Cell>> result = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            int row = 1;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",", -1);
                List<Cell> cells = new ArrayList<>();

                for (int col = 0; col < tokens.length; col++) {
                    cells.add(CellParser.parse(tokens[col], row, col + 1));
                }

                result.add(cells);
                row++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            throw new OpenFileException("Error: file " + filePath + " could not be opened");
        }

        return result;
    }
}
