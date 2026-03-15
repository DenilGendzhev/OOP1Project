package commands;


import models.Spreadsheet;

/**
 * *Class for the helping command.
 */
public class HelpCommand extends Command{

    public HelpCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {

        System.out.println("The following commands are supported:");
        System.out.println("open <file> opens <file>");
        System.out.println("close                   closes currently opened");
        System.out.println("save                    saves the currently opened file");
        System.out.println("save as <file>          saves the currently opened file in <file>  ");
        System.out.println("print                   prints the spreadsheet");
        System.out.println("edit <cell> <value>     edits <cell> with <value>");
        System.out.println("help                    prints this information");
        System.out.println("exit                    exits the program");
    }
}
