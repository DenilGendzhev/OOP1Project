package commands;

import exceptions.*;
import io.FileReader;
import models.Cell;
import models.Spreadsheet;
import services.SpreadsheetService;
import utils.Printer;

import java.util.List;


/**
 * Opens a CSV file and loads its contents into the spreadsheet.
 */

public class OpenCommand extends Command{

    /**
     * Initialize a {@param fileReader} and a {@param service} which are used in this class
     */
    private final FileReader fileReader = new FileReader();
    private final SpreadsheetService service = new SpreadsheetService();


    /**
     * Constructs an {@code OpenCommand} with the given spreadsheet.
     *
     * @param spreadsheet the spreadsheet to load data into
     */
    public OpenCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    /**
     * Executes the open command.
     *
     * @param args the command arguments, where {@code args[1]} is the file path
     */
    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        if (args.length < 2) {
            sb.append("Usage: open <path>");
            printer.print(sb.toString());
            return;
        }

        String filePath = args[1];

        try {
            List<List<Cell>> data = fileReader.read(filePath);
            service.loadData(getSpreadsheet(), data);
            getSpreadsheet().setFilePath(filePath);
            sb.append("Successfully opened: ").append(filePath);
            printer.print(sb.toString());
        } catch (OpenFileException | IncorrectInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
