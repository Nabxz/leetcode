package Two_Pointers;

/*
* Time Complexity: O(n)
* Space Complexity: O()
*/
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        Boolean isValid = true;
        int top = 0;
        int tail = s.length() - 1;
        while (isValid && top < tail && s.length() != 1) {
            while (!Character.isLetterOrDigit(s.charAt(top)) && top < tail) { // While top isnt an alphanumeric characters ignore it
                top++;
            }
            while (!Character.isLetterOrDigit(s.charAt(tail)) && top < tail) { // While tail isnt an alphanumeric characters ignore it
                tail--;
            }

            if(Character.toLowerCase(s.charAt(top)) == Character.toLowerCase(s.charAt(tail))) {
                top++;
                tail--;
            } else {
                isValid = false;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:\nExpected: true\nResult: " + isPalindrome("Was it a car or a cat I saw?"));
        System.out.println("\nTest 2:\nExpected: false\nResult: " + isPalindrome("tab a cat"));
        System.out.println("\nTest 3:\nExpected: true\nResult: " + isPalindrome(" "));
        System.out.println("\nTest 4:\nExpected: true\nResult: " + isPalindrome(".,"));
        System.out.println("\nTest 5:\nExpected: false\nResult: " + isPalindrome("0P"));
    }
}
