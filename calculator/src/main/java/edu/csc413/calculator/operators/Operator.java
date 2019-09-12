package edu.csc413.calculator.operators;
import edu.csc413.calculator.evaluator.Operand;
import java.util.HashMap;

public abstract class Operator {
    /**
     * declaration of a private static operators HashMap
     * private: in order to control the access
     * static: so that every class gets a share
     */
    private static HashMap<String, Operator> operators = new HashMap<>();
    /**
     * program automatically initializes HashMap
     * static block only runs once
     */
    static{
        operators.put("(", new RightParenthesisOperator());
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("/", new DivideOperator());
        operators.put("^", new PowerOperator());
        operators.put(")", new LeftParenthesisOperator());
    }
    /**
     * used to get the priority of an operator
     *
     * @return as an int, priority of operator
     */
    public abstract int priority();

    public abstract Operand execute(Operand op1, Operand op2);
    /**
     * determines if a given token is a valid operator.
     * @param token key of the operator that need to be checked
     * using containsKey method which provides constant-time performance
     */
    public static boolean check(String token) {
        return operators.containsKey(token);
    }
    /**
     * used to retrieve an operator from our HashMap.
     * This will act as out publicly facing function,
     * granting access to the Operator HashMap.
     *
     * @param token key of the operator we want to retrieve
     * @return reference to a Operator instance.
     */
    public static Operator getOperator(String token) {
        return operators.get(token);
    }
}
