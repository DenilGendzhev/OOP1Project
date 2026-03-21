package commands;

import models.Spreadsheet;

/**
 * Base abstract class for all command types that inherit it.
 */

public abstract class Command {

    private Spreadsheet spreadsheet;

    public Command(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public abstract void execute(String[] args);

}
