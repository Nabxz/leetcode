/*
* Time Complexity: O(n), where n is the size of the input array
* Space Complexity: O(n)
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] topKFrequent = new int[k];
       
        // We store the frequency of every number as values of a hashmap and store the number itself
        // as the key
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : nums){
            if (frequencyMap.containsKey(number)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                frequencyMap.put(number, 1);
            }
        }

        // We use the frequency of each number as the key of the TreeMap which is sorted in descending order and
        // the values are the number it self
        TreeMap<Integer, Integer> orderedFrequencyMap = new TreeMap<>(Collections.reverseOrder());
        for(int number : frequencyMap.keySet()) {
            orderedFrequencyMap.put(frequencyMap.get(number), number);
        }

        // We add our numbers back to our array
        int i = 0;
        for(int frequency : orderedFrequencyMap.keySet()) {
            if (i < topKFrequent.length) {
                topKFrequent[i] = orderedFrequencyMap.get(frequency);
                i++;
            }
        }

        return topKFrequent;
    }

    public static void main(String[] args) {
        int[] test = {1,2,2,3,3,3};
        int[] result = topKFrequent(test, 2);
        System.out.println("Test 1:\nExpected: [3,2]\nResult: [" + result[0] + "," + result[1] + "]");

        int[] test2 = {7,7};
        System.out.println("\nTest 2:\nExpected: [7]\nResult: [" + topKFrequent(test2, 1)[0] + "]");
    }
}
