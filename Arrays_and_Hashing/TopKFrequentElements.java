package Arrays_and_Hashing;

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

        System.out.println(frequencyMap);

        int[] arrayOfFrequency = new int[frequencyMap.values().size()];

        for(int i = 0; i < frequencyMap.values().size(); i++){
            arrayOfFrequency[i] = frequencyMap.get(nums[i]);
            System.out.println(arrayOfFrequency[i]);
        }

        // Now that we have an array of the frequencies we sort that
        int[] sortedArrayOfFrequency = new int[frequencyMap.values().size()];
        

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
