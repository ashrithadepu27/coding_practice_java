package com.coding.practice.datastructure.stack;

import com.sun.media.sound.InvalidDataException;

public class ExpressionParsing {


    public static void main(String[] args) {
        String infixExpression = "1 + 2 * ( 3 ^ 4 - 5 ) ^ ( 1 + 8 / 8 ) - 9";
        String postfixExpression = Infix2Postfix.convertToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        try {
            System.out.println("Result: " + PostFixEvaluation.evaluatePostFixExpression(postfixExpression));
        } catch (InvalidDataException dex) {
            System.out.println("Error Occurred while evaluating Postfix: " + dex);
        }
    }
}
