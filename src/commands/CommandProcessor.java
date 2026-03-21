package commands;

import models.Spreadsheet;
import java.util.HashMap;
import java.util.Map;

/**
 * Reads user input and routes it to the correct {@link Command}.
 */

public class CommandProcessor{

    /** Maps command names to their implementations. */
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Constructs a {@code CommandProcessor} and registers all supported commands.
     *
     * @param spreadsheet the spreadsheet passed to each command
     */
    public CommandProcessor(Spreadsheet spreadsheet) {
        commands.put("open",    new OpenCommand(spreadsheet));
        commands.put("close",   new CloseCommand(spreadsheet));
        commands.put("save",    new SaveCommand(spreadsheet));
        commands.put("save as", new SaveAsCommand(spreadsheet));
        commands.put("print",   new PrintCommand(spreadsheet));
        commands.put("edit",    new EditCommand(spreadsheet));
        commands.put("help",    new HelpCommand(spreadsheet));
        commands.put("exit",    new ExitCommand(spreadsheet));
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
