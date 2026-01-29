/*
* Time Complexity: O( )
* Space Complexity: O( )
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
        int operand1;
        int operand2;
        String operator;

        for (int i = tokens.length - 1; i >= 0; i--) {
            operationStack.push(tokens[i]);
        }

        // For the first two operands we extract the the 2 operands ans the operator
        if (operationStack.size() >= 3) {
            operand1 = Integer.parseInt(operationStack.pop());
            operand2 = Integer.parseInt(operationStack.pop());
            operator = operationStack.pop();

            totalValue += executeOperation(operand1, operand2, operator);

            // For the remaining operators and operand we extract one operand and one operator
            while (!operationStack.isEmpty()) {
                operand1 = Integer.parseInt(operationStack.pop());
                operator = operationStack.pop();
                totalValue = executeOperation(totalValue, operand1, operator);
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: 5\nResult: " + evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"}));
        System.out.println("Test 2:\nExpected: 6\nResult: " + evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
