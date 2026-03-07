package models;

import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {

    private List<List<Cell>> table;

    public Spreadsheet() {
        table = new ArrayList<>();
    }

    public void addRow(List<Cell> row) {
        table.add(row);
    }
}
