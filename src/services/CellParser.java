package services;

import exceptions.IncorrectInputException;
import models.*;

/**
 * Parses a string token into the correct {@link Cell} subclass({@link DoubleCell}, {@link IntegerCell},
 * {@link StringCell}, {@link EmptyCell}).
 */

public class CellParser {

    /**
     * Parses a single token into a {@link Cell}.
     *
     * @param token the string to parse
     * @param row   the row number (for error messages)
     * @param col   the column number (for error messages)
     * @return the appropriate {@link Cell} subclass
     * @throws IncorrectInputException if the token cannot be parsed as any known type
     */

    public static Cell parse(String token, int row, int col) throws IncorrectInputException {
        String trimmed = token.trim();

        /**
         * {@link EmptyCell}
         */
        if (trimmed.isEmpty()){
            return new EmptyCell();
        }

        /**
         * {@link StringCell}
         */
        if (trimmed.startsWith("\"")) {
            return parseString(trimmed, row, col);
        }

        /**
         * {@link IntegerCell}
         */
        if (trimmed.matches("[+-]?\\d+")) {
            return new IntegerCell(Integer.parseInt(trimmed));
        }

        /**
         * {@link DoubleCell}
         */
        if (trimmed.matches("[+-]?\\d+\\.\\d+")) {
            return new DoubleCell(Double.parseDouble(trimmed));
        }

        /**
         * {@link FormulaCell}
         */
        if(trimmed.startsWith("=")){
            return new FormulaCell(trimmed.substring(1).trim());
        }

        /**
         * {@link IncorrectInputException}
         */
        throw new IncorrectInputException(
                "Error: row " + row + ", col " + col + ", " + token + " is an unknown data type."
        );
    }

    /**
     * Parses a quoted string token into a {@link StringCell}.
     * Handles escape sequences: {@code \"} for quotes and {@code \\} for backslashes.
     *
     * @param token the quoted string token
     * @param row   the row number (for error messages)
     * @param col   the column number (for error messages)
     * @return a {@link StringCell} with the unescaped content
     * @throws IncorrectInputException if the string is not properly closed
     */
    private static StringCell parseString(String token, int row, int col) throws IncorrectInputException {
        if (!token.endsWith("\"") || token.length() < 2) {
            throw new IncorrectInputException(
                    "Error: row " + row + ", col " + col + ", string is not properly closed"
            );
        }
        String content = token.substring(1, token.length() - 1)
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");
        return new StringCell(content);
    }
}
