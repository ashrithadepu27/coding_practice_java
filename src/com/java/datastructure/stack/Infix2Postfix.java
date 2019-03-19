package com.java.datastructure.stack;

import java.util.*;

public class Infix2Postfix {

    private static Map<String, Integer> operatorPriority = new HashMap<>();
    static {
        operatorPriority.put("^", 0);
        operatorPriority.put("/", 1);
        operatorPriority.put("*", 2);
        operatorPriority.put("+", 3);
        operatorPriority.put("-", 4);
    }

    public static String convertToPostfix(String infix) {

        String[] comp = infix.split(" ");
        Stack<String> operator = new Stack<>();
        Stack<String> operand = new Stack<>();
        for(String c : comp) {
            try {
                Integer.parseInt(c);
                operand.push(c);
            } catch (Exception ex) {
                if(operator.isEmpty()) {
                    operator.push(c);
                } else {
                    String o = operator.peek();
                    if(c.equals("(")) {
                        operator.push(c);
                    }
                    else if(c.equals(")")) {
                        o = operator.pop();
                        while(!o.equals("(")) {
                            String op1 = operand.pop();
                            String op2 = operand.pop();
                            operand.push(op2 + " " + op1 + " " + o);
                            o = operator.pop();
                        }
                    }
                    else if(o.equals("(") || operatorPriority.get(o) >= operatorPriority.get(c)) {
                        operator.push(c);
                    } else {
                        while (!operator.isEmpty() && !operator.peek().equals("(") && operatorPriority.get(operator.peek()) < operatorPriority.get(c)) {
                            o = operator.pop();
                            String op1 = operand.pop();
                            String op2 = operand.pop();
                            operand.push(op2 + " " + op1 + " " + o);
                        }
                        operator.push(c);
                    }
                }
            }
        }
        while(!operator.isEmpty()) {
            String o = operator.pop();
            String op1 = operand.pop();
            String op2 = operand.pop();
            operand.push(op2 + " " + op1 + " " + o);
        }
        return operand.peek();
    }
}
