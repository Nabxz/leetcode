package Arrays_and_Hashing;

import java.util.HashSet;

/*
* Time Complexity: O(n)
* Space Complexity: O(n)
*/

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {

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

    public static void main(String[] args) {
        int[] test = {25, 25, 100};
        System.out.println("Test 1:\nExpected: true\nResult: " + hasDuplicate(test));
        int[] test2 = {25, 125, 100};
        System.out.println("\nTest 2:\nExpected: false\nResult: " + hasDuplicate(test2));
    }
}
