package services;


import exceptions.IncorrectExpressionException;
import models.Cell;
import models.Spreadsheet;
import utils.ExpressionEvaluator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that handles the formula operations and calculates them through {@link ExpressionEvaluator}
 */
public class FormulaEvaluator {

    /** Pattern matching cel references*/
    private static final Pattern CELL_REF = Pattern.compile("[R](\\d+)[C](\\d+)");

    /** {@link ExpressionEvaluator} used for the mathematical calculations*/
    private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    /**
     * Evaluates a formula by resolving all cell references and computing the expression.
     *
     * @param formula the formula string without the leading '='
     * @param spreadsheet the spreadsheet used to resolve cell references
     * @return the numeric result of the formula
     * @throws IncorrectExpressionException if the expression is invalid or division by zero
     */
    public double evaluate(String formula, Spreadsheet spreadsheet) throws IncorrectExpressionException {

        //Mather that scans the formula string looking for the pattern
        Matcher matcher = CELL_REF.matcher(formula);

        //StringBuilder that builds the string that will be sent to the ExpressionEvaluator
        StringBuilder expression = new StringBuilder();

        while (matcher.find()) {
            //splitting the regex into two groups, then giving them to the cell
            int row = Integer.parseInt(matcher.group(1));
            int col = Integer.parseInt(matcher.group(2));
            Cell cell = spreadsheet.getCell(row, col);
            //replacing the coordinates of the table with it`s numeric value
            matcher.appendReplacement(expression, String.valueOf(cell.getNumericValue(spreadsheet)));
        }
        //adding what is left after it
        matcher.appendTail(expression);

        //sends string to the expressionEvaluator
        return expressionEvaluator.evaluate(expression.toString());
    }

}
