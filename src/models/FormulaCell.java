package models;

import exceptions.IncorrectExpressionException;
import services.FormulaEvaluator;

/**
 * Cell that stores and evaluates a formula expression.
 */
public class FormulaCell extends Cell{
    private String formula;
    private final FormulaEvaluator evaluator = new FormulaEvaluator();

    public FormulaCell(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return formula;
    }

    /**
     * Returns the evaluated result of the formula, or ERROR if evaluation fails.
     *
     * @param table the spreadsheet used to resolve cell references
     * @return the result as a string or {@code "ERROR"} on failure
     */
    @Override
    public String getDisplayValue(Spreadsheet table) {
        try {
            double result = evaluator.evaluate(formula, table);
            if (result==Math.floor(result)){
                return String.valueOf((long)result);
            }
            return String.valueOf(result);
        } catch (IncorrectExpressionException e){
            return "ERROR";
        }
    }

    /**
     * Returns the numeric result of the formula, or 0 if evaluation fails.
     *
     * @param table the spreadsheet used to resolve cell references
     * @return the numeric result
     */
    @Override
    public double getNumericValue(Spreadsheet table) {
        try {
            return evaluator.evaluate(formula, table);
        } catch (IncorrectExpressionException e) {
            return 0;
        }
    }

    @Override
    public String getRawValue() {
        return "=" + formula;
    }
}
