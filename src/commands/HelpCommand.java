package commands;


import models.Spreadsheet;
import utils.Printer;

/**
 * *Class for the helping command.
 */
public class HelpCommand extends Command{

    public HelpCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {
        StringBuilder sb = new StringBuilder();
        Printer printer = new Printer();

        sb.append("The following commands are supported:\n");
        sb.append("open <file>             opens file\n");
        sb.append("close                   closes currently opened file\n");
        sb.append("save                    saves the currently opened file\n");
        sb.append("save as <file>          saves the currently opened file in <file>\n");
        sb.append("print                   prints the spreadsheet\n");
        sb.append("edit <cell> <value>     edits <cell> with <value>\n");
        sb.append("help                    prints this information\n");
        sb.append("exit                    exits the program");
        printer.print(sb.toString());
    }
}
