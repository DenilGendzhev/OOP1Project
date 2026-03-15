package commands;


import models.Spreadsheet;

/**
 * *Class for the editing command.
 */
public class EditCommand extends Command{

    public EditCommand(Spreadsheet spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {

        System.out.println("Enter <cell> and <value> to edit");

    }
}
