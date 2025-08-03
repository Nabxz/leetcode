package Arrays_and_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Encode
* Time Complexity: O(n)
* Space Complexity: O(n)
*
* Decode
* Time Complexity: O(n)
* Space Complexity: O(n)
*/
public class EncodeAndDecodeStrings {
    public static String encode(List<String> strs) {
        StringBuilder encodedWord = new StringBuilder();
        for (String word : strs) {
            encodedWord.append(word.length() + "#" + word);
        }
        return encodedWord.toString();
    }

    public static List<String> decode(String str) {

        List<String> decodedList = new ArrayList<>();
        if (str.length() == 0)
            return decodedList;

        String word = "";
        int stringLengthIndex = 0;
        String stringLengthBuffer = "";
        int currReadStringLength = 0;
        // String length can be 1 or more digits so we read till we hit a hashtag
        while (str.charAt(stringLengthIndex) != '#') {
            stringLengthBuffer += str.charAt(stringLengthIndex);
            stringLengthIndex++;
        }
        int stringLength = Integer.parseInt(stringLengthBuffer);
        int indexToFetchFrom = stringLengthIndex + 1;

        while (currReadStringLength <= stringLength && indexToFetchFrom < str.length() + 1) {

            if (currReadStringLength == stringLength) {
                decodedList.add(word);

                // If there are more words to read
                if ((indexToFetchFrom + 1) < str.length()) {
                    word = "";
                    currReadStringLength = 0;
                    // String length can be 1 or more digits so we read till we hit a hashtag
                    stringLengthBuffer = "";
                    stringLengthIndex = indexToFetchFrom;
                    while (str.charAt(stringLengthIndex) != '#') {
                        stringLengthBuffer += str.charAt(stringLengthIndex);
                        stringLengthIndex++;
                    }
                    stringLength = Integer.parseInt(stringLengthBuffer);
                    indexToFetchFrom = stringLengthIndex + 1;
                } else {
                    break;
                }

            }

            word += str.charAt(indexToFetchFrom);
            currReadStringLength++;
            indexToFetchFrom++;
        }

        return decodedList;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("");
        System.out.println("Test 1:\nExpected: [\"\"]\nResult: [" + decode(encode(test)) + "]");

        List<String> test2 = new ArrayList<>();
        test2.addAll(Arrays.asList("we", "say", ":", "yes", "!@#$%^&*()"));
        List<String> result = decode(encode(test2));
        System.out.print("\nTest 2:\nExpected: [\"we\",\"say\",\":\",\"yes\",\"!@#$%^&*()\"]\nResult: [");

        for (int i = 0; i < result.size(); i++) {
            System.out.print("\"");
            System.out.print(result.get(i));
            System.out.print("\"");
            if (i + 1 == test2.size()) {
                System.out.println("]");
            } else {
                System.out.print(",");
            }
        }

        List<String> test3 = new ArrayList<>();
        test3.addAll(Arrays.asList("The quick brown fox", "jumps over the", "lazy dog", "1234567890",
                "abcdefghijklmnopqrstuvwxyz"));
        List<String> result2 = decode(encode(test3));
        System.out.print(
                "\nTest 3:\nExpected: \"The quick brown fox\",\"jumps over the\",\"lazy dog\",\"1234567890\",\"abcdefghijklmnopqrstuvwxyz\"\nResult: [");

        for (int i = 0; i < result2.size(); i++) {
            System.out.print("\"");
            System.out.print(result2.get(i));
            System.out.print("\"");
            if (i + 1 == test3.size()) {
                System.out.println("]");
            } else {
                System.out.print(",");
            }
        }
    }
}
