package models;

public class FormulaCell extends Cell{
    private String formula;

    public FormulaCell(String formula) {
        this.formula = formula;
    }

    @Override
    public String getDisplayValue(Spreadsheet table) {
        return null;
    }

    @Override
    public double getNumericValue(Spreadsheet table) {
        return 0;
    }
}
