package commands;


import models.Spreadsheet;

/**
 * *Class for the opening command.
 */

public class OpenCommand extends Command{

    public OpenCommand(Spreadsheet spreadsheet){
        super(spreadsheet);
    }

    @Override
    public void execute(String[] args) {

        System.out.println("Opening: ");

    }

}
