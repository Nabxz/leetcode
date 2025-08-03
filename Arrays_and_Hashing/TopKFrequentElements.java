package Arrays_and_Hashing;

import java.util.ArrayList;
/*
* Time Complexity: O(n), where n is the size of the input array
* Space Complexity: O(n)
*/
import java.util.HashMap;

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

        // Using bucket sort, for each frequency possible we store which values have that frequency
        // Note the highest possible frequency is our arrays length
        // Each bucket represents the frequency and inside we have an array list of which values have
        // that frequency

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] frequencyBucket = new ArrayList[nums.length + 1];

        // Storing the values in their frequency bucket
        for(int value : frequencyMap.keySet()) {

            // If this is the first time we are initializing it then we must set up the arraylist
            if (frequencyBucket[frequencyMap.get(value)] == null) {
                frequencyBucket[frequencyMap.get(value)] = new ArrayList<Integer>();
            }

            frequencyBucket[frequencyMap.get(value)].add(value);
        }
        
        // We iterate backward on our frequency buckets picking the top k frequent values
        // and return them
        int currentTopFrequentFound = 0;
        for(int i = frequencyBucket.length - 1; i > 0 && currentTopFrequentFound < k; i--){

            if(frequencyBucket[i] != null) {
                for(int value : frequencyBucket[i]) {
                    topKFrequent[currentTopFrequentFound] = value;
                    currentTopFrequentFound++;
                }
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
