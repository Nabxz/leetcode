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
        int totalValue;

        if (tokens.length == 1) {
            totalValue = Integer.parseInt(tokens[0]);

        } else {
            for (String value : tokens) {
                if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {

                    int operand2 = Integer.parseInt(operationStack.pop());
                    int operand1 = Integer.parseInt(operationStack.pop());
                    operationStack.push(String.valueOf(executeOperation(operand1, operand2, value)));

                } else {
                    operationStack.push(value);
                }

            }
            totalValue = Integer.parseInt(operationStack.pop());
        }

        return totalValue;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 5\nResult: " + evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"}));
        System.out.println("\nTest 2:\nExpected: 6\nResult: " + evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println("\nTest 3:\nExpected: 22\nResult: " + evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        System.out.println("\nTest 4:\nExpected: -7\nResult: " + evalRPN(new String[]{"4", "-2", "/", "2", "-3", "-", "-"}));
    }
}
