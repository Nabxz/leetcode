/*
* Time Complexity: O(n)
* Space Complexity: O(n)
 */

import java.util.Stack;

public class ReversePolishNotation {

    static Stack<String> operationStack = new Stack<>();

    private static int executeOperation(int op1, int op2, String operand) {
        int value = 0;

        if (operand.equals("+")) {
            value = op1 + op2;
        } else if (operand.equals("-")) {
            value = op1 - op2;
        } else if (operand.equals("*")) {
            value = op1 * op2;
        } else if (operand.equals("/")) {
            value = op1 / op2;
        }

        return value;
    }

    public static int evalRPN(String[] tokens) {
        int totalValue = 0;
        boolean firstExpression = true;

        for (String value : tokens) {

            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {

                if (firstExpression & operationStack.size() >= 2) {
                    firstExpression = false;
                    int operand2 = Integer.parseInt(operationStack.pop());
                    int operand1 = Integer.parseInt(operationStack.pop());
                    totalValue = executeOperation(operand1, operand2, value);
                } else if (!firstExpression & operationStack.size() >= 1) {
                    totalValue = executeOperation(totalValue, Integer.parseInt(operationStack.pop()), value);
                } else {
                    // The equation is invalid, but i'm not accounting for that
                }
            } else {
                operationStack.push(value);
            }

        }

        return totalValue;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 5\nResult: " + evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"}));
        System.out.println("Test 2:\nExpected: 6\nResult: " + evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println("Test 3:\nExpected: 22\nResult: " + evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
