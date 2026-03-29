package commands;

import models.Spreadsheet;
import java.util.HashMap;
import java.util.Map;

/**
 * Reads user input and routes it to the correct {@link Command}.
 */

public class CommandProcessor{

    /** Maps command names to their implementations. */
    private final Map<CommandType, Command> commands = new HashMap<>();

    /**
     * Constructs a {@code CommandProcessor} and registers all supported commands.
     *
     * @param spreadsheet the spreadsheet passed to each command
     */
    public CommandProcessor(Spreadsheet spreadsheet) {
        commands.put(CommandType.OPEN,    new OpenCommand(spreadsheet));
        commands.put(CommandType.CLOSE,   new CloseCommand(spreadsheet));
        commands.put(CommandType.SAVE,    new SaveCommand(spreadsheet));
        commands.put(CommandType.SAVE_AS, new SaveAsCommand(spreadsheet));
        commands.put(CommandType.PRINT,   new PrintCommand(spreadsheet));
        commands.put(CommandType.EDIT,    new EditCommand(spreadsheet));
        commands.put(CommandType.HELP,    new HelpCommand(spreadsheet));
        commands.put(CommandType.EXIT,    new ExitCommand(spreadsheet));
    }

    /**
     * Parses and executes the given user input.
     *
     * @param input the raw string typed by the user
     */

    public void process(String input) {
        // work with the input here
    }
}
