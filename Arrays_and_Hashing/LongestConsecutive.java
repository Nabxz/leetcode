package Arrays_and_Hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
* Time Complexity: O(n)
* Space Complexity: O(n)
*/
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {

        int longestConsecutive = 0;
        HashMap<Integer, ArrayList<Integer>> consecutiveNumberMap = new HashMap<>();
        for (int number : nums) {

            if ((consecutiveNumberMap.containsKey(number - 1) && consecutiveNumberMap.containsKey(number + 1)) ||
                    (consecutiveNumberMap.containsKey(number) && (consecutiveNumberMap.get(number).contains(number - 1)
                            && consecutiveNumberMap.get(number).contains(number + 1)))) {

            }
        }

        return longestConsecutive;
    }
}
