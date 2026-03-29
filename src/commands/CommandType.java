package commands;

import exceptions.IncorrectCommandException;

/**
 * Enum representing all supported command types.
 */

public enum CommandType {
    OPEN,
    CLOSE,
    SAVE,
    SAVE_AS,
    PRINT,
    EDIT,
    HELP,
    EXIT;

    /**
     * Converts an input string to the corresponding {@link CommandType}.
     *
     * @param input the command string typed by the user
     * @return the matching {@link CommandType}
     * @throws IncorrectCommandException if the input doesn't match any command
     */

    public static CommandType fromString(String input) throws IncorrectCommandException {
        if (input == null || input.trim().isEmpty()) {
            throw new IncorrectCommandException("No command entered.");
        }

        /**
         * Trimming the input and changing its letters to lowercase
         */
        String trimmed = input.trim().toLowerCase();

        if (trimmed.equals("open"))    return OPEN;
        if (trimmed.equals("close"))   return CLOSE;
        if (trimmed.equals("save as")) return SAVE_AS;
        if (trimmed.equals("save"))    return SAVE;
        if (trimmed.equals("print"))   return PRINT;
        if (trimmed.equals("edit"))    return EDIT;
        if (trimmed.equals("help"))    return HELP;
        if (trimmed.equals("exit"))    return EXIT;

        throw new IncorrectCommandException("Unknown command: " + input + ". Type 'help' for help.");
    }
}
