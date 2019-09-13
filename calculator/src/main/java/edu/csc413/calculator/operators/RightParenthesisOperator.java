package edu.csc413.calculator.operators;
import edu.csc413.calculator.evaluator.Operand;

public class RightParenthesisOperator extends Operator {
    // Parenthesis need to have priority less than the other operators
    public int priority() {
        return 0;
    }

    public Operand execute(Operand op1, Operand op2) {
        return op1;
    }
}
