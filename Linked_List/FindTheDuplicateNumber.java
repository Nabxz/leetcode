/*
* Time Complexity: O(n)
* Space Complexity: O(1)
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {

        int duplicate;

        if (nums.length <= 2) {
            duplicate = nums[0];

        } else {
            // Find the intersection point
            int slow = nums[0];
            int fast = nums[0];

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            // At this point slow and fast have intersected so we
            // know we are in the cycle, now we ned to find the cycle start
            int cycleFinderSlow = nums[0];
            int cycleFinderSlow2 = fast;

            while (cycleFinderSlow != cycleFinderSlow2) {
                cycleFinderSlow = nums[cycleFinderSlow];
                cycleFinderSlow2 = nums[cycleFinderSlow2];
            }

            duplicate = cycleFinderSlow2;
        }

        return duplicate;
    }
}
