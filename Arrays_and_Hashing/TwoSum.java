package Arrays_and_Hashing;

/*
* Time Complexity: O(n)
* Space Complexity: O(n)
*/

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        boolean sumsFound = false;
        int[] indices = new int[2];

        // We store the difference as the key and the index as it's value
        HashMap<Integer, Integer> sumHashMap = new HashMap<>();
        
        for(int i = 0; i < nums.length && !sumsFound; i++) {
            
            // If the difference is in the hashmap then we have found our two indices
            if (sumHashMap.get(target - nums[i]) != null) {

                indices[0] = sumHashMap.get(target - nums[i]);
                indices[1] = i;
                sumsFound = true;

                // If it's not add the number we just checked in the hash map and keep going
            } else {
                sumHashMap.put(nums[i], i);
            }
        }

        return indices;
    }
}
