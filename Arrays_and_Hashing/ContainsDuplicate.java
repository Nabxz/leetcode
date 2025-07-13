package Arrays_and_Hashing;

import java.util.HashSet;

/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> myHash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (myHash.contains(nums[i])) {
                return true;
            } else {
                myHash.add(nums[i]);
            }
        }

        return false;
    }
}
