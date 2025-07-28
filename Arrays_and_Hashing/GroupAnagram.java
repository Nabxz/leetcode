package Arrays_and_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* Time Complexity: O(m * n), , where m is the number of strings and n is the length of the longest string
* Space Complexity: O(m * n)
*/

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<List<Integer>, ArrayList<String>> mapOfAnagrams = new HashMap<>();
        for (String word: strs) {

            // For each word we get the frequency of each letter, then we use that as a key in our hashmap
            List<Integer> characterFrequency = new ArrayList<>(26);
            // populate the array
            for(int i = 0; i < 26; i++){
                characterFrequency.add(0);
            }
            for(int i = 0; i < word.length(); i++){
                characterFrequency.set(word.charAt(i) - 97, characterFrequency.get(word.charAt(i) - 97) + 1);
            }

            // If it's anagram exist, add this word to the list
            if(mapOfAnagrams.get(characterFrequency) != null) {
                mapOfAnagrams.get(characterFrequency).add(word);

            // It's a new word, give it it's own list
            } else {
                mapOfAnagrams.put(characterFrequency, new ArrayList<String>());
                mapOfAnagrams.get(characterFrequency).add(word);
            }
        }
        
        List<List<String>> listOfAnagrams = new ArrayList<>(mapOfAnagrams.values());
        return listOfAnagrams;
    }

    public static void main(String[] args) {
        String[] test = {"bat", "tab", "cat"};
        List<List<String>> anagrams = groupAnagrams(test);
        for(List<String> list: anagrams) {
            System.out.println(list);
        }
    }
}
