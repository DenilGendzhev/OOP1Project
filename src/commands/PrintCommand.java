package commands;


import models.Spreadsheet;
import services.SpreadsheetService;

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
        if (getSpreadsheet().getFilePath() == null) {
            System.out.println("No file is currently open.");
            return;
        }
        service.print(getSpreadsheet());
    }
}
