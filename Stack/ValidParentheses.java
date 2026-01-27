
import java.util.Stack;

/*
* Time Complexity: O(n)
* Space Complexity: O(n)
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        boolean isValid = s.length() > 1;
        Stack<Character> stringValidatorStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (character == '(' || character == '[' || character == '{') {
                stringValidatorStack.push(character);
            } else if (character == ')') {
                if (stringValidatorStack.isEmpty() || stringValidatorStack.pop() != '(') {
                    isValid = false;
                }
            } else if (character == ']') {
                if (stringValidatorStack.isEmpty() || stringValidatorStack.pop() != '[') {
                    isValid = false;
                }
            } else if (character == '}') {
                if (stringValidatorStack.isEmpty() || stringValidatorStack.pop() != '{') {
                    isValid = false;
                }
            }

        }

        return isValid && stringValidatorStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: true\nResult: " + isValid("[]"));
        System.out.println("\nTest 2:\nExpected: false\nResult: " + isValid("[(])"));
        System.out.println("\nTest 3:\nExpected: false\nResult: " + isValid("["));
        System.out.println("\nTest 4:\nExpected: false\nResult: " + isValid("]"));
        System.out.println("\nTest 5:\nExpected: false\nResult: " + isValid("]]"));
    }
}
