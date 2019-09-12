package edu.csc413.calculator.operators;
import edu.csc413.calculator.evaluator.Operand;

public class DivideOperator extends Operator{

    public int priority(){
        return 2;
    }

    public Operand execute(Operand op1, Operand op2){
        if(op2.getValue()==0) throw new UnsupportedOperationException("Error: Can't divide by 0");
        Operand total = new Operand(op1.getValue()/op2.getValue());
        return total;
    }
}
