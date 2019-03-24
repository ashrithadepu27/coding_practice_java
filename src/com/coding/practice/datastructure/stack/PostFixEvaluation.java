package com.coding.practice.datastructure.stack;

import com.sun.media.sound.InvalidDataException;

import java.util.Stack;

public class PostFixEvaluation {

    public static Double evaluatePostFixExpression(String postfix) throws InvalidDataException{
        String[] comps = postfix.split(" ");
        Stack<Double> operand = new Stack<>();
        for(String c : comps) {
            try {
                Double o = Double.parseDouble(c);
                operand.push(o);
            } catch (Exception ex) {
                Double op1 = operand.pop();
                Double op2 = operand.pop();
                Double result = 0.0;
                switch (c) {
                    case "+":
                        result = op2 + op1;
                        break;
                    case "-":
                        result = op2 - op1;
                        break;
                    case "*":
                        result = op2 * op1;
                        break;
                    case "/":
                        result = op2 / op1;
                        break;
                    case "^":
                        result = Math.pow(op2, op1);
                        break;
                    default:
                        throw new InvalidDataException("Operator not supported " + c);
                }
                operand.push(result);
            }
        }
        return operand.pop();
    }
}
