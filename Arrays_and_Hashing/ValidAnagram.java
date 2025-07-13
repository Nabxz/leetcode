package Arrays_and_Hashing;

import java.util.HashMap;

/*
 * Time Complexity: O(2n + m), where n is the length of the string s and m is the length of the string t
 * Space Complexity: O(1)
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        boolean validAnagram = false;
        if (s.length() == t.length()) {

            HashMap<Character, Integer> anagramHashMap = new HashMap<>();
            for (int letterIndex = 0; letterIndex < s.length(); letterIndex++) {

                // Letter already exist, increment count
                if (anagramHashMap.get(s.charAt(letterIndex)) != null) {
                    anagramHashMap.put(s.charAt(letterIndex), anagramHashMap.get(s.charAt(letterIndex)) + 1);

                    // New Letter, append it
                } else {
                    anagramHashMap.put(s.charAt(letterIndex), 1);
                }
            }

            validAnagram = true;
            for (int letterIndex = 0; letterIndex < t.length() && validAnagram == true; letterIndex++) {

                // If it's a new Letter then it's not an anagram
                if (anagramHashMap.get(t.charAt(letterIndex)) == null) {
                    validAnagram = false;

                    // If the letter already exist, increment count
                } else {
                    anagramHashMap.put(t.charAt(letterIndex), anagramHashMap.get(t.charAt(letterIndex)) + 1);
                }
            }

            // If it's an anagram then at the end all our values should be divisible by 2
            for (int letterIndex = 0; letterIndex < s.length() && validAnagram == true; letterIndex++) {
                if (anagramHashMap.get(s.charAt(letterIndex)) % 2 != 0) {
                    validAnagram = false;
                }
            }
        }

        return validAnagram;
    }
}
