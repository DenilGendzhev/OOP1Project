package commands;


import models.Spreadsheet;
import services.SpreadsheetService;
import utils.Printer;

/**
 * Prints the contents of the spreadsheet to the screen.
 */
public class PrintCommand extends Command{

    private final SpreadsheetService service = new SpreadsheetService();

    /**
     * Constructs a {@code PrintCommand} with the given spreadsheet.
     *
     * @param spreadsheet the spreadsheet to print
     */
    public PrintCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        if (getSpreadsheet().getFilePath() == null) {
            sb.append("No file is currently open.");
            printer.print(sb.toString());
            return;
        }
        service.print(getSpreadsheet());
    }
}
